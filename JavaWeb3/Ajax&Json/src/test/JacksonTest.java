package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author nzy
 * @create 2020-05-10 10:57
 */

public class JacksonTest {
    @Test
    public void JacksonTest1() throws IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(16);
        p.setGender("男");
        //2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*
        *   转换方法:
        *       writeValue(参数1,obj)
        *           参数1:
        *               File: 将obj对象转换为Json字符串,并写入文件中
        *               Writer   将obj对象转换为Json字符串,并将json数据填充到字符输出流中
        *               OutputStream
        *        writeValueAsString(obj)  将obj对象转换为Json字符串
        * */
        //将obj对象转换为了Json字符串
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
        //将obj对象转换字符串写入file文件中
        mapper.writeValue(new File("d://1.txt"),p);
        //将obj对象转换为json字符串填充到字符输出流中
        mapper.writeValue(new FileWriter("d://b.txt"),p);
    }
    @Test
    public void JasksonTest2() throws JsonProcessingException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        //@JasonIgnore 排除属性
        //@JsonFormat(pattern="格式")  属性值的格式化
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }
    @Test
    public void JasksonTest3() throws JsonProcessingException {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setGender("男");
        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(18);
        p2.setGender("男");
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        ObjectMapper mapper = new ObjectMapper();
        //转换出来是数组
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }
    @Test
    public void JacksonTest4() throws JsonProcessingException {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",18);
        map.put("gender","男");
        ObjectMapper mapper = new ObjectMapper();
        String json  = mapper.writeValueAsString(map);
        System.out.println(json);

    }
    @Test
    public void JacksonTest5() throws IOException {
        //1.初始化JSON字符串
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        //转换为Java对象 Person对象
        Person p = mapper.readValue(json,Person.class);
        System.out.println(p);
    }
}
