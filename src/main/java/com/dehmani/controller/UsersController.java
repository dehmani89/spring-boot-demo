package com.dehmani.controller;

import com.dehmani.model.User;
import com.dehmani.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

	/** The JPA repository */
    @Autowired
    private UserJpaRepository userJpaRepository;

	/**
	 * Used to fetch all the users from DB
	 * @return list of {@link User}
	 */
    @GetMapping(value = "/all")
    public List<User> findAll() {
        return userJpaRepository.findAll();
    }

    /**
	 * Used to find and return a user by name
	 * @param name refers to the name of the user
	 * @return {@link User} object
	 */
   /* @GetMapping(value = "/{name}")
    public User findByName(@PathVariable final String name){
        return userJpaRepository.findByName(name);
    }
*/

    /**
     * Used to find and return a user by ID
     * @param id refers to the id of the user
     * @return {@link User} object
     */
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable final Integer id){
        return userJpaRepository.findById(id);
    }

    /**
     * Used to create a User in the DB
     * @param users refers to the User needs to be saved
     * @return the {@link User} created
     */
    @PostMapping(value = "/load")
    public User load(@RequestBody final User users) {
        userJpaRepository.save(users);
        return userJpaRepository.findById(users.getId());
    }
}
