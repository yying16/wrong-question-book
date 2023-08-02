package com.wrongquestionbook.controller;

import com.wrongquestionbook.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/changePassword/{account}/{oldPsw}/{newPsw}")
    public boolean changePassword(@PathVariable String account,@PathVariable String oldPsw, @PathVariable String newPsw) {
        return userService.changePassword(account,oldPsw,newPsw);
    }
}
