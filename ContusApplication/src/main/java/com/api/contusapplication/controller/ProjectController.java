package com.api.contusapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.contusapplication.entity.Project;
import com.api.contusapplication.service.ProjectService;


@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    //POST API: Assign project to the user.(multiple projects can be assigned to the same user) 
    //POST http://localhost:8080/api/v1/project/assign?userId=?&projectName=?
    @PostMapping("/assign")
    public ResponseEntity<Project> assignProjectToUser(@RequestParam Long userId, @RequestParam String projectName){
        Project project=projectService.assignProjectToUser(userId, projectName);
         return new ResponseEntity<>(project, HttpStatus.CREATED);
    }


  

}
