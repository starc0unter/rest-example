package rest.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@SuppressWarnings("NotNullNullableValidation")
public abstract class Inheritance {
    @GET
    @Produces("application/json")
    public abstract Response get();

    @Path("/inheritance")
    public static final class Child extends Inheritance {

//        if uncommented, then GET annotation from parent will not be inherited.
//        @Produces("application/json")
        @Override
        public Response get() {
            return Response.ok("accepted").header("key", "value").build();
        }
    }
}
