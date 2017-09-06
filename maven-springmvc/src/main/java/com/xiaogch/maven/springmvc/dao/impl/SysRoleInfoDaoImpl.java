package com.xiaogch.maven.springmvc.dao.impl;

import com.xiaogch.maven.springmvc.dao.SysRoleInfoDao;
import com.xiaogch.maven.springmvc.entity.SysRoleInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

@Repository("sysRoleInfoDao")
public class SysRoleInfoDaoImpl extends BaseDaoImpl<SysRoleInfoBean> implements SysRoleInfoDao {

    public SysRoleInfoDaoImpl() {
        super.setNamespace("com.xiaogch.maven.springmvc.entity.SysRoleInfoBean");
    }

    @Autowired
    @Required
    @Qualifier("sqlSessionTemplate")
    public void setSqlSessionTemplateAutowired(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
