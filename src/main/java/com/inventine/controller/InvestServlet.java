package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.PaymentDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Project;
import com.inventine.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "InvestServlet", value = "/invest")
public class InvestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        CredsDaoImplementation credsDao = new CredsDaoImplementation();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();

        String userId = (String)request.getSession().getAttribute("userId");


        User user = userDao.getUser(userId);

        Creds creds = credsDao.getCreds(userId);
        String projectId = request.getParameter("projectId");


        request.setAttribute("project",projectDao.getProject(projectId));
        request.setAttribute("user",user);
        request.setAttribute("creds",creds);
        System.out.println("this servlet");


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
