package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/** JDBC工具类 使用Druid连接池
 * @author nzy
 * @create 2020-04-23 14:08
 */
public class JDBCUtils {
    private static DataSource ds;
    //静态代码块类一加载就创建
    static {
        try {
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //创建DataSource对象
            ds= DruidDataSourceFactory.createDataSource(pro);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    /**
     * 获取连接池对象
     * */
    public static DataSource getDataSource(){
        return ds;
    }
    /**
     *获取连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
}
