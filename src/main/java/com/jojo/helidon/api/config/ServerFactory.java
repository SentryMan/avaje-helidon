package com.jojo.helidon.api.config;

import java.util.List;

import com.jojo.helidon.api.exception.ErrorAdvice;

import io.avaje.config.Config;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.helidon.webserver.Routing;
import io.helidon.webserver.Service;
import io.helidon.webserver.WebServer;

@Factory
public class ServerFactory {

  @Bean
  WebServer server(List<Service> routes, ErrorAdvice advice) {
    final var builder = WebServer.builder();

    return builder
        .routing(
            advice
                .addErrorHandling(Routing.builder())
                .register(routes.stream().toArray(Service[]::new)))
        .port(Config.getInt("server.port", 8080))
        .build();
  }
}
