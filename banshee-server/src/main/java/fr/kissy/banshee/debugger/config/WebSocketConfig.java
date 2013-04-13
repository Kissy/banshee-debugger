package fr.kissy.banshee.debugger.config;

import fr.kissy.banshee.debugger.socket.BansheeWebSocket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guillaume LE BILLER
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public BansheeWebSocket pingWebSocket() {
        return new BansheeWebSocket();
    }
}
