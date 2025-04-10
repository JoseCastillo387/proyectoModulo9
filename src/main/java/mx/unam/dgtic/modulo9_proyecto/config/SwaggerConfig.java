package mx.unam.dgtic.modulo9_proyecto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Tienda")
                        .version("1.0")
                        .description("API para una tienda online"))
                .servers(List.of(
                        new Server().url("http://localhost:8080")
                                .description("Servidor local")
                ));
    }

    @Bean
    public GroupedOpenApi customGroupedOpenAPI() {
        return GroupedOpenApi.builder()
                .group("Tienda API")
                .pathsToMatch("/api/**")
                .build();
    }
}
