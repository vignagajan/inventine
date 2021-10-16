package com.inventine.controller;

import com.inventine.util.DotEnv;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "home-servlet", value = "/")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.setAttribute("host_url",DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Home");
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

}