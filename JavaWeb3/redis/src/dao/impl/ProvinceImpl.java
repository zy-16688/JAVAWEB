package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

/**
 * @author nzy
 * @create 2020-05-11 10:07
 */
public class ProvinceImpl implements ProvinceDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> list = template.query(sql,new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
