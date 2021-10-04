package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.OrganizationDaoInterface;

import com.inventine.model.Organization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganizationDaoImplementation implements OrganizationDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public boolean create(Organization organization) {

        String query = "INSERT INTO organization(organizationId,creatorId,supportTeamId, name, address, district,contactNumber ) " +
                "VALUES (?, ?,?, ?,?,?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, organization.getOrganizationId());
            stmt.setString(2, organization.getCreatorId());
            stmt.setString(3, organization.getSupportTeamId());
            stmt.setString(4, organization.getName());
            stmt.setString(5, organization.getAddress());
            stmt.setString(6, organization.getDistrict());
            stmt.setString(7, organization.getContactNumber());




         /* stmt.setString(5, String.valueOf(organization.getRole()));
            stmt.setString(6, String.valueOf(organization.getStatus())); */

            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Organization setOrganization(Organization organization, ResultSet rs) {

        try {

            organization.setOrganizationId(rs.getString("organizationId"));
            organization.setCreatorId(rs.getString("creatorId"));
            organization.setSupportTeamId(rs.getString("supportTeamId"));
            organization.setName(rs.getString("name"));
            organization.setAddress(rs.getString("address"));
            organization.setDistrict(rs.getString("district"));
            organization.setContactNumber(rs.getString("contactNumber"));





        } catch (SQLException e) {
            e.printStackTrace();
        }

        return organization;
    }

    @Override
    public Organization getOrganization(String username) {

        String query = "SELECT * FROM organization WHERE organizationId= ?";

        Organization organization = new Organization();
        boolean found = false;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, organization.getOrganizationId());


            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                found = true;
                organization = setOrganization(organization, rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (found == true) {
            return organization;
        } else
            return null;

    }

    @Override
    public List<Organization> getAllOrganization() {

        String query = "SELECT * FROM organization";

        List<Organization> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Organization organization = new Organization();
                organization = setOrganization(organization, rs);
                ls.add(organization);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }
    @Override
    public boolean update(String organizationId, String column, String value) {

        String query = String.format("UPDATE organization SET %s=? WHERE organizationId =?",column);

        try{

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, value);
            stmt.setString(2, organizationId);



            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }







    @Override
    public boolean delete(String organizationId) {

        update(organizationId, "status", "D");
        return true;

    }


}