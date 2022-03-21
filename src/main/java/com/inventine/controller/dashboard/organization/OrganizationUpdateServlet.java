package com.inventine.controller.dashboard.organization;

import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Organization;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrganizationUpdateServlet", value = "/dashboard/organization/update/*")
public class OrganizationUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }

        response.setContentType("text/html");

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        String organizationId =  uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();
        Organization organization = new Organization();
        organization = organizationDao.getOrganization(organizationId);



        request.setAttribute("organization",organization);
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.getRequestDispatcher("/WEB-INF/dashboard/organization/update.jsp").forward(request, response);

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
        String supportTeamId = "-1";
        String logoId = "1640618179717";
        String headerId = "1640618091700";

        //  char financialStatus = 'I';
        // char status = 'A';
        //String endingAt_ = request.getParameter("endingAt");
        //String startingAt_ = request.getParameter("startingAt");
        //int prizeMoney = Integer.parseInt(request.getParameter("prizeMoney"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        String contactnumber = request.getParameter("contactnumber");

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
            ok = organization.setSupportTeamId(supportTeamId);
            ok = organization.setHeaderId(headerId);
            ok = organization.setLogoId(logoId);
            ok = organization.setName(name);
            ok = organization.setAddress(address);
            System.out.println(address);
            ok = organization.setDistrict(district);
            ok = organization.setContactNumber(contactnumber);
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

