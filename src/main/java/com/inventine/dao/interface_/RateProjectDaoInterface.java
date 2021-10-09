package com.inventine.dao.interface_;

import com.inventine.model.RateProject;

import java.util.List;

public interface RateProjectDaoInterface{

    public boolean create(RateProject rateProject);

    public RateProject getRateProject(String rateProjectId);

    public List<RateProject> getAllRateProject();

    public boolean update(RateProject rateProject);

}