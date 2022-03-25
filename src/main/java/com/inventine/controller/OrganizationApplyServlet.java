package com.inventine.controller;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Organization;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrganizationApplyServlet", value = "/apply")
public class OrganizationApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");


        request.setAttribute("host_url", System.getenv("HOST_URL"));

        String topic = "Organization Apply-page";
        request.setAttribute("title", topic);
        // request.setAttribute("title","Organization");
        request.getRequestDispatcher("/WEB-INF/organizationapply.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        Organization organization = new Organization();
        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();

        Creds creds = new Creds();
        CredsDaoImplementation credsDao = new CredsDaoImplementation();

        // Parse request data

        String supportTeamId = "1";
        String logoId = "1640618179717";
        String headerId = "1640618091700";

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        String contactnumber = request.getParameter("contactnumber");
        char orgtype = request.getParameter("orgtype").charAt(0);

        String username = request.getParameter("username");
        String email= request.getParameter("email");
        String password_ = request.getParameter("password");
        char role ='O';

        char status = 'U';

        // Transactions
        if(ok){

           // ok = organization.setCreatorId(creatorId);

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
