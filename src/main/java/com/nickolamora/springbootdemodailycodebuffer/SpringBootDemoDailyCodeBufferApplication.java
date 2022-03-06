package com.nickolamora.springbootdemodailycodebuffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * contains @SpringBootConfiguration which tells the application this is the main configuration file
 * contains @EnableAutoConfiguration means that all the configurations for our application will be added to it
 * contains @ComponentScan that will scan the path (default the package where this lives and all sub packages) specified for classes that are annotated to be added to the Spring container at runtime
 */
@SpringBootApplication
public class SpringBootDemoDailyCodeBufferApplication {

  public static void main(String[] args) {

    SpringApplication.run(SpringBootDemoDailyCodeBufferApplication.class, args);
  }

}
