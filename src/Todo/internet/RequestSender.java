package org.example.internals.internet;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.example.internals.Sys;

/**
 * A utility class for sending HTTP and JSON-RPC requests to remote servers.
 * Supports GET, POST, PUT, DELETE, PATCH requests as well as JSON-RPC 2.0 requests.
 */

public class RequestSender {

  /**
   * Sends a JSON-RPC 2.0 request to the specified URL.
   *
   * @param url    The endpoint URL of the JSON-RPC server.
   * @param id     The request identifier.
   * @param method The method to call on the server.
   * @param params The parameters for the method in order.
   * @return The server's response as a String, or null if an error occurred.
   */
  public static String sendRpcRequest(String url,  String id, String method, String... params) {
    StringBuilder paramsArray = new StringBuilder();
    paramsArray.append("[");
    for (int i = 0; i < params.length; i++) {
      paramsArray.append(params[i]);
      if (i < params.length - 1) {
        paramsArray.append(", ");
      }
    }
    paramsArray.append("]");

    String jsonCall =
        """
        {
          "jsonrpc" : "2.0",
          "method"  : "%s",
          "params"  :  %s,
          "id"      : "%s"
        }
        """.formatted(method, paramsArray, id);

    try {
      URL urlInternal = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) urlInternal.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Content-Type", "application/json");
      conn.setRequestProperty("Accept", "application/json");
      try (OutputStream os = conn.getOutputStream()) {
        os.write(jsonCall.getBytes(StandardCharsets.UTF_8));
      }
      int status = conn.getResponseCode();
      if (status < 200 || status >= 300) {
        Sys.printError("An HTTP Error occurred: " + status);
      }
      return getResult(conn);
    } catch (IOException e) {
      Sys.printError("An error occurred while sending the request: " + e.getMessage());
    }
    return null;
  }

  /**
   * Sends a GET request to the specified URL.
   *
   * @param url The URL to send the request to.
   * @return The server's response as a String, or null if an error occurred.
   */
  public static String sendHttpGetRequest(String url) {
    return sendRestRequest(url, "GET", null);
  }

  /**
   * Sends a GET request to the specified URL with JSON parameters.
   *
   * @param url  The URL to send the request to.
   * @param json JSON-formatted parameters.
   * @return The server's response as a String, or null if an error occurred.
   */
  public static String sendHttpGetRequest(String url, String json) {
    return sendRestRequest(url, "GET", json);
  }

  /**
   * Sends a POST request to the specified URL with JSON payload.
   *
   * @param url  The URL to send the request to.
   * @param json JSON-formatted payload.
   * @return The server's response as a String, or null if an error occurred.
   */
  public static String sendHttpPostRequest(String url, String json) {
    return sendRestRequest(url, "POST", json);
  }

  /**
   * Sends a PUT request to the specified URL with JSON payload.
   *
   * @param url  The URL to send the request to.
   * @param json JSON-formatted payload.
   * @return The server's response as a String, or null if an error occurred.
   */
  public static String sendHttpPutRequest(String url, String json) {
    return sendRestRequest(url, "PUT", json);
  }

  /**
   * Sends a DELETE request to the specified URL with JSON payload.
   *
   * @param url  The URL to send the request to.
   * @param json JSON-formatted payload.
   * @return The server's response as a String, or null if an error occurred.
   */
  public static String sendHttpDeleteRequest(String url, String json) {
    return sendRestRequest(url, "DELETE", json);
  }

  /**
   * Sends a PATCH request to the specified URL with JSON payload.
   *
   * @param url  The URL to send the request to.
   * @param json JSON-formatted payload.
   * @return The server's response as a String, or null if an error occurred.
   */
  public static String sendHttpPatchRequest(String url, String json) {
    return sendRestRequest(url, "PATCH", json);
  }

  /**
   * Sends a REST request to the given URL using the specified HTTP method.
   *
   * @param url        The endpoint URL.
   * @param httpMethod The HTTP method (GET, POST, PUT, DELETE, PATCH).
   * @param params     The request payload in JSON format (can be null for GET without parameters).
   * @return The server's response as a String, or null if an error occurred.
   */
  public static String sendRestRequest(String url, String httpMethod, String params) {
    try {
      HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
      // GET request with no params
      if (params == null && httpMethod.equals("GET")) {
        con.setRequestMethod("GET");
      } else {
        if (!isValidJson(params)) {
          throw new JsonSyntaxException("Invalid JSON parameters: " + params);
        }
      }
      con.setRequestMethod(httpMethod);
      con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      con.setRequestProperty("Accept", "application/json");
      con.setDoOutput(true);
      try (OutputStream os = con.getOutputStream()) {
        if (params != null) {
          byte[] input = params.getBytes(StandardCharsets.UTF_8);
          os.write(input, 0, input.length);
        } else {
          os.write("{}".getBytes(StandardCharsets.UTF_8));
        }
      }
      return getResult(con);
    } catch (IOException e) {
      Sys.printError("An error occurred while sending the REST request: " + e.getMessage());
    }
    return null;
  }

  /**
   * Reads the response from the HttpURLConnection.
   *
   * @param con The HttpURLConnection object.
   * @return The response body as a String.
   * @throws IOException If an error occurs while reading the response.
   */
  private static String getResult(HttpURLConnection con) throws IOException {
    StringBuilder responseBuilder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        responseBuilder.append(line);
      }
    }
    return responseBuilder.toString();
  }

  /**
   * Checks whether a given string is valid JSON.
   *
   * @param json The string to check.
   * @return True if valid JSON, false otherwise.
   */
  public static boolean isValidJson(String json) {
    try {
      JsonParser.parseString(json);
      return true;
    } catch (JsonSyntaxException ex) {
      return false;
    }
  }
}