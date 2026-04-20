<%@ page import="javax.servlet.http.*" %>
<html>
<body>

<%
    String name = request.getParameter("cname");
    String domain = request.getParameter("cdomain");
    String ageStr = request.getParameter("cage");

    int age = 0;

    if (ageStr != null && !ageStr.isEmpty()) {
        age = Integer.parseInt(ageStr);
    } else {
        out.println("<h3>Error: Age field is empty!</h3>");
        return;
    }

    Cookie cookie = new Cookie("userName", name);
    cookie.setDomain(domain);
    cookie.setMaxAge(age);

    response.addCookie(cookie);
%>

<h2>Cookie Created Successfully!</h2>

<p>Name: <%= name %></p>
<p>Domain: <%= domain %></p>
<p>Max Age: <%= age %></p>

<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>