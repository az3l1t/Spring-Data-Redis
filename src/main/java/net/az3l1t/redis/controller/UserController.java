package net.az3l1t.redis.controller;

import net.az3l1t.redis.model.User;
import net.az3l1t.redis.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/redis")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(
            @RequestBody User user
    ) {
        boolean result = service.saveUser(user);
        if(result){
            return ResponseEntity.ok("User Created Successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> fetchAllUser(){
        List<User> users = new ArrayList<>();
        users = service.fetchAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> fetchUserById(
            @PathVariable("id") Long id
    ) {
        User user = new User();
        user = service.fetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("id") Long id
    ) {
        boolean result = service.deleteUser(id);
        if(result){
            return ResponseEntity.ok("User deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
