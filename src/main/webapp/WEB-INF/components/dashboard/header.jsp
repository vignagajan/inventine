<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header start -->
<header id="header">
    <h1 id="title" >
        <%= (String)session.getAttribute("username")%>
    </h1>
    <div class="user-wrapper">
        <h4>admin</h4>
        <div class="dropdown">
            <img src="static/img/img2.png" width="50px" height="50px" alt="">
            <div class="dropdown-content">
                <a href="#">Generate Report</a>
                <a href="#">Profile</a>
                <a href="#">Homepage</a>
                <a href="#">Logout</a>
            </div>
        </div>
    </div>

</header>
<!-- header end -->
