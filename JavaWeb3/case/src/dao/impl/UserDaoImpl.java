package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nzy
 * @create 2020-04-25 15:44
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //若是查找的是单个对象 则使用queryForObject  查找的是集合 则使用query
    @Override
    public List<User> findAll() {
        //通过jdbctemplate实现数据库操作
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
    //登陆方法
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void del(int id) {
        String sql = "delete from user where id=?";
        template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }
    /*
    * 分页条件查询  模糊查询
    * */
    @Override
    public List<User> findByPage(int start, int row,Map<String, String[]> condition) {
        String sql = "select * from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        //存储参数值
        List<Object> pramas = new ArrayList<Object>();
        //获取键值对
        for (String key : keySet) {
            //排除分页条件
            if ("currentpage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                //将条件拼接到原有的sql中
                sb.append(" and " + key + " like ? ");
                //将参数添加到list集合中
                pramas.add("%" + value + "%");
            }
        }
        //添加限制调制条件条目
        sb.append(" limit ?,?");
        pramas.add(start);
        pramas.add(row);

        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), pramas.toArray());

    }

    @Override
    public int getTotalCount(Map<String, String[]> condition) {
        //用于动态拼接条件
        String sql = "select count(*) from user where 1=1";
        //sb用于拼接条件
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> pramas = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件
            if ("currentpage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取map条件集合中的值
            String value = condition.get(key)[0];
            //值不为空且不等于空字符串
            if (value != null && !"".equals(value)) {
                //将条件拼接到sql后
                sb.append(" and " + key + " like ? ");
                //并且将参数值存入到pramas集合中 可进行模糊查询
                pramas.add("%" + value + "%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(pramas);
        int count = template.queryForObject(sb.toString(), Integer.class, pramas.toArray());
        return count;
    }

}

