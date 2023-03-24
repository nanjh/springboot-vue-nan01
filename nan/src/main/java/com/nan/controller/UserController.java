package com.nan.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nan.common.QueryPageParam;
import com.nan.common.Result;
import com.nan.entity.User;
import com.nan.service.IUserService;
import freemarker.template.utility.StringUtil;
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
    public Result save(@RequestBody User user) {
        return userService.save(user) ? Result.success():Result.fail();
    }


    //更新
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.updateById(user) ? Result.success():Result.fail();
    }

    //删除
    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        return userService.removeById(id) ? Result.success():Result.fail();
    }

    //登陆
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        List list = userService.lambdaQuery().eq(User::getNo, user.getNo())
                .eq(User::getPassword, user.getPassword()).list();

        return list.size()>0 ? Result.success(list.get(0)):Result.fail();
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
    public Result listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(user.getName())) {
            lambdaQueryWrapper.like(User::getName, user.getName());
        }

        return Result.success(userService.list(lambdaQueryWrapper));
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


    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no) {
        List<User> list = userService.lambdaQuery().eq(User::getNo, no).list();
        return list.size()>0?Result.success(list):Result.fail();
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

    @PostMapping("/listResult")
    public Result listResult(@RequestBody QueryPageParam query) {
        /*System.out.println(query);
        System.out.println("num ===" + query.getPageNum());
        System.out.println("size ===" + query.getPageSize());*/
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        String sex = (String) param.get("sex");

        System.out.println("name ===" + name);

        /**
         * current: 当前页
         * size: 每页多少条
         */
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name)) {
            lambdaQueryWrapper.like(User::getName, name);
        }

        if(StringUtils.isNotBlank(sex)) {
            lambdaQueryWrapper.eq(User::getSex, sex);
        }


        //分页
        //IPage result = userService.pageC(page);
        IPage result = userService.pageCC(page, lambdaQueryWrapper);
        System.out.println("total ==" + result.getTotal());
        System.out.println(result.getRecords());
        //System.out.println(result);
        return Result.success(result.getRecords(), result.getTotal());
    }



}
