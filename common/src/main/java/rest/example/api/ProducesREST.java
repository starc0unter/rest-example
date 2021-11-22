package rest.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.Date;

@SuppressWarnings("NotNullNullableValidation")
@Path("/produces")
public final class ProducesREST {
  @GET
//  @Produces({"text/*"})
  @Produces({"text/html; qs=0.7", "text/plain;  qs=0.9"})
  public String get() {
    return content();
  }

  private String content() {
    return "<!DOCTYPE html>" +
        "<html>" +
        "<head><title>Example</title></head>" +
        "<body><h1>" + "Current time " + Date.from(Instant.now()) + "</h1></body>" +
        "</html>";
  }
}
