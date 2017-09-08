package com.xiaogch.maven.springmvc.dao.impl;

import com.xiaogch.maven.common.db.impl.BaseDaoImpl;
import com.xiaogch.maven.springmvc.dao.SystemRoleInfoDao;
import com.xiaogch.maven.springmvc.entity.SystemRoleInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

@Repository("systemRoleInfoDao")
public class SystemRoleInfoDaoImpl extends BaseDaoImpl<SystemRoleInfoBean> implements SystemRoleInfoDao {

    public SystemRoleInfoDaoImpl() {
        super.setNamespace("com.xiaogch.maven.springmvc.entity.SysRoleInfoBean");
    }

    @Autowired
    @Required
    @Qualifier("sqlSessionTemplate")
    public void setSqlSessionTemplateAutowired(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
