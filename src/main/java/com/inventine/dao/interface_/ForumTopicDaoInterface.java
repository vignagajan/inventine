package com.inventine.dao.interface_;

import com.inventine.model.FinanceAdmin;
import com.inventine.model.ForumReply;
import com.inventine.model.ForumTopic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ForumTopicDaoInterface {

    public boolean create(ForumTopic forumTopic);

    public ForumTopic getForumTopic(String forumTopicId);

    public List<ForumTopic> getForumTopics(String condition);

//    public  List<ForumTopic> getForumTopicsFilter(String condition);

    public boolean update(ForumTopic forumTopic);

    public int getCount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);
}