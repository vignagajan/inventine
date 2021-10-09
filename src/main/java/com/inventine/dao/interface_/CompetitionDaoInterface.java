package com.inventine.dao.interface_;

import com.inventine.model.Competition;

import java.util.List;

public interface CompetitionDaoInterface {
    public boolean create(Competition competition);

    public Competition getCompetition(String competitionId);

    public List<Competition> getAllCompetition();

    public boolean update(String competitionId, String column, String value);

    public boolean delete(String competitionId);
}
