
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create patient</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <h2>Register new Patient</h2>
    <form action="" method="get">
        <table border="1">
            <tr>
                <td><label for="fName">First Name:</label> </td>
                <td><input type="text" name="fName" id="fName"></td>
            </tr>
            <tr>
                <td><label for="lName">Last Name: </label> </td>
                <td><input type="text" name="lName" id="lName"></td>
            </tr>
            <tr>
                <td><label for="cEmail">Email: </label> </td>
                <td><input type="text" name="cEmail" id="cEmail"></td>
            </tr>
            <tr>
                <td><label for="phoneNumber">Phone number: </label> </td>
                <td><input type="text" name="phoneNumber" id="phoneNumber"></td>
            </tr>
        </table>
        <p>
        <input type="submit" value="Create">
    </form>

</body>
</html>
