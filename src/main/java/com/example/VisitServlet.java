package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/visitServlet")
public class VisitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 1;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }
                if (c.getName().equals("username")) {
                    name = c.getValue();
                }
            }
        }

        // Create / Update cookies
        Cookie nameCookie = new Cookie("username", name);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // ⏰ Expiry (30 seconds demo)
        nameCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<html><body>");
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");

        // Display cookies with values
        out.println("<h3>Cookie List with Values:</h3>");

        Cookie[] newCookies = request.getCookies();

        if (newCookies != null) {
            for (Cookie c : newCookies) {
                out.println("<p>");
                out.println("Cookie Name: " + c.getName() + "<br>");
                out.println("Cookie Value: " + c.getValue() + "<br>");
                out.println("Max Age: " + c.getMaxAge() + "<br>");
                out.println("</p><hr>");
            }
        } else {
            out.println("<p>No cookies found!</p>");
        }

        out.println("<p>(Refresh within 30 sec → count increases)</p>");
        out.println("<p>(After 30 sec → cookie expires → resets)</p>");

        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }

    // Handle GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}
