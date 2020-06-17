package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceImpl;
import domain.Province;
import jedis.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import service.ProvinceService;

import java.util.List;

/**
 * @author nzy
 * @create 2020-05-11 10:08
 */
public class ProvinceServiceImpl implements ProvinceService {
    ProvinceDao dao = new ProvinceImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtils.getJeids();
        //从redis中取数据
        String  province_json  = jedis.get("province");
        if(province_json == null || province_json.length() == 0){
            System.out.println("redis中没数据,查询数据库");
            List<Province> list = dao.findAll();
            ObjectMapper mapper  = new ObjectMapper();
            try {
                //序列化为json数据
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            jedis.close();
        }else {
            System.out.println("redis中有数据");
        }
        return province_json;
    }
}
