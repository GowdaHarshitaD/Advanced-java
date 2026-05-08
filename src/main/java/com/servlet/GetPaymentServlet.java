package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/getPayment")
public class GetPaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("paymentId"));

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college_fee_db",
                "root",
                "password"
            );

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM FeePayments WHERE PaymentID=?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                out.print("{");
                out.print("\"studentId\":\"" + rs.getString("StudentID") + "\",");
                out.print("\"studentName\":\"" + rs.getString("StudentName") + "\",");
                out.print("\"paymentDate\":\"" + rs.getDate("PaymentDate") + "\",");
                out.print("\"amount\":\"" + rs.getDouble("Amount") + "\",");
                out.print("\"status\":\"" + rs.getString("Status") + "\"");
                out.print("}");
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}