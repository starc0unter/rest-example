package rest.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NotNullNullableValidation")
@Path("/returnTypes")
public final class ReturnTypesREST {

    @Path("/void")
    @POST
    public void getVoid() {
    }

    @Path("/response")
    @GET
    public Response getResponse() {
        return Response.ok("ResponseBody")
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .build();
    }

    @Path("/genericEntity")
    @GET
    public GenericEntity<List<String>> getGenericEntity() {
        final List<String> list = new ArrayList<>();
        list.add("string1");
        list.add("string2");
        return new GenericEntity<>(list, List.class);
    }

    @Path("/string")
    @GET
    public String getString() {
        return "data";
    }

}
