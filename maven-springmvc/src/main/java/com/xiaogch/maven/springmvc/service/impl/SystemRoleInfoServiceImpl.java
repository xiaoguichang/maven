package com.xiaogch.maven.springmvc.service.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.impl.BaseServiceImpl;
import com.xiaogch.maven.springmvc.dao.SystemRoleInfoDao;
import com.xiaogch.maven.springmvc.entity.SystemRoleInfoBean;
import com.xiaogch.maven.springmvc.service.SystemRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 16:23 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Service("systemRoleInfoService")
public class SystemRoleInfoServiceImpl extends BaseServiceImpl<SystemRoleInfoBean> implements SystemRoleInfoService {

    @Autowired
    private SystemRoleInfoDao systemRoleInfoDao;

    @Override
    public BaseDao<SystemRoleInfoBean> getBaseDao() {
        return systemRoleInfoDao;
    }
}
