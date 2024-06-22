package com.api.contusapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * Assignd User to Project according to user Id and Project Name, Retrieves Project objects.
     *
     * @param  userId       Input user Id, needed for assinging to the project
     * @param  projectName  Input Project Name
     * @return              ResponseEntity<Project> representing Project object.
     */
    @PostMapping("/assign")
    public ResponseEntity<Project> assignProjectToUser(@RequestParam Long userId, @RequestParam String projectName){
        Project project=projectService.assignProjectToUser(userId, projectName);
         return new ResponseEntity<>(project, HttpStatus.CREATED);
    }


  

}
