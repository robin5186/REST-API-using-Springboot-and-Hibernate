package com.robin.user.controller;


import com.robin.user.User;
import com.robin.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewWebUser(@RequestBody User user)
    {
        User user1 =new User();
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        userRepository.save(user1);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody User user)
    {
        userRepository.deleteAll();
    }

}
