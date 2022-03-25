<%@ page import="com.inventine.model.Organization" %>
<%@ page import="com.inventine.model.Competition" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/head-import.jsp" %>
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/competition.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/contactus.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/organization.css">
    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/project-cards.css">



</head>
<body>

<%@ include file="/WEB-INF/components/nav-bar.jsp" %>



<main id="main">

    <%
        Competition competition = (Competition) request.getAttribute("competition");
        Organization organization = (Organization) request.getAttribute("organization");

    %>

    <div class="container">
        <div class="top-image">
            <img style="height: 100%; width: 100%;" src="https://upload.wikimedia.org/wikipedia/commons/9/9a/Midpoint_Nokia_Karaportti.jpg">
        </div>
        <div class="row">
            <div class="left">
                <img class="photo" src="https://www.allcareer.online/wp-content/uploads/2021/06/Nokia.jpg">
                <h4 class="name"><% out.print(organization.getName());%></h4>
                <p class="info"><% out.print(organization.getDistrict());%></p>
                <p class="number-stat">Contact.No:<% out.print(organization.getContactNumber());%></p>
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

                    <div id="Competitions" class="tabcontent">
                        <div class="main">
                            <ul class="cards">
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
