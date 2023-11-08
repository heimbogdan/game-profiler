package ro.helator.gameprofiler.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.helator.gameprofiler.config.properties.SwaggerProperties;

@Configuration
public class OpenApiConfiguration {

    private final SwaggerProperties swaggerProperties;

    @Value("${app.version}")
    private String apiVersion = "0.0.1-SNAPSHOT";

    public OpenApiConfiguration(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    @Bean
    public OpenAPI springDemoAPI() {
        OpenAPI api = new OpenAPI()
                .info(new Info()
                        .title("Assetto Public Backend API")
                        .version(apiVersion)
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Assetto License")
                                .url("http://example.com")))
                .addServersItem(new Server().url(swaggerProperties.getServer().getUrl()));

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                                .bearerFormat("JWT");
        Components components = new Components().addSecuritySchemes("bearerAuth", securityScheme);
        api.setComponents(components);
        return api;
    }

}
