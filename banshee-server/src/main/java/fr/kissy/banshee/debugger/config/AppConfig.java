package fr.kissy.banshee.debugger.config;

import fr.kissy.banshee.debugger.service.ConnectionService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Guillaume LE BILLER
 */
@Configuration
@PropertySource("/fr/kissy/banshee/debugger/common.properties")
@Import(value = {WebSocketConfig.class, ZeroMQConfig.class})
public class AppConfig {
    @Bean
    public ConnectionService connectionService() {
        return new ConnectionService();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
