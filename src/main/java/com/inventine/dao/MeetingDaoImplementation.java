package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.MeetingDaoInterface;
import com.inventine.model.Meeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingDaoImplementation implements MeetingDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public boolean create(Meeting meeting) {

        String query = "INSERT INTO Meeting( creatorId, launchedAt, link) " +
                "VALUES ( ?, ?, ?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, meeting.getCreatorId());
            stmt.setString(3, String.valueOf(meeting.getLaunchedAt()));
            stmt.setString(4, meeting.getLink());




            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace(); }

            return false;

    }

    private Meeting setMeeting(Meeting meeting, ResultSet rs) {

        try {

            meeting.setMeetingId(rs.getString("meetingId"));
            meeting.setCreatorId(rs.getString("creatorId"));
            meeting.setLink(rs.getString("link"));
            meeting.setCreatedAt(Timestamp.valueOf(rs.getString("createdAt")));
            meeting.setLaunchedAt(Timestamp.valueOf(rs.getString("launchedAt")));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meeting;
    }

    @Override
    public Meeting getMeeting(String meetingId) {

        String query = "SELECT * FROM meeting WHERE meetingId= ?";

        Meeting meeting = new Meeting();


        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,meetingId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                meeting = setMeeting(meeting, rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


            return null;

    }

    @Override
    public List<Meeting> getAllMeeting() {

        String query = "SELECT * FROM meeting";

        List<Meeting> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Meeting meeting = new Meeting();
                meeting = setMeeting(meeting, rs);
                ls.add(meeting);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    @Override
    public boolean update(Meeting meeting) {

        String query = String.format("UPDATE Meeting SET creatorId=?, launchedAt=?, link=? WHERE meetingId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, meeting.getCreatorId());
            stmt.setTimestamp(2, meeting.getLaunchedAt());
            stmt.setString(3, meeting.getLink());
            stmt.setString(3, meeting.getMeetingId());


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }


}