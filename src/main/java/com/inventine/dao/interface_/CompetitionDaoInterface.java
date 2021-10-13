package com.inventine.dao.interface_;

import com.inventine.model.Competition;

import java.util.List;

public interface CompetitionDaoInterface {
    public boolean create(Competition competition);

    public Competition getCompetition(String competitionId);

    public List<Competition> getCompetitions();

    public boolean update(Competition competition);


}
