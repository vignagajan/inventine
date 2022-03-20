package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "ProfileServlet", value = "/profile/*")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        UserDaoImplementation userDao = new UserDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();
        String userId = uri.substring(uri.lastIndexOf('/') + 1);

        User user = userDao.getUser(userId);
        Creds creds = credsDao.getCreds(userId);

        request.setAttribute("user", user);
        request.setAttribute("creds", creds);
        request.setAttribute("title",creds.getUsername());
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
