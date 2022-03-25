package com.inventine.controller.dashboard.project;

import com.inventine.dao.MeetingDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.Meeting;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProjectUpdateServlet", value = "/dashboard/project/update/*")
public class ProjectUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }

        response.setContentType("text/html");

        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();

        String projectId =  uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();
        Project project = new Project();
        project = projectDao.getProject(projectId);



        request.setAttribute("project",project);
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.getRequestDispatcher("/WEB-INF/dashboard/project/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        Project project = new Project();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();

        // Parse request data
        String creatorId = (String)session.getAttribute("userid");
        String supportTeamId = "1";
        char financialStatus = 'I';
        char status = 'A';
        String dateOfExpiry_ = request.getParameter("dateOfExpiry");
        int requestedAmount = Integer.parseInt(request.getParameter("requestedAmount"));
        String projectName = request.getParameter("projectName");
        String category = request.getParameter("category");
        String description = request.getParameter("ck");


        // Data to be processed
        Timestamp dateOfExpiry = null;

        // Data preprocessing
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateOfExpiry_);
            dateOfExpiry = new java.sql.Timestamp(date.getTime());

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }

        // Logic
//        if(projectDao.getCount("WHERE projectname=vicky") >= 1){
//            ok=false;
//            messages.add("projectname is already found!");
//        }

        // Transactions
        if(ok){

            ok = project.setCreatorId(creatorId);
            ok = project.setSupportTeamId(supportTeamId);
            ok = project.setFinancialStatus(financialStatus);
            ok = project.setStatus(status);
            ok = project.setDateOfExpiry(dateOfExpiry);
            ok = project.setRequestedAmount(requestedAmount);
            ok = project.setCategory(category);
            ok = project.setProjectName(projectName);
            ok = project.setDescription(description);

            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

//             Pass model to DAO
//            if(!projectDao.create(project)){
//                ok=false;
//                messages.clear();
//                messages.add("Something went wrong!");
//                System.out.println("There is a issue with dao!");
//
//            }
//            System.out.println(description);
//            System.out.println(creatorId);
//            System.out.println(status);
//            System.out.println(projectName);
//            System.out.println(requestedAmount);


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
