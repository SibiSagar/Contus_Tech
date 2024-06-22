package com.api.contusapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contusapplication.entity.Project;
import com.api.contusapplication.entity.Users;
import com.api.contusapplication.exception.ProjectNotFoundException;
import com.api.contusapplication.exception.UserNotFoundException;
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

        if(projectName.isEmpty() || projectName.isBlank() ) {
            throw new ProjectNotFoundException("Project name cannot be null or blank");
        }

        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        return projectRepository.save(Project.builder().projectName(projectName).users(user).build());

    }
    
}
