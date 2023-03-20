package com.xqy.tms.mapper;

import com.xqy.tms.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
    UserDO findByUsernameAndAndPasswordAndAndRole(String username,String password,String role);
}
