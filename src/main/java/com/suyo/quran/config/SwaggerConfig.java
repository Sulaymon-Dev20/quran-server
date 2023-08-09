package com.suyo.quran.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;
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
@SecurityScheme(
    name = "security_auth",
    type = SecuritySchemeType.OAUTH2,
    flows = @OAuthFlows(clientCredentials = @OAuthFlow(tokenUrl = "${openapi.oAuthFlow.tokenUrl}", scopes = @OAuthScope(name = "openid", description = "openid scope")))
)
public class SwaggerConfig {

    @Value("${spring.application.name:SpringBoot}")
    private String applicationName;

    @Value("${spring.application.version:-}")
    private String applicationVersion;

    @Value("${spring.application.description:-}")
    private String applicationDescription;

    @Value("${spring.application.url:-}")
    private String applicationSourceUrl;

    @Value("${server.port:6236}")
    private String localPort;

    @Bean
    public GroupedOpenApi apiIOS() {
        return GroupedOpenApi.builder()
            .group("FOR IOS PART")
            .displayName("complimentary apis")
            .pathsToMatch("/api/**")
            .packagesToScan("com.suyo.quran.controller.nonAuth")
            .build();
    }

    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder()
            .group("Auth Controller")
            .displayName("authenticated apis")
            .pathsToMatch("/api/**")
            .packagesToScan("com.suyo.quran.controller.auth")
            .build();
    }

    @Bean
    public GroupedOpenApi allApis() {
        return GroupedOpenApi.builder()
            .group("All APIs")
            .displayName("all apis")
            .pathsToMatch("/api/**")
            .packagesToScan("com.suyo.quran.controller")
            .build();
    }

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        final Server localServer = new Server()
            .url("http://localhost:" + localPort)
            .description("Server URL in Local environment");

        final Server devServer = new Server()
            .url("{protocol}://{address}")
            .description("Server URL in Development environment")
            .variables(new ServerVariables()
                .addServerVariable("protocol", new ServerVariable()._default("http")._enum(List.of("http", "https")))
                .addServerVariable("address", new ServerVariable()._default("16.16.90.73:" + localPort)));

        final Server prodServer = new Server()
            .url("{protocol}://{subdomain}.sulaymonyahyo.com")
            .description("Server URL in Production environment")
            .variables(new ServerVariables()
                .addServerVariable("protocol", new ServerVariable()._default("https")._enum(List.of("http", "https")))
                .addServerVariable("subdomain", new ServerVariable().description("nimadir nimadir nimadir 222")._default("quran")));

        return new OpenAPI()
            .info(
                new Info().title(applicationName)
                    .contact(new Contact().name("𝕊𝕦𝕝𝕒𝕪𝕞𝕠𝕟 𝕐𝕒𝕙𝕪𝕠").url("https://sulaymonyahyo.com").email("sulaymon1w@gmail.com"))
                    .license(new License().name("Apache License Version 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                    .description("<h1>بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ</h1>" + applicationDescription + " <h2>Project Tools </h2> <img height='100' src='/utilLogos.png' alt='Swagger UI'/>")
                    .version(applicationVersion))
            .externalDocs(new ExternalDocumentation()
                .description("Source code Github")
                .url(applicationSourceUrl))
            .servers(List.of(localServer, devServer, prodServer));
    }
}
