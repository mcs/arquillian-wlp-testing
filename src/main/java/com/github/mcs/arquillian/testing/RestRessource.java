package com.github.mcs.arquillian.testing;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RestRessource {

    @GET
    @Path("{name}")
    public String sayHello(@PathParam("name") String name) {
        return "Hello " + name;
    }
}
