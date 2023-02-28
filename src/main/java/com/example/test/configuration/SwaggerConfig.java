package com.example.test.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${server.servlet.context-path}") String contextPath) {
        return new OpenAPI()
                .addServersItem(new Server().url(contextPath))
                .info(new Info()
                        .title("Lashes")
                        .version("1.0.0")
                        .contact(new Contact()
                                .email("Osmolovskiy.Yuriy@ya.ru")
                                .url("https://github.com/bones-wp")
                                .name("Osmolovkiy Yuriy")
                        )
                );
    }
}
