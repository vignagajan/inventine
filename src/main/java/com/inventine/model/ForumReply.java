package com.inventine.model;


import com.inventine.util.DataValidator;

public class ForumReply extends Post{
    private String ForumReplyId;
    private DataValidator validator = new DataValidator();

    public String getForumReplyId() {
        return ForumReplyId;
    }

    public boolean setForumReplyId(String forumReplyId) {
        this.validator.setTxt(forumReplyId);
        if(this.validator.isNumber()){
            this.ForumReplyId = forumReplyId;
            return true;
        }
        return false;
    }
}
