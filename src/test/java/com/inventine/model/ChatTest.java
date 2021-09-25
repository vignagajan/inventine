package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ChatTest {

    Chat chat;

    @BeforeEach
    void setUp() {
        this.chat = new Chat();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Chat.csv", numLinesToSkip = 1)
    void getterSetter(String chat_id, String receiver, String content, Timestamp created_at) {

        this.chat.setChatId(chat_id);
        this.chat.setReceiver(receiver);
        this.chat.setContent(content);
        this.chat.setCreatedAt(created_at);


        assertEquals(chat_id, this.chat.getChatId());
        assertEquals(receiver, this.chat.getReceiver());
        assertEquals(content, this.chat.getContent());
        assertEquals(created_at, this.chat.getCreatedAt());


    }

}