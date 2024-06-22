package com.api.contusapplication.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.api.contusapplication.entity.Users;



public interface UsersRepository extends JpaRepository<Users, Long> {

    // GET API: List users - user_name, assigned_project_count  (order based on assigned project count)
    // GET http://localhost:8080/api/v1/users/users-project-count
    @Query(value="SELECT u.name as userName, COUNT(p.id) as assignedProjectCount " +
    "FROM users u "+
    "LEFT JOIN project p ON u.id=p.user_assigned_id " +
    "GROUP BY u.name " +
    "ORDER BY assignedProjectCount DESC", nativeQuery = true)
    public List<Object[]> findByUsersWithAssignedProjectCount();


    // GET API: List places - place,  assigned_project_count  (order based on place count)
    // GET http://localhost:8080/api/v1/users/place-project-count
    @Query(value="SELECT u.place as place, COUNT(p.id) as assignedProjectCount "+ 
    "FROM users u "+
    "LEFT JOIN project p ON u.id=p.user_assigned_id " +
    "GROUP BY u.place "+
    "ORDER BY assignedProjectCount DESC", nativeQuery = true)
    public List<Object[]> findbyPlaceWithAssignedProjectCount();

}


