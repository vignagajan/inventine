package com.inventine.controller.dashboard;

import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DasboardServlet", value = "/dashboard")
public class DasboardServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String graph_labels = "['Week1', 'Week2', 'Week3', 'Week4']";

        request.setAttribute("graph_labels",graph_labels);
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Creator");
        request.getRequestDispatcher("/WEB-INF/dashboard/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
