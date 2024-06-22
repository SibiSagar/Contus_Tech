package com.api.contusapplication.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.contusapplication.dto.PlaceProjectCount;
import com.api.contusapplication.dto.UsersProjectCount;
import com.api.contusapplication.model.UserRequest;
import com.api.contusapplication.service.UsersService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/v1/users")
@Log4j2
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    /**
     * Saves a user by receiving a UserRequest object in the request body and
     * delegating the saving operation to the UsersService.
     *
     * @param  userRequest  the UserRequest object containing the user data to be saved
     */
    @PostMapping
    public void saveUser(@RequestBody UserRequest userRequest) {
        log.info("UserRequest: " + userRequest + " received");
        usersService.saveUser(userRequest);

    }

    /**
     * Retrieves a list of UsersProjectCount objects representing the count of assigned projects for each user.
     *
     * @return ResponseEntity<List<UsersProjectCount>> representing the list of UsersProjectCount objects.
     */
    @GetMapping("/users-project-count")
    public ResponseEntity<List<UsersProjectCount>> findByUsersWithAssignedProjectCount() {
        log.info("UsersProjectCount list retrieved: " + this.usersService.findByUsersWithAssignedProjectCount()  );
       return new ResponseEntity<>( this.usersService.findByUsersWithAssignedProjectCount(),HttpStatus.OK);
        
    }

    /**
     * Retrieves a list of place-project counts based on assigned projects.
     *
     * @return ResponseEntity<List<PlaceProjectCount>> representing the place-project counts.
     */
    @GetMapping("/place-project-count")
    public ResponseEntity<List<PlaceProjectCount>> findbyPlaceWithAssignedProjectCount(){
        log.info("PlaceProjectCount list retrieved: " + this.usersService.findbyPlaceWithAssignedProjectCount()  );
        return new ResponseEntity<>( this.usersService.findbyPlaceWithAssignedProjectCount(),HttpStatus.OK);

    }




}
