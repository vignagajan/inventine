package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.RateProjectDaoInterface;
import com.inventine.model.RateCreator;
import com.inventine.model.RateProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateProjectDaoImplementation implements RateProjectDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public boolean create(RateProject rateProject) {

        String query = "INSERT INTO RateProject( projectId, investorId, projectRating) " +
                "VALUES (?, ?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, rateProject.getProjectId());
            stmt.setString(2, rateProject.getInvestorId());
            stmt.setString(3, String.valueOf(rateProject.getProjectRating()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();        }

            return false;

    }

    private RateProject setRateProject(RateProject rateProject, ResultSet rs) {

        try {

            rateProject.setRateProjectId(rs.getString("rateProjectId"));
            rateProject.setProjectId(rs.getString("projectId"));
            rateProject.setInvestorId(rs.getString("investorId"));
            rateProject.setProjectRating(rs.getInt("projectRating"));
            rateProject.setCreatedAt(Timestamp.valueOf(rs.getString("createdAt")));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rateProject;
    }

    @Override
    public RateProject getRateProject(String rateProjectId) {

        String query = "SELECT * FROM rateProject WHERE rateProjectId= ?";

        RateProject rateProject = new RateProject();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,rateProjectId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                rateProject = setRateProject(rateProject, rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

            return null;

    }

    @Override
    public List<RateProject> getAllRateProject() {

        String query = "SELECT * FROM rateProject";

        List<RateProject> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RateProject rateProject = new RateProject();
                rateProject = setRateProject(rateProject, rs);
                ls.add(rateProject);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    @Override
    public boolean update(RateProject rateProject) {

        String query = String.format("UPDATE rateProject SET projectId=?, investorId=?, projectRating=? WHERE rateProjectId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, rateProject.getProjectId());
            stmt.setString(2, rateProject.getInvestorId());
            stmt.setInt(3, rateProject.getProjectRating());
            stmt.setString(4, rateProject.getRateProjectId());

            stmt.executeUpdate();

            return  true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

}