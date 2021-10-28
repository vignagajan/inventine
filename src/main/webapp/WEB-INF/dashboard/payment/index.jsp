<%@ page import="com.inventine.model.Payment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${host_url}/static/css/dashboard/form.css">

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
            <div><i class="fas fa-chalkboard-teacher fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>Creators</div>
                <div class="overviewcard__info" style="font-size: 36px; float: right;">${creators}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(3, 216, 21);">
            <div><i class="far fa-lightbulb fa-2x"></i></div>
            <div class="overviewcard__icon" >
                <div>Projects</div>
                <div class="overviewcard__info"style="font-size: 36px;float: right">${projects}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(0, 110, 255);">
            <div><i class="fas fa-people-carry fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>Meetings</div>
                <div class="overviewcard__info" style="font-size: 36px;float: right">${meetings}</div>
            </div>
        </div>

        <div class="overviewcard" style="background-color:white;color: rgb(255, 0, 76);">
            <div><i class="fas fa-hand-holding-usd fa-2x"></i></div>
            <div class="overviewcard__icon">
                <div>Payments (k)</div>
                <div class="overviewcard__info" style="font-size: 36px;float: right">${transactions}</div>
            </div>
        </div>

    </div>
    <!-- end of 4 data cards -->


    <div class="main-tables">
        <table id="example" class="table" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Payment ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Amount</th>
                <th>Payment Date</th>

            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>Payment ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Amount</th>
                <th>Payment Date</th>

            </tr>
            </tfoot>

            <tbody>
                  <%
                    for (Payment payment: (ArrayList<Payment>)request.getAttribute("payments")){
                  %>
                  <tr>
                    <th><% out.print(payment.getPaymentId());%></th>
                    <th><% out.print(payment.getProjectId());%></th>
                    <td>Book Light</td>
                    <td><% out.print(payment.getAmount());%></td>
                    <td><% out.print(payment.getCreatedAt());%></td>

                  </tr>
                 <%}%>


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

<script src="${host_url}/static/js/dashboard/chart.js"></script>
<script src="${host_url}/static/js/dashboard/dashboard.js"></script>
</body>
</html>

