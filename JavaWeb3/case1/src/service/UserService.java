package service;

import domain.User;

import java.util.List;

/**
 * @author nzy
 * @create 2020-04-25 16:36
 */
public interface UserService {
    public List<User> findAll();
}
