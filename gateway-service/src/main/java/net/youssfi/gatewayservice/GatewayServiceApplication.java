package net.youssfi.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
	SpringApplication.run(GatewayServiceApplication.class, args);
    }

    /**
     * Créer ce bean pour configurer les routes dynamique sans passer par la config static dans le fichier .yml
     * @param rdc
     * @param dlp
     * @return
     */
    @Bean
    DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
	return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }

}
