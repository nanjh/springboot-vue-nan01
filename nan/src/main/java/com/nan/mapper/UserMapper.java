package com.nan.mapper;

import com.nan.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nan
 * @since 2023-03-15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
