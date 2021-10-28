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
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from competition";
        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);
            query = query.concat(condition);
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            count = rs.getInt("count");
        }catch (SQLException e){
            count = 0;
        }

        return count;
    }

    @Override
    public boolean create(Competition competition) {

        String query = "INSERT INTO competition(organizationId,  supportTeamId,projectId,endingAt ,prizeMoney,rules,cType,pType,competitionName ) " +
                "VALUES (?, ?, ?,?,?,?,CAST(? AS cp),CAST(? AS pte),?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(competition.getOrganizationId()));
            stmt.setInt(2, Integer.parseInt(competition.getSupportTeamId()));
            stmt.setInt(3, Integer.parseInt(competition.getProjectId()));
            stmt.setTimestamp(4, competition.getEndingAt());
            stmt.setInt(5, competition.getPrizeMoney());
            stmt.setString(6, competition.getRules());
            stmt.setString(7, String.valueOf(competition.getCType()));
            stmt.setString(8, String.valueOf(competition.getPType()));
            stmt.setString(9,String.valueOf(competition.getCompetitionName()));






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
            competition.setCreatedAt(rs.getTimestamp("createdAt"));
            competition.setEndingAt(rs.getTimestamp("endingAt"));
            competition.setPrizeMoney(rs.getInt("prizeMoney"));
            competition.setRules(rs.getString("rules"));
            competition.setCType(rs.getString("cType").charAt(0));
            competition.setPType(rs.getString("pType").charAt(0));
            competition.setCompetitionName(rs.getString("competitionName"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return competition;
    }

    @Override
    public Competition getCompetition(String competitionId) {

        String query = "SELECT * FROM competition WHERE competitionId= ?";

        Competition competition = new Competition();
        boolean found = false;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(competitionId));


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
    public List<Competition> getCompetitions(String condition) {

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
    public boolean update(Competition competition) {

        String query = String.format("UPDATE competition SET organizationId=?, supportTeamId=?, projectId=?, endingAt=?, prizeMoney=?, rules=?,cType=CAST(? AS cp),pType=CAST(? AS pte),competitionName=? WHERE competitionId =?");

        try{

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(competition.getOrganizationId()));
            stmt.setInt(2, Integer.parseInt(competition.getSupportTeamId()));
            stmt.setInt(3, Integer.parseInt(competition.getProjectId()));
            stmt.setTimestamp(4, competition.getEndingAt());
            stmt.setInt(5,competition.getPrizeMoney());
            stmt.setString(6,competition.getRules());
            stmt.setString(7, String.valueOf(competition.getCType()));
            stmt.setString(8, String.valueOf(competition.getPType()));
            stmt.setString(9,competition.getCompetitionName());
            stmt.setInt(10, Integer.parseInt(competition.getCompetitionId()));





            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }








}