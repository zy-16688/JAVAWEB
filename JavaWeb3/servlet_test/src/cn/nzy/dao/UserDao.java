package cn.nzy.dao;

import cn.nzy.domain.User;
import cn.nzy.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author nzy
 * @create 2020-04-23 14:05
 */
public class UserDao {
    //获取JdbcTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /*登陆方法
            参数  loginuser 只有用户名和密码
           返回值 User 包含所有的用户信息   若查询到有此用户就返回用户信息  否则就是异常则返回null
      */
    public User login(User loginuser){

        try {
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(),loginuser.getPassword()
                    );
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
