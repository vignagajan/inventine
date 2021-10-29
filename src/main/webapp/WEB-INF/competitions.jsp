<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${host_url}/static/css/competitions.css">




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


        <div class="wrap">
            <div class="search">
                <input type="text" class="searchTerm" placeholder="What are you looking for?">
                <button type="submit" class="searchButton">
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </div>
        <div class="rowbutton">
            <a href=""><button class="b">Food</button></a>
            <a href=""><button class="b">Software</button></a>
            <a href=""><button class="b">Tech</button></a>
            <a href=""><button class="b">All</button></a>
            <a href=""><button class="b">Art</button></a>
            <a href=""><button class="b">Film</button></a>
            <a href=""><button class="b">Punlication</button></a>
        </div>






        <div class="main">
            <ul class="cards">
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=1"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=2"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=11"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=10"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=3"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=8"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=7"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=6"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
                <li class="cards_item">
                    <div class="card">
                        <div class="card_image"><img src="https://picsum.photos/500/300/?image=5"></div>
                        <div class="card_content">
                            <h2 class="card_title">Card Grid Layout</h2>
                            <p class="card_text">Demo of pixel perfect pure CSS simple responsive card grid layout</p>
                            <a href="/inventine_war/competition-profile">
                                                <button class="btn card_btn">View</button>
                                            </a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>



</main>

<%@ include file="/WEB-INF/components/footer.jsp" %>

<script src="static/js/profile.js"></script>
</body>
</html>
