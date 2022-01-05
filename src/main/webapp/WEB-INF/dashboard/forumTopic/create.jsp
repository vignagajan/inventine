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


<div class="container">
    <div class="content">

        <div class="form">

            <!-- input boxes start -->
            <div class="details">

                <div class="input-box">
                    <span class="details">Title</span>
                    <input type="text"
                           name="title" id="title"  required >
                    <span class="error" aria-live="polite" style="display: none;">letters and number of length 1-150 is allowed</span>
                </div>



                <div class="input-box">
                    <span class="details">Description</span>
                    <input type="text"
                           name="description" id="description"  required >
                    <span class="error" aria-live="polite" style="display: none;">letters and number of length 1-150 is allowed</span>
                </div>

                <!-- input boxes end -->

                <div style="display: flex">
                    <button type="button" id="cancelBtn" onclick="location.href='${System.getenv("HOST_URL")}/forum';">Cancel</button>
                    <button onclick="signupValidation()">Create</button>
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
                'Forum post is created successfully!',
                '${System.getenv("HOST_URL")}/forum'


            )
        }

    </script>

    <script src="${System.getenv("HOST_URL")}/static/js/dashboard/dashboard.js"></script>

</div>
</body>
</html>