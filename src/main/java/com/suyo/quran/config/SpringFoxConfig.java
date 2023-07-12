package com.suyo.quran.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static io.swagger.v3.oas.models.security.SecurityScheme.In.HEADER;
import static io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP;

@Configuration
public class SpringFoxConfig {

    @Value("${spring.application.name:SpringBoot}")
    private String applicationName;

    @Value("${spring.application.version:-}")
    private String applicationVersion;

    @Bean
    public GroupedOpenApi apiIOS() {
        return GroupedOpenApi.builder()
                .group("FOR IOS PART")
                .displayName("for REGULAR USERS")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("FOR IOS PART 2")
                .displayName("for authenticated USERS")
                .pathsToMatch("/api/**")
                .packagesToScan("com.suyo.quran.controller")
                .addOpenApiCustomizer(internalApiCustomizer())
                .build();
    }


    @Bean
    public OpenApiCustomizer internalApiCustomizer() {
        return openApi -> openApi
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("TOKEN SWAMP 😐",
                                new SecurityScheme().scheme("bearer").name("bearerAuth").description("JWT auth description").type(HTTP).bearerFormat("JWT").in(HEADER)));
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
