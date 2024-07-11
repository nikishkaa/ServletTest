<%@ page import="java.util.List" %>
<%@ page import="org.example.servlettest.util.XMLCurrencyParser" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 11.07.2024
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    int counter = 0;
%>

<%
    // Java is here
    counter++;
    Object courses = request.getAttribute("courses");

    List<String> currencies = (List<String>) courses;

    XMLCurrencyParser c = new XMLCurrencyParser();

    response.getWriter().println();
%>

<h1>PAGE COUNTER: <%=counter%>
</h1>
<table border="1">
    <tr>
        <th>currencies code</th>
        <th>CU rate</th>
    </tr>
        <%
        for (String s : currencies) {
    %>
    <tr>
        <td> <!-- JSP Expression -->
            <%=XMLCurrencyParser.getCurrency("840")%>
        </td>
        <td> <!-- JSP Expression -->
            978
        </td>
        <td> <!-- JSP Expression -->
            643
        </td>
        <td> <!-- JSP Expression -->
            <%=840%>
        </td>
    </tr>
        <%
   }
    %>

    // Принести базу данных


</body>
</html>
