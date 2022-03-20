<%@ page import="com.inventine.model.User" %>
<%@ page import="com.inventine.model.Creds" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

  <link rel="stylesheet" href="${host_url}/static/css/dashboard/form.css">
  <script src="${host_url}/static/js/img_upload.js"></script>


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>

<% User employee = (User)request.getAttribute("employee");%>
<% Creds creds = (Creds)request.getAttribute("creds");%>


<div class="container">
  <div class="content">

    <div class="form">

      <!-- input boxes start -->
      <div class="details">

        <div class="input-box">
          <span class="details">Profile Picture</span>
          <button onclick="upload(200,200,'profile_id')" style="margin-top: 10px;"> Upload Image </button>
           <input type="text" name="profile_id" id="profile_id" hidden>
        </div>

        <div class="input-box">
          <span class="details">Cover Picture</span>
          <button onclick="upload(1230,270,'cover_id')" style="margin-top: 10px;"> Upload Image </button>
          <input type="text" name="cover_id" id="cover_id" hidden>
        </div>

        <div class="input-box">
          <span class="details">First Name</span>
          <input type="text"
                 name="firstName" id="firstName"  required pattern="[a-zA-Z]{2,50}" value="<% out.print(employee.getFirstName());%>">
          <span class="error" aria-live="polite" style="display: none;">Capital and Small letters of length 2-50 is allowed</span>
        </div>

        <div class="input-box">
          <span class="details">Last Name</span>
          <input type="text"
                 name="lastName" id="lastName" required pattern="[a-zA-Z]{2,50}" value="<% out.print(employee.getLastName());%>">
          <span class="error" aria-live="polite" style="display: none;">Capital and Small letters of length 2-50 is allowed</span>
        </div>

        <div class="input-box">
          <span class="details">Date of Birth</span>
          <input type="date"
                 id="dob" name="dob" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])" value="<% out.print(new Date(employee.getDob().getTime()));%>">
          <span class="error" aria-live="polite" style="display: none;" >Select gender</span>
        </div>

        <div class="input-box">
          <span class="details">Gender</span>
          <select class="gender"
                  id="gender" name="gender" required pattern=[A-Z] value="<% out.print(employee.getGender());%>">
            <option value="M">Male</option>
            <option value="F">Female</option>
          </select>
          <span class="error" aria-live="polite" style="display: none;" >Select gender</span>
        </div>

        <div class="input-box">
          <span class="details">Email</span>
          <input type="email"
                 id="email" name="email" placeholder="" value="<% out.print(creds.getEmail());%>" disabled>
          <span class="error" aria-live="polite" style="display: none;" >Enter valid email address</span>
        </div>

        <div class="input-box">
          <span class="details">Phone Number</span>
          <input type="text"
                 id="phone" type="tel" name="phone" placeholder="" required pattern="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s\./0-9]*$" value="<% out.print(employee.getPhone());%>">
          <span class="error" aria-live="polite" style="display: none;" >Enter phone number in international code</span>
        </div>

        <div class="input-box">
          <span class="details">Address</span>
          <input type="text"
                 id="address"name="address" placeholder="" required pattern="{10,255}" value="<% out.print(employee.getAddress());%>" disabled>
          <span class="error" aria-live="polite" style="display: none;" >Enter valid postal address</span>
        </div>

        <div class="input-box">
          <span class="details">District</span>
          <select class="district" name="district" id="district" value="<% out.print(employee.getDistrict());%>" disabled>
<%--            <option disabled selected value> -- select a district -- </option>--%>
            <option value="Ampara">Ampara</option>
            <option value="Anuradhapura">Anuradhapura</option>
            <option value="Badulla">Badulla</option>
            <option value="Batticaloa">Batticaloa</option>
            <option value="Colombo">Colombo</option>
            <option value="Galle">Galle</option>
            <option value="Gampaha">Gampaha</option>
            <option value="Hambanthota">Hambanthota</option>
            <option value="Jaffna">Jaffna</option>
            <option value="Kaluthara">Kaluthara</option>
            <option value="Kandy">Kandy</option>
            <option value="Kegalle">Kegalle</option>
            <option value="Kilinochchi">Kilinochchi</option>
            <option value="Kurunegala">Kurunegala</option>
            <option value="Mannar">Mannar</option>
            <option value="Matale">Matale</option>
            <option value="Matara">Matara</option>
            <option value="Monaragala">Monaragala</option>
            <option value="Mulativu">Mulativu</option>
            <option value="Nuwara_Eliya">Nuwara Eliya</option>
            <option value="Polonnaruwa">Polonnaruwa</option>
            <option value="Puttalam">Kaluthara</option>
            <option value="Ratanapura">Ratanapura</option>
            <option value="Trincomalee">Trincomalee</option>
            <option value="Vavuniya">Vavuniya</option>
          </select>
          <span class="error" aria-live="polite" style="display: none;" ></span>
        </div>

        <div class="input-box">
          <span class="details">Employee Type</span>
          <select class="role" name="role"
                  id="role" required pattern="[A-Z]" value="<% out.print(creds.getRole());%>">
            <option disabled selected value> -- select a type -- </option>
            <option value="S">Support Team Member</option>
            <option value="F">Financial Admin</option>
          </select>
          <span class="error" aria-live="polite" style="display: none;" >Select account type</span>
          </span>

        </div>

        <!-- input boxes end -->

        <div style="display: flex">
          <button type="button" id="cancelBtn" onclick="location.href='${host_url}/dashboard/employee';">Cancel</button>
          <button onclick="signupValidation()">Create</button>
        </div>

      </div>
    </div>
  </div>

  <script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/validate.js"></script>

  <script>

    function signupValidation(){

      for (i = 0; i < y.length; i++) {

        if(y[i].value == ""){

          Swal.fire({
            icon: 'warning',
            title: 'Form fields cannot be empty!',
            iconColor: "#0097e6",
            confirmButtonColor: "#0097e6",
          });

          return false;
        }

        if(!y[i].checkValidity()){

          Swal.fire({
            icon: 'error',
            title: 'Form fields should be valid!',
            iconColor: "#0097e6",
            confirmButtonColor: "#0097e6",
          });

          return false;
        }

      }

      requestHandler(
              y,
              window.location.href,
              'Employee is created successfully!',
              ''
      )
    }

  </script>

  <script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/dashboard.js"></script>

</body>
</html>
