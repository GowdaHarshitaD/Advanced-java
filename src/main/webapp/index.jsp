<!DOCTYPE html>
<html>
<head>
<title>College Fee System</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #4facfe, #00f2fe);
    text-align: center;
}

.container {
    margin-top: 80px;
}

h1 {
    color: white;
    margin-bottom: 40px;
}

.btn {
    display: block;
    width: 300px;
    margin: 10px auto;
    padding: 15px;
    background: white;
    color: #333;
    text-decoration: none;
    border-radius: 10px;
    font-size: 18px;
    transition: 0.3s;
}

.btn:hover {
    background: #333;
    color: white;
}
</style>
</head>

<body>

<div class="container">
    <h1>💳 College Fee Payment System</h1>

    <a href="feepaymentadd.jsp" class="btn">➕ Add Payment</a>
    <a href="feepaymentdisplay.jsp" class="btn">📄 View Payments</a>
    <a href="feepaymentupdate.jsp" class="btn">✏ Update Payment</a>
    <a href="feepaymentdelete.jsp" class="btn">❌ Delete Payment</a>
    <a href="report_form.jsp" class="btn">📊 Reports</a>
</div>

</body>
</html>