package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.RateCreatorDaoInterface;
import com.inventine.model.RateCreator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateCreatorDaoImplementation implements RateCreatorDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public boolean create(RateCreator rateCreator) {

        String query = "INSERT INTO RateCreator( creatorId, investorId, creatorRating) " +
                "VALUES (?, ?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, rateCreator.getCreatorId());
            stmt.setString(2, rateCreator.getInvestorId());
            stmt.setString(3, String.valueOf(rateCreator.getCreatorRating()));



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();        }

            return false;

    }

    private RateCreator setRateCreator(RateCreator rateCreator, ResultSet rs) {

        try {

            rateCreator.setRateCreatorId(rs.getString("rateCreatorId"));
            rateCreator.setCreatorId(rs.getString("creatorId"));
            rateCreator.setInvestorId(rs.getString("investorId"));
            rateCreator.setCreatorRating(rs.getInt("creatorRating"));
            rateCreator.setCreatedAt(Timestamp.valueOf(rs.getString("createdAt")));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rateCreator;
    }

    @Override
    public RateCreator getRateCreator(String rateCreatorId) {

        String query = "SELECT * FROM rateCreator WHERE rateCreatorId= ?";

        RateCreator rateCreator = new RateCreator();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,rateCreatorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                rateCreator = setRateCreator(rateCreator, rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


            return null;

    }

    @Override
    public List<RateCreator> getAllRateCreator() {

        String query = "SELECT * FROM rateCreator";

        List<RateCreator> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RateCreator rateCreator = new RateCreator();
                rateCreator = setRateCreator(rateCreator, rs);
                ls.add(rateCreator);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    @Override
    public boolean update(RateCreator rateCreator) {

        String query = String.format("UPDATE rateCreator SET creatorId=?, investorId=?, creatorRating=? WHERE rateCreatorId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setString(1, rateCreator.getCreatorId());
            stmt.setString(2, rateCreator.getInvestorId());
            stmt.setInt(4, rateCreator.getCreatorRating());
            stmt.setString(4, rateCreator.getRateCreatorId());

            stmt.executeUpdate();

            return  true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }


}