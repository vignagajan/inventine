package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompetitionTest {
    Competition competition;

    @BeforeEach
    void setUp() {
        this.competition = new Competition();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Competition.csv", numLinesToSkip = 1)
    void getterSetter(String competition_id, Timestamp starting_at, Timestamp ending_at, int prize_money, String type, String rules) {

        this.competition.setCompetitionId(competition_id);
        this.competition.setStartingAt(starting_at);
        this.competition.setEndingAt(ending_at);
        this.competition.setPrizeMoney(prize_money);
        this.competition.setType(type);
        this.competition.setRules(rules);

        assertEquals(competition_id, this.competition.getCompetitionId());
        assertEquals(starting_at, this.competition.getStartingAt());
        assertEquals(ending_at, this.competition.getEndingAt());
        assertEquals(prize_money, this.competition.getPrizeMoney());
        assertEquals(type, this.competition.getType());
        assertEquals(rules, this.competition.getRules());
    }
}
