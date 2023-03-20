package com.xqy.tms.controller;


import com.xqy.tms.config.Audience;
import com.xqy.tms.dto.LoginDto;
import com.xqy.tms.dto.Result;
import com.xqy.tms.model.UserDO;
import com.xqy.tms.service.user.UserService;
import com.xqy.tms.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private Audience audience;

    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginDto loginDto) throws Exception {
        UserDO userDO = userService.authLogin(loginDto);
        Result result = null == userDO ? Result.error("登录失败！") : Result.success(JwtTokenUtil.createJWT(userDO.getId().toString(),userDO.getUsername(),userDO.getRole(),audience),"登录成功");
        return result;
    }

//    @GetMapping("/logout")
//    public Result<?> logout(HttpServletRequest request) {
//        SecurityContextHolder.clearContext();
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/checkToken")
//    public Result<?> checkToken(HttpServletRequest request) {
//        String authToken = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
//        if (jwtTokenUtil.validateToken(authToken)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
