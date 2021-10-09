package com.inventine.dao.interface_;

import com.inventine.model.Project;

import java.util.List;

public interface ProjectDaoInterface{

    public boolean create(Project project);

    public Project getProject(String projectId);

    public List<Project> getAllProject();

    public boolean update(Project project);

}