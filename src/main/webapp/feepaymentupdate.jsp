<html>
<head>
<title>Update Payment</title>

<script>
function fetchData() {
    let id = document.getElementById("paymentId").value;

    if(id === "") return;

    fetch("getPayment?paymentId=" + id)
    .then(response => response.json())
    .then(data => {
        document.getElementById("studentId").value = data.studentId;
        document.getElementById("studentName").value = data.studentName;
        document.getElementById("paymentDate").value = data.paymentDate;
        document.getElementById("amount").value = data.amount;
        document.getElementById("status").value = data.status;
    })
    .catch(err => console.log(err));
}
</script>

</head>

<body>

<h2>Update Fee Payment</h2>

<form action="updatePayment" method="post">

Payment ID:
<input type="number" id="paymentId" name="paymentId" onblur="fetchData()" required><br><br>

Student ID:
<input type="text" id="studentId" name="studentId"><br><br>

Student Name:
<input type="text" id="studentName" name="studentName"><br><br>

Payment Date:
<input type="date" id="paymentDate" name="paymentDate"><br><br>

Amount:
<input type="number" id="amount" name="amount"><br><br>

Status:
<select id="status" name="status">
    <option>Paid</option>
    <option>Overdue</option>
</select><br><br>

<input type="submit" value="Update">

</form>

</body>
</html>