package com.inventine.controller.dashboard.employee;

import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/dashboard/employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        UserDaoImplementation userDao = new UserDaoImplementation();

        String topic= "User Dashboard";
        request.setAttribute("Dashboard",topic);

        request.setAttribute("active",userDao.getCount("status='A'"));
        request.setAttribute("blocked", userDao.getCount("status='B'"));
        request.setAttribute("deleted", userDao.getCount("status='D'"));
        request.setAttribute("total", userDao.getCount(""));


        List<User> users = userDao.getUsers("");
        request.setAttribute("users",users);
        request.getRequestDispatcher("/WEB-INF/dashboard/employee/employee.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}