package com.hasan.foraty.springmapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMappingApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMappingApplication.class, args);
  }


  @Bean
  public CommandLineRunner commandLineRunner (){
    return runner ->{
      System.out.println("hello word!");
    };
  }



}
