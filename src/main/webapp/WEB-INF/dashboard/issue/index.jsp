<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>


<main id="main">

    <button style="display: none" class="show-modal">Log       In</button>

    <!-- the modal itself -->
    <div style="display: none" class="modal hidden">

        <!-- button to close the modal -->
        <button  class="close-modal">&times;</button>

        <h3 >Do you want to delete the project?</h3>
        <form action="">
            <p style="text-align: left;margin-top: 20px;">Type the project name to delete...</p>
            <input type="email" id="" placeholder="restored-cars">
            <button type="submit">Delete project</button>
        </form>
    </div>
    <div style="display: none" class="overlay hidden"></div>

    <!-- the 4 cards containing data at top -->
    <div class="main-overview">

        <div class="overviewcard" style="background-color:white;color: rgb(182, 0, 182);">
            <div><i class="fas fa-money-check-alt fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>Investors</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">59</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(3, 216, 21);">
            <div><i class="far fa-lightbulb fa-2x"></i></div>
            <div class="overviewcard__icon" >
                <div>Projects</div>
                <div class="overviewcard__info"style="font-size: 36px;float: right">9</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(0, 110, 255);">
            <div><i class="fas fa-people-carry fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>Meetings</div>
                <div class="overviewcard__info" style="font-size: 36px;float: right">203</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(255, 0, 76);">
            <div><i class="fas fa-hand-holding-usd fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>Funds (k)</div>
                <div class="overviewcard__info" style="font-size: 36px;float: right">123</div>
            </div>
        </div>

    </div>
    <!-- end of 4 data cards -->


    <div class="cbutton">
        <button class="createbutton">Create Issue</button>
    </div>

    <div class="main-tables">
        <table id="example" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>

                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Date Created</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tfoot>
            <tr>

                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Date Created</th>
                <th>Actions</th>
            </tr>
            </tfoot>

            <tbody>
            <tr>

                <td>100028</td>
                <td>Jack</td>
                <td>Jack@gmail.com</td>
                <td>2011/04/25</td>
                <td> <button class="updatebutton" id="idUpdateButton" onclick="idUpdateButton_onclick();">Update</button>
                    <button class="deletebutton" id="idDeleteButton" onclick="idDeleteButton_onclick();">Delete</button>
                </td>
            </tr>
            <tr>

                <td>100099</td>
                <td>Sahar</td>
                <td>sahar@gmail.com</td>
                <td>2011/07/25</td>
                <td> <button class="updatebutton" id="idUpdateButton" onclick="idUpdateButton_onclick();">Update</button>
                    <button class="deletebutton" id="idDeleteButton" onclick="idDeleteButton_onclick();">Delete</button>
                </td>
            </tr>



            </tbody>
        </table>
    </div>






</main>


<!-- javascript -->
<script>
    $(document).ready(function() {

        const modal = document.querySelector(".modal"); //selects the modal
        const btnCloseModal = document.querySelector(".close-modal"); //selects the button to close the modal
        const btnOpenModal = document.querySelector(".show-modal"); //selects the button to show the modal
        const overlay = document.querySelector(".overlay"); //selects the overlay

        const toggleModal = function () {
            modal.classList.toggle("hidden");
            overlay.classList.toggle("hidden");
        };

        btnOpenModal.addEventListener("click", toggleModal);

        btnCloseModal.addEventListener("click", toggleModal);

        overlay.addEventListener("click", toggleModal);

        var table = $('#example').DataTable({
            select: false,
        });//End of create main table


        $('#example tbody').on( 'click', 'tr', function () {

            alert(table.row( this ).data()[0]);

        } );

        var table = $('#example1').DataTable({
            select: false,

        });//End of create main table


        $('#example1 tbody').on( 'click', 'tr', function () {

            alert(table.row( this ).data()[0]);

        } );
    });



</script>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>
</body>
</html>

