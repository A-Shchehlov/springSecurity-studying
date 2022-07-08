package com.example.security.model;

import com.example.security.security.UserRole;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
public class User {
    //@Id
    private Long id;
    private String username;
    private String password;
    //@Enumerated(EnumType.STRING)
    private UserRole userRole;
}
