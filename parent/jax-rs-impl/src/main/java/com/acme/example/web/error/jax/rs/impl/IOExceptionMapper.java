package com.acme.example.web.error.jax.rs.impl;

import java.io.IOException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsExtension;

@Component
@JaxrsExtension
public class IOExceptionMapper implements ExceptionMapper<IOException>{
    @Override
    public Response toResponse(IOException exception) {
        return Response.ok("Safely defused the IOException: " + exception.getMessage()).build();
    }
}
