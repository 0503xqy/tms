package com.xqy.tms.controller;


import com.xqy.tms.dto.Result;
import com.xqy.tms.model.UserDO;
import com.xqy.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody UserDO UserDO) throws Exception {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenUtil.generateToken(authentication);
        return Result.success(1);
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
