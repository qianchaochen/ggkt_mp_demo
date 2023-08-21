package com.mindray;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mindray.entity.User;
import com.mindray.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class LambdaTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLambdaQuery(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(User::getAge, 20);
        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testLambdaQuery2() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAge,30);
        queryWrapper.like(User::getName,"张");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }
}

