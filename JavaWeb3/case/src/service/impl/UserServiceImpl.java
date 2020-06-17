package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author nzy
 * @create 2020-04-25 15:42
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User loginUser) {
        return dao.findUserByUsernameAndPassword(loginUser.getUsername(),loginUser.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void delUser(String id) {
        dao.del(Integer.parseInt(id));
    }

    @Override
    public User findUserByid(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }
    /*
    * 批量删除选中的用户
    * */
    @Override
    public void delSelectedUser(String[] ids) {
        for(String id:ids){
            dao.del(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentpage, String rows, Map<String, String[]> condition) {
        //将页面传递过来的当前页和显示条数转换为整型
        int currentPage = Integer.parseInt(currentpage);
        int row =Integer.parseInt(rows);
        if(currentPage==0){
            currentPage=1;
        }
        //封装一个PageBean对象
        PageBean<User> pb =new PageBean<User>();
        //初始化PageBean对象
        pb.setCurrentPage(currentPage);
        pb.setRows(row);
        //通过调用dao中的获取总条目数方法
        int  count =dao.getTotalCount(condition);
        pb.setTotalCount(count);
        //每页开始的索引 为当前页-1*每页显示条目数
        int start = (currentPage-1)*row;
        //调用dao中的分页条件查询
        List<User> list =dao.findByPage(start,row,condition);
        pb.setList(list);
        //获取总的页数
        int totalPage = (count%row==0)?count/row:count/row+1;

        pb.setTotalPage(totalPage);

        return pb;
    }


}
