package rest.example.api;

import rest.example.server.ContentGenerator;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@SuppressWarnings("NotNullNullableValidation")
@Path("/time")
public final class PathREST {

  @GET
  public String get() {
    return new ContentGenerator().content();
  }
}
