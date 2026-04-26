<!DOCTYPE html>
<html>
<head>
    <title>Delete Payment</title>
</head>
<body>

<h2>Delete Payment</h2>

<form action="/CollegeFeeWebApp/deletePayment" method="post">
Payment ID:<br>
<input type="text" name="paymentId" required><br><br>

<input type="submit" value="Delete">

</form>

<br>
<a href="index.jsp">Back</a>

</body>
</html>