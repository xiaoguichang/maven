package com.xiaogch.maven.system.dao.scan;

import com.xiaogch.maven.system.entity.ParameterInfoBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@Mapper
public interface ParameterInfoDao {

    /**
     *
     * 功能描述：获取某个系统参数
     * @param paramKey 系统参数key
     * @return 系统参数详情
     * @author xiaogch
     * @since 2017年7月19日
     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
    @Select({ "select id , param_key , param_value , description , create_time , update_time from t_sys_param_info where param_key = #{paramKey}" })
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "param_key" , property = "paramKey"),
            @Result(column = "param_value" , property = "paramValue"),
            @Result(column = "description" , property = "description"),
            @Result(column = "create_time" , property = "createTime"),
            @Result(column = "update_time" , property = "updateTime")
    })
    public ParameterInfoBean getSystemParameterByKey(String paramKey);


    final String getSystemParameterByKeysSQL = "<script>"
            + "select id , param_key , param_value , description , create_time , update_time"
            + " from t_sys_param_info where param_key in "
            + "<foreach collection='list' item='item' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>";

    /***
     *
     * 功能描述：获取多个系统参数
     *
     * @param paramKeys 系统参数key
     * @return 系统参数详情列表
     *
     * @author xiaogch
     *
     * @since 2017年7月19日
     *
     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
     */
    @Select(getSystemParameterByKeysSQL)
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "param_key" , property = "paramKey"),
            @Result(column = "param_value" , property = "paramValue"),
            @Result(column = "description" , property = "description"),
            @Result(column = "create_time" , property = "createTime"),
            @Result(column = "update_time" , property = "updateTime")
    })
    public List<ParameterInfoBean> getSystemParameterByKeys(List<String> paramKeys);

}
