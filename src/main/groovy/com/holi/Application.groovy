package com.holi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by selonj on 16-8-5.
 */
@SpringBootApplication
//@ComponentScan default is scan packages under @SpringBootApplication
class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application, args);
  }
}
