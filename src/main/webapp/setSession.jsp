<%@ page session="true" %>
<html>
<head>
    <title>Session Started</title>
</head>
<body>

<%
    String name = request.getParameter("username");
    String timeStr = request.getParameter("time");

    int time = Integer.parseInt(timeStr);

    // Store in session
    session.setAttribute("user", name);

    // Set custom session expiry time
    session.setMaxInactiveInterval(time);
%>

<h2>Hello <%= name %>!</h2>
<p>Your session is set for <%= time %> seconds.</p>

<p>
Click below link to check session before expiry:
</p>

<a href="checkSession.jsp">Check Session</a>

<p>Or wait for the given time and then click the link to see session expiry.</p>

</body>
</html>