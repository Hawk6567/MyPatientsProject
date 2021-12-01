<%@ page import="learn.home.model.Patient"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Edit Patient</title>
</head>
<body>
<%@include file="header.jsp"%>

<%
    Patient patient = (Patient) request.getAttribute("patient");
%>

<h2>Change car`s parameters</h2>

<form action="" method="post">
    <table border="1">
        <tr>
            <td><label for="id">Id: </label></td>
            <td><input type="text" name="id" id="id" disabled
                       value="<%=patient.getId()%>"></td>
        </tr>
        <tr>
            <td><label for="fName">First Name: </label></td>
            <td><input type="text" name="fName" id="fName"
                       value="<%=patient.getfName()%>"></td>
        </tr>
        <tr>
            <td><label for="lName">Last Name: </label></td>
            <td><input type="text" name="lName" id="lName"
                       value="<%=patient.getlName()%>"></td>
        </tr>
        <tr>
            <td><label for="cEmail">Email: </label></td>
            <td><input type="text" name="cEmail" id="cEmail"
                       value="<%=patient.getEmail()%>"></td>
        </tr>
        <tr>
            <td><label for="phoneNumber">Phone number: </label></td>
            <td><input type="text" name="phoneNumber" id="phoneNumber"
                       value="<%=patient.getPhoneNumber()%>"></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Update">
</form>

</body>
</html>