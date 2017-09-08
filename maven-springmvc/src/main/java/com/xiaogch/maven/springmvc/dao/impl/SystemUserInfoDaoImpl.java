package com.xiaogch.maven.springmvc.dao.impl;

import com.xiaogch.maven.common.db.impl.BaseDaoImpl;
import com.xiaogch.maven.springmvc.dao.SystemUserInfoDao;
import com.xiaogch.maven.springmvc.entity.SystemUserInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;


@Repository("systemUserInfoDao")
public class SystemUserInfoDaoImpl extends BaseDaoImpl<SystemUserInfoBean> implements SystemUserInfoDao {

    public SystemUserInfoDaoImpl() {
        super.setNamespace("com.xiaogch.maven.springmvc.entity.SystemUserInfoBean");
    }

    @Autowired
    @Required
    @Qualifier("sqlSessionTemplate")
    public void setSqlSessionTemplateAutowired(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
