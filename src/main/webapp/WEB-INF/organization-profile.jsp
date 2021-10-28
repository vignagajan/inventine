<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${host_url}/static/css/competition.css">
    <link rel="stylesheet" href="${host_url}/static/css/contactus.css">
    <link rel="stylesheet" href="${host_url}/static/css/organization.css">
    <link rel="stylesheet" href="${host_url}/static/css/project-cards.css">



</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>



<main id="main">

    <div class="container">
        <div class="top-image">
            <img style="height: 100%; width: 100%;" src="https://upload.wikimedia.org/wikipedia/commons/9/9a/Midpoint_Nokia_Karaportti.jpg">
        </div>
        <div class="row">
            <div class="left">
                <img class="photo" src="https://www.allcareer.online/wp-content/uploads/2021/06/Nokia.jpg">
                <h4 class="name">NOKIA</h4>
                <p class="info">services@nokia.com</p>
                <p class="number-stat">Contact.No: +358 10 44 88 000</p>
                <p class="desc-stat"></p>
                <div class="desc">
                    <p >We create technology that helps the world act together.

                        As a trusted partner for critical networks, we are committed to innovation and technology leadership across mobile, fixed and cloud networks. </p>
                </div>
                <div class="social">
                    <i class="fa fa-facebook-square" aria-hidden="true"></i>
                    <i class="fa fa-twitter-square" aria-hidden="true"></i>
                    <i class="fa fa-tumblr-square" aria-hidden="true"></i>
                </div>
            </div>

            <div class="right">
                <div class="tabs">
                    <button class="tablink" onclick="openPage('Creators', this, '#0097e6','#fff')"id="defaultOpen">Creators</button>
                    <button class="tablink" onclick="openPage('Competitions', this, '#0097e6','#fff')" >Competitions</button>
                    <button class="tablink" onclick="openPage('Contact', this, '#0097e6','#fff')">Contacts Us</button>

                </div>

                <div class="details">
                    <div id="Creators" class="tabcontent">
                        <div class="main">
                            <ul class="cards">
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Emily Wilson</h2>
                                            <a href="profile.html">
                                                <button class="btn card_btn">View</button>
                                            </a>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Jane Doe</h2>
                                            <a href="profile.html">
                                                <button class="btn card_btn">View</button>
                                            </a>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Fred Denvers</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>

                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Beth Wickers</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Tim Buonapart</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Jennifer Le Fay</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>

                    <div id="Competitions" class="tabcontent">
                        <div class="main">
                            <ul class="cards">
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://digitaltimes-media.s3.amazonaws.com/original_images/ai.jpeg"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">Digit Recognizer: Learn computer vision fundamentals with the famous MNIST data</h2>
                                            <a href="competition.html">
                                                <button class="btn card_btn">View</button>
                                            </a>
                                        </div>
                                    </div>
                                </li>
                                <li class="cards_item">
                                    <div class="card">
                                        <div class="card_image"><img src="https://media.nationalgeographic.org/assets/photos/292/614/dc236c71-ed37-4299-9678-e414e1d9aeed_c0-121-2400-1381_r1200x630.jpg?80a71820ca54ba44e21f71c1d177158ff7dd2956"></div>
                                        <div class="card_content">
                                            <h2 class="card_title">LearnPlatform COVID-19 Impact on Digital Learning</h2>
                                            <button class="btn card_btn">View</button>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div id="Contact" class="tabcontent">
                        <div class="container-cu">
                            <div class="row-cu">
                                <h1>Contact Us</h1>
                            </div>
                            <div class="row-cu">
                                <h4 style="text-align:center">Leave a Message, your thoughts are appreciated!</h4>
                            </div>
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
                                <div class="col-md-6 col-sm-12">
                                    <div class="styled-input" style="float:right;">
                                        <label>Phone Number</label>
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
                                    <div class="btn-lrg submit-btn">Send Message</div>
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

<script src="static/js/profile.js"></script>
</body>
</html>
