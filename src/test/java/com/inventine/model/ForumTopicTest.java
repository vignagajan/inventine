package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumTopicTest {
    ForumTopic forumTopic;

    @BeforeEach
    void setUp() {
        this.forumTopic = new ForumTopic();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumTopic.csv", numLinesToSkip = 1)
    void getterSetter(String forum_topic) {

        this.forumTopic.setForumTopicId(forum_topic);

        assertEquals(forum_topic,this.forumTopic.getForumTopicId());

    }
}
