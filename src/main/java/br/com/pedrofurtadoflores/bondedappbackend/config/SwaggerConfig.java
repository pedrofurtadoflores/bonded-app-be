package br.com.pedrofurtadoflores.bondedappbackend.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bonded App - Back End")
                        .description("Projeto de aplicativo para casais.")
                        .version("1.0.0"));
    }
}