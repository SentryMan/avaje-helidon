package com.jojo.helidon.api.controller;

import com.jojo.helidon.api.service.ServiceClass;
import io.avaje.http.api.Controller;
import io.avaje.http.api.FormParam;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.helidon.common.http.MediaType;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import jakarta.inject.Inject;
import java.util.List;

@Controller
@Path("/helidon")
public class ControllerClass {

  private final ServiceClass service;

  @Inject
  public ControllerClass(ServiceClass service) {

    this.service = service;
  }

  @Produces("image/png")
  @Get("/get")
  void test(ServerRequest req, ServerResponse res) {
    res.headers().contentType(MediaType.parse("image/png"));
    res.send(service.callDownStream());
  }

  @Get("/get2")
  List<String> testList(@FormParam String d) {
    return List.of("ffd");
  }

  @Get("/get2")
  String[] testarr() {
    return null;
  }

  @Post("/post")
  RequestModel testPost(RequestModel model) {

    return model;
  }

  @Get("/health")
  String health() {

    return "healthlmao";
  }
}
