<%@ page import="com.inventine.model.Competition" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/competitions.css">




</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>



<main id="main">

    <div class="contents">
        <!-- description and image start -->
        <div class="container">
            <div class="column-1 box">
                <h1>Competitions</h1>
                <span class="paragraph">Competition is a rivalry where two or more parties strive for a common goal which cannot be shared: where one's gain is the other's loss. Competition can arise between entities such as individuals, economic and social groups, etc
      Grow your data science skills by competing in our exciting competitions. Find help in the documentation or learn about InClass competitions.</span>
                <div class="hostbutton">
                    <a href="">
                        <button class="button1" style="background-color:black;color:white">
                            <i class="addicon" style="background-color:black;color:white; " sizeValue:18px>+</i>
                            <span class="host">Host a Competition</span>
                        </button>
                    </a>
                </div>
            </div>
            <div class="column-2 box">
                <img src="static/img/imgc.jpg" style="width: 300px;height: 250px;">
            </div>
        </div>
        <!-- discription and image end -->


        <div class="search-bar">
            <table class="search-bar-element">
                <tr>
                    <td>
                        <input type="text" placeholder="Search" class="search">
                    </td>
                    <td>
                        <a href="#"><i class="fas fa-search" style="color:#0e4a6c;text-align:right"></i></a>
                    </td>
                </tr>
            </table>
        </div>
