package com.inventine.dao;

import com.inventine.model.Competition;
import com.inventine.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionDaoImplementationTest {

    Competition competition;
    CompetitionDaoImplementation competitionDao;

    @BeforeEach
    void setUp() {
        this.competition = new Competition();
        this.competitionDao = new CompetitionDaoImplementation();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void create(String competition_Id,String organization_Id,String support_Team_Id,String project_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type) {
       this.competition.setCompetitionId(competition_Id);
        this.competition.setOrganizationId(organization_Id);
        this.competition.setSupportTeamId(support_Team_Id);
        this.competition.setProjectId(project_Id);
        this.competition.setCreatedAt(created_At);
        this.competition.setEndingAt(ending_at);
        this.competition.setPrizeMoney(prize_money);
        this.competition.setRules(rules);
        this.competition.setCType(c_type);
        this.competition.setPType(p_type);

        assertTrue(this.competitionDao.create(competition));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void getCompetition(String competition_Id,String organization_Id,String support_Team_Id,String project_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type) {

        this.competition = this.competitionDao.getCompetition(competition_Id);

        assertEquals(competition_Id, this.competition.getCompetitionId());
        assertEquals(organization_Id, this.competition.getOrganizationId());
        assertEquals(support_Team_Id, this.competition.getSupportTeamId());
        assertEquals(project_Id, this.competition.getProjectId());
        assertEquals(created_At, this.competition.getCreatedAt());
        assertEquals(ending_at, this.competition.getEndingAt());
        assertEquals(prize_money, this.competition.getPrizeMoney());
        assertEquals(c_type, this.competition.getCType());
        assertEquals(p_type, this.competition.getPType());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void getCompetitions(String competition_Id,String organization_Id,String support_Team_Id,String project_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type) {

        List<Competition> ls = this.competitionDao.getCompetitions();

        this.competition.setCompetitionId(competition_Id);
        this.competition.setOrganizationId(organization_Id);
        this.competition.setSupportTeamId(support_Team_Id);
        this.competition.setProjectId(project_Id);
        this.competition.setCreatedAt(created_At);
        this.competition.setEndingAt(ending_at);
        this.competition.setPrizeMoney(prize_money);
        this.competition.setRules(rules);
        this.competition.setCType(c_type);
        this.competition.setPType(p_type);

        assertEquals(ls.get(0).getCompetitionId(),this.competition.getCompetitionId());
        assertEquals(ls.get(0).getOrganizationId(),this.competition.getOrganizationId());
        assertEquals(ls.get(0).getSupportTeamId(),this.competition.getSupportTeamId());
        assertEquals(ls.get(0).getProjectId(),this.competition.getProjectId());
        assertEquals(ls.get(0).getCreatedAt(),this.competition.getCreatedAt());
        assertEquals(ls.get(0).getEndingAt(),this.competition.getEndingAt());
        assertEquals(ls.get(0).getPrizeMoney(),this.competition.getPrizeMoney());
        assertEquals(ls.get(0).getRules(),this.competition.getRules());
        assertEquals(ls.get(0).getCType(),this.competition.getCType());
        assertEquals(ls.get(0).getPType(),this.competition.getPType());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void update(String competition_Id,String organization_Id,String support_Team_Id,String project_Id, Timestamp created_At, Timestamp ending_at, int prize_money,  String rules,char c_type, char p_type) {

        this.competition.setCompetitionId(competition_Id);
        this.competition.setOrganizationId(organization_Id);
        this.competition.setSupportTeamId(support_Team_Id);
        this.competition.setProjectId(project_Id);
        this.competition.setCreatedAt(created_At);
        this.competition.setEndingAt(ending_at);
        this.competition.setPrizeMoney(prize_money);
        this.competition.setRules(rules);
        this.competition.setCType('T');
        this.competition.setPType('I');

        this.competitionDao.update(this.competition);

        Competition updated = this.competitionDao.getCompetition(competition_Id);

        assertEquals(this.competition.getCompetitionId(),updated.getCompetitionId());
        assertEquals(this.competition.getOrganizationId(),updated.getOrganizationId());
        assertEquals(this.competition.getSupportTeamId(),updated.getSupportTeamId());
        assertEquals(this.competition.getProjectId(),updated.getProjectId());
        assertEquals(this.competition.getCreatedAt(),updated.getCreatedAt());
        assertEquals(this.competition.getEndingAt(),updated.getEndingAt());
        assertEquals(this.competition.getPrizeMoney(),updated.getPrizeMoney());
        assertEquals(this.competition.getRules(),updated.getRules());
        assertEquals('T',updated.getCType());
        assertEquals('I',updated.getPType());





    }

}