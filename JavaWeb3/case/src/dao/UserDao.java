package dao;

/**
 * @author nzy
 * @create 2020-04-25 15:43
 */

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 * */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username, String password);
    public void add(User user);
    public void del(int i);
    public User findById(int id);

    public void update(User user);

    List<User> findByPage(int start, int row,Map<String, String[]> condition);

    int getTotalCount(Map<String, String[]> condition);
}
