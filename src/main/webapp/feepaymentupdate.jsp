<!DOCTYPE html>
<html>
<head>
    <title>Update Payment</title>
</head>
<body>

<h2>Update Fee Payment</h2>

<form action="updatePayment" method="post">

Payment ID:<br>
<input type="text" name="paymentId" required><br><br>

Student ID:<br>
<input type="text" name="studentId"><br><br>

Student Name:<br>
<input type="text" name="studentName"><br><br>

Payment Date:<br>
<input type="date" name="paymentDate"><br><br>

Amount:<br>
<input type="text" name="amount"><br><br>

Status:<br>
<select name="status">
    <option value="Paid">Paid</option>
    <option value="Overdue">Overdue</option>
</select><br><br>

<input type="submit" value="Update">

</form>

<br>
<a href="index.jsp">Back</a>

</body>
</html>