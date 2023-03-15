package com.nan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author nan
 * @since 2023-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    @TableField("NO")
    private String no;

    /**
     * 名字
     */
    @TableField("NAME")
    private String name;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    private Integer age;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 电话
     */
    private String phone;

    /**
     * 角色 0超级管理员 1管理员 2普通账号
     */
    private Integer roleId;

    /**
     * 是否有效 Y有效 其他无效
     */
    @TableField("isValid")
    private String isvalid;


}
