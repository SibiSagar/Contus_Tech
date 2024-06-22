package com.api.contusapplication.service;

import com.api.contusapplication.entity.Project;

public interface ProjectService {
    
    Project assignProjectToUser(Long userId, String projectName);
}
