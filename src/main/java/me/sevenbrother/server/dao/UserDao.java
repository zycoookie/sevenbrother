package me.sevenbrother.server.dao;

import me.sevenbrother.server.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao{

    @Autowired
    private MongoTemplate template;

    public void save(User user){
        template.save(user);
    }

    public User getUserById(){
        return template.findById(1, User.class);
    }
}
