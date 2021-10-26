package com.inventine.dao.interface_;

import com.inventine.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PostDaoInterface {
    public boolean create(Post post);

    public Post getPost(String postId);

    public List<Post> getPosts(String condition);

    public boolean update(Post post);

    public int getCount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);


}
