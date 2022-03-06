package com.nickolamora.springbootdemodailycodebuffer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// contains @Controller that tells Spring that this is the Controller class
// contains @Component that tells Spring that this should be a class that should be handled as a bean in the Spring container
// Tells Spring that this is a controller that will always return a response body
@RestController
public class HelloController {

  //@Value can be used to pull configs from the properties file
  @Value("${welcome.message}")
  private String welcomeMessage;

  // @RequestMapping(value="/", method = RequestMethod.GET)
  // contains/implements @RequestMapping which Tells whatever request I execute it should map to this method
  @GetMapping("/")
  public String helloWorld() {

    return welcomeMessage;
  }

}
