package cn.mmooo.dao;


import cn.mmooo.AppTest;
import cn.mmooo.model.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

public class UserMapperTest extends AppTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectAllTest() {
        // 第二页，每页十条数据
        PageHelper.startPage(2, 10, true);
        List<User> list = userMapper.selectAll();

        if (list instanceof Page) {
            Page<User> selectAll = (Page<User>) list;
            System.out.println(selectAll.getTotal());
            list = selectAll.getResult();
            System.out.println("=========进入分页=======");
        }

        list.stream().forEach(System.out::println);
        // System.out.println(workerMapper.selectAll());
    }

    @Test
    public void ListUser() {
        List<User> listInfo = userMapper.findAll();
       listInfo.stream().forEach(c->System.out.println(c.getName()));

    }


    @Test
    //@Rollback(true)
    public void testInsert() {

        User user = new User();
        user.setName("555888");
        userMapper.insert(user);


    }

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        users.forEach(c->System.out.println(c.getId()+"______"+c.getName()));
    }


    @Test
    public void deleteById() {
        userMapper.deleteByPrimaryKey(1);
    }
}
