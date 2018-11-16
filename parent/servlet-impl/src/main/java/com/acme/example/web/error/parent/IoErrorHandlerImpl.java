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
@HttpWhiteboardServletErrorPage(errorPage = {"java.io.IOException"})
public class IoErrorHandlerImpl extends HttpServlet implements Servlet {
    
    private static final long serialVersionUID = -6878372997572258542L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.append("The IO Error handler was called with an incoming exception: " + throwable.getMessage());
        writer.println();
        writer.println();
        throwable.printStackTrace(writer);
    }
}
