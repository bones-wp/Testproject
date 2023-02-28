//package com.example.test.configuration;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"org.springdoc"})
//@Import({org.springdoc.core.SpringDocConfiguration.class,
//        org.springdoc.webmvc.core.SpringDocWebMvcConfiguration.class,
//        org.springdoc.webmvc.ui.SwaggerConfig.class,
//        org.springdoc.core.SwaggerUiConfigProperties.class,
//        org.springdoc.core.SwaggerUiOAuthProperties.class,
//        org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration.class})
//
//public class OpenApiConfig implements WebMvcConfigurer {
//    @Bean
//    public OpenAPI customOpenAPI(@Value("/") String contextPath) {
//        return new OpenAPI()
//                .addServersItem(new Server().url(contextPath))
//                .info(new Info()
//                        .title("Lashes")
//                        .version("1.0.0")
//                        .contact(new Contact()
//                                .url("https://github.com/intensiveproject/nogotochki")
//                                .name("Team Sunrise")
//                        )
//                );
//    }
//}