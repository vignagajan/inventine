package com.inventine.controller.dashboard.project;

import com.inventine.dao.PaymentDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.Payment;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProjectServlet", value = "/dashboard/project")
public class ProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", 'A');
        }

        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();
        ProjectDaoImplementation projectsDao = new ProjectDaoImplementation();

        String card1_condition= null;
        String card2_condition= null;
        String card3_condition= null;
        String card4_condition= null;
        String get_condition = "";
        String totalq= null;

        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S'){
            card1_condition = "status = 'A'";
            card2_condition = "select count(DISTINCT projectid) from payment";
            card3_condition = "select count(DISTINCT investorid) from payment";
            card4_condition = "select sum(amount/(1000)) from payment";
            get_condition = "";
        }

        if (role == 'C'){
            card2_condition = "select count(DISTINCT projectid) from payment";
            card3_condition = "select count(DISTINCT investorid) from payment";
            card4_condition = "select sum(amount/(1000)) from payment";
            totalq = "select sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s)";
            get_condition = "";
        }

        if (role == 'I'){
            card2_condition = "select count(DISTINCT projectid) from payment";
            card3_condition = "select count(DISTINCT investorid) from payment";
            card4_condition = "select sum(amount/(1000)) from payment";
            totalq = "select sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s)";
        }

//        String creators = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String projects = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String meetings = String.format("select count(investorid) from acceptmeeting where investorid=%s;",investorId);
//        String transactions = String.format("select sum(amount/(1000)) from payment where investorid=%s;",investorId);

        List<Payment> payments = paymentDao.getPayments(get_condition);
        List<Project> projects = projectsDao.getProjects(get_condition);


        int card1_count = 0;
        int card2_count = 0;
        int card3_count = 0;
        int card4_count = 0;

        for (Project project : projects) {

            if(Character.compare(project.getStatus(),'A') == 0){
                card1_count += 1;
            }
            if(Character.compare(project.getStatus(),'B') == 0){
                card2_count += 1;
            }
            if(Character.compare(project.getStatus(),'D') == 0){
                card3_count += 1;
            }


        }

        card4_count = card1_count+card2_count+card3_count;

        // Add card labels
        request.setAttribute("card1_label","Active");
        request.setAttribute("card2_label","Blocked");
        request.setAttribute("card3_label","Deleted");
        request.setAttribute("card4_label","Total");

        // Add card values
        request.setAttribute("card1_count",card1_count);
        request.setAttribute("card2_count",card2_count);
        request.setAttribute("card3_count",card3_count);
        request.setAttribute("card4_count",card4_count);

        // Add card colors
        request.setAttribute("card1_color","#03D815");
        request.setAttribute("card2_color","#FFC400");
        request.setAttribute("card3_color","#FF004C");
        request.setAttribute("card4_color","#006EFF");

        // Add card icons
        request.setAttribute("card1_icon","fa-lightbulb");
        request.setAttribute("card2_icon","fa-lightbulb");
        request.setAttribute("card3_icon","fa-lightbulb");
        request.setAttribute("card4_icon","fa-lightbulb");

        // Add table data
        request.setAttribute("payments",payments);
        request.setAttribute("projects",projects);

        request.setAttribute("title","Project");
        request.getRequestDispatcher("/WEB-INF/dashboard/project/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
