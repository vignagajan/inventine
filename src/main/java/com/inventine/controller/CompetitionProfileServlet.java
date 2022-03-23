package com.inventine.controller;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.Competition;
import com.inventine.model.Organization;
import com.inventine.model.Project;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "CompetitionProfileServlet", value = "/competition-profile/*")
public class CompetitionProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");





        CompetitionDaoImplementation CompetitionDao = new CompetitionDaoImplementation();
        OrganizationDaoImplementation OrganazationDao = new OrganizationDaoImplementation();




        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        String competitionId = uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        if(competitionId.isEmpty()){
            System.out.println("Competition ID is empty");
        }

        Competition competition = CompetitionDao.getCompetition(competitionId);

        Organization organization = OrganazationDao.getOrganization(competition.getOrganizationId());
        request.setAttribute("organization",organization);
        request.setAttribute("competition",competition);

        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title","CompetitionProfile");
        request.getRequestDispatcher("/WEB-INF/competition-profile.jsp").forward(request, response);



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
