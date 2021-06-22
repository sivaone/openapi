package com.sivaone.openapi;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
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
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .securityContexts(List.of(securityContext()))
        .securitySchemes(List.of(securityScheme()));
  }

  private SecurityScheme securityScheme() {
    return HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("JWT").build();
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(securityReferences())
        .build();
  }

  private List<SecurityReference> securityReferences() {
    AuthorizationScope authorizationScope =
        new AuthorizationScope("allowAll", "allowAll");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return List.of(new SecurityReference("JWT", authorizationScopes));
  }
}
