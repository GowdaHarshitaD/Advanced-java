<%@ page session="true" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    // Get name from form
    String name = request.getParameter("username");

    // If user submitted form
    if (name != null) {
        session.setAttribute("user", name);

        // Set session expiry to 60 seconds
        session.setMaxInactiveInterval(60);
    }

    // Get session data
    String user = (String) session.getAttribute("user");

    if (user != null) {
%>

<h2>Hello <%= user %>!</h2>
<p>Your session will expire in 1 minute.</p>

<p>Refresh within 1 minute to keep session alive.</p>
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