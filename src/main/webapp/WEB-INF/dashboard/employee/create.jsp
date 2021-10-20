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


<div class="container">
    <div class="content">

        <form action="create.php" id="signupForm" method="post" onsubmit="return signupValidation()">

            <!-- input boxes start -->
            <div class="details">

                <div class="input-box">
                    <span class="details">First Name</span>
                    <input type="text"
                           name="firstName" id="firstName"  required pattern="[a-zA-Z]{2,50}">
                    <span class="error" aria-live="polite" style="display: none;">Capital and Small letters of length 2-50 is allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Last Name</span>
                    <input type="text"
                           name="lastName" id="lastName" required pattern="[a-zA-Z]{2,50}">
                    <span class="error" aria-live="polite" style="display: none;">Capital and Small letters of length 2-50 is allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Date of Birth</span>
                    <input type="date"
                           id="dob" name="dob" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])">
                    <span class="error" aria-live="polite" style="display: none;" >Select gender</span>
                </div>

                <div class="input-box">
                    <span class="details">Gender</span>
                    <select class="gender"
                            id="gender" name="gender" required pattern=[A-Z]>
                        <option disabled selected value> -- select a gender -- </option>
                        <option value="M">Male</option>
                        <option value="F">Female</option>
                    </select>
                    <span class="error" aria-live="polite" style="display: none;" >Select gender</span>
                </div>

                <div class="input-box">
                    <span class="details">Email</span>
                    <input type="email"
                           id="email" name="email" placeholder="" required>
                    <span class="error" aria-live="polite" style="display: none;" >Enter valid email address</span>
                </div>

                <div class="input-box">
                    <span class="details">Phone Number</span>
                    <input type="text"
                           id="phone" name="phone" placeholder="" required pattern="[a-zA-Z]{2,50}">
                    <span class="error" aria-live="polite" style="display: none;" >Enter phone number in international code</span>
                </div>

                <div class="input-box">
                    <span class="details">Address</span>
                    <input type="text"
                           id="address"name="address" placeholder="" required pattern="[a-zA-Z]{2,50}">
                    <span class="error" aria-live="polite" style="display: none;" >Enter valid address</span>
                </div>

                <div class="input-box">
                    <span class="details">District</span>
                    <select class="district" name="district" id="district" required>
                        <option disabled selected value> -- select a district -- </option>
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
                    <span class="details">Username</span>
                    <input type="text"
                           name="username" id="username"  placeholder="" required pattern="[a-zA-Z]{2,50}">
                    <span class="error" aria-live="polite" style="display: none;" >Small letters of length 4-50 is allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Password</span>
                    <input type="password" name="password"
                           id="password" placeholder="" required pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}">
                    <span class="error" aria-live="polite" style="display: none;">
                        <div style="padding:5px;">
                          <p>Should contain: </p>
                          <ul>
                            <li>* At least one upper case English letter</li>
                            <li>* At least one lower case English letter</li>
                            <li>* At least one digit</li>
                            <li>* At least one special character</li>
                            <li>* Minimum eight characters</li>
                          </ul>
                        </div>
                      </span>
                </div>

                <div class="input-box">
                    <span class="details">Confirm Password</span>
                    <input type="password" name="confirm_password"
                           id="confirm_password" placeholder="" required>
                    <span class="error" aria-live="polite" style="display: none;" >Password cannot be empty</span>
                </div>

                <div class="input-box">
                    <span class="details">Account Type</span>
                    <select class="atype" name="atype"
                            id="atype" required pattern="[A-Z]">
                        <option disabled selected value> -- select a type -- </option>
                        <option value="C">Creator</option>
                        <option value="I">Investor</option>
                    </select>
                    <span class="error" aria-live="polite" style="display: none;" >Select account type</span>
                    </span>

                </div>

                <!-- input boxes end -->

                <div style="display: flex">
                    <button type="button" id="cancelBtn" onclick="location.href='${host_url}/dashboard/employee';">Cancel</button>
                    <button  type="submit">Create</button>
                </div>

        </form>
    </div>
</div>

<script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/validate.js"></script>

<script>

    function signupValidation(){

        // Password Validation

        const password = document.getElementById("password");
        const cpassword = document.getElementById("confirm_password");

        if( password.value != cpassword.value){
            return false;
        }

        return true;

    }



</script>

<script src="<%= request.getAttribute("host_url") %>/static/js/dashboard/dashboard.js"></script>

</body>
</html>

