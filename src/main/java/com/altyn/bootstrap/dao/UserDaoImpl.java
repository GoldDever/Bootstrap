package com.altyn.bootstrap.dao;

import com.altyn.bootstrap.module.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery
                ("select u from User u", User.class).getResultList();
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User updatedUser) {
        User user = getById(id);
        user.setAge(updatedUser.getAge());
        user.setName(updatedUser.getName());
        user.setLastName(updatedUser.getLastName());
        user.setPassword(updatedUser.getPassword());
        user.setRoles(updatedUser.getRoles());
        entityManager.merge(user);
    }

    @Override
    public void remove(long id) {
        User user = getById(id);
        entityManager.remove(user);
    }

    @Override
    public User getUserByUserName(String login) {
        Query q = (Query) entityManager.createQuery("SELECT u FROM User u WHERE u.login=:name");
        q.setParameter("name", login);
        User user = (User) q.getSingleResult();
        return user;
    }
}
