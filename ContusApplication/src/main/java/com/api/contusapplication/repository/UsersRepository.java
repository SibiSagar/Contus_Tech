package com.api.contusapplication.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.api.contusapplication.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * Retrieves a list of Object arrays representing the user's name and the count of assigned projects.
     *
     * @return  A list of Object arrays, where each array contains the user's name and the assigned project count.
     *          The list is ordered by assigned project count in descending order
     */
    @Query(value="SELECT u.name as userName, COUNT(p.id) as assignedProjectCount " +
    "FROM users u "+
    "LEFT JOIN project p ON u.id=p.user_assigned_id " +
    "GROUP BY u.name " +
    "ORDER BY assignedProjectCount DESC", nativeQuery = true)
    public List<Object[]> findByUsersWithAssignedProjectCount();


    /**
     * Retrieves a list of Object arrays representing the place and the count of assigned projects.
     *
     * @return  A list of Object arrays, where each array contains the place and the assigned project count.
     *          The list is ordered by assigned project count in descending order.
     */
    @Query(value="SELECT u.place as place, COUNT(p.id) as assignedProjectCount "+ 
    "FROM users u "+
    "LEFT JOIN project p ON u.id=p.user_assigned_id " +
    "GROUP BY u.place "+
    "ORDER BY assignedProjectCount DESC", nativeQuery = true)
    public List<Object[]> findbyPlaceWithAssignedProjectCount();

}


