package com.api.ContusApplication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.api.contusapplication.entity.Project;
import com.api.contusapplication.entity.Users;
import com.api.contusapplication.exception.ProjectNotFoundException;
import com.api.contusapplication.repository.ProjectRepository;
import com.api.contusapplication.repository.UsersRepository;
import com.api.contusapplication.service.ProjectServiceImpl;

import java.util.Optional;

@SpringBootTest
public class ProjectServiceImplTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private ProjectRepository projectRepository;

    @Autowired
    @InjectMocks
    private ProjectServiceImpl projectServiceImpl;

   
    @Test
    public void testAssignProjectToUserSuccess() {
        Long userId = 1L;
        String place= "Chennai";
        String username="Sibi";
        String projectName = "Test Project";

        Users mockUser = new Users();
        mockUser.setId(userId);
        mockUser.setPlace(place);
        mockUser.setName(username);
        when(usersRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        Project mockProject = new Project();
        mockProject.setProjectName(projectName);
        mockProject.setUsers(mockUser);
        when(projectRepository.save(any(Project.class))).thenReturn(mockProject);

        Project result = projectServiceImpl.assignProjectToUser(userId, projectName);

        assertNotNull(result);
        assertEquals(projectName, result.getProjectName());
        assertEquals(mockUser, result.getUsers());

      
    }


    @Test
    public void testAssignProjectToUser_ProjectNameBlank() {
        Long userId = 1L;
        String projectName = " ";

        assertThrows(ProjectNotFoundException.class, () -> {
            projectServiceImpl.assignProjectToUser(userId, projectName);
        });

        
    }

    @Test
    public void testAssignProjectToUser_ProjectNameEmpty() {
        Long userId = 1L;
        String projectName = "";

        assertThrows(ProjectNotFoundException.class, () -> {
            projectServiceImpl.assignProjectToUser(userId, projectName);
        });

    }
}
