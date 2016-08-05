package com.holi.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by selonj on 16-8-5.
 */
@RestController
class HomeController {
  @RequestMapping('/')
  def index() {
    return 'success';
  }
}
