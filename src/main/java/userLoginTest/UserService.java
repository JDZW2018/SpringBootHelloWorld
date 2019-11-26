package userLoginTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {
    private static Map<String, User> users = new HashMap<String, User>();

    @Autowired
    private UserMapper mapper;

    @Value("${spring.datasource.contype}")
    private String type;

    static {
        users.put("tom", new User("tom", "123", "1"));
        users.put("jerry", new User("jerry", "123", "2"));
    }

    public User login(String username, String password) {
        if("mysql".equals(type)){
            User user = mapper.login(username);
            return user.getPassword().equals(password) ? user : null;
        }else {
            User user = users.get(username);
            if (user == null) return null;
            return user.getPassword().equals(password) ? user : null;
        }
    }
}