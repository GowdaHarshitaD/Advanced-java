<!DOCTYPE html>
<html>
<head>
<title>Add Payment</title>
<head>
<title>Add Payment</title>

<script>
function validateForm() {
    let amt = document.forms["form1"]["amount"].value;

    if (amt <= 0) {
        alert("Amount must be positive");
        return false;
    }
}
</script>

</head>
<style>
body {
    font-family: Arial;
    background: #f4f7fa;
}
<%
int randomId = (int)(Math.random() * 10000);
%>

<label>Payment ID</label>
<input type="text" value="<%=randomId%>" readonly>
.form-container {
    width: 400px;
    margin: 50px auto;
    background: white;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 0 10px gray;
}

h2 {
    text-align: center;
}

input, select {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border-radius: 5px;
    border: 1px solid #ccc;
}

button {
    width: 100%;
    padding: 12px;
    background: #4facfe;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 16px;
}

button:hover {
    background: #007bff;
}
</style>
</head>

<body>

<div class="form-container">

<h2>Add Fee Payment</h2>

<form action="addPayment" method="post">

<label>Student ID</label>
<input type="text" name="studentId" required>

<label>Student Name</label>
<input type="text" name="studentName" required>

<label>Payment Date</label>
<input type="date" name="paymentDate" required>

<label>Amount</label>
<input type="number" name="amount" min="1" required>

<label>Status</label>
<select name="status">
    <option>Paid</option>
    <option>Overdue</option>
</select>

<button type="submit">Add Payment</button>

</form>

</div>

</body>
</html>