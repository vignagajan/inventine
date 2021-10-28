<%@ page import="com.inventine.model.Post" %>
<%@ page import="com.inventine.model.User"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.inventine.model.ForumTopic" %>
<%@ page import="com.inventine.dao.PostDaoImplementation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="/WEB-INF/components/head-import.jsp" %>

    <link rel="stylesheet" href="${host_url}/static/css/home.css">
    <link rel="stylesheet" href="${host_url}/static/css/forum.css">

</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>

<div class="content">
    <!-- description and image start -->
    <div class="container">
        <div class="column-1">
            <h1>MAKE YOUR IDEAS WORKABLE!</h1>
            <span class="paragraph">We are inventine, who makes tour Ideas get funded and mentoring to enhance the business process.</span>
            <div class="search-bar">
                <table class="search-bar-element">
                    <tr>
                        <td>
                            <input type="text" placeholder="Search" class="search">
                        </td>
                        <td>
                            <a href="#"><i class="fas fa-search" style="color:#424242"></i></a>
                        </td>
                    </tr>
                </table>
            </div>

        </div>
        <div class="column-2">
            <div class="image-slider-cont">
                <div class="image-slider">
                    <div class="slideshow-container">

                        <!-- Full-width images with number and caption text -->
                        <div class="mySlides fade">
                            <div class="numbertext">1 / 3</div>
                            <img src="img3.jpg" style="width:100%">
                            <div class="text">Caption Text</div>
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">2 / 3</div>
                            <img src="img1.jpg" style="width:100%" >
                            <div class="text">Caption Two</div>
                        </div>

                        <div class="mySlides fade">
                            <div class="numbertext">3 / 3</div>
                            <img src="img2.jpg" style="width:100%">
                            <div class="text">Caption Three</div>
                        </div>

                        <!-- Next and previous buttons -->
                        <!-- <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                        <a class="next" onclick="plusSlides(1)">&#10095;</a> -->
                    </div>
                    <br>

                    <!-- The dots/circles -->
                    <!-- <div style="text-align:center">
                      <span class="dot" onclick="currentSlide(1)"></span>
                      <span class="dot" onclick="currentSlide(2)"></span>
                      <span class="dot" onclick="currentSlide(3)"></span>
                    </div> -->
                </div>

            </div>
        </div>
    </div>
    <!-- discription and image end -->

</div>
<div class="main">
    <ul class="cards">
        <li class="cards_item">
            <div class="card">
                <div class="card_image"><img style="height: 100%; width: 100%;" src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-4-180x180.jpg"></div>
                <div class="card_content">
                    <h2 class="card_title">Mirror One | Your life at a glance</h2>
                    <button class="btn card_btn">View</button>
                </div>
            </div>
        </li>
        <li class="cards_item">
            <div class="card">
                <div class="card_image"><img style="height: 100%; width: 100%;" src="https://i.etsystatic.com/6563235/r/il/328096/2585488407/il_570xN.2585488407_3gpt.jpg"></div>
                <div class="card_content">
                    <h2 class="card_title">Wildlife Illustrated GiftWrap <br><br></h2>
                    <button class="btn card_btn">View</button>
                </div>
            </div>
        </li>
        <li class="cards_item">
            <div class="card">
                <div class="card_image"><img style="height: 100%; width: 100%;" src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-5-180x180.jpg"></div>
                <div class="card_content">
                    <h2 class="card_title">VR Ears | Hear Off-World Listen Off-Ear</h2>
                    <button class="btn card_btn">View</button>
                </div>
            </div>
        </li>
        <li class="cards_item">
            <div class="card">
                <div class="card_image"><img style="height: 100%; width: 100%;" src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-2-180x180.jpg"></div>
                <div class="card_content">
                    <h2 class="card_title">SelfDriving Robot for Target Shooting Game</h2>
                    <button class="btn card_btn">View</button>
                </div>
            </div>
        </li>

    </ul>
</div>

<div class="forum-cont">
    <div class="container-2">
        <div class="grid-container">
            <div class="item1">Community Activity</div>
            <div class="item23">
                <div class="item2"><label>Sorted by: </label></div>
                <div class="item3">
                    <select class="dropbox" name="" id="">
                        <option value="">Most Recent</option>
                        <option value="">Most Viewed</option>
                        <option value="">Most Commented</option>
                        <option value="">Most Helpful</option>
                    </select>
                </div>
            </div>
            <div class="item4"><a href="http://localhost:8080/inventine_war/dashboard/forumTopic/create"><button class="button2">Start Conversation</button></a></div>
        </div>
    </div>
    <div class="posts">
        <%
            for ( ForumTopic forumTopic: (ArrayList<ForumTopic>)request.getAttribute("forumTopic")){
        %>

        <div class="grid-container-2">

            <div class="post-header">
                <div class="post-header-container-1">
                    <div class="profile-pic">
                        <img style="width: 60px; height: 60px; vertical-align:super;" src="img1.jpg">
                    </div>
                    <div class="profile-owner">
                        <% out.print(forumTopic.getFirstName() + " " + forumTopic.getLastName());%>
                    </div>
                </div>
                <div class="post-header-container-2">
                    <div class="like-amount">
                        <div class="like">
                            <i class="fas fa-thumbs-up "></i>
                        </div>
                        <div class="amount">
                            100
                        </div>
                    </div>
                    <div class="views-amount">
                        <div class="views">
                            <i class="fas fa-eye"></i>
                        </div>
                        <div class="amount">
                            200
                        </div>
                    </div>
                    <div class="comment-amount">
                        <div class="comments">
                            <i class="fas fa-comment"></i>
                        </div>
                        <div class="amount">
                            300
                        </div>
                    </div>
                </div>
            </div>
            <div class="post-title">
                <% out.print(forumTopic.getTitle());%>
            </div>
            <div class="post-cont">
                <% out.print(forumTopic.getDescription());%>
            </div>
            <div class="post-footer">
                <div class="time">
                    <% out.print(forumTopic.getCreatedAt());%>
                </div>
                <div class="catogory">
                    Posted in <label>Catogory</label>
                </div>
                <div class="latest-reply">
                    Latest reply by <label>User</label> on <label>30/05/2021 05:30:21 PM</label>
                </div>
                <div class="like-btn">
                    <button>Like</button>
                </div>
                <div class="reply-btn">
                    <button>Reply</button>
                </div>
            </div>

        </div>
        <%}%>
    </div>

</div>


<%@ include file="/WEB-INF/components/footer.jsp" %>

</body>
</html>

