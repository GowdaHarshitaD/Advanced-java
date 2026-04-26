package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/addPayment")
public class AddFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🟢 1. GET DATA FROM FORM
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String paymentDateStr = request.getParameter("paymentDate");
        String amountStr = request.getParameter("amount");
        String status = request.getParameter("status");

        // 🟢 2. CONVERT DATA TYPES
        Date paymentDate = Date.valueOf(paymentDateStr);
        double amount = Double.parseDouble(amountStr);

        // 🟢 3. SET TO MODEL OBJECT
        FeePayment p = new FeePayment();
        p.setStudentId(studentId);
        p.setStudentName(studentName);
        p.setPaymentDate(paymentDate);
        p.setAmount(amount);
        p.setStatus(status);

        // 🟢 4. CALL DAO TO INSERT
        FeePaymentDAO dao = new FeePaymentDAO();
        int result = dao.addPayment(p);

        // DEBUG (OPTIONAL BUT IMPORTANT FOR VIVA)
        System.out.println("Rows inserted = " + result);

        // 🟢 5. REDIRECT TO DISPLAY PAGE (IMPORTANT STEP)
        response.sendRedirect("feepaymentdisplay.jsp");
    }
}