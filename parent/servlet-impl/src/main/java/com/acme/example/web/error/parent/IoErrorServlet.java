package com.acme.example.web.error.parent;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletPattern;

@Component
@HttpWhiteboardServletPattern("/error/io/*")
public class IoErrorServlet extends HttpServlet implements Servlet {
    
    private static final long serialVersionUID = -6878372997572258542L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        throw new IOException("The IoErrorServlet threw an IOException");
    }
}
