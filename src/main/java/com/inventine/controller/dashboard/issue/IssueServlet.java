package com.inventine.controller.dashboard.issue;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.IssuesDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Issues;
import com.inventine.model.Project;
import com.inventine.model.User;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IssueServlet", value = "/dashboard/issue")
public class IssueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", 'A');
        }

        IssuesDaoImplementation issueDao = new IssuesDaoImplementation();
        UserDaoImplementation userDao = new UserDaoImplementation();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        String card1_condition= null;
        String card2_condition= null;
        String card3_condition= null;
        String card4_condition= null;
        String get_condition = "";
        String totalq= null;

        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S'){
            card1_condition = "select count(DISTINCT issueid) from issues where status = 'A'";
            card2_condition = "select count(DISTINCT issueid) from issues where status = 'B'";
            card3_condition = "select count(DISTINCT issueid) from issues where status = 'R'";
            card4_condition = "select count(DISTINCT issueid) from issues where status = 'S'";
            get_condition = "";
        }

        if (role == 'C'){
            card1_condition = "select count(DISTINCT issueid) from issues where status = 'A' and userid=%s";
            card2_condition = "select count(DISTINCT issueid) from issues where status = 'B' and userid=%s";
            card3_condition = "select count(DISTINCT issueid) from issues where status = 'R' and userid=%s";
            card4_condition = "select count(DISTINCT issueid) from issues where status = 'S' and userid=%s";
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

        List<Issues> issues = issueDao.getIssues(get_condition);
        List<User> users = userDao.getUsers(get_condition);
        List<Creds> creds = credsDao.getManyCreds(get_condition);

        int card1_count = 0;
        int card2_count = 0;
        int card3_count = 0;
        int card4_count = 0;

        for (Issues issue : issues) {

            if(Character.compare(issue.getStatus(),'A') == 0){
                card1_count += 1;
            }
            if(Character.compare(issue.getStatus(),'B') == 0){
                card2_count += 1;
            }
            if(Character.compare(issue.getStatus(),'R') == 0){
                card3_count += 1;
            }
            if(Character.compare(issue.getStatus(),'S') == 0){
                card4_count += 1;
            }


        }
//
//        card4_count = card1_count+card2_count+card3_count;

        // Add card labels
        request.setAttribute("card1_label","Active");
        request.setAttribute("card2_label","Blocked");
        request.setAttribute("card3_label","Rejected");
        request.setAttribute("card4_label","Solved");

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
        request.setAttribute("card1_icon","fas fa-ticket-alt");
        request.setAttribute("card2_icon","fas fa-ticket-alt");
        request.setAttribute("card3_icon","fas fa-ticket-alt");
        request.setAttribute("card4_icon","fas fa-ticket-alt");

        // Add table data
        request.setAttribute("issues",issues);
        request.setAttribute("users",users);
        request.setAttribute("creds",creds);

        request.setAttribute("title","Issues");
        request.getRequestDispatcher("/WEB-INF/dashboard/employee/employee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
