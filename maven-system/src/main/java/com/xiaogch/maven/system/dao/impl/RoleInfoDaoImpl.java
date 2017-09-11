package com.xiaogch.maven.system.dao.impl;

import com.xiaogch.maven.common.db.impl.BaseDaoImpl;
import com.xiaogch.maven.system.dao.RoleInfoDao;
import com.xiaogch.maven.system.entity.RoleInfoBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

@Repository("roleInfoDao")
public class RoleInfoDaoImpl extends BaseDaoImpl<RoleInfoBean> implements RoleInfoDao {

    public RoleInfoDaoImpl() {
        super.setNamespace("system.roleInfo");
    }

    @Autowired
    @Required
    @Qualifier("sqlSessionTemplate")
    public void setSqlSessionTemplateAutowired(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
