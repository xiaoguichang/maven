package com.xiaogch.maven.system.dao.impl;

import com.xiaogch.maven.common.db.impl.BaseDaoImpl;
import com.xiaogch.maven.system.dao.UserInfoDao;
import com.xiaogch.maven.system.entity.UserInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;


@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfoBean> implements UserInfoDao {

    public UserInfoDaoImpl() {
        super.setNamespace("system.userInfoBean");
    }

    @Autowired
    @Required
    @Qualifier("sqlSessionTemplate")
    public void setSqlSessionTemplateAutowired(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
