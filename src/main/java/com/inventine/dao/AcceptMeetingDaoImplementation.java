package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.AcceptMeetingDaoInterface;
import com.inventine.model.AcceptMeeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcceptMeetingDaoImplementation implements AcceptMeetingDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public boolean create(AcceptMeeting acceptMeeting) {

        String query = "INSERT INTO AcceptMeeting( investorId, meetingId) " +
                "VALUES (?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, acceptMeeting.getInvestorId());
            stmt.setString(2, acceptMeeting.getMeetingId());



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;

    }

    private AcceptMeeting setAcceptMeeting(AcceptMeeting acceptMeeting, ResultSet rs) {

        try {

            acceptMeeting.setAcceptMeetingId(rs.getString("acceptMeetingId"));
            acceptMeeting.setInvestorId(rs.getString("investorId"));
            acceptMeeting.setMeetingId(rs.getString("meetingId"));
            acceptMeeting.setCreatedAt(Timestamp.valueOf(rs.getString("createdAt")));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return acceptMeeting;
    }

    @Override
    public AcceptMeeting getAcceptMeeting(String acceptMeetingId) {

        String query = "SELECT * FROM acceptMeeting WHERE acceptMeetingId= ?";

        AcceptMeeting acceptMeeting = new AcceptMeeting();


        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, acceptMeetingId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                acceptMeeting = setAcceptMeeting(acceptMeeting, rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    public List<AcceptMeeting> getAllAcceptMeeting() {

        String query = "SELECT * FROM acceptMeeting";

        List<AcceptMeeting> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AcceptMeeting acceptMeeting = new AcceptMeeting();
                acceptMeeting = setAcceptMeeting(acceptMeeting, rs);
                ls.add(acceptMeeting);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    @Override
    public boolean update(AcceptMeeting acceptMeeting) {

        String query = String.format("UPDATE acceptMeeting SET investorId=?, meetingId=? WHERE acceptMeetingId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, acceptMeeting.getInvestorId());
            stmt.setString(2, acceptMeeting.getMeetingId());
            stmt.setString(3, acceptMeeting.getAcceptMeetingId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}