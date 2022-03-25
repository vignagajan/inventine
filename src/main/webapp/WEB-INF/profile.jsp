<%@ page import="com.inventine.model.User" %>
<%@ page import="com.inventine.model.Creds" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/profile.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/contactus.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/project-cards.css">



</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>

<%
    User user = (User)request.getAttribute("user");
    Creds cred = (Creds)request.getAttribute("cred");
%>

<main id="main">

    <div class="container">
        <div class="top-image">
            <img  src="${System.getenv("HOST_URL")}/image/<% out.print(user.getHeaderId());%>" style="height: 270px;width: 100%;">
        </div>
        <div class="row">
            <div class="left">
                <img class="photo" src="${System.getenv("HOST_URL")}/image/<% out.print(cred.getProfileId());%>">
                <h4 class="name"><% out.print(user.getFirstName());%> <% out.print(user.getLastName());%> </h4>
                <p class="info"><% out.print(cred.getEmail());%> </p>
                <p class="number-stat">7.8</p>
                <p class="desc-stat">Rating</p>
                <div class="desc">
                    <p >Hi ! My name is Emily Wilson. I'm a UI/UX Designer from Paris, in France. I really enjoy photography and mountains.</p>
                </div>
                <div class="social">
                    <i class="fa fa-facebook-square" aria-hidden="true"></i>
                    <i class="fa fa-twitter-square" aria-hidden="true"></i>
                    <i class="fa fa-tumblr-square" aria-hidden="true"></i>
                </div>
            </div>

            <div class="right">
                <div class="tabs">
                    <button class="tablink" onclick="openPage('Projects', this, '#0097e6','#fff')"id="defaultOpen">Projects</button>
                    <button class="tablink" onclick="openPage('Organization', this, '#0097e6','#fff')" >Organization</button>
                    <button class="tablink" onclick="openPage('Contact', this, '#0097e6','#fff')">Contact</button>

                </div>

                <div class="details">
                    <div id="Projects" class="tabcontent">
                        <div class="main">
                            <ul class="cards">
                                <%
                                    List<User> users= (ArrayList<User>)request.getAttribute("users");
                                    List<Creds> creds= (ArrayList<Creds>)request.getAttribute("creds");
                                    int i = 0;
                                    for ( Project project: (ArrayList<Project>)request.getAttribute("project")){
                                %>
                                <div class="card">
                                    <div class="card-header">
                                        <a href="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
                                            <img src="https://www.newsbtc.com/wp-content/uploads/2020/06/mesut-kaya-LcCdl__-kO0-unsplash-scaled.jpg" alt="ballons" />
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <span class="tag tag-purple"><% out.print(project.getCategory());%></span>

                                        <h4>
                                            <a href="${System.getenv("HOST_URL")}/project/<% out.print(project.getProjectId());%>">
                                                <% out.print(project.getProjectName()); %>
                                            </a>
                                        </h4>
                                        <p>
                                            <%--                        The future can be scary, but there are ways to--%>
                                            <%--                        deal with that fear.--%>
                                        </p>
                                        <div class="user">
                                            <img src="${System.getenv("HOST_URL")}/image/<%out.print(creds.get(i).getProfileId());%>" />
                                            <div class="user-info">
                                                <h5>
                                                    <%out.print(users.get(i).getFirstName());%> <%out.print(users.get(i).getLastName());%></h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%i++;}%>

                            </ul>
                        </div>
                    </div>

                    <div id="Organization" class="tabcontent">
                        <div class="content">
                            <div class="container" style="margin-top: -20px">
                                <div class="column-1">
                                    <h1 style="color:black" >Nokia Corporation</h1>
                                    <span class="paragraph" style="margin-top: 30px;margin-bottom: 30px">At Nokia, we create technology that helps the world act together.<br>

The world is facing fundamental challenges. Pressure on the planet is increasing, productivity is stalling and access to opportunity remains stubbornly unequal. Technology is central to the solution.<br>

Through technology leadership and trusted partnerships, we deliver critical networks to help address global issues.  We have the power to bring together the world’s people, machines and devices, sensing and acting in real time at massive scale. Our critical networks go beyond connectivity to enable self-optimizing, intelligent systems both locally and globally.


        </span>
                                </div>
                                <div class="column-2">
                                    <img src="https://www.nokia.com/sites/default/files/2020-12/Company-page-header-image-1312.jpg" style="width: 100%;height: 300px;margin-top: 30px">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="Contact" class="tabcontent">
                        <div class="container-cu">

                            <div class="row-cu input-container">
                                <div class="col-xs-12">
                                    <div class="styled-input wide">
                                        <label>Name</label>
                                        <input type="text" required />

                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <div class="styled-input">
                                        <label>Email</label>
                                        <input type="text" required />

                                    </div>
                                </div>

                                <div class="col-xs-12">
                                    <div class="styled-input wide">
                                        <label>Message</label>
                                        <textarea required></textarea>

                                    </div>
                                </div>
                                <div class="col-xs-12">
                                    <div class="btn-lrg submit-btn" style="margin-left: 10px">Send Message</div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>



</main>

<%@ include file="/WEB-INF/components/footer.jsp" %>

<script src="${System.getenv("HOST_URL")}/static/js/profile.js"></script>
</body>
</html>
