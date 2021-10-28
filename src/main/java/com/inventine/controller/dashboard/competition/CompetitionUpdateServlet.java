package com.inventine.controller.dashboard.competition;

import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/dashboard/competition/update")
public class CompetitionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));

        String topic= "Competition update-page";
        request.setAttribute("title",topic);
        request.getRequestDispatcher("/WEB-INF/dashboard/competition/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
