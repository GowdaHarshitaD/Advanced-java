<%@ page import="java.util.*, com.dao.FeePaymentDAO, com.model.FeePayment" %>

<html>
<body>

<h2>Fee Payment Records</h2>

<%
    FeePaymentDAO dao = new FeePaymentDAO();
    List<FeePayment> list = dao.getAllPayments();
%>

<table border="1" cellpadding="10">

<tr>
    <th>Payment ID</th>
    <th>Student ID</th>
    <th>Name</th>
    <th>Date</th>
    <th>Amount</th>
    <th>Status</th>
</tr>

<%
    if(list != null && list.size() > 0) {
        for(FeePayment p : list) {
%>

<tr>
    <td><%=p.getPaymentId()%></td>
    <td><%=p.getStudentId()%></td>
    <td><%=p.getStudentName()%></td>
    <td><%=p.getPaymentDate()%></td>
    <td><%=p.getAmount()%></td>
    <td><%=p.getStatus()%></td>
</tr>

<%
        }
    } else {
%>

<tr>
    <td colspan="6">No records found</td>
</tr>

<%
    }
%>

</table>

<br>
<a href="index.jsp">Back</a>

</body>
</html>