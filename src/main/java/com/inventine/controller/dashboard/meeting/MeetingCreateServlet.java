package com.inventine.controller.dashboard.meeting;

import com.inventine.dao.MeetingDaoImplementation;
import com.inventine.model.Meeting;
import com.inventine.util.DotEnv;
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
//        HttpSession session = request.getSession();
//
//        // JSON parameters
//        JSONObject json = new JSONObject();
//        List<String> messages = new ArrayList<>();
//        boolean ok = true;
//
//        // Models and DAOs
//        Meeting meeting = new Meeting();
//        MeetingDaoImplementation meetingDao = new MeetingDaoImplementation();
//
//        // Parse request data
//        String creatorId = (String)session.getAttribute("userid");
//        String launchedAt = request.getParameter("launchedAt");
//        int requestedAmount = Integer.parseInt(request.getParameter("requestedAmount"));
//        String meetingName = request.getParameter("meetingName");
//        String category = request.getParameter("category");
//        String description = request.getParameter("ck");
//
//
//        // Data to be processed
//        Timestamp dateOfExpiry = null;
//
//        // Data preprocessing
//        try {
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse(dateOfExpiry_);
//            dateOfExpiry = new java.sql.Timestamp(date.getTime());
//
//        }catch (Exception e){
//            ok = false;
//            messages.clear();
//            messages.add("Something went wrong at get data!");
//            e.printStackTrace();
//        }
//
//        // Logic
////        if(meetingDao.getCount("WHERE meetingname=vicky") >= 1){
////            ok=false;
////            messages.add("meetingname is already found!");
////        }
//
//        // Transactions
//        if(ok){
//
//            ok = meeting.setCreatorId(creatorId);
//            ok = meeting.setLaunchedAt(launchedAt);
//            ok = meeting.setCategory(category);
//            ok = meeting.setMeetingName(meetingName);
//            ok = meeting.setDetails(description.getBytes());
//
//            if(!ok){
//
//                messages.clear();
//                messages.add("Something went wrong at get data!");
//                System.out.println("There is a issue with setting attributes!");
//
//            }
//
////             Pass model to DAO
////            if(!meetingDao.create(meeting)){
////                ok=false;
////                messages.clear();
////                messages.add("Something went wrong!");
////                System.out.println("There is a issue with dao!");
////
////            }
////            System.out.println(description);
////            System.out.println(creatorId);
////            System.out.println(status);
////            System.out.println(meetingName);
////            System.out.println(requestedAmount);
//
//
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

    }
}
