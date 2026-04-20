package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/primeCheck")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int num = Integer.parseInt(request.getParameter("num"));
            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            out.println("<html><body>");

            if (isPrime) {
                out.println("<h2>" + num + " is a Prime Number</h2>");
            } else {
                out.println("<h2>" + num + " is NOT a Prime Number</h2>");
            }

            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<h3>Invalid Input!</h3>");
        }
    }

    // Handle GET (avoids 405 error)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}