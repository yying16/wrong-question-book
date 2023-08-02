package com.wrongquestionbook;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wrongquestionbook.domain.User;
import com.wrongquestionbook.mapper.UserMapper;
import com.wrongquestionbook.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WrongQuestionBookApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    public boolean changePassword(String account,String oldPsw, String newPsw) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("account",account);
        User user = userMapper.selectById(account);
        if(user.getPassword().equals(oldPsw)){
            user.setPassword(newPsw);
            userMapper.updateById(user);
            return true;
        }
        return false;
    }

    @Test
    void contextLoads() {
        System.out.println(userService.changePassword("zhangsan","zs123456",""));
    }

}
