package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

@WebServlet("/sessionInfo")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get session object
        HttpSession session = request.getSession(true);

        // Set session timeout to 60 seconds
        session.setMaxInactiveInterval(60);

        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        // Get session details
        String sessionID = session.getId();
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        // Output
        out.println("<html><body>");
        out.println("<h2>Session Tracking Information</h2>");

        out.println("<p><b>Session ID:</b> " + sessionID + "</p>");
        out.println("<p><b>Session Creation Time:</b> " + creationTime + "</p>");
        out.println("<p><b>Last Access Time:</b> " + lastAccessTime + "</p>");
        out.println("<p><b>Visit Count:</b> " + visitCount + "</p>");

        out.println("<p>(Refresh page to increase visit count)</p>");
        out.println("<p>(After 60 sec inactivity → session expires → count resets)</p>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
