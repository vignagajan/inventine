package com.inventine.controller.dashboard.meeting;

import com.inventine.dao.CredsDaoImplementation;
import com.inventine.dao.MeetingDaoImplementation;
import com.inventine.dao.MeetingDaoImplementation;
import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.Creds;
import com.inventine.model.Meeting;
import com.inventine.model.Meeting;
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

@WebServlet(name = "MeetingCreateServlet", value = "/dashboard/create-meeting")
public class MeetingCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }
        response.setContentType("text/html");
        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Create Meeting");
        request.getRequestDispatcher("/WEB-INF/dashboard/meeting/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // JSON parameters
//        JSONObject json = new JSONObject();
//        List<String> messages = new ArrayList<>();
//        boolean ok = true;
//
//        // Models and DAOs
//
//
//        Meeting meeting = new Meeting();
//        MeetingDaoImplementation meetingDao = new MeetingDaoImplementation();
//
//        // Parse request data
//
//        HttpSession session = request.getSession();
//
//        //   String creatorId = session.getAttribute("userId").toString();
////        String supportTeamId = "1";
////        String logoId = "1640618179717";
////        String headerId = "1640618091700";
//
//        //  char financialStatus = 'I';
//        // char status = 'A';
//
//        String link = request.getParameter("link");
//        String description = request.getParameter("description");
////        String date = request.getParameter("date");
////        String time = request.getParameter("time");
//
////
////        String username = request.getParameter("username");
////        String email= request.getParameter("email");
////        String password_ = request.getParameter("password");
////        char type = 'O';
//
//        char status = 'A';
//
//        //String category = request.getParameter("category");
//        //String rules = request.getParameter("rules");
//        //char cType = request.getParameter("cType").charAt(0);
//        // char pType = 'A';
//
//        // Data to be processed
////        Timestamp endingAt = null;
////
////
////        // Data preprocessing
////        try {
////
////            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////            Date date = dateFormat.parse(endingAt_);
////            endingAt = new java.sql.Timestamp(date.getTime());
////
////        }catch (Exception e){
////            ok = false;
////            messages.clear();
////            messages.add("Something went wrong at get data!");
////            e.printStackTrace();
////        }
////        Timestamp startingAt = null;
////        try {
////
////            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////            Date date = dateFormat.parse(startingAt_);
////            startingAt = new java.sql.Timestamp(date.getTime());
////
////        }catch (Exception e){
////            ok = false;
////            messages.clear();
////            messages.add("Something went wrong at get data!");
////            e.printStackTrace();
////        }
//
//        // Logic
////        if(competitionDao.getCount("WHERE competitionname=vicky") >= 1){
////            ok=false;
////            messages.add("competitionname is already found!");
////        }
//
//        // Transactions
//        if(ok){
//
//            //ok = meeting.setCreatorId(creatorId);
//
//            //System.out.println(meeting.getCreatorId());
//            ok = meeting.setSupportTeamId(supportTeamId);
//            System.out.println(meeting.getSupportTeamId());
//            ok = meeting.setHeaderId(headerId);
//            System.out.println(meeting.getHeaderId());
//            ok = meeting.setLogoId(logoId);
//            System.out.println(meeting.getLogoId());
//            ok = meeting.setName(name);
//            System.out.println(meeting.getName());
//            ok = meeting.setAddress(address);
//            System.out.println(meeting.getAddress());
//            ok = meeting.setDistrict(district);
//            System.out.println(meeting.getDistrict());
//            ok = meeting.setContactNumber(contactnumber);
//            System.out.println(meeting.getContactNumber());
//            ok = meeting.setOrgType(orgtype);
//            System.out.println(meeting.getOrgType());
//            ok = meeting.setStatus(status);
//            System.out.println(meeting.getStatus());
//            //    ok = competition.setFinancialStatus(financialStatus);
//            //  ok = competition.setStatus(status);
//
//
//            if(!ok){
//
//                messages.clear();
//                messages.add("Something went wrong at get data!");
//                System.out.println("There is a issue with setting attributes!");
//
//            }
//
//            // Pass model to DAO
//            if(!meetingDao.create(meeting)){
//                ok=false;
//                messages.clear();
//                messages.add("Something went wrong!");
//                System.out.println("There is a issue with dao!");
//
//            }
//        }
//
//        // JSON response
//        json.put("ok", ok);
//        json.put("messages", messages);
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        out.print(json);
//        out.flush();
//
//

    
    }
}
