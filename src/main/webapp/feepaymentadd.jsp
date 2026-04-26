<!DOCTYPE html>
<html>
<head>
    <title>Add Payment</title>
</head>
<body>

<h2>Add Fee Payment</h2>

<form action="/CollegeFeeWebApp/addPayment" method="post">
Student ID:<br>
<input type="text" name="studentId" required><br><br>

Student Name:<br>
<input type="text" name="studentName" required><br><br>

Payment Date:<br>
<input type="date" name="paymentDate" required><br><br>

Amount:<br>
<input type="text" name="amount" required><br><br>

Status:<br>
<select name="status">
    <option value="Paid">Paid</option>
    <option value="Overdue">Overdue</option>
</select><br><br>

<input type="submit" value="Add Payment">

</form>

<br>
<a href="index.jsp">Back</a>

</body>
</html>