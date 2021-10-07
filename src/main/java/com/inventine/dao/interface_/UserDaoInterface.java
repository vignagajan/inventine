package com.inventine.dao.interface_;

import com.inventine.model.User;

import java.util.List;

public interface UserDaoInterface {

    public boolean create(User user);

    public User getUser(String username);

    public List<User> getUsers();

    public boolean update(User user);

}
