package com.suyo.quran.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SecurityScheme(
    name = "bearerAuth",
    description = "JWT auth description",
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    in = SecuritySchemeIn.HEADER
)
public class SpringFoxConfig {

    @Value("${spring.application.name:SpringBoot}")
    private String applicationName;

    @Value("${spring.application.version:-}")
    private String applicationVersion;

    @Bean
    public GroupedOpenApi apiIOS() {
        return GroupedOpenApi.builder()
            .group("FOR IOS PART")
            .displayName("FOR IOS PART")
            .pathsToMatch("/api/**")
            .packagesToScan("com.suyo.quran.controller.nonAuth")
            .build();
    }

    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder()
            .group("Auth Controller")
            .displayName("Auth Controller")
            .pathsToMatch("/api/**")
            .packagesToScan("com.suyo.quran.controller.auth")
            .build();
    }

    @Bean
    public GroupedOpenApi allApis() {
        return GroupedOpenApi.builder()
            .group("All APIs")
            .displayName("All APIs")
            .pathsToMatch("/api/**")
            .build();
    }


    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:6236");
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl("http://localhost:121");
        prodServer.setDescription("Server URL in Production environment");

        return new OpenAPI()
            .info(
                new Info().title(applicationName)
                    .contact(new Contact().name("𝕊𝕦𝕝𝕒𝕪𝕞𝕠𝕟 𝕐𝕒𝕙𝕪𝕠").url("https://sulaymonyahyo.com").email("sulaymon1w@gmail.com"))
                    .license(new License().name("Apache License Version 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                    .description("<h1>بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ</h1>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum <h2>Project Tools </h2> <img height='100' src='/utilLogos.png' alt='Swagger UI'/>")
                    .version(applicationVersion))
            .externalDocs(new ExternalDocumentation()
                .description("Source code Github")
                .url("https://github.com/Sulaymon-Dev20/quran-online"))
            .servers(List.of(devServer, prodServer));
    }
}
