package com.inventine.controller;

import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CompetitionsServlet", value = "/competitions")
public class CompetitionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Competitions");
        request.getRequestDispatcher("/WEB-INF/competitions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
