package com.samdevweb.monitoramento.monitoring;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (isInternetAvailable()) {
            return Health
                .up()
                .withDetail("message", "Conexão estabelecida com sucesso")
                .build();
        }
        return Health
            .down()
            .withDetail("message", "Não foi possível estabeler uma Conexão")
            .build();
    }

    private boolean isInternetAvailable() {
        try {
            URL url = new URI("https://www.google.com").toURL();
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
