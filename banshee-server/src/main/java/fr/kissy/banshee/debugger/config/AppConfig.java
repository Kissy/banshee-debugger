package fr.kissy.banshee.debugger.config;

import fr.kissy.banshee.debugger.service.ConnectionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Guillaume LE BILLER
 */
@Configuration
@Import(value = {WebSocketConfig.class, ZeroMQConfig.class})
public class AppConfig {
    @Bean
    public ConnectionService connectionService() {
        return new ConnectionService();
    }
}
