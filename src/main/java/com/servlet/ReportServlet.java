package com.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.model.FeePayment;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");

        List<FeePayment> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college_fee_db",
                "root",
                "password"
            );

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM FeePayments WHERE PaymentDate BETWEEN ? AND ?"
            );

            ps.setDate(1, java.sql.Date.valueOf(fromDate));
            ps.setDate(2, java.sql.Date.valueOf(toDate));

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                FeePayment p = new FeePayment();

                p.setPaymentId(rs.getInt("PaymentID"));
                p.setStudentId(rs.getString("StudentID"));
                p.setStudentName(rs.getString("StudentName"));
                p.setPaymentDate(rs.getDate("PaymentDate"));
                p.setAmount(rs.getDouble("Amount"));
                p.setStatus(rs.getString("Status"));

                list.add(p);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("data", list);
        request.getRequestDispatcher("report_result.jsp").forward(request, response);
    }
}