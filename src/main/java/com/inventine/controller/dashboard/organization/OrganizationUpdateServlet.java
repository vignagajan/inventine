package com.inventine.controller.dashboard.organization;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrganizationUpdateServlet", value = "/dashboard/organization/update")
public class OrganizationUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        String topic= "Organization update-page";
        request.setAttribute("title",topic);

        request.getRequestDispatcher("/WEB-INF/dashboard/organization/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // System.out.println(request.setAttribute("fname"));

    }
}
