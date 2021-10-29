<%@ page import="java.util.List" %>
<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.inventine.model.User" %>
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

    <div class="overviewcard" style="background-color:white;color: rgb(3, 216, 21);">
      <div><i class="far fa-lightbulb fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>Active</div>
        <div class="overviewcard__info" style="font-size: 36px; float: right;">${active}</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(255, 196, 0);">
      <div><i class="far fa-lightbulb fa-2x"></i></div>
      <div class="overviewcard__icon" >
        <div>Blocked</div>
        <div class="overviewcard__info"style="font-size: 36px;float: right">${blocked}</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(255, 0, 76);">
      <div><i class="far fa-lightbulb fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>Deleted</div>
        <div class="overviewcard__info" style="font-size: 36px;float: right">${deleted}</div>
      </div>
    </div>

    <div class="overviewcard" style="background-color:white;color: rgb(0, 110, 255);">
      <div><i class="far fa-lightbulb fa-2x"></i></div>
      <div class="overviewcard__icon">
        <div>Total</div>
        <div class="overviewcard__info" style="font-size: 36px;float: right">${total}</div>
      </div>
    </div>



  </div>
  <!-- end of 4 data cards -->

  <div class="cbutton">
    <a href="http://localhost:8080/inventine_war/dashboard/employee/create">
      <button class="createbutton">Create </button></a>
  </div>

  <div class="main-tables">
    <table id="example" class="table" cellspacing="0" width="100%">
      <thead>
      <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th>District</th>
        <th>Actions</th>
      </tr>
      </thead>

      <tfoot>
      <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th>District</th>
        <th>Actions</th>
      </tr>
      </tfoot>

      <tbody>
      <%
        for (User user: (ArrayList<User>)request.getAttribute("users")){
      %>
      <tr>
        <th><% out.print(user.getUserId());%></th>
        <td><% out.print(user.getFirstName());%></td>
        <td><% out.print(user.getLastName());%></td>
        <td><% out.print(user.getAddress());%></td>
        <td><% out.print(user.getDistrict());%></td>
        <td>
          <button class="updatebutton" id="idUpdateButton" onclick="window.location.href='${host_url}/dashboard/employee/update'">Update</button>
          <button class="deletebutton" id="idDeleteButton" onclick="idDeleteButton_onclick();">Delete</button>

        </td>
      </tr>
      <%}%>


      </tbody>
    </table>
  </div>






</main>


<!-- javascipt -->
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
      "columnDefs": [{
        className: "Name",
        "targets":[0],
        "visible": false,
        "searchable":false
      }]
    });

    //End of create main table



  });
</script>
<script src="${host_url}/static/js/dashboard/dashboard.js"></script>
</body>
</html>