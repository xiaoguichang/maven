package com.xiaogch.maven.springmvc.dao.impl;

import com.xiaogch.maven.common.db.impl.BaseDaoImpl;
import com.xiaogch.maven.springmvc.dao.SystemPrivilegeInfoDao;
import com.xiaogch.maven.springmvc.entity.SystemPrivilegeInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;


@Repository("systemPrivilegeInfoDao")
public class SystemPrivilegeInfoDaoImpl extends BaseDaoImpl<SystemPrivilegeInfoBean> implements SystemPrivilegeInfoDao {


    public SystemPrivilegeInfoDaoImpl() {
        super.setNamespace("com.xiaogch.maven.springmvc.entity.SystemPrivilegeInfoBean");
    }

    @Autowired
    @Required
    @Qualifier("sqlSessionTemplate")
    public void setSqlSessionTemplateAutowired(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
