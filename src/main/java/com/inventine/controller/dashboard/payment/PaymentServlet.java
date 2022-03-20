package com.inventine.controller.dashboard.payment;

import com.inventine.dao.AcceptMeetingDaoImplementation;
import com.inventine.dao.CreatorDaoImplementation;
import com.inventine.dao.PaymentDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.*;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PaymentServlet", value = "/dashboard/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role") == null){
            session.setAttribute("role", 'A' );
        }
        String uri = URLDecoder.decode( request.getRequestURI(), "UTF-8" ).toLowerCase();
        String investorId = uri.substring(uri.lastIndexOf('/') + 1);//"ImageDaoInterface not found!";

        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();
        ProjectDaoImplementation projectDao = new ProjectDaoImplementation();

        List<Payment> payments = paymentDao.getPayments("");


        String creatorsq= null;
        String projectsq= null;
        String investorsq= null;
        String transactionsq= null;
//        String totalq= null;
        char role = (char)request.getSession().getAttribute("role");

        if (role == 'A' || role == 'F' || role == 'S'){
            creatorsq = "select count(DISTINCT creatorid) from project where projectid=(select distinct projectid from payment)";
            projectsq = "select count(DISTINCT projectid) from payment";
            investorsq = "select count(DISTINCT investorid) from payment";
            transactionsq = "select sum(amount/(1000)) from payment";
        }

//        if (role == 'C'){
//            projectsq = "select count(DISTINCT projectid) from payment";
//            investorsq = "select count(DISTINCT investorid) from payment";
//            transactionsq = "select sum(amount/(1000)) from payment";
//            totalq = "select sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s)";
//        }
//
//        if (role == 'I'){
//            projectsq = "select count(DISTINCT projectid) from payment";
//            investorsq = "select count(DISTINCT investorid) from payment";
//            transactionsq = "select sum(amount/(1000)) from payment";
//            totalq = "select sum(amount/(1000)) from payment where projectid=(select projectid from project where creatorid=%s)";
//        }

//        String creators = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String projects = String.format("select count(investorid) from payment where investorid=%s;",investorId);
//        String meetings = String.format("select count(investorid) from acceptmeeting where investorid=%s;",investorId);
//        String transactions = String.format("select sum(amount/(1000)) from payment where investorid=%s;",investorId);




        if(investorId.isEmpty()){
            System.out.println("Investor ID is empty");
        }

        ResultSet rsc = paymentDao.executeQuery(creatorsq);
        ResultSet rsp = paymentDao.executeQuery(projectsq);
        ResultSet rsm = paymentDao.executeQuery(investorsq);
        ResultSet rst = paymentDao.executeQuery(transactionsq);
        try {
            request.setAttribute("creatorsq", rsc.getInt("count"));
            request.setAttribute("projectsq", rsp.getInt("count"));
            request.setAttribute("investorsq", rsm.getInt("count"));
            request.setAttribute("transactionsq", rst.getInt("sum"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("payments",payments);

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Payment");
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/dashboard/payment/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
