package com.example.springbootwithreactcrudoperations.controller;

import com.example.springbootwithreactcrudoperations.exception.UserNotFoundException;
import com.example.springbootwithreactcrudoperations.model.User;
import com.example.springbootwithreactcrudoperations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserBYId(@PathVariable long id){

        return userRepository.findById(id);
    }



    @PostMapping("/users")
    public User postUsers( @RequestBody User user){
        return  userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public List<User> putUser(@RequestBody User user , @PathVariable long id)
    {
        if(userRepository.findById(id) ==null){
            throw new UserNotFoundException( id);
        }

       List<User> user1=userRepository.findAll();
        for (User x:user1){
            if(x.getId()==id) {
                x.setEmail(user.getEmail());
                x.setName(user.getName());
                x.setUsername(user.getUsername());
            }
            userRepository.save(x);
        }
        return userRepository.findAll();
    }


    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id){
        if(userRepository.findById(id) ==null){
            throw new UserNotFoundException( id);
        }
        userRepository.deleteById(id);
        return "User with  "+id+"  Deleted";
    }

}
