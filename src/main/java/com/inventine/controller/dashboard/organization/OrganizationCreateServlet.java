package com.inventine.controller.dashboard.organization;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Competition;
import com.inventine.model.Creds;
import com.inventine.model.Organization;
import com.inventine.model.User;
import com.inventine.util.DotEnv;
import com.inventine.util.SHA256;
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

@WebServlet(name = "OrganizationCreateServlet", value = "/dashboard/organization/create")
public class OrganizationCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null) {
            session.setAttribute("role", 'A');
        }
        response.setContentType("text/html");


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));

        String topic = "Organization Create-page";
        request.setAttribute("title", topic);
        // request.setAttribute("title","Organization");
        request.getRequestDispatcher("/WEB-INF/dashboard/organization/create.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
//        Competition competition = new Competition();
//        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();

        Organization organization = new Organization();
        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();

        // Parse request data

        HttpSession session = request.getSession();

        String creatorId = session.getAttribute("userId").toString();
        String supportTeamId = "1";
        String logoId = "1234";
        String headerId = "1640618179717";

        //  char financialStatus = 'I';
        // char status = 'A';
        //String endingAt_ = request.getParameter("endingAt");
        //String startingAt_ = request.getParameter("startingAt");
        //int prizeMoney = Integer.parseInt(request.getParameter("prizeMoney"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        String contactnumber = request.getParameter("contactnumber");
        char orgtype = request.getParameter("orgtype").charAt(0);

        char status = 'A';

        //String category = request.getParameter("category");
        //String rules = request.getParameter("rules");
        //char cType = request.getParameter("cType").charAt(0);
       // char pType = 'A';

        // Data to be processed
//        Timestamp endingAt = null;
//
//
//        // Data preprocessing
//        try {
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse(endingAt_);
//            endingAt = new java.sql.Timestamp(date.getTime());
//
//        }catch (Exception e){
//            ok = false;
//            messages.clear();
//            messages.add("Something went wrong at get data!");
//            e.printStackTrace();
//        }
//        Timestamp startingAt = null;
//        try {
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse(startingAt_);
//            startingAt = new java.sql.Timestamp(date.getTime());
//
//        }catch (Exception e){
//            ok = false;
//            messages.clear();
//            messages.add("Something went wrong at get data!");
//            e.printStackTrace();
//        }

        // Logic
//        if(competitionDao.getCount("WHERE competitionname=vicky") >= 1){
//            ok=false;
//            messages.add("competitionname is already found!");
//        }

        // Transactions
        if(ok){

           ok = organization.setCreatorId(creatorId);

            System.out.println(organization.getCreatorId());
           ok = organization.setSupportTeamId(supportTeamId);
           System.out.println(organization.getSupportTeamId());
           ok = organization.setHeaderId(headerId);
           System.out.println(organization.getHeaderId());
           ok = organization.setLogoId(logoId);
           System.out.println(organization.getLogoId());
           ok = organization.setName(name);
           System.out.println(organization.getName());
           ok = organization.setAddress(address);
           System.out.println(organization.getAddress());
           ok = organization.setDistrict(district);
           System.out.println(organization.getDistrict());
           ok = organization.setContactNumber(contactnumber);
           System.out.println(organization.getContactNumber());
           ok = organization.setOrgType(orgtype);
           System.out.println(organization.getOrgType());
           ok = organization.setStatus(status);
           System.out.println(organization.getStatus());
            //    ok = competition.setFinancialStatus(financialStatus);
            //  ok = competition.setStatus(status);


            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            // Pass model to DAO
            if(!organizationDao.create(organization)){
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
