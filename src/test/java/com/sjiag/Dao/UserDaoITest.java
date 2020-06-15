package com.sjiag.Dao;

import com.sjiag.Beans.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
public class UserDaoITest {

    @Resource
    PermissionDao permissionDao;
    @Test
    public void queryUserByUsername() throws Exception{
//        Set<String> set = permissionDao.queryPermissionByUsername("zhangsan");
//        System.out.println(set);
        User user = new User();
        user.setUserId("1");
        user.setPwdSalt("as");
        User user1 = new User();
        user1.setUserId("2");
        user1.setPwdSalt("ass");
        List list = new ArrayList();
        list.add("aaa");
        list.add(user);
        list.add(user1);
        System.out.println(list);
    }

}