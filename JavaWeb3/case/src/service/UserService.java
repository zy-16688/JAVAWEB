package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author nzy
 * @create 2020-04-25 15:41
 */
/**
 * 实现查询用户的所有信息
 * */
public interface UserService {
    /*
    * 查找用户的所有信息
    * */
    public List<User> findAll();
    /*
    * 进行登录信息验证  若信息正确则返回用户的所有信息 否则返回空
    * */
    public User login(User loginUser);
    /*
    * 添加用户
    * */
    public void  addUser(User user);
    /*
    * 根据id删除用户
    * */
    public void  delUser(String id);
    /*
    * 根据id进行查询
    * */
    User findUserByid(String id);
    /*
    * 修改用户信息
    * */
    void updateUser(User user);
    /*
    * 批量删除选中的用户信息
    * */
    void delSelectedUser(String[] ids);
    /*
    * 分页条件查询
    * */
    PageBean<User> findUserByPage(String currentpage, String rows, Map<String, String[]> condition);
}
