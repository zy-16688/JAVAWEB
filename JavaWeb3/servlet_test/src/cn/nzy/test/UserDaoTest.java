package cn.nzy.test;

import cn.nzy.dao.UserDao;
import cn.nzy.domain.User;
import org.junit.Test;

/**
 * @author nzy
 * @create 2020-04-23 14:40
 */
public class UserDaoTest {
    @Test
    public void testlogin(){
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123");
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);

    }
}
