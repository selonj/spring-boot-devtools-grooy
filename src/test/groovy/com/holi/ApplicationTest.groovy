package com.holi

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT

/**
 * Created by selonj on 16-8-5.
 */
@RunWith(SpringRunner)
@SpringBootTest(webEnvironment = DEFINED_PORT)
class ApplicationTest implements HttpRequestMethods {
  private @Value('${server.port}') Integer serverPort;

  @Test public void 'application already'() throws Exception {
    get("http://localhost:$serverPort") { def response ->
      assert response.status == 200
      assert response.content == 'success'
    }
  }
}
