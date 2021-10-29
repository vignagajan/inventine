package com.inventine.controller.dashboard.meeting;

import com.inventine.dao.MeetingDaoImplementation;
import com.inventine.model.Meeting;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MeetingServlet", value = "/dashboard/meeting")
public class MeetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        MeetingDaoImplementation meetingDao = new MeetingDaoImplementation();

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));


        request.setAttribute("accepted",meetingDao.getCount("creatorid=3 AND status='A'"));
        request.setAttribute("rejected", meetingDao.getCount("creatorid=3 AND status='R'"));
        request.setAttribute("upcoming", meetingDao.getCount("creatorid=3 AND launchedAt>=NOW()"));
        request.setAttribute("total", meetingDao.getCount("creatorid=3"));

        List<Meeting> meetings = meetingDao.getMeetings("");
        request.setAttribute("meetings",meetings);
        request.getRequestDispatcher("/WEB-INF/dashboard/meeting/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
