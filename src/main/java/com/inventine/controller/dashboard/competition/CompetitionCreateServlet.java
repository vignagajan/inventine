package com.inventine.controller.dashboard.competition;

import com.inventine.dao.CompetitionDaoImplementation;

import com.inventine.model.Competition;

import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CreateServlet", value = "/dashboard/competition/create")
public class CompetitionCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));

        String topic= "Competition Create-page";
        request.setAttribute("title",topic);
        request.getRequestDispatcher("/WEB-INF/dashboard/competition/create.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        Competition competition = new Competition();
        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();

        // Parse request data
        String organizationId = "17";
        String supportTeamId = "2";
        String projectId = "1";
      //  char financialStatus = 'I';
       // char status = 'A';
        String endingAt_ = request.getParameter("endingAt");
        int prizeMoney = Integer.parseInt(request.getParameter("prizeMoney"));
        String competitionName = request.getParameter("competitionName");
        //String category = request.getParameter("category");
        String rules = request.getParameter("rules");
        char cType = request.getParameter("cType").charAt(0);
        char pType = 'A';

        // Data to be processed
        Timestamp endingAt = null;

        // Data preprocessing
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(endingAt_);
            endingAt = new java.sql.Timestamp(date.getTime());

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }

        // Logic
//        if(competitionDao.getCount("WHERE competitionname=vicky") >= 1){
//            ok=false;
//            messages.add("competitionname is already found!");
//        }

        // Transactions
        if(ok){

            ok = competition.setOrganizationId(organizationId);
            ok = competition.setSupportTeamId(supportTeamId);
            ok = competition.setProjectId(projectId);

        //    ok = competition.setFinancialStatus(financialStatus);
          //  ok = competition.setStatus(status);
            ok = competition.setEndingAt(endingAt);
            ok = competition.setPrizeMoney(prizeMoney);
            //ok = competition.setCategory(category);
            ok = competition.setCompetitionName(competitionName);
            ok = competition.setRules(rules);
            ok = competition.setCType(cType);
            ok = competition.setPType(pType);

            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            // Pass model to DAO
            if(!competitionDao.create(competition)){
                ok=false;
                messages.clear();
                messages.add("Something went wrong!");
                System.out.println("There is a issue with dao!");

            }
        }

        // JSON response
        json.put("ok", ok);
        json.put("messages", messages);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();

    }

    }


