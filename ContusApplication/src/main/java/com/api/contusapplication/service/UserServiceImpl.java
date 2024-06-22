package com.api.contusapplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contusapplication.dto.PlaceProjectCount;
import com.api.contusapplication.dto.UsersProjectCount;
import com.api.contusapplication.entity.Users;
import com.api.contusapplication.model.UserRequest;
import com.api.contusapplication.repository.UsersRepository;

@Service
public class UserServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void saveUser(UserRequest userRequest) {
        
        usersRepository.save(Users.builder()
        .name(userRequest.getName())
        .place(userRequest.getPlace())
        .build());

    }

    //*** Mapper is required when NativeQuery approach is used in the Repo layer in order to map with the DTO.
    public List<UsersProjectCount> findByUsersWithAssignedProjectCount() {
       return usersRepository.findByUsersWithAssignedProjectCount().stream()
        .map(obj -> UsersProjectCount.builder().userName((String)obj[0]).projectCount((Long)obj[1]).build())
        .collect(Collectors.toList());
  
    }


    public List<PlaceProjectCount> findbyPlaceWithAssignedProjectCount(){

        return usersRepository.findbyPlaceWithAssignedProjectCount().stream()
        .map(obj->PlaceProjectCount.builder().place((String)obj[0]).assignedProjectCount((Long)obj[1]).build())
        .collect(Collectors.toList());
    }
    
}
