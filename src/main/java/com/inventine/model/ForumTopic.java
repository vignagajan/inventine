package com.inventine.model;

import com.inventine.controller.dashboard.DasboardServlet;
import com.inventine.util.DataValidator;

public class ForumTopic extends Post{
    private String ForumTopicId;
    private DataValidator validator = new DataValidator();

    public String getForumTopicId() {
        return ForumTopicId;
    }

    public boolean setForumTopicId(String forumTopicId) {
        this.validator.setTxt(forumTopicId);
        if(this.validator.isNumber()){
            this.ForumTopicId = forumTopicId;
            return true;
        }
        return false;
    }
}
