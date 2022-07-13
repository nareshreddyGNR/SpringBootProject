package com.springBootDemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig  implements WebMvcConfigurer {

    private ApiKey apiKey(){
        return new ApiKey("JWT", "Authorization", "header");
    }

    private List<SecurityReference> authentication(){

        AuthorizationScope scope= new AuthorizationScope("global", "accessEverything");

        AuthorizationScope[] scopes=new AuthorizationScope[1];

        scopes[0]=scope;

        return Arrays.asList(new SecurityReference("JWT", scopes));
    }

    private SecurityContext securityContext(){

        return SecurityContext.builder().securityReferences(authentication()).build();
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).securityContexts(Arrays.asList(securityContext()))

                .securitySchemes(Arrays.asList(apiKey())).select()
                .apis(RequestHandlerSelectors.basePackage("com.springBootDemo"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Api Student").description("student management application").version("2.0").build();
    }
}