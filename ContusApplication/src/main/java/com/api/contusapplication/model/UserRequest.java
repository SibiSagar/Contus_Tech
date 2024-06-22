package com.api.contusapplication.model;

import lombok.Data;
import lombok.AllArgsConstructor;   
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private long id;
    private String name;
    private String place;
}
