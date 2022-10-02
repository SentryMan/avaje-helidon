package com.jojo.helidon.api;

import io.avaje.inject.BeanScope;
import io.helidon.webserver.WebServer;

public class HelidonAPI {

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HelidonAPI.class);

  public static void main(String[] args) {

    try {

      BeanScope.builder()
          .build()
          .get(WebServer.class)
          .start()
          .thenAccept(ws -> log.info("Server started at: http://localhost:" + ws.port()))
          .toCompletableFuture()
          .get();

    } catch (final Exception e) {

      log.error("Failed to start: ", e);
    }
  }
}
