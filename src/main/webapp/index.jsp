<!DOCTYPE html>
<html>
<head>
    <title>Student Result Form</title>
    <script>
        function validateForm() {
            let roll = document.forms["form"]["rollno"].value;
            let name = document.forms["form"]["name"].value;
            let marks = ["sub1","sub2","sub3","sub4","sub5"];

            if (roll === "" || name === "") {
                alert("Roll No and Name are required!");
                return false;
            }

            for (let i = 0; i < marks.length; i++) {
                let value = document.forms["form"][marks[i]].value;
                if (value === "" || isNaN(value) || value < 0 || value > 100) {
                    alert("Enter valid marks (0-100) for all subjects!");
                    return false;
                }
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>Student Marks Entry</h2>
    <form name="form" action="ResultServlet" method="post" onsubmit="return validateForm()">
        Roll No: <input type="text" name="rollno"><br><br>
        Name: <input type="text" name="name"><br><br>

        Subject 1: <input type="text" name="sub1"><br>
        Subject 2: <input type="text" name="sub2"><br>
        Subject 3: <input type="text" name="sub3"><br>
        Subject 4: <input type="text" name="sub4"><br>
        Subject 5: <input type="text" name="sub5"><br><br>

        <input type="submit" value="Calculate Result">
    </form>
</body>
</html>