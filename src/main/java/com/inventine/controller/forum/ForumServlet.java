package com.inventine.controller.forum;

import com.inventine.dao.ForumTopicDaoImplementation;
import com.inventine.dao.PostDaoImplementation;
import com.inventine.dao.ProjectDaoImplementation;
import com.inventine.model.ForumTopic;
import com.inventine.model.Post;
import com.inventine.model.Project;
import com.inventine.util.DotEnv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ForumServlet", value = "/forum")
public class ForumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("host_url", DotEnv.load().get("HOST_URL"));

        PostDaoImplementation postDao = new PostDaoImplementation();
        ForumTopicDaoImplementation forumTopicDao = new ForumTopicDaoImplementation();

        String condition;

        List<ForumTopic> forumTopics = forumTopicDao.getForumTopics("");
        for (final ForumTopic forumTopic: forumTopics){
            condition = String.format("%s",forumTopic.getPostId());
            Post post = postDao.getPost(condition);
            forumTopic.setDescription(post.getDescription());
            forumTopic.setCreatedAt(post.getCreatedAt());
        }
        request.setAttribute("forumTopic",forumTopics);

        request.getRequestDispatcher("/WEB-INF/forum/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
