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
   * sendRpcRequest(<a href="https://playground.oresat.org/json-rpc">...</a>,
   * """
   *     {
   *       "jsonrpc": "2.0",
   *       "method": "subtract",
   *       "params": [42, 23],
   *       "id": 1
   *     }
   * """)
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
      try (OutputStream os = conn.getOutputStream()) {
        os.write(jsonCall.getBytes());
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
   * @param url url of the JSON_RPC server
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
  public static String sendRestRequest(String url, String endPoint, String params) {
    try {
      HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
      if (endPoint.equals("GET")) {
        con.setRequestMethod("GET");
      } else {
        if (isValidJson(params)) {
          throw new IllegalArgumentException("Your JSON is not valid, buddy");
        }
        con.setRequestMethod(endPoint);
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
          byte[] input = params.getBytes(StandardCharsets.UTF_8);
          os.write(input, 0, input.length);
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
      return false;
    } catch (JsonSyntaxException ex) {
      return true;
    }
  }
}