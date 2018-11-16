package com.acme.example.web.error.parent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletErrorPage;

@Component
@HttpWhiteboardServletErrorPage(errorPage = {"418"})
public class TeapotErrorHandlerImpl extends HttpServlet implements Servlet {
    
    private static final long serialVersionUID = -6878372997572258542L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer code = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String message = (String) req.getAttribute("javax.servlet.error.message");
        
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.append("The teapot handler was called with an incoming error code of ");
        writer.append(String.valueOf(code));
        writer.append(" and a message \"");
        writer.append(message);
        writer.append("\"");
    }
}
