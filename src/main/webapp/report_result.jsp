<%@ page import="java.util.*, com.model.FeePayment" %>

<html>
<body>

<h2>Report Result</h2>

<%
List<FeePayment> list = (List<FeePayment>) request.getAttribute("data");
%>

<table border="1">

<tr>
    <th>ID</th>
    <th>Student ID</th>
    <th>Name</th>
    <th>Date</th>
    <th>Amount</th>
    <th>Status</th>
</tr>

<%
if(list != null && !list.isEmpty()){
    for(FeePayment p : list){
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