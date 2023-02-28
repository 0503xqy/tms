package com.xqy.tms.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.*;


@Entity(name = "sys_user")
@Data
@ToString
@DynamicUpdate
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
    
    private String role;
    
}
