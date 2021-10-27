package com.inventine.controller.dashboard.competition;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.model.Competition;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CompetitionServlet", value = "/competition")
public class CompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();

        String topic= "Competition Dashboard";
        request.setAttribute("Dashboard",topic);

        request.setAttribute("active",competitionDao.getCount("creatorid=5 AND status='A'"));
        request.setAttribute("blocked", competitionDao.getCount("creatorid=5 AND status='B'"));
        request.setAttribute("deleted", competitionDao.getCount("creatorid=5 AND status='D'"));
        request.setAttribute("total", competitionDao.getCount("creatorid=5"));


        List<Competition> competitions = competitionDao.getCompetitions("");
        request.setAttribute("competitions",competitions);
        request.getRequestDispatcher("/WEB-INF/dashboard/competition/index.jsp").forward(request, response);
      

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
