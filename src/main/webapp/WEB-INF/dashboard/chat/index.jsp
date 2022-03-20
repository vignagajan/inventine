<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/dashboard/chat.css">


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>


<main id="main">



    <div class="main-container">
        <div class="container">
            <div class="side-nav">
                <div class="profile">
                    <img style="width: 50px;height: 50px;" src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80">
                </div>
                <div class="icon-container">
                    <i class="fa fa-home"></i>
                </div>
                <div class="icon-container">
                    <i class="fas fa-calendar"></i>
                </div>
                <div class="icon-container active">
                    <i class="fa fa-comment-alt"></i>
                </div>
                <div class="icon-container">
                    <i class="fa fa-list"></i>
                </div>
                <div class="icon-container">
                    <i class="fa fa-sticky-note"></i>
                </div>
            </div>
            <div class="main-veiw">
                <div class="top-nav">
                    <div class="logo">CHAT</div>
                </div>
                <div class="content">
                    <div class="message-list">
                        <div class="list-top">
                            <input type="text">
                            <button class="search">
                                <i class="fa fa-search"></i>
                            </button>
                            <button class="add">
                                +
                            </button>
                            <button class="close-list">
                                <i class="fa fa-chevron-left"></i>
                            </button>
                        </div>
                        <div class="list">
                            <div class="contact unread">
                                <div class="icon">
                                    <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="kitten-image">
                                </div>
                                <div class="blurb">
                                    <h2 class="name">
                                        Emily Wilson
                                    </h2>
                                </div>
                            </div>
                            <div class="contact unread active">
                                <div class="icon">
                                    <img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="kitten-image">
                                </div>
                                <div class="blurb">
                                    <h2 class="name">
                                        Jane Doe
                                    </h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="chat">
                        <div class="top">
                            <div class="open-message">
                                <i class="fa fa-chevron-left"></i>
                            </div>
                            <div class="name" id="open">
                                Jane Doe
                            </div>
                            <div class="button-container">
                                <button>
                                    <i class="fa fa-phone"></i>
                                </button>
                                <button>
                                    <i class="fa fa-camera"></i>
                                </button>
                                <button>
                                    <i class="fa fa-folder"></i>
                                </button>
                            </div>
                        </div>
                        <div class="message-container">
                            <div class="comment me">
                                <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
                                <div class="bubble">
                                    <img src="static/img1.jpg" alt="">
                                </div>
                            </div>
                            <div class="comment me">
                                <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
                                <div class="bubble">
                                    Let me know if this works
                                </div>
                            </div>
                            <div class="comment other">
                                <img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <div class="bubble">
                                    yes this is great
                                </div>
                            </div>
                            <div class="divider"><span>
                    Feb 8 12:01
                  </span></div>
                            <div class="comment other">
                                <img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <div class="bubble">
                                    Did you find a place for monday's metting?
                                </div>
                            </div>
                            <div class="comment me">
                                <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
                                <div class="bubble">
                                    I found a couple venues. The one on meeting street seems nice.
                                </div>
                            </div>
                            <div class="comment me">
                                <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
                                <div class="bubble">
                                    can you give me some guidelines to follow as I look for one?
                                </div>
                            </div>
                            <div class="comment other">
                                <img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <div class="bubble">
                                    Here's a link to a good one. It should be avalible.
                                    <a href="#">venues.com</a>
                                </div>
                            </div>
                            <div class="divider">
                                <span>Today 8:58 PM</span>
                            </div>
                            <div class="comment me">
                                <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
                                <div class="bubble">
                                    Are we still holding the metting on monday?
                                </div>
                            </div>
                            <div class="comment other">
                                <img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <div class="bubble">
                                    Yeah, can you bring napkins?
                                </div>
                            </div>
                            <div class="comment other">
                                <img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <div class="bubble">
                                    I've got napkins covered 👍
                                </div>
                            </div>
                            <div class="comment me">
                                <img src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29ufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80" alt="">
                                <div class="bubble">
                                    How do you feel about terraforming?
                                </div>
                            </div>
                            <div class="comment other">
                                <img src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <div class="bubble">
                                    I feel like thats's a bit off topic.
                                </div>
                            </div>
                        </div>
                        <div class="input-container">
                            <button class="attach">
                                <i class="fa fa-paperclip"></i>
                            </button>
                            <div class="textarea-container">
                                <textarea type="text" placeholder="message"></textarea>
                            </div>
                            <button class="send">
                                <i class="fa fa-paper-plane"></i>
                            </button>
                        </div>
                    </div>
                    <div class="contact-detail">
                        <button class="close">
                            x
                        </button>
                        <img src="https://placekitten.com/200/200?image=2" alt="">
                        <h3>Jane Doe</h3>
                        <div class="bio">
                            A bunch of great weirdos
                        </div>
                        <ul class="contact-list">
                            <li>
                                <img class="contact-img" src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <span class="name">
                    Maria Hugges
                  </span>
                            </li>
                            <li>
                                <img class="contact-img" src="https://img.freepik.com/free-photo/cheerful-curly-business-girl-wearing-glasses_176420-206.jpg?size=626&ext=jpg" alt="">
                                <span class="name">
                    Lucy Farrel
                  </span>
                            </li>
                            <li>
                                <img class="contact-img" src="https://placekitten.com/540/540" alt="">
                                <span class="name">
                    Your Neighbor
                  </span>
                            </li>
                            <li>
                                <img class="contact-img" src="https://placekitten.com/550/555" alt="">
                                <span class="name">
                    Sam Willis
                  </span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>





</main>





<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>