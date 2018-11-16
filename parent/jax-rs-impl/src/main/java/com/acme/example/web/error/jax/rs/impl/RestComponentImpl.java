package com.acme.example.web.error.jax.rs.impl;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

@Component(service=RestComponentImpl.class)
@JaxrsResource
@Path("error")
public class RestComponentImpl {
    @Path("io")
    @GET
    public String throwIO() throws IOException {
        throw new IOException("The REST component threw an IOException");
    }
}
