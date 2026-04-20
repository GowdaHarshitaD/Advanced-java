<%@ page session="true" %>
<html>
<head>
    <title>Check Session</title>
</head>
<body>

<%
    String user = (String) session.getAttribute("user");

    if (user != null) {
%>

<h2>Hello <%= user %>! Session is still active.</h2>

<%
    } else {
%>

<h2>Session Expired!</h2>
<p>Please start again.</p>
<a href="index.jsp">Go Back</a>

<%
    }
%>

</body>
</html>