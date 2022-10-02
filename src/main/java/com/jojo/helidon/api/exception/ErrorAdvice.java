package com.jojo.helidon.api.exception;

import io.helidon.webserver.Routing.Builder;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import jakarta.inject.Singleton;

@Singleton
public class ErrorAdvice {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ErrorAdvice.class);

  public Builder addErrorHandling(Builder builder) {

    return builder.error(Exception.class, this::handle);
  }

  private void handle(ServerRequest req, ServerResponse res, Exception ex) {
    res.status(500).send(ex.getMessage());
  }
}
