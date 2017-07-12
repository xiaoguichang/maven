package com.xiaogch.maven.springmvc.dao;

import com.xiaogch.maven.springmvc.entity.UserInfoBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@Mapper
public interface UserInfoDao {

    @Insert({"insert into t_user_info(name , address , age , birthday , create_time) " +
            " values(#{name} , #{address} , #{age} , #{birthday} , now())"})
    @SelectKey(resultType = Integer.class , statementType = StatementType.STATEMENT , before = false , keyProperty = "id" , statement = "select last_insert_id()")
    int insert(UserInfoBean userInfoBean);

    @Select({"select id , name , address , age , birthday , create_time from t_user_info where id = #{id}"})
    @Results(id = "selectByIdResult" , value = {
            @Result(column = "id" , property = "id"),
            @Result(column = "name" , property = "name"),
            @Result(column = "address", property = "address"),
            @Result(column = "age" , property = "age"),
            @Result(column = "birthday" , property = "birthday"),
            @Result(column = "create_time" , property = "createTime")
    })
    UserInfoBean selectById(@Param("id") Integer id);
}
