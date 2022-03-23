<%@ page import="com.inventine.model.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/components/dashboard/head-import.jsp" %>

    <link rel="stylesheet" href="${System.getenv("HOST_URL")}/static/css/dashboard/form.css">


</head>
<body>

<%@ include file="/WEB-INF/components/dashboard/sidebar.jsp" %>
<%@ include file="/WEB-INF/components/dashboard/header.jsp" %>

<%   Project project = (Project)request.getAttribute("project");   %>

<div class="container">
    <div class="content">
        <div class="form">


            <div class="details">


                <div class="input-box">
                    <span class="details">Project Id</span>
                    <input type="text" name="projectId" id="projectId"   value="<%out.print(project.getProjectId());%>" disabled>

                </div>

                <div class="input-box">
                    <span class="details">Project Name</span>
                    <input type="text" name="projectName" id="projectName"  required pattern="[a-zA-Z0-9\.\,\/\-\*\+]{1,100}" value="<%out.print(project.getProjectName());%>" >

                    <span class="error" aria-live="polite" style="display: none;">A name of length 1-100 and (/*-+.,) special characters are allowed</span>
                </div>

                <div class="input-box">
                    <span class="details">Requested Amount</span>
                    <input type="text"
                           name="requestedAmount" id="requestedAmount" required pattern="^(?:0|[1-9]\d*)$"  value="<%out.print(project.getRequestedAmount());%>" disabled>

                    <span class="error" aria-live="polite" style="display: none;">Enter an amount no decimals needed</span>
                </div>

                <div class="input-box">
                    <span class="details">Ending Date</span>
                    <input type="date"
                           name="dateOfExpiry" id="dateOfExpiry" required pattern="\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])"  value="<%out.print(new Date(project.getDateOfExpiry().getTime()));%>" disabled>

                    <span class="error" aria-live="polite" style="display: none;" >Select the date of funding expiry</span>
                </div>

<%--                <div class="input-box">--%>
<%--                    <span class="details">Description</span>--%>
<%--                    <input type="text"--%>
<%--                           name="description" id="description" value="<%out.print(project.getDetails());%>" >--%>
<%--                    <span class="error" aria-live="polite" style="display: none;" >Input the description</span>--%>
<%--                </div>--%>
                <div class="input-box">
                    <span class="details">Description</span>
                    <textarea
                            id="description" name="description" >
                         <%out.print(project.getDetails());%>
                    </textarea>
                </div>

                <div class="input-box">
                    <span class="details">Category</span>
                    <select class="category" name="category" id="category" required  value="<%out.print(project.getCategory());%>">
                        <option value="Art">Art</option>
                        <option value="Design">Design</option>
                        <option value="Food">Food</option>
                        <option value="Publication">Publication</option>
                        <option value="Software">Software</option>
                        <option value="Technology">Technology</option>
                        <option value="Other">Other</option>
                    </select>
                    <span class="error" aria-live="polite" style="display: none;" >--Select a Category--</span>
                </div>
                <!-- input boxes end -->

            </div>

            <div style="display: flex">
                <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/dashboard/project';">Cancel</button>
                <button onclick="signupValidation()">Update</button>
            </div>

        </div>
    </div>
</div>
<script src="${System.getenv("HOST_URL")}/static/js/dashboard/validate.js"></script>

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
            'Project created successfully!',
            ''
        )
    }

</script>

<script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>




</body>
</html>
