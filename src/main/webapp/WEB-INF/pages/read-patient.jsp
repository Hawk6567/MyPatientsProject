<%@ page import="learn.home.model.Patient" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19.11.2021
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read all patients</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Current patient</h1>
<%
    Patient patient = (Patient) request.getAttribute("patient");
%>
<table border="1">
    <tr>
        <td>ID:</td>
        <td><strong><%=patient.getId()%></strong></td>
    </tr>
    <tr>
        <td>First Name:</td>
        <td><strong><%=patient.getfName()%></strong></td>
    </tr>
    <tr>
        <td>Surname</td>
        <td><strong><%=patient.getlName()%></strong></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><strong><%=patient.getEmail()%></strong></td>
    </tr>
    <tr>
        <td>Phone number</td>
        <td><strong><%=patient.getPhoneNumber()%></strong></td>
    </tr>

</table>
</body>
</html>
