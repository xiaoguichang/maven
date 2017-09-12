package com.xiaogch.maven.system.service;

import com.xiaogch.maven.common.db.BaseService;
import com.xiaogch.maven.common.db.bean.PagedList;
import com.xiaogch.maven.system.entity.MenuVO;
import com.xiaogch.maven.system.entity.RolePrivilegeVO;
import com.xiaogch.maven.system.entity.UserRolePrivilegeRelVO;
import com.xiaogch.maven.system.entity.UserRoleRelVO;

import java.util.List;
import java.util.Map;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 16:10 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public interface UserRolePrivilegeRelService extends BaseService<UserRolePrivilegeRelVO> {

    List<UserRolePrivilegeRelVO> selectUserRolePrivilegeRel(Map<String , Object> parameter);
    List<UserRolePrivilegeRelVO> selectUserPrivilegeRel(Map<String , Object> parameter);
    List<RolePrivilegeVO> selectRolePrivilegeRel(Map<String , Object> parameter);
    List<UserRoleRelVO> selectUserRoleRel(Map<String , Object> parameter);

    PagedList<UserRolePrivilegeRelVO> selectUserRolePrivilegeRel(Map<String , Object> parameter , int pageNo , int pageSize);
    PagedList<UserRolePrivilegeRelVO> selectUserPrivilegeRel(Map<String , Object> parameter , int pageNo , int pageSize);
    PagedList<RolePrivilegeVO> selectRolePrivilegeRel(Map<String , Object> parameter , int pageNo , int pageSize);
    PagedList<UserRoleRelVO> selectUserRoleRel(Map<String , Object> parameter , int pageNo , int pageSize);

    int inserUserRoleRel(UserRoleRelVO userRoleRelVO);
    int batchInserUserRoleRel(List<UserRoleRelVO> userRoleRelVOs);
    int inserRolePrivilegeRel(RolePrivilegeVO rolePrivilegeVO);
    int batchInserRolePrivilegeRel(List<RolePrivilegeVO> rolePrivilegeVOs);

    int updateUserRoleRel(UserRoleRelVO userRoleRelVO);
    int updateRolePrivilegeRel(RolePrivilegeVO rolePrivilegeVO);
    int batchUpdateUserRoleRel(List<UserRoleRelVO> userRoleRelVOs);
    int batchUpdateRolePrivilegeRel(List<RolePrivilegeVO> rolePrivilegeVOs);

    List<MenuVO> selectMenuByUserId(Integer userId);
}
