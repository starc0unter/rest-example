package rest.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@SuppressWarnings("NotNullNullableValidation")
@Path("/options")
public final class OptionsREST {

    @OPTIONS
    public Response options() {
        return Response.ok("Non-REST response body")
                .header("Allow", "OPTIONS, HEAD, NOT GET")
                .build();
    }

    @HEAD
    public Response head() {
        return Response.ok()
                .header("MyFavouriteParam1", "value1")
                .header("MyFavouriteParam2", "value2")
                .build();
    }

    @GET
    public String get() {
        return "response";
    }
}
