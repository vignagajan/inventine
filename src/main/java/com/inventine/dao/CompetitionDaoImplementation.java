package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.CompetitionDaoInterface;

import com.inventine.model.Competition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDaoImplementation implements CompetitionDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public boolean create(Competition competition) {

        String query = "INSERT INTO competition(competitionId,organizationId,  supportTeamId,projectId,createdAt,endingAt ,prizeMoney,type,rules ) " +
                "VALUES (?, ?, ?,?,?,?,?,?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, competition.getCompetitionId());
            stmt.setString(2, competition.getOrganizationId());
            stmt.setString(3, competition.getSupportTeamId());
            stmt.setString(4, competition.getProjectId());
            stmt.setTimestamp(5, competition.getCreatedAt());
            stmt.setTimestamp(6, competition.getEndingAt());
            stmt.setInt(7, competition.getPrizeMoney());
            stmt.setString(8, competition.getType());
            stmt.setString(9, competition.getRules());



         /* stmt.setString(5, String.valueOf(competition.getRole()));
            stmt.setString(6, String.valueOf(competition.getStatus())); */

            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Competition setCompetition(Competition competition, ResultSet rs) {

        try {

            competition.setCompetitionId(rs.getString("competitionId"));
            competition.setOrganizationId(rs.getString("organizationId"));
            competition.setSupportTeamId(rs.getString("supportTeamId"));
            competition.setProjectId(rs.getString("projectId"));
            competition.setCreatedAt(Timestamp.valueOf(rs.getString("createdAt")));
            competition.setCreatedAt(Timestamp.valueOf(rs.getString("endingAt")));
            competition.setPrizeMoney(rs.getInt("prizeMoney"));
            competition.setType(rs.getString("type"));
            competition.setRules(rs.getString("rules"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return competition;
    }

    @Override
    public Competition getCompetition(String username) {

        String query = "SELECT * FROM competition WHERE competitionId= ?";

        Competition competition = new Competition();
        boolean found = false;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, competition.getCompetitionId());


            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                found = true;
                competition = setCompetition(competition, rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (found == true) {
            return competition;
        } else
            return null;

    }

    @Override
    public List<Competition> getAllCompetition() {

        String query = "SELECT * FROM competition";

        List<Competition> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Competition competition = new Competition();
                competition = setCompetition(competition, rs);
                ls.add(competition);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }
    @Override
    public boolean update(String competitionId, String column, String value) {

        String query = String.format("UPDATE competition SET %s=? WHERE competitionId =?",column);

        try{

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, value);
            stmt.setString(2, competitionId);



            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }







    @Override
    public boolean delete(String competitionId) {

        update(competitionId, "status", "D");
        return true;

    }


}