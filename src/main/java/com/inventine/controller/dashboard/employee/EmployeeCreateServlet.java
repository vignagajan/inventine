package com.inventine.controller.dashboard.employee;

import com.inventine.dao.UserDaoImplementation;
import com.inventine.model.User;
import com.inventine.util.DotEnv;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeCreateServlet", value = "/dashboard/employee/create")
public class EmployeeCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));
        request.setAttribute("title","Employee");
        request.getRequestDispatcher("/WEB-INF/dashboard/employee/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // JSON parameters
        JSONObject json = new JSONObject();
        List<String> messages = new ArrayList<>();
        boolean ok = true;

        // Models and DAOs
        User user = new User();
        UserDaoImplementation userDao = new UserDaoImplementation();

        // Parse request data
        String first_name = request.getParameter("firstName");
        String last_name = request.getParameter("lastName");
        String dob_ = request.getParameter("dob");
        char gender = request.getParameter("gender").charAt(0);
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String district = request.getParameter("district");
        char type = 'A';
        String username = request.getParameter("username");

        // Data to be processed
        Timestamp dob = null;

        // Data preprocessing
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dob_);
            dob = new java.sql.Timestamp(date.getTime());

        }catch (Exception e){
            ok = false;
            messages.clear();
            messages.add("Something went wrong at get data!");
            e.printStackTrace();
        }

        // Logic
//        if(userDao.getCount("WHERE username=vicky") >= 1){
//            ok=false;
//            messages.add("Username is already found!");
//        }

        // Transactions
        if(ok){

            ok = user.setFirstName(first_name);
            ok = user.setLastName(last_name);
            ok = user.setDob(dob);
            ok = user.setGender(gender);
            ok = user.setPhone(phone);
            ok = user.setAddress(address);
            ok = user.setDistrict(district);
            ok = user.setType(type);

            if(!ok){

                messages.clear();
                messages.add("Something went wrong at get data!");
                System.out.println("There is a issue with setting attributes!");

            }

            // Pass model to DAO
            if(userDao.create(user) == -1){
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
