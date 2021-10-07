package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.UserDaoInterface;
import com.inventine.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplementation implements UserDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public boolean create(User user) {

        String query = "INSERT INTO users(firstName, lastName, dob, gender, phone, address, district, type ) " +
                "VALUES (?, ?,?, CAST(? AS ge),?, ?,?, CAST(? AS te))";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setTimestamp(3, user.getDob());
            stmt.setString(4, String.valueOf(user.getGender()));
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getDistrict());
            stmt.setString(8, String.valueOf(user.getType()));

            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    private User setUser(User user, ResultSet rs) {

        try {
            user.setUserId(rs.getString("userId"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setDob(rs.getTimestamp("dob"));
            user.setGender(rs.getString("gender").charAt(0));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            user.setDistrict(rs.getString("district"));
            user.setType(rs.getString("type").charAt(0));
            user.setCreatedAt(rs.getTimestamp("createdAt"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getUser(String userId) {

        String query = "SELECT * FROM users WHERE userId= ?";

        User user = new User();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(userId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user = setUser(user, rs);
            }

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<User> getUsers() {

        String query = "SELECT * FROM users";

        List<User> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user = setUser(user, rs);
                ls.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    @Override
    public boolean update(User user) {

        String query = String.format("UPDATE users SET firstName=?, lastName=?, dob=?, gender=CAST(? AS ge), phone=?, address=?, district=?, type=CAST(? AS te) WHERE userId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setTimestamp(3, user.getDob());
            stmt.setString(4, String.valueOf(user.getGender()));
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getDistrict());
            stmt.setString(8, String.valueOf(user.getType()));
            stmt.setInt(9, Integer.parseInt(user.getUserId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

}