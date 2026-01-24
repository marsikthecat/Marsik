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

public class RequestSender {
  /**
   * You can use this method to send a JSON-RPC request to a given URL.
   * Make sure the URL exists and is reachable
   * @param url url of the JSON_RPC server
   * @param id id of the request
   * @param method method to be called on the server
   * @param params required params for the method
   * @return the response from the server as a String or null if an error happened.
   * Example for method usage:
   * <pre>
   * sendRpcRequest("<a href="https://playground.oresat.org/json-rpc">...</a>", "1", "subtract", "42", "23")
   */

  public static String sendRPCRequest(String url,  String id, String method, String... params) {
    StringBuilder paramsArray = new StringBuilder();
    paramsArray.append("[");
    for (int i = 0; i < params.length; i++) {
      paramsArray.append(params[i]);
      if (i < params.length - 1) {
        paramsArray.append(", ");
      }
    }
    paramsArray.append("]");

    String jsonCall = """
        {
          "jsonrpc" : "2.0",
          "method"  : "%s",
          "params"  :  %s,
          "id"      : "%s"
        }
    """.formatted(method, paramsArray, id);

    try {
      URL url_internal = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) url_internal.openConnection();
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

  public static String sendHttpGetRequest(String url) {
    return sendRestRequest(url, "GET", null);
  }

  public static String sendHttpGetRequest(String url, String json) {
    return sendRestRequest(url, "GET", json);
  }

  public static String sendHttpPostRequest(String url, String json) {
    return sendRestRequest(url, "POST", json);
  }

  public static String sendHttpPutRequest(String url, String json) {
    return sendRestRequest(url, "PUT", json);
  }

  public static String sendHttpDeleteRequest(String url, String json) {
    return sendRestRequest(url, "DELETE", json);
  }

  public static String sendHttpPatchRequest(String url, String json) {
    return sendRestRequest(url, "PATCH", json);
  }

  /**
   * You can use this method to send a Rest request to a given URL.
   * Make sure the URL exists and is reachable
   * @param url url of the JSON_RPC server.
   * @param httpMethod Rest method that you want to use.
   * @param params the params that are required, in json format please.
   * @return the response from the server as a String or null if an error happened.
   * example for method usage:
   * <pre>
   * sendRpcRequest(<a href="https://playground.oresat.org/json-rpc">...</a>,
   * "POST", """
   *         {
   *           "title": "foo",
   *           "body": "bar",
   *           "userId": 1
   *         }
   *         """)
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

  public static boolean isValidJson(String json) {
    try {
      JsonParser.parseString(json);
      return true;
    } catch (JsonSyntaxException ex) {
      return false;
    }
  }
}