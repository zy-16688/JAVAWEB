package dao;

import com.alibaba.druid.util.JdbcUtils;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * @author nzy
 * @create 2020-04-24 0:53
 */
public class UserDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User load(User loginuser){
       try{
           String sql = "select * from user where username=? and password=?";
           User user  = template.queryForObject(sql,
                   new BeanPropertyRowMapper<User>(),
                   loginuser.getUsername(),loginuser.getPassword());
           return user;
       }catch(Exception e){
           return null;
       }
   }
}
