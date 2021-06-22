package com.sivaone.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class OpenapiApplication {

  public static void main(String[] args) {
    SpringApplication.run(OpenapiApplication.class, args);
  }

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.OAS_30)
        .apiInfo(new ApiInfoBuilder()
            .title("Product API")
            .description("A CRUD API to demonstrate Springfox 3 integration")
            .version("1.0.0")
            .license("MIT")
            .licenseUrl("https://opensource.org/licenses/MIT")
            .build())
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .build();
  }
}
