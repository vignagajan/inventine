package com.inventine.controller;

import com.inventine.dao.CreatorDaoImplementation;
import com.inventine.dao.PaymentDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creator;
import com.inventine.model.Payment;
import com.inventine.model.Project;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Base64;

@WebServlet(name = "ProjectViewServlet", value = "/project/*")
public class ProjectDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();
        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();

        System.out.println(request.getRemoteHost());

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        String projectId = uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        if(projectId.isEmpty()){
            System.out.println("Project ID is empty");
        }

        Project project = projectDao.getProject(projectId);
        User user = userDao.getUser(project.getCreatorId());
        String query = String.format("select sum(amount) from payment where projectid=%s;",projectId);
        String investors = String.format("select count(investorid) from payment where projectid=%s;",projectId);
    //  String percentage = String.format("select sum(amount)/(select requestedamount from project where projectid=%s)*100 from payment where projectid=%s;",projectId);
    //    Timestamp daysleft = String.format("SELECT dateofexpiry - current_date as difference from project where projectid=%s",projectId);

     //   System.out.println(daysleft);
        request.setAttribute("project",project);
        request.setAttribute("user",user);
        ResultSet rsi = paymentDao.executeQuery(investors);
        try {
            request.setAttribute("investors", rsi.getInt("count"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = paymentDao.executeQuery(query);
        try {
            request.setAttribute("pledge", rs.getInt("sum"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        System.out.println(new String(project.getDetails()));
//        ResultSet rsd = projectDao.executeQuery(daysleft);
//        try {
//            request.setAttribute("daysleft", rsd.getInt("dif"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Project-Details");
        request.getRequestDispatcher("/WEB-INF/project-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
