package com.inventine.dao.interface_;

import com.inventine.model.Organization;

import java.util.List;

public interface OrganizationDaoInterface {
    public boolean create(Organization organization);

    public Organization getOrganization(String organizationId);

    public List<Organization> getAllOrganization();

    public boolean update(String organizationId, String column, String value);

    public boolean delete(String organizationId);
}
