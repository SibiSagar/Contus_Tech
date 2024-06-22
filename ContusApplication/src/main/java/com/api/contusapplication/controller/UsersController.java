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

/*
c) GET API: List places - place,  assigned_project_count  (order based on place count)
 */

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    //For adding new user
    @PostMapping
    public void saveUser(@RequestBody UserRequest userRequest) {
        usersService.saveUser(userRequest);

    }

    //GET API: List users - user_name, assigned_project_count  (order based on assigned project count)
    @GetMapping("/users-project-count")
    public ResponseEntity<List<UsersProjectCount>> findByUsersWithAssignedProjectCount() {

       return new ResponseEntity<>( this.usersService.findByUsersWithAssignedProjectCount(),HttpStatus.OK);
        
    }

    @GetMapping("/place-project-count")
    public ResponseEntity<List<PlaceProjectCount>> findbyPlaceWithAssignedProjectCount(){

        return new ResponseEntity<>( this.usersService.findbyPlaceWithAssignedProjectCount(),HttpStatus.OK);

    }




}
