package com.nan.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nan.common.QueryPageParam;
import com.nan.entity.User;
import com.nan.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author nan
 * @since 2023-03-15
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    // 新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    // 修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user) {
        return userService.updateById(user);
    }

    // 新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    // 删除
    @GetMapping("/delete")
    public boolean delete(Integer id) {
        return userService.removeById(id);
    }

    // 查询(模糊、匹配)
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getName, user.getName());

        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query) {
        /*System.out.println(query);
        System.out.println("num ===" + query.getPageNum());
        System.out.println("size ===" + query.getPageSize());*/
        HashMap param = query.getParam();
        System.out.println((String) param.get("name"));
        System.out.println((String) param.get("no"));

        /**
         * current: 当前页
         * size: 每页多少条
         */
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, (String) param.get("name"));

        //分页
        IPage result = userService.page(page, lambdaQueryWrapper);
        System.out.println(result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listPageC")
    public List<User> listPageC(@RequestBody QueryPageParam query) {
        /*System.out.println(query);
        System.out.println("num ===" + query.getPageNum());
        System.out.println("size ===" + query.getPageSize());*/
        HashMap param = query.getParam();
        String name = (String) param.get("name");

        System.out.println("name ===" + name);

        /**
         * current: 当前页
         * size: 每页多少条
         */
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);

        //分页
        //IPage result = userService.pageC(page);
        IPage result = userService.pageCC(page, lambdaQueryWrapper);
        System.out.println("total ==" + result.getTotal());
        //System.out.println(result);
        return result.getRecords();
    }
}
