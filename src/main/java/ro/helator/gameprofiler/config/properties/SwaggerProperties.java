package ro.helator.gameprofiler.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.swagger")
public class SwaggerProperties {

    private Server server;

    @Data
    public static final class Server {
        private String url;
    }
}
