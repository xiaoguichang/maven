package com.xiaogch.maven.system.service.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.impl.BaseServiceImpl;

import com.xiaogch.maven.system.dao.RoleInfoDao;
import com.xiaogch.maven.system.entity.RoleInfoBean;
import com.xiaogch.maven.system.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 16:23 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Service("roleInfoService")
public class RoleInfoServiceImpl extends BaseServiceImpl<RoleInfoBean> implements RoleInfoService {

    @Autowired
    private RoleInfoDao roleInfoDao;

    @Override
    public BaseDao<RoleInfoBean> getBaseDao() {
        return roleInfoDao;
    }
}
