package com.xiaogch.maven.springmvc.dao.impl;

import com.xiaogch.maven.common.db.impl.BaseDaoImpl;
import com.xiaogch.maven.springmvc.dao.UserRolePrivilegeRelDao;
import com.xiaogch.maven.common.db.bean.PagedList;
import com.xiaogch.maven.springmvc.entity.RolePrivilegeVO;
import com.xiaogch.maven.springmvc.entity.UserRolePrivilegeRelVO;
import com.xiaogch.maven.springmvc.entity.UserRoleRelVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userRolePrivilegeRelDao")
public class UserRolePrivilegeRelDaoImpl extends BaseDaoImpl<UserRolePrivilegeRelVO> implements UserRolePrivilegeRelDao {

    public UserRolePrivilegeRelDaoImpl() {
        super.setNamespace("com.xiaogch.maven.springmvc.entity.UserRolePrivilegeRelVO");
    }

    @Autowired
    @Required
    @Qualifier("sqlSessionTemplate")
    public void setSqlSessionTemplateAutowired(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public List<UserRolePrivilegeRelVO> selectUserRolePrivilegeRel(Map<String, Object> parameter) {
        return selectList("selectUserRolePrivilegeRelAll" , parameter);
    }

    @Override
    public PagedList<UserRolePrivilegeRelVO> selectUserRolePrivilegeRel(Map<String, Object> parameter, int pageNo, int pageSize) {
        return selectList("selectUserRolePrivilegeRelAll" , parameter , pageNo , pageSize);
    }
    @Override
    public List<UserRolePrivilegeRelVO> selectUserPrivilegeRel(Map<String, Object> parameter) {
        return selectList("selectUserPrivilegeRelAll" , parameter);
    }
    @Override
    public PagedList<UserRolePrivilegeRelVO> selectUserPrivilegeRel(Map<String, Object> parameter, int pageNo, int pageSize) {
        return selectList("selectUserPrivilegeRelAll" , parameter , pageNo , pageSize);
    }


    @Override
    public List<RolePrivilegeVO> selectRolePrivilegeRel(Map<String, Object> parameter) {
        return selectList("selectRolePrivilegeRelAll" , parameter);
    }

    @Override
    public List<UserRoleRelVO> selectUserRoleRel(Map<String, Object> parameter) {
        return selectList("selectUserRoleRelAll" , parameter);
    }

    @Override
    public PagedList<RolePrivilegeVO> selectRolePrivilegeRel(Map<String, Object> parameter, int pageNo, int pageSize) {
        return selectList("selectRolePrivilegeRelAll" , parameter , pageNo , pageSize);
    }

    @Override
    public PagedList<UserRoleRelVO> selectUserRoleRel(Map<String, Object> parameter, int pageNo, int pageSize) {
        return selectList("selectUserRoleRelAll" , parameter , pageNo , pageSize);
    }

    @Override
    public int inserUserRoleRel(UserRoleRelVO userRoleRelVO) {
        return insert("inserUserRoleRel" , userRoleRelVO);
    }

    @Override
    public int batchInserUserRoleRel(List<UserRoleRelVO> userRoleRelVOs) {
        return insert("batchnserUserRoleRel" , userRoleRelVOs);
    }

    @Override
    public int inserRolePrivilegeRel(RolePrivilegeVO rolePrivilegeVO) {
        return insert("inserRolePrivilegeRel" , rolePrivilegeVO);
    }

    @Override
    public int batchInserRolePrivilegeRel(List<RolePrivilegeVO> rolePrivilegeVOs) {
        return insert("batchInserRolePrivilegeRel" , rolePrivilegeVOs);
    }

    @Override
    public int updateUserRoleRel(UserRoleRelVO userRoleRelVO) {
        return update("updateUserRoleRel" , userRoleRelVO);
    }

    @Override
    public int updateRolePrivilegeRel(RolePrivilegeVO rolePrivilegeVO) {
        return update("updateRolePrivilegeRel" , rolePrivilegeVO);
    }

    @Override
    public int batchUpdateUserRoleRel(List<UserRoleRelVO> userRoleRelVOs) {
        return update("batchUpdateUserRoleRel" , userRoleRelVOs);
    }

    @Override
    public int batchUpdateRolePrivilegeRel(List<RolePrivilegeVO> rolePrivilegeVOs) {
        return update("batchUpdateRolePrivilegeRel" , rolePrivilegeVOs);
    }
}
