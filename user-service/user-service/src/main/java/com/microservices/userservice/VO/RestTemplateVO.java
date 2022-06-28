package com.microservices.userservice.VO;

import com.microservices.userservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplateVO {

    public User user;
    public Department department;
}
