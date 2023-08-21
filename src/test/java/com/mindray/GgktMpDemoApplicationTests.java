package com.mindray;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mindray.entity.User;
import com.mindray.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GgktMpDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLambdaQuery() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAge,30);
        queryWrapper.like(User::getName,"张");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    @Test
    public void testLogicDelete() {
        int rows = userMapper.deleteById(3);
        System.out.println("rows = " + rows);
        findAll();
    }

    @Test
    public void testGetByIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 3, 5));
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteBatchIds() {
        int rows = userMapper.deleteBatchIds(Arrays.asList(1654410466020880386L, 1690670664536326145L, 1690671574079569922L));
        System.out.println("rows = " + rows);
    }

    @Test
    public void testPagination(){
        IPage<User> page = new Page<>(2, 3);
        IPage<User> userPage = userMapper.selectPage(page, null);
        userPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
        users.forEach(System.out::println);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setName("b");
        user.setAge(10);
        user.setEmail("b@126.com");
//        user.setId(7);
        int insert = userMapper.insert(user);
        System.out.println("rows = " + insert);
    }


    @Test
    public void testInserUser(){
        User user = new User();
        user.setEmail("qwb@126.com");
        user.setName("qwb");
        user.setAge(9);
        int rows = userMapper.insert(user);
        System.out.println("rows = " + rows);
        System.out.println("user = " + user);
    }

}
