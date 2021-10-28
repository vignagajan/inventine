package com.inventine.controller.dashboard.organization;

import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrganizationCreateServlet", value = "/dashboard/organization/create")
public class OrganizationCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));

        String topic= "Organization Create-page";
        request.setAttribute("title",topic);
       // request.setAttribute("title","Organization");
        request.getRequestDispatcher("/WEB-INF/dashboard/organization/create.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
