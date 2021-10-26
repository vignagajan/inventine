package com.inventine.controller.dashboard.project;

import com.inventine.dao.MeetingDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.Meeting;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProjectUpdateServlet", value = "/dashboard/update-project")
public class ProjectUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        String topic= "Project Dashboard";
        request.setAttribute("Dashboard",topic);



        List<Project> projects = projectDao.getProjects("projectid=19");
        request.setAttribute("projects",projects);

        request.getRequestDispatcher("/WEB-INF/dashboard/project/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        Project project = new Project();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(request.getParameter("dateOfExpiry"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp dateOfExpiry = new java.sql.Timestamp(date.getTime());

        boolean ok = true;

        project.setProjectId("19");
        project.setCreatorId("5");
        project.setSupportTeamId("1");
        project.setStatus('U');
        project.setFinancialStatus('I');
        project.setProjectName(request.getParameter("projectName"));
        project.setRequestedAmount(Integer.parseInt(request.getParameter("requestedAmount")));
        project.setDateOfExpiry(dateOfExpiry);
        project.setCategory("category");
        project.setDetails("description");


        projectDao.update(project);

    }
}
