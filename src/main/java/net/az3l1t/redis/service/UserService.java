package net.az3l1t.redis.service;

import net.az3l1t.redis.model.User;
import net.az3l1t.redis.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean saveUser(User user) {
        return repository.saveUser(user);
    }

    public List<User> fetchAllUser() {
        return repository.fetchAllUser();
    }

    public User fetchUserById(Long id) {
        return repository.fetchUserById(id);
    }

    public boolean deleteUser(Long id) {
        return repository.deleteById(id);
    }
}
