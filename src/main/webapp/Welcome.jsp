<%@ page session="true" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    String name = request.getParameter("username");

    if (name != null) {
        // Create session and store name
        session.setAttribute("user", name);

        // Set session timeout to 1 minute (60 seconds)
        session.setMaxInactiveInterval(60);
    }

    String user = (String) session.getAttribute("user");

    if (user != null) {
%>

<h2>Hello <%= user %>!</h2>
<p>Your session will expire in 1 minute.</p>

<a href="welcome.jsp">Refresh Page</a>

<%
    } else {
%>

<h2>Session Expired!</h2>
<p>Please enter your name again.</p>
<a href="index.html">Go Back</a>

<%
    }
%>

</body>
</html>