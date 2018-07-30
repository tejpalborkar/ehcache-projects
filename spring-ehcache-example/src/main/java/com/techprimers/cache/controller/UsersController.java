package com.techprimers.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.cache.cache.UsersService;
import com.techprimers.cache.model.Users;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersController {

    @Autowired
    UsersService usersCache;

    @GetMapping(value = "/{name}")
    public Users getUserByName(@PathVariable final String name) {
        return usersCache.getUser(name);
    }
    
    @GetMapping(value = "/{name}/{id}")
    public Users getUserByNameAndId(@PathVariable final String name, @PathVariable final Integer id) {
        return usersCache.getUserByNameAndId(name, id);
    }
    
    @PostMapping(value = "/create")
    public Users createUer(@RequestBody Users user) {
        return usersCache.save(user);
    }
}
