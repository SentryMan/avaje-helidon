package com.jojo.helidon.api.config;

import io.avaje.config.Config;
import io.avaje.http.api.WebRoutes;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.helidon.webserver.Routing;
import io.helidon.webserver.Service;
import io.helidon.webserver.WebServer;
import java.util.List;

@Factory
public class ServerFactory {

  @Bean
  WebServer server(List<Service> routes, List<ServerCustomizer> customizers) {
    final WebRoutes s = null;
    Routing.builder().register(routes.stream().toArray(Service[]::new));
    return WebServer.builder()

        // .routing(Main::routing)
        .port(Config.getInt("server.port", 8080))
        .build();
  }
}
