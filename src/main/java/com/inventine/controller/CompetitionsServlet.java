package com.inventine.controller;

import com.inventine.dao.CompetitionDaoImplementation;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Competition;

import com.inventine.model.Competition;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "CompetitionsServlet", value = "/competitions")
public class CompetitionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");



        request.setAttribute("host_url",System.getenv("HOST_URL"));

        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();

       

        String condition;

        List<Competition> competitions = competitionDao.getCompetitions("");

        for (final Competition competition: competitions){
            condition = String.format("%s",competition.getOrganizationId());
            User user = userDao.getUser(condition);
//            user.setFirstName(user.getFirstName());
//            user.setLastName(user.getLastName());
            competition.setCompetitionName(competition.getCompetitionName());
            competition.setCreatedAt(competition.getCreatedAt());
        }


        request.setAttribute("title","Competition");
        request.setAttribute("competitions",competitions);

        request.getRequestDispatcher("/WEB-INF/competitions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
