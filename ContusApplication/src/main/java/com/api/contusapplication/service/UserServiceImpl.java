package com.api.contusapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contusapplication.dto.PlaceProjectCount;
import com.api.contusapplication.dto.UsersProjectCount;
import com.api.contusapplication.entity.Users;
import com.api.contusapplication.exception.InvalidUserDataException;
import com.api.contusapplication.exception.UserAlreadyExistsException;
import com.api.contusapplication.model.UserRequest;
import com.api.contusapplication.repository.UsersRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    /**
     * Saves a user based on the provided UserRequest object.
     *
     * @param  userRequest  the UserRequest object containing the user data to be saved
     * @throws InvalidUserDataException if the name or place is null, empty, or blank
     * @throws UserAlreadyExistsException if a user with the same ID already exists
     */
    @Override
    public void saveUser(UserRequest userRequest) {
        

        if (userRequest.getName() == null || userRequest.getName().isBlank()) {
            throw new InvalidUserDataException("Name cannot be null or blank");
        }

        if (userRequest.getPlace() == null || userRequest.getPlace().isBlank()) {
            throw new InvalidUserDataException("Place cannot be null or blank");
        }

        Optional<Users> user = usersRepository.findById(userRequest.getId());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException("ID: " + user.get().getId() + " already exists");
        }

        Users newUser = Users.builder()
                .name(userRequest.getName())
                .place(userRequest.getPlace())
                .build();
        log.info("User: " + newUser.getName() + " saved");
        usersRepository.save(newUser);

    }

    /**
     * Retrieves a list of UsersProjectCount objects representing the count of assigned projects for each user.
     * Mapper is required when NativeQuery approach is used in the Repo layer in order to map with the DTO.
     * @return  A list of UsersProjectCount objects, where each object contains the user's name and the count of assigned projects.
     */    
    public List<UsersProjectCount> findByUsersWithAssignedProjectCount() {
       return usersRepository.findByUsersWithAssignedProjectCount().stream()
        .map(obj -> UsersProjectCount.builder().userName((String)obj[0]).projectCount((Long)obj[1]).build())
        .collect(Collectors.toList());
  
    } 

    /**
     * Retrieves a list of PlaceProjectCount objects based on assigned projects for each place.
     *
     * @return List of PlaceProjectCount objects representing the place and assigned project count.
     */
    public List<PlaceProjectCount> findbyPlaceWithAssignedProjectCount(){

        return usersRepository.findbyPlaceWithAssignedProjectCount().stream()
        .map(obj->PlaceProjectCount.builder().place((String)obj[0]).assignedProjectCount((Long)obj[1]).build())
        .collect(Collectors.toList());
    }
    
}
