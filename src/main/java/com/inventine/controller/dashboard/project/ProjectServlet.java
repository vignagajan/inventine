package com.inventine.controller.dashboard.project;

import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProjectServlet", value = "/dashboard/project")
public class ProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();

        request.setAttribute("title","Project");
        request.setAttribute("active",projectDao.getCount("creatorid=5 AND status='A'"));
        request.setAttribute("blocked", projectDao.getCount("creatorid=5 AND status='B'"));
        request.setAttribute("deleted", projectDao.getCount("creatorid=5 AND status='D'"));
        request.setAttribute("total", projectDao.getCount("creatorid=5"));


        List<Project> projects = projectDao.getProjects("");
        request.setAttribute("projects",projects);
        request.getRequestDispatcher("/WEB-INF/dashboard/project/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
