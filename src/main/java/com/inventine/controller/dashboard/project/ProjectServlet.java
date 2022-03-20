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

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }

        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();


        String get_condition = "";
//        String totalq= null;
        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S'){
            get_condition = "";
        }

        if (role == 'C'){
            get_condition = String.format("creatorid=%s", session.getAttribute("userid"));
        }

        if (role == 'I'){
            get_condition = String.format("projectid=(select projectid from payment where investorid=%s)",session.getAttribute("userid"));
        }
        

        List<Project> projects = projectDao.getProjects(get_condition);
        List<Payment> payments = new ArrayList<Payment>();
        String payment_condition = null;

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

            payment_condition = String.format("select sum(amount) from payment where projectid=%s", project.getProjectId());
           payments.add(paymentDao.getPayment(payment_condition));

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
        request.setAttribute("card3_color","#FF0000");
        request.setAttribute("card4_color","#0097E6");

        // Add card icons
        request.setAttribute("card1_icon","fa-lightbulb");
        request.setAttribute("card2_icon","fa-lightbulb");
        request.setAttribute("card3_icon","fa-lightbulb");
        request.setAttribute("card4_icon","fa-lightbulb");


        request.setAttribute("projects",projects);
        request.setAttribute("payments",payments);

        request.setAttribute("host_url",System.getenv("HOST_URL"));
        request.setAttribute("title","Project");
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/dashboard/project/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
