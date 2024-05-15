package net.az3l1t.redis.repository;

import net.az3l1t.redis.model.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";

    public UserRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean saveUser(User user) {
        try{
            redisTemplate.opsForHash().put(KEY,user.getId().toString(),user);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<User> fetchAllUser() {
        List<User> users;
        users = redisTemplate.opsForHash().values(KEY);
        return users;
    }

    public User fetchUserById(Long id) {
        User user = new User();
        user = (User) redisTemplate.opsForHash().get(KEY,id.toString());
        return user;
    }

    public boolean deleteById(Long id) {
        try{
            redisTemplate.opsForHash().delete(KEY,id.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
