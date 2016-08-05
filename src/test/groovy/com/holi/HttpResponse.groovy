package com.holi

/**
 * Created by selonj on 16-8-5.
 */
interface HttpResponse {
  int getStatus();

  String getContent();
}