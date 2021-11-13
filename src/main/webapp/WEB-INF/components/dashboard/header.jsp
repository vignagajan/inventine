<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header start -->
<header id="header">
    <h1 id="title" >

       Dashboard

    </h1>
    <div class="user-wrapper">
        <h4 href="${host_url}/profile"> <%= (String)session.getAttribute("username")%></h4>
        <div class="dropdown">
            <img src="${host_url}static/img/img2.png" width="50px" height="50px" alt="">
            <div class="dropdown-content">
<%--                <a href="#">Generate Report</a>--%>
                <a href="${host_url}/profile">Profile</a>
                <a href="${host_url}">Homepage</a>
                <a href="${host_url}/logout">Logout</a>
            </div>
        </div>
    </div>

</header>
<!-- header end -->