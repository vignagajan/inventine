package com.inventine.controller.dashboard.chat;

import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChatServlet", value = "/dashboard/chat")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", 'A');
        }
        response.setContentType("text/html");


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Chat");
        request.getRequestDispatcher("/WEB-INF/dashboard/chat/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}