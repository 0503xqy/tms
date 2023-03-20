package com.xqy.tms.service.user;

import com.xqy.tms.dto.LoginDto;
import com.xqy.tms.mapper.UserRepository;
import com.xqy.tms.model.UserDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public UserDO authLogin(LoginDto loginDto){
       return userRepository.findByUsernameAndAndPasswordAndAndRole(loginDto.getUsername(), loginDto.getPassword(), loginDto.getRole());
    }
}
