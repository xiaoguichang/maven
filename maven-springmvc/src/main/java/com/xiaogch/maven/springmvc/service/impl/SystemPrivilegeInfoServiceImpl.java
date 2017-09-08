package com.xiaogch.maven.springmvc.service.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.impl.BaseServiceImpl;
import com.xiaogch.maven.springmvc.dao.SystemPrivilegeInfoDao;
import com.xiaogch.maven.springmvc.entity.SystemPrivilegeInfoBean;
import com.xiaogch.maven.springmvc.service.SystemPrivilegeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 16:20 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Service("systemPrivilegeInfoService")
public class SystemPrivilegeInfoServiceImpl extends BaseServiceImpl<SystemPrivilegeInfoBean> implements SystemPrivilegeInfoService {

    @Autowired
    private SystemPrivilegeInfoDao systemPrivilegeInfoDao;

    @Override
    public BaseDao<SystemPrivilegeInfoBean> getBaseDao() {
        return systemPrivilegeInfoDao;
    }
}
