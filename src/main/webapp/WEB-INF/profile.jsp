<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${host_url}/static/css/profile.css">
    <link rel="stylesheet" href="${host_url}/static/css/project-cards.css">



</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>



<main id="main">

    <div class="container">
        <div class="top-image">
            <img  src="https://upload.wikimedia.org/wikipedia/commons/9/9a/Midpoint_Nokia_Karaportti.jpg" style="height: 270px;width: 100%;">
        </div>
        <div class="row">
            <div class="left">
                <img class="photo" src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80">
                <h4 class="name">Emily Wilson</h4>
                <p class="info">emily.wilson@gmail.com</p>
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
                    <button class="tablink" onclick="openPage('Contact', this, '#0097e6','#fff')">Contacts</button>

                </div>

                <div class="details">
                    <div id="Projects" class="tabcontent">
                        <div class="main">
                            <ul class="cards">
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-4-180x180.jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Mirror One | Your life at a glance</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://i.etsystatic.com/6563235/r/il/328096/2585488407/il_570xN.2585488407_3gpt.jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Wildlife Illustrated GiftWrap</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-5-180x180.jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">VR Ears | Hear Off-World Listen Off-Ear</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://ae01.alicdn.com/kf/HTB1YA5RedqUQKJjSZFIq6AOkFXaW/Creative-Notebook-Cactus-Leaves-PU-Leather-Cover-Planner-Diary-Book-Exercise-Composition-Binding-Notepad-Gift-Stationery.jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Notebook for your creative observation</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://www.ofdesign.net/wp-content/uploads/images/100-interior-design-ideas-for-kids-room-with-bright-colors-for-girls-and-boys-0-2061936751.jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Beautiful colors for all the designers & students</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://www.gavias-theme.com/wp/krowd/wp-content/uploads/2016/03/campaign-2-180x180.jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">SelfDriving Robot for Target Shooting Game</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>

                    <div id="Organization" class="tabcontent">
                        <h3>Organization</h3>
                        <p>Some news this fine day!</p>
                    </div>

                    <div id="Contact" class="tabcontent">
                        <h3>Contacts</h3>
                        <p>Numbers!</p>
                    </div>
                </div>
            </div>
        </div>
    </div>



</main>

<%@ include file="/WEB-INF/components/footer.jsp" %>

<script src="static/js/profile.js"></script>
</body>
</html>
