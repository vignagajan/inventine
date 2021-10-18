package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumReplyTest {
    ForumReply forumReply;

    @BeforeEach
    void setUp() {
        this.forumReply = new ForumReply();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumReply.csv", numLinesToSkip = 1)
    void getterSetter(String forum_reply_id) {

        this.forumReply.setForumReplyId(forum_reply_id);

        assertEquals(forum_reply_id,this.forumReply.getForumReplyId());

    }
}
