package com.api.contusapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contusapplication.entity.Project;
import com.api.contusapplication.entity.Users;
import com.api.contusapplication.repository.ProjectRepository;
import com.api.contusapplication.repository.UsersRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project assignProjectToUser(Long userId, String projectName) {
       
        Users user= this.usersRepository.findById(userId).orElseThrow(RuntimeException::new);

        return projectRepository.save(Project.builder().projectName(projectName).users(user).build());

    }
    
}
