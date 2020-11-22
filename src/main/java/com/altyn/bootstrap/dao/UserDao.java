package com.altyn.bootstrap.dao;

import com.altyn.bootstrap.module.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getById(long id);
    void save(User user);
    void remove(long id);
    void update(long id, User user);
    User getUserByUserName(String name);
}
