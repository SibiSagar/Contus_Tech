package com.api.contusapplication.service;

import java.util.List;

import com.api.contusapplication.dto.PlaceProjectCount;
import com.api.contusapplication.dto.UsersProjectCount;
import com.api.contusapplication.model.UserRequest;

public interface UsersService {

void saveUser(UserRequest userRequest);
List<UsersProjectCount> findByUsersWithAssignedProjectCount();
List<PlaceProjectCount> findbyPlaceWithAssignedProjectCount();

}
