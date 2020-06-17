package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * @author nzy
 * @create 2020-04-25 16:37
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