<%--        <div class="rowbutton">--%>
<%--            <a href=""><button class="b">Food</button></a>--%>
<%--            <a href=""><button class="b">Software</button></a>--%>
<%--            <a href=""><button class="b">Tech</button></a>--%>
<%--            <a href=""><button class="b">All</button></a>--%>
<%--            <a href=""><button class="b">Art</button></a>--%>
<%--            <a href=""><button class="b">Film</button></a>--%>
<%--            <a href=""><button class="b">Punlication</button></a>--%>
<%--        </div>--%>






        <div class="main">

                <ul class="cards">
                    <%
                        for ( Competition competition: (ArrayList<Competition>)request.getAttribute("competitions")){
                    %>
                    <div class="card">
                        <div class="card-header">
                            <a href="${System.getenv("HOST_URL")}/competition/<% out.print(competition.getCompetitionId());%>">
                                <img src="https://www.newsbtc.com/wp-content/uploads/2020/06/mesut-kaya-LcCdl__-kO0-unsplash-scaled.jpg" alt="ballons" />
                            </a>
                        </div>
                        <div class="card-body">
                            <span class="tag tag-purple"><% out.print(competition.getCType());%></span>
                            <h4>
                                <a href="${System.getenv("HOST_URL")}/competition/<% out.print(competition.getCompetitionId());%>">
                                    <% out.print(competition.getCompetitionName()); %>
                                </a>
                            </h4>
                            <p>
                                The future can be scary, but there are ways to
                                deal with that fear.
                            </p>
                            <div class="user">
                                <img src="https://images.gr-assets.com/authors/1353452301p8/1406384.jpg" alt="user" />
                                <div class="user-info">
                                    <h5></h5>
                                    <small><%out.print(new Date(competition.getCreatedAt().getTime()));%></small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>

                </ul>
<%--                <div class="card">--%>
<%--                    <div class="card-header">--%>
<%--                        <img src="https://www.newsbtc.com/wp-content/uploads/2020/06/mesut-kaya-LcCdl__-kO0-unsplash-scaled.jpg" alt="ballons" />--%>
<%--                    </div>--%>
<%--                    <div class="card-body">--%>
<%--                        <span class="tag tag-purple">Popular</span>--%>
<%--                        <h4>--%>
<%--                            How to Keep Going When You Don’t Know What’s Next--%>
<%--                        </h4>--%>
<%--                        <p>--%>
<%--                            The future can be scary, but there are ways to--%>
<%--                            deal with that fear.--%>
<%--                        </p>--%>
<%--                        <div class="user">--%>
<%--                            <img src="https://images.gr-assets.com/authors/1353452301p8/1406384.jpg" alt="user" />--%>
<%--                            <div class="user-info">--%>
<%--                                <h5>Eyup Ucmaz</h5>--%>
<%--                                <small>Yesterday</small>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>



                <div class="card">
                    <div class="card-header">
                        <img src="https://images6.alphacoders.com/312/thumb-1920-312773.jpg" alt="city" />
                    </div>
                    <div class="card-body">
                        <span class="tag tag-pink">Design</span>
                        <h4>
                            10 Rules of Dashboard Design
                        </h4>
                        <p>
                            Dashboard Design Guidelines
                        </p>
                        <div class="user">
                            <img src="https://studyinbaltics.ee/wp-content/uploads/2020/03/3799Ffxy.jpg" alt="user" />
                            <div class="user-info">
                                <h5>Carrie Brewer</h5>
                                <small>1w ago</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="https://c0.wallpaperflare.com/preview/483/210/436/car-green-4x4-jeep.jpg" alt="rover" />
                    </div>
                    <div class="card-body">
                        <span class="tag tag-teal">Technology</span>
                        <h4>
                            Why is the Tesla Cybertruck designed the way it
                            is?
                        </h4>
                        <p>
                            An exploration into the truck's polarising design
                        </p>
                        <div class="user">
                            <img src="https://cbsnews2.cbsistatic.com/hub/i/r/2014/11/15/028d7403-becc-414c-8e0a-96c69478c187/thumbnail/1200x630/956b9f22bd7910836f484686d8eac35b/mark-ruffalo-interview-promo.jpg" alt="user" />
                            <div class="user-info">
                                <h5>July Dec</h5>
                                <small>2h ago</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="https://www.newsbtc.com/wp-content/uploads/2020/06/mesut-kaya-LcCdl__-kO0-unsplash-scaled.jpg" alt="ballons" />
                    </div>
                    <div class="card-body">
                        <span class="tag tag-purple">Popular</span>
                        <h4>
                            How to Keep Going When You Don’t Know What’s Next
                        </h4>
                        <p>
                            The future can be scary, but there are ways to
                            deal with that fear.
                        </p>
                        <div class="user">
                            <img src="https://images.gr-assets.com/authors/1353452301p8/1406384.jpg" alt="user" />
                            <div class="user-info">
                                <h5>Eyup Ucmaz</h5>
                                <small>Yesterday</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="https://images6.alphacoders.com/312/thumb-1920-312773.jpg" alt="city" />
                    </div>
                    <div class="card-body">
                        <span class="tag tag-pink">Design</span>
                        <h4>
                            10 Rules of Dashboard Design
                        </h4>
                        <p>
                            Dashboard Design Guidelines
                        </p>
                        <div class="user">
                            <img src="https://studyinbaltics.ee/wp-content/uploads/2020/03/3799Ffxy.jpg" alt="user" />
                            <div class="user-info">
                                <h5>Carrie Brewer</h5>
                                <small>1w ago</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="https://c0.wallpaperflare.com/preview/483/210/436/car-green-4x4-jeep.jpg" alt="rover" />
                    </div>
                    <div class="card-body">
                        <span class="tag tag-teal">Technology</span>
                        <h4>
                            Why is the Tesla Cybertruck designed the way it
                            is?
                        </h4>
                        <p>
                            An exploration into the truck's polarising design
                        </p>
                        <div class="user">
                            <img src="https://cbsnews2.cbsistatic.com/hub/i/r/2014/11/15/028d7403-becc-414c-8e0a-96c69478c187/thumbnail/1200x630/956b9f22bd7910836f484686d8eac35b/mark-ruffalo-interview-promo.jpg" alt="user" />
                            <div class="user-info">
                                <h5>July Dec</h5>
                                <small>2h ago</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="https://www.newsbtc.com/wp-content/uploads/2020/06/mesut-kaya-LcCdl__-kO0-unsplash-scaled.jpg" alt="ballons" />
                    </div>
                    <div class="card-body">
                        <span class="tag tag-purple">Popular</span>
                        <h4>
                            How to Keep Going When You Don’t Know What’s Next
                        </h4>
                        <p>
                            The future can be scary, but there are ways to
                            deal with that fear.
                        </p>
                        <div class="user">
                            <img src="https://images.gr-assets.com/authors/1353452301p8/1406384.jpg" alt="user" />
                            <div class="user-info">
                                <h5>Eyup Ucmaz</h5>
                                <small>Yesterday</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <img src="https://images6.alphacoders.com/312/thumb-1920-312773.jpg" alt="city" />
                    </div>
                    <div class="card-body">
                        <span class="tag tag-pink">Design</span>
                        <h4>
                            10 Rules of Dashboard Design
                        </h4>
                        <p>
                            Dashboard Design Guidelines
                        </p>
                        <div class="user">
                            <img src="https://studyinbaltics.ee/wp-content/uploads/2020/03/3799Ffxy.jpg" alt="user" />
                            <div class="user-info">
                                <h5>Carrie Brewer</h5>
                                <small>1w ago</small>
                            </div>
                        </div>
                    </div>
                </div>

            </ul>
        </div>
    </div>



</main>

<%@ include file="/WEB-INF/components/footer.jsp" %>

<script src="${System.getenv("HOST_URL")}/static/js/profile.js"></script>
</body>
</html>
