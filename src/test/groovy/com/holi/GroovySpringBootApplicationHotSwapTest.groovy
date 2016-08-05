package com.holi

import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.config.YamlMapFactoryBean
import org.springframework.boot.yaml.DefaultProfileDocumentMatcher
import org.springframework.core.io.ClassPathResource

/**
 * Created by selonj on 16-8-5.
 */
class GroovySpringBootApplicationHotSwapTest implements HttpRequestMethods {
  private Integer serverPort = 9999;

  @Before public void setUp() throws Exception {
    Map<String, Object> profile = yml('application.yml')
    serverPort = profile.server.port as Integer;
  }

  @Test public void 'spring boot devtools avaiable for groovy'() throws Exception {
    get("http://localhost:$serverPort") { def response ->
      assert response.status == 200
      assert response.content == 'success'
    }
    //change class file and rerun test should available for test
  }

  private static Map<String, Object> yml(String resource) throws RuntimeException {
    YamlMapFactoryBean ymlResolver = new YamlMapFactoryBean();
    ymlResolver.setResources(new ClassPathResource(resource));
    ymlResolver.setDocumentMatchers(new DefaultProfileDocumentMatcher());
    ymlResolver.afterPropertiesSet();
    return ymlResolver.object;
  }
}
