package com.xiaogch.maven.system.service.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.impl.BaseServiceImpl;
import com.xiaogch.maven.system.dao.PrivilegeInfoDao;
import com.xiaogch.maven.system.entity.PrivilegeInfoBean;
import com.xiaogch.maven.system.service.PrivilegeInfoService;
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
public class PrivilegeInfoServiceImpl extends BaseServiceImpl<PrivilegeInfoBean> implements PrivilegeInfoService {

    @Autowired
    private PrivilegeInfoDao privilegeInfoDao;

    @Override
    public BaseDao<PrivilegeInfoBean> getBaseDao() {
        return privilegeInfoDao;
    }
}
