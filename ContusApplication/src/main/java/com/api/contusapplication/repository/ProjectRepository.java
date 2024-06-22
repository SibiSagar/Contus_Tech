package com.api.contusapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.contusapplication.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {


}
