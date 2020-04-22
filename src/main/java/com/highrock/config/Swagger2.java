package com.highrock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"dev","stage"})
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.highrock.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {

        Contact contact=new Contact("Jony Z","","jinwen_zhang@highrock.com.cn");
        return new ApiInfoBuilder()
                .title("StoreServiceApi")
                .description("HIGHROCK Co.,Ltd")
                .termsOfServiceUrl("http://www.atauro72..com/")
                .contact(contact)
                .version("1.0")
                .build();
    }
}