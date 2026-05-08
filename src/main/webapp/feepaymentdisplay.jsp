<%@ page import="java.util.*, com.dao.FeePaymentDAO, com.model.FeePayment" %>

<html>
<head>
<title>View Payments</title>

<style>
body {
    font-family: Arial;
    background: #f4f7fa;
    text-align: center;
}

h2 {
    margin-top: 20px;
}

/* Tabs */
.tabs {
    margin: 20px;
}

.tabs a button {
    padding: 10px 20px;
    margin: 5px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.all { background: #333; color: white; }
.paid { background: green; color: white; }
.overdue { background: red; color: white; }

/* Table */
table {
    margin: 30px auto;
    border-collapse: collapse;
    width: 80%;
    background: white;
    box-shadow: 0 0 10px gray;
}

th {
    background: #4facfe;
    color: white;
    padding: 12px;
}

td {
    padding: 10px;
    border-bottom: 1px solid #ddd;
}

tr:hover {
    background: #f1f1f1;
}

/* Success message */
.success-box {
    background-color:#d4edda;
    color:#155724;
    padding:12px;
    margin:15px auto;
    width:60%;
    text-align:center;
    border-radius:8px;
    font-size:18px;
    font-weight:bold;
}
</style>

</head>

<body>

<!-- ✅ SUCCESS MESSAGE -->
<%
String msg = request.getParameter("msg");
if("success".equals(msg)){
%>

<div class="success-box">
    ✔ Payment Added Successfully!
</div>

<script>
alert("✅ Payment Added Successfully!");
</script>

<%
}
%>

<!-- ✅ TABS -->
<div class="tabs">

<a href="feepaymentdisplay.jsp?type=all">
    <button class="all">All</button>
</a>

<a href="feepaymentdisplay.jsp?type=Paid">
    <button class="paid">Paid</button>
</a>

<a href="feepaymentdisplay.jsp?type=Overdue">
    <button class="overdue">Overdue</button>
</a>

</div>

<h2>Fee Payment Records</h2>

<%
FeePaymentDAO dao = new FeePaymentDAO();

String type = request.getParameter("type");

List<FeePayment> list;

if(type == null || type.equals("all")){
    list = dao.getAllPayments();
} else {
    list = dao.getPaymentsByStatus(type);
}
%>
<table>

<tr>
<th>Payment ID</th>
<th>Student ID</th>
<th>Name</th>
<th>Date</th>
<th>Amount</th>
<th>Status</th>
</tr>

<%
if(list.size() > 0){
    for(FeePayment p : list){
%>

<tr>
<td><%=p.getPaymentId()%></td>
<td><%=p.getStudentId()%></td>
<td><%=p.getStudentName()%></td>
<td><%=p.getPaymentDate()%></td>
<td><%=p.getAmount()%></td>

<td style="color:<%= p.getStatus().equalsIgnoreCase("Paid") ? "green" : "red" %>;">
    <%=p.getStatus()%>
</td>

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
<a href="index.jsp">⬅ Back to Home</a>

</body>
</html>