package com.inventine.controller.dashboard.organization;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Organization;
import com.inventine.model.Organization;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrganizationServlet", value = "/dashboard/organization")
public class OrganizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//
//        if (session.getAttribute("role") == null){
//            session.setAttribute("role", 'A' );
//        }
//
       OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();
//
//
//        String get_condition = "";
////        String totalq= null;
//        char role = (char)request.getSession().getAttribute("role");
//
//        if (role == 'A' || role == 'S'){
//            get_condition = "";
//        }
//
//        if (role == 'C'){
//            get_condition = String.format("creatorid=%s", session.getAttribute("userid"));
//        }
//
//
//
//
//       List<Organization> organizations = organizationDao.getOrganizations(get_condition);
//
//        int card1_count = 0;
//        int card2_count = 0;
//        int card3_count = 0;
//        int card4_count = 0;
//
//        for (Organization organization : organizations) {
//
//            if(Character.compare(organization.getStatus(),'A') == 0){
//                card1_count += 1;
//            }
//            if(Character.compare(organization.getStatus(),'B') == 0){
//                card2_count += 1;
//            }
//            if(Character.compare(organization.getStatus(),'D') == 0){
//                card3_count += 1;
//            }
//
//
//        }
//
//        card4_count = card1_count+card2_count+card3_count;
//
//        // Add card labels
//        request.setAttribute("card1_label","Active");
//        request.setAttribute("card2_label","Blocked");
//        request.setAttribute("card3_label","Deleted");
//        request.setAttribute("card4_label","Total");
//
//        // Add card values
//        request.setAttribute("card1_count",card1_count);
//        request.setAttribute("card2_count",card2_count);
//        request.setAttribute("card3_count",card3_count);
//        request.setAttribute("card4_count",card4_count);
//
//        // Add card colors
//        request.setAttribute("card1_color","#03D815");
//        request.setAttribute("card2_color","#FFC400");
//        request.setAttribute("card3_color","#FFC400");
//        request.setAttribute("card4_color","#FFC400");
//
//        // Add card icons
//        request.setAttribute("card1_icon","fa-lightbulb");
//        request.setAttribute("card2_icon","fa-lightbulb");
//        request.setAttribute("card3_icon","fa-lightbulb");
//        request.setAttribute("card4_icon","fa-lightbulb");


        List<Organization> organizations = organizationDao.getOrganizations("");
        request.setAttribute("organizations",organizations);

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Organization");
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/dashboard/organization/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
