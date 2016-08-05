package com.holi

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType

/**
 * Created by selonj on 16-8-5.
 */
trait HttpRequestMethods {
  def get(String url, @DelegatesTo(value = HttpResponse) @ClosureParams(value = SimpleType, options = 'com.holi.HttpResponse') Closure closure) {
    HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();
    connection.connect();
    HttpResponse response = new HttpURLConnectionResponse(connection);
    closure.rehydrate(response, this, this).with {
      it.call(response);
    };
  }

  private static class HttpURLConnectionResponse implements HttpResponse {
    private HttpURLConnection connection;
    private String content;

    HttpURLConnectionResponse(HttpURLConnection connection) {
      this.connection = connection;
    }

    @Override
    int getStatus() {
      return connection.responseCode;
    }

    @Override
    String getContent() {
      return content = content ?: connection.inputStream.text;
    }

    @Override
    String toString() {
      return "response of :${connection.url}";
    }
  }
}