package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InvestServlet", value = "/invest")
public class InvestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CredsDaoImplementation credsDao = new CredsDaoImplementation();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();



        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title","Invest");
        request.getRequestDispatcher("/WEB-INF/invest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String amount = (String)request.getParameter("amount");
        String projectId = (String)request.getParameter("projectId");
        String login_redirect = System.getenv("HOST_URL")+"/project/"+projectId;


        if (session.getAttribute("role") == null) {
           session.setAttribute("login_redirect",login_redirect);
            LoginServlet login_servlet = new LoginServlet();
            login_servlet.doGet(request,response);
        }
    }
}
