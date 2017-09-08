package com.xiaogch.maven.springmvc.service.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.bean.PagedList;
import com.xiaogch.maven.common.db.impl.BaseServiceImpl;
import com.xiaogch.maven.springmvc.dao.UserRolePrivilegeRelDao;
import com.xiaogch.maven.springmvc.entity.RolePrivilegeVO;
import com.xiaogch.maven.springmvc.entity.UserRolePrivilegeRelVO;
import com.xiaogch.maven.springmvc.entity.UserRoleRelVO;
import com.xiaogch.maven.springmvc.service.UserRolePrivilegeRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 16:13 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Service("userRolePrivilegeRelService")
public class UserRolePrivilegeRelServiceImpl extends BaseServiceImpl<UserRolePrivilegeRelVO> implements UserRolePrivilegeRelService {

    @Autowired
    UserRolePrivilegeRelDao userRolePrivilegeRelDao;

    @Override
    public BaseDao<UserRolePrivilegeRelVO> getBaseDao() {
        return userRolePrivilegeRelDao;
    }

    @Override
    public List<UserRolePrivilegeRelVO> selectUserRolePrivilegeRel(Map<String, Object> parameter) {
        return userRolePrivilegeRelDao.selectUserRolePrivilegeRel(parameter);
    }

    @Override
    public List<UserRolePrivilegeRelVO> selectUserPrivilegeRel(Map<String, Object> parameter) {
        return userRolePrivilegeRelDao.selectUserPrivilegeRel(parameter);
    }

    @Override
    public List<RolePrivilegeVO> selectRolePrivilegeRel(Map<String, Object> parameter) {
        return userRolePrivilegeRelDao.selectRolePrivilegeRel(parameter);
    }

    @Override
    public List<UserRoleRelVO> selectUserRoleRel(Map<String, Object> parameter) {
        return userRolePrivilegeRelDao.selectUserRoleRel(parameter);
    }

    @Override
    public PagedList<UserRolePrivilegeRelVO> selectUserRolePrivilegeRel(Map<String, Object> parameter, int pageNo, int pageSize) {
        return userRolePrivilegeRelDao.selectUserRolePrivilegeRel(parameter , pageNo , pageSize);
    }

    @Override
    public PagedList<UserRolePrivilegeRelVO> selectUserPrivilegeRel(Map<String, Object> parameter, int pageNo, int pageSize) {
        return userRolePrivilegeRelDao.selectUserPrivilegeRel(parameter , pageNo , pageSize);
    }

    @Override
    public PagedList<RolePrivilegeVO> selectRolePrivilegeRel(Map<String, Object> parameter, int pageNo, int pageSize) {
        return userRolePrivilegeRelDao.selectRolePrivilegeRel(parameter , pageNo , pageSize);
    }

    @Override
    public PagedList<UserRoleRelVO> selectUserRoleRel(Map<String, Object> parameter, int pageNo, int pageSize) {
        return userRolePrivilegeRelDao.selectUserRoleRel(parameter , pageNo , pageSize);
    }

    @Override
    public int inserUserRoleRel(UserRoleRelVO userRoleRelVO) {
        return userRolePrivilegeRelDao.inserUserRoleRel(userRoleRelVO);
    }

    @Override
    public int batchInserUserRoleRel(List<UserRoleRelVO> userRoleRelVOs) {
        return userRolePrivilegeRelDao.batchInserUserRoleRel(userRoleRelVOs);
    }

    @Override
    public int inserRolePrivilegeRel(RolePrivilegeVO rolePrivilegeVO) {
        return userRolePrivilegeRelDao.inserRolePrivilegeRel(rolePrivilegeVO);
    }

    @Override
    public int batchInserRolePrivilegeRel(List<RolePrivilegeVO> rolePrivilegeVOs) {
        return userRolePrivilegeRelDao.batchInserRolePrivilegeRel(rolePrivilegeVOs);
    }

    @Override
    public int updateUserRoleRel(UserRoleRelVO userRoleRelVO) {
        return userRolePrivilegeRelDao.updateUserRoleRel(userRoleRelVO);
    }

    @Override
    public int updateRolePrivilegeRel(RolePrivilegeVO rolePrivilegeVO) {
        return userRolePrivilegeRelDao.updateRolePrivilegeRel(rolePrivilegeVO);
    }

    @Override
    public int batchUpdateUserRoleRel(List<UserRoleRelVO> userRoleRelVOs) {
        return userRolePrivilegeRelDao.batchUpdateUserRoleRel(userRoleRelVOs);
    }

    @Override
    public int batchUpdateRolePrivilegeRel(List<RolePrivilegeVO> rolePrivilegeVOs) {
        return userRolePrivilegeRelDao.batchUpdateRolePrivilegeRel(rolePrivilegeVOs);
    }
}
