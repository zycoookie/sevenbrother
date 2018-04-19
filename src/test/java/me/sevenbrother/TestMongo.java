package me.sevenbrother;

import me.sevenbrother.server.dao.UserDao;
import me.sevenbrother.server.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestMongo extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Before
    public void setup(){
        User user = new User();
        user.setId(1);
        user.setFirstName("七");
        user.setLastName("哥");
        userDao.save(user);
    }

    @Test
    public void test(){
        User user = userDao.getUserById();
        System.out.println(user);
    }
}
