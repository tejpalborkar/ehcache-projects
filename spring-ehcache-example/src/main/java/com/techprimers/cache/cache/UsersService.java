package com.techprimers.cache.cache;

import com.techprimers.cache.model.Users;
import com.techprimers.cache.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Cacheable(value = "usersCache", key = "#name")
    public Users getUser(String name) {
        System.out.println("Retrieving from Database for name: " + name);
        return usersRepository.findByName(name);
    }
    
    @Cacheable(value = "usersCache", key = "#name#id")
    public Users getUserByNameAndId(String name, Integer id) {
        System.out.println("Retrieving from Database for name: " + name);
        return usersRepository.findByNameAndId(name,id);
    }

	public Users save(Users user) {
		 System.out.println("Storin in Database for name: " + user.getName());
		return usersRepository.save(user);
	}
}
