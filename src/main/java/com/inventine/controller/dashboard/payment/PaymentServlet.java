package com.inventine.controller.dashboard.payment;

import com.inventine.dao.AcceptMeetingDaoImplementation;
import com.inventine.dao.CreatorDaoImplementation;
import com.inventine.dao.PaymentDaoImplementation;
import com.inventine.model.Payment;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PaymentServlet", value = "/dashboard/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Payment");

        CreatorDaoImplementation creatorDao = new CreatorDaoImplementation();
        AcceptMeetingDaoImplementation acceptMeetingDao = new AcceptMeetingDaoImplementation();
        PaymentDaoImplementation paymentDao = new PaymentDaoImplementation();


        request.setAttribute("creators",paymentDao.getCount("investorid=1"));
        request.setAttribute("projects", paymentDao.getCount("investorid=1"));
        request.setAttribute("meetings", acceptMeetingDao.getCount("investorid=1"));
        ResultSet rs = creatorDao.executeQuery("select sum(amount/(1000)) from payment where investorid=1;");
        try {
            request.setAttribute("transactions", rs.getInt("sum"));
        } catch (SQLException e) {
            e.printStackTrace();
        }




        List<Payment> payments = paymentDao.getPayments("investorid=1");
        request.setAttribute("payments",payments);
        request.getRequestDispatcher("/WEB-INF/dashboard/payment/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
