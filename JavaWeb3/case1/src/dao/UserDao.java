package dao;

import domain.User;

import java.util.List;

/**
 * @author nzy
 * @create 2020-04-25 16:38
 */
public interface UserDao {
    public List<User> findAll();
}
