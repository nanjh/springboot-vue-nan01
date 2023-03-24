package com.nan.controller;


import com.nan.common.Result;
import com.nan.entity.Menu;
import com.nan.entity.User;
import com.nan.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nan
 * @since 2023-03-24
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/list")
    public Result list(@RequestParam String roleId) {
        List<Menu> list = menuService.lambdaQuery().like(Menu::getMenuright, roleId).list();
        return Result.success(list);
    }
}
