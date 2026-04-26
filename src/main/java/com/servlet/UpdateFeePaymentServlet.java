package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/updatePayment")
public class UpdateFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FeePayment p = new FeePayment();

        p.setPaymentId(Integer.parseInt(request.getParameter("paymentId")));
        p.setStudentId(request.getParameter("studentId"));
        p.setStudentName(request.getParameter("studentName"));
        p.setPaymentDate(Date.valueOf(request.getParameter("paymentDate")));
        p.setAmount(Double.parseDouble(request.getParameter("amount")));
        p.setStatus(request.getParameter("status"));

        FeePaymentDAO dao = new FeePaymentDAO();
        dao.addPayment(p);

        response.sendRedirect("feepaymentdisplay.jsp");
    }
}