package com.xiaogch.maven.system.dao.impl;

import com.xiaogch.maven.system.dao.PrivilegeInfoDao;
import com.xiaogch.maven.system.entity.PrivilegeInfoBean;;

import com.xiaogch.maven.common.db.impl.BaseDaoImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;


@Repository("privilegeInfoDao")
public class PrivilegeInfoDaoImpl extends BaseDaoImpl<PrivilegeInfoBean> implements PrivilegeInfoDao {


    public PrivilegeInfoDaoImpl() {
        super.setNamespace("system.privilegeInfoBean");
    }

    @Autowired
    @Required
    @Qualifier("sqlSessionTemplate")
    public void setSqlSessionTemplateAutowired(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
