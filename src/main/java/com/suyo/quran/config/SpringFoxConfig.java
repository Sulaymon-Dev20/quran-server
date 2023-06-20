package com.suyo.quran.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Configuration
@Import({BeanValidatorPluginsConfiguration.class, SpringDataRestConfiguration.class})
public class SpringFoxConfig {

    @Value("${spring.application.name:SpringBoot}")
    private String applicationName;

    @Bean
    public Docket api1() {
        Class[] classes = {InputStream.class, Resource.class};
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("FOR IOS PART")
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.suyo.quran.controller"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(classes)
                .apiInfo(apiInfo())
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(apiKey()));
    }

/*
    @Bean
    public Docket api2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("For Mobile Front")
                .select()
                .paths(PathSelectors.ant("/api/products/**"))
                .build();
    }*/

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(List.of(new SecurityReference("TOKEN SWAMP 💪", new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")}))).build();
    }

    private ApiKey apiKey() {
        return new ApiKey("TOKEN SWAMP 💪", "Authentication", "header");
    }

    private ApiInfo apiInfo() {
        final String version = "UNKNOWN";
        return new ApiInfo(applicationName,
                "API description",
                version,
                null,
                new Contact("𝕊𝕦𝕝𝕒𝕪𝕞𝕠𝕟 𝕐𝕒𝕙𝕪𝕠", "https://sulaymonyahyo.com", "sulaymon1w@gmail.com"),
                null,
                null,
                Collections.emptyList());
    }
}
