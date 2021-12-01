<%@ page import="java.util.List" %>
<%@ page import="learn.home.model.Patient" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of patients</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <h2>List of patients</h2>
<%
    List<Patient> patients = (List<Patient>) request.getAttribute("patients");
    if (!patients.isEmpty()){
%>
    <table border="1">
        <tr>
            <th>Id.</th>
            <ht>FirstName</ht>
            <th>LastName</th>
            <th>Email<th>
            <th>PhoneNumber</th>
            <th colspan="5">Operation</th>
        </tr>
        <%
            for(int i = 0;i<patients.size();i++){
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=patients.get(i).getfName()%></td>
            <td><%=patients.get(i).getlName()%></td>
            <td><%=patients.get(i).getEmail()%></td>
            <td><%=patients.get(i).getPhoneNumber()%></td>
            <td><a href="/read-patient?id=<%=patients.get(i).getId()%>">Read</a></td>
            <td><a href="/edit-patient?id=<%=patients.get(i).getId()%>">Edit</a></td>
            <td><a href="/delete-patient?id=<%=patients.get(i).getId()%>">Delete</a></td>
        </tr>
        <%
            }
        %>
    </table>
<%
    }
%>
</body>
</html>
