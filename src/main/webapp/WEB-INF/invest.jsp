<%@ page import="com.inventine.model.Creds" %>
<%@ page import="com.inventine.model.User" %>
<%@ page import="com.inventine.model.Project" %><%--
  Created by IntelliJ IDEA.
  User: amila
  Date: 25/03/2022
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
Project project = (Project) request.getAttribute("project");
User user = (User) request.getAttribute("user");
Creds creds = (Creds) request.getAttribute("creds");
%>
<form method="post" action="https://sandbox.payhere.lk/pay/checkout" >
    <input type="hidden" name="merchant_id" value="1219497">    <!-- Replace your Merchant ID -->
    <input type="hidden" name="return_url" value="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
    <input type="hidden" name="cancel_url" value="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
    <input type="hidden" name="notify_url" value="${System.getenv("HOST_URL")}/payhere">
    <br><br>Item Details<br>
    <input type="text" name="order_id" value="<% out.print(project.getProjectId());%>">
    <input type="text" name="items" value="<% out.print(project.getProjectName());%>"><br>
    <input type="text" name="currency" value="LKR">
    <input type="text" name="amount" value="1000">
    <br><br>Customer Details<br>
    <input type="text" name="first_name" value="<% out.print(user.getFirstName());%>">
    <input type="text" name="last_name" value="<% out.print(user.getLastName());%>"><br>
    <input type="text" name="email" value="<% out.print(creds.getEmail());%>">
    <input type="text" name="phone" value="<% out.print(user.getPhone());%>"><br>
    <input type="text" name="address" value="<% out.print(user.getAddress());%>">
    <input type="text" name="city" value="<% out.print(user.getDistrict());%>">
    <br>
    <input type="submit" value="Confirm" >
</form>
</body>
</html>
