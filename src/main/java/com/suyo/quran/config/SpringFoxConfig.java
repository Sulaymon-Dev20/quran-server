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
import java.util.Set;

@Configuration
@Import({BeanValidatorPluginsConfiguration.class, SpringDataRestConfiguration.class})
public class SpringFoxConfig {

    @Value("${spring.application.name:SpringBoot}")
    private String applicationName;

    @Value("${spring.application.version:-}")
    private String applicationVersion;

    final Class[] classes = {InputStream.class, Resource.class};

    @Bean
    public Docket apiIOS() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("FOR IOS PART")
            .useDefaultResponseMessages(false)
            .produces(Set.of("application/json"))
            .select()
//                .apis(RequestHandlerSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.suyo.quran.controller"))
            .paths(PathSelectors.any())
            .build()
            .ignoredParameterTypes(classes)
            .apiInfo(apiInfo());
    }

    @Bean
    public Docket apiFrontEnd() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("For Mobile Front")
                .useDefaultResponseMessages(false)
//                .globalResponses(HttpMethod.DELETE, List.of())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.suyo.quran.controller"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(classes)
                .apiInfo(apiInfo())
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(apiKey()));
    }

    static SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(List.of(new SecurityReference("TOKEN SWAMP 💪", new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")}))).build();
    }

    private ApiKey apiKey() {
        return new ApiKey("TOKEN SWAMP 💪", "Authentication", "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(applicationName,
                "<h1>بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ</h1>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum <h2>Project Tools </h2> <img height='100' src='/utilLogos.png' alt='Swagger UI'/>",
                applicationVersion,
                null,
                new Contact("𝕊𝕦𝕝𝕒𝕪𝕞𝕠𝕟 𝕐𝕒𝕙𝕪𝕠", "https://sulaymonyahyo.com", "sulaymon1w@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList());
    }
}
