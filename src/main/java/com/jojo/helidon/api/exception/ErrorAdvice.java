package com.jojo.helidon.api.exception;

import com.jojo.helidon.api.config.ServerCustomizer;
import io.helidon.common.Builder;
import jakarta.inject.Singleton;

@Singleton
public class ErrorAdvice implements ServerCustomizer {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ErrorAdvice.class);

  @Override
  public void customize(Builder app) { // TODO Auto-generated method stub
  }
}
