package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.FeePaymentDAO;

@WebServlet("/deletePayment")
public class DeleteFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int paymentId = Integer.parseInt(request.getParameter("paymentId"));

        FeePaymentDAO dao = new FeePaymentDAO();
        dao.deletePayment(paymentId);

        response.sendRedirect("feepaymentdisplay.jsp");
    }
}