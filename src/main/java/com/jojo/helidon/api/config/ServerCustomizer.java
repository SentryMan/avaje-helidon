package com.jojo.helidon.api.config;

import io.helidon.common.Builder;

@FunctionalInterface
public interface ServerCustomizer {

  void customize(Builder app);
}
