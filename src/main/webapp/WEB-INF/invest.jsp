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
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/dashboard/form.css">
</head>
<body>
<%
Project project = (Project) request.getAttribute("project");
User user = (User) request.getAttribute("user");
Creds creds = (Creds) request.getAttribute("creds");
%>
<div class="form">

    <!-- input boxes start -->
    <div class="details">
<form method="post" action="https://sandbox.payhere.lk/pay/checkout" >
    <div class="input-box">
    <input type="hidden" name="merchant_id" value="1219497">    <!-- Replace your Merchant ID -->
    </div>
    <div class="input-box">
    <input type="hidden" name="return_url" value="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
    </div>
    <div class="input-box">
    <input type="hidden" name="cancel_url" value="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
    </div>
    <div class="input-box">
    <input type="hidden" name="notify_url" value="${System.getenv("HOST_URL")}/payhere">
    </div>
    <br><br>Item Details<br>
    <div class="input-box">
        <span class="details">Project ID</span>
    <input type="text" name="order_id" value="<% out.print(project.getProjectId());%>" disabled>
    </div>
    <div class="input-box">
        <span class="details">Project Name</span>
    <input type="text" name="items" value="<% out.print(project.getProjectName());%>" disabled><br>
    </div>
    <div class="input-box">
        <span class="details">Currency</span>
    <input type="text" name="currency" value="LKR" disabled>
    </div>
    <div class="input-box">
        <span class="details">Amount</span>
    <input type="text" name="amount" value="1000">
    </div>
    <br><br>Customer Details<br>
    <div class="input-box">
        <span class="details">First Name</span>
    <input type="text" name="first_name" value="<% out.print(user.getFirstName());%>" disabled>
    </div>
    <div class="input-box">
        <span class="details">Last Name</span>
    <input type="text" name="last_name" value="<% out.print(user.getLastName());%>" disabled><br>
    </div>
    <div class="input-box">
        <span class="details">Email</span>
    <input type="text" name="email" value="<% out.print(creds.getEmail());%>" disabled>
    </div>
    <div class="input-box">
        <span class="details">Phone</span>
    <input type="text" name="phone" value="<% out.print(user.getPhone());%>" disabled><br>
    </div>
    <div class="input-box">
        <span class="details">Address</span>
    <input type="text" name="address" value="<% out.print(user.getAddress());%>" disabled>
    </div>
    <div class="input-box">
        <span class="details">District</span>
    <input type="text" name="city" value="<% out.print(user.getDistrict());%>" disabled>
    </div>
    <br>
    <button type="submit">Confirm</button>
</form>

    </div>
</div>
</body>
</html>
