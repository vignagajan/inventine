package com.inventine.controller.dashboard.organization;

import com.inventine.dao.CompetitionDaoImplementation;
import com.inventine.dao.OrganizationDaoImplementation;
import com.inventine.model.Organization;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrganizationServlet", value = "/dashboard/organization")
public class OrganizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        OrganizationDaoImplementation organizationDao = new OrganizationDaoImplementation();
        CompetitionDaoImplementation competitionDao = new CompetitionDaoImplementation();

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        String topic= "Organization Dashboard";
        request.setAttribute("title",topic);


        request.setAttribute("creator",organizationDao.getCount("creatorid=3 "));
        request.setAttribute("competition", competitionDao.getCount("organizationid=17"));
//        request.setAttribute("deleted", organizationDao.getCount("creatorid=5 AND status='D'"));
//        request.setAttribute("total", organizationDao.getCount("creatorid=5"));
        List<Organization> organizations = organizationDao.getOrganizations("");
        request.setAttribute("organizations",organizations);

        request.getRequestDispatcher("/WEB-INF/dashboard/organization/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
