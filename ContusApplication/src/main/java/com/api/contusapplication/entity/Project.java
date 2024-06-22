package com.api.contusapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

//project - id, project_name, user_assigned_id

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "project_name")
    private String projectName;
  
    @ManyToOne
    @JoinColumn(name = "user_assigned_id")
    private Users users;


}
