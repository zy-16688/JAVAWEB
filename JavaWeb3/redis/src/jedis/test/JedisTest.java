package jedis.test;

import jedis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nzy
 * @create 2020-05-10 20:31
 */
public class JedisTest {
    /*
    * Jedis入门
    * */
    @Test
    public void test1() {
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username","zhansan");
        //3.关闭链接
        jedis.close();
    }
    /*
    * string数据结构操作
    * */
    @Test
    public void test2() {
        //获取链接
        Jedis jedis = new Jedis();
        //存储值
        jedis.set("username","lisi");
        //获取值
        String username = jedis.get("username");
        System.out.println(username);
        //可以使用setex()方法存储可以指定过期时间的key value
        jedis.setex("activecode",5,"hehe");
    }
    /*
    * hash 数据结构操作
    * */
    @Test
    public void test3() {
        //获取连接
        Jedis jedis = new Jedis();
        //操作 存储hash
        jedis.hset("user","username","zhansan");
        jedis.hset("user","age","16");
        jedis.hset("user","gender","male");
        //获取值
        String username = jedis.hget("user","username");
        System.out.println(username);
        //获取所有值  返回的是Map集合
        Map<String, String> user = jedis.hgetAll("user");
        //通过keyset() 返回Set集合
        Set<String> strings = user.keySet();
        for(String key : strings) {
            System.out.println(user.get(key));
        }
    }
    @Test
    public void test4(){
        //获取连接
        Jedis jedis = new Jedis();
        //list 存储
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");
        //范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        String mylist1 = jedis.lpop("mylist");
        System.out.println(mylist1);
    }
    @Test
    public void test5(){
        //获取连接
        Jedis jedis = new Jedis();
        //存储数据
        jedis.sadd("myset","java","c++");
        //获取数据
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.close();
    }
    @Test
    public void test6() {
        Jedis jedis = new Jedis();
        //zadd(key,score,value)
        jedis.zadd("mysortset",3,"亚瑟");
        jedis.zadd("mysortset",16,"后裔");
        jedis.zadd("mysortset",18,"猴子");
        //zrange(key,start,end)
        Set<String> mysortset = jedis.zrange("mysortset", 0, -1);
        System.out.println(mysortset);
    }
    /**
     * 连接池的使用
     */
    @Test
    public void test7() {
        //创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //创建Jedis连接池对象
        JedisPool jedisPool  = new JedisPool(config,"localhost",6379);
        //获取连接
        Jedis jedis =  jedisPool.getResource();
        String set = jedis.set("username", "zhansan");
        System.out.println(set);
        jedis.close();
    }
    @Test
    public void test8() {
        //1.获取链接
        Jedis jedis = JedisPoolUtils.getJeids();
        //2.操作
        jedis.set("username","zhansan");
        //3.关闭链接
        jedis.close();
    }
}
