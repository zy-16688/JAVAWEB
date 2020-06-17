package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author nzy
 * @create 2020-04-24 0:54
 */
public class JDBCUtils {
    private static DataSource ds ;
    static {
        try {
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds  = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource(){
        return ds ;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
