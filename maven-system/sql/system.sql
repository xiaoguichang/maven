INSERT INTO t_sys_user_info (user_id, user_name, password, nickname, phone, email, open_id, status, create_time, remark) VALUES ('1', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '系统管理员', NULL, NULL, NULL, '1', '2017-09-21 18:43:20', NULL);
INSERT INTO t_sys_user_role_rel (user_id, role_id, status) VALUES ('1', '1', '1');
INSERT INTO t_sys_role_privilege_rel (role_id, privilege_id, status) VALUES ('1', '2', '1');
INSERT INTO t_sys_role_privilege_rel (role_id, privilege_id, status) VALUES ('1', '3', '1');
INSERT INTO t_sys_role_privilege_rel (role_id, privilege_id, status) VALUES ('1', '4', '1');
INSERT INTO t_sys_role_privilege_rel (role_id, privilege_id, status) VALUES ('1', '5', '1');
INSERT INTO t_sys_role_privilege_rel (role_id, privilege_id, status) VALUES ('1', '6', '1');
INSERT INTO t_sys_role_privilege_rel (role_id, privilege_id, status) VALUES ('1', '7', '1');
INSERT INTO t_sys_role_privilege_rel (role_id, privilege_id, status) VALUES ('1', '8', '1');
INSERT INTO t_sys_role_info (role_id, role_key, role_name, role_remark) VALUES ('1', 'admin', 'admin', '系统管理员');
INSERT INTO t_sys_privilege_info (privilege_id, privilege_name, privilege_type, parent_privilege_id, privilege_entity, status, create_time) VALUES ('1', '系统', '1', '-1', NULL, '1', '2017-09-22 17:07:57');
INSERT INTO t_sys_privilege_info (privilege_id, privilege_name, privilege_type, parent_privilege_id, privilege_entity, status, create_time) VALUES ('2', '系统管理', '1', '1', NULL, '1', '2017-09-22 17:08:28');
INSERT INTO t_sys_privilege_info (privilege_id, privilege_name, privilege_type, parent_privilege_id, privilege_entity, status, create_time) VALUES ('3', '用户管理', '1', '2', '/system/user/index', '1', '2017-09-22 17:08:43');
INSERT INTO t_sys_privilege_info (privilege_id, privilege_name, privilege_type, parent_privilege_id, privilege_entity, status, create_time) VALUES ('4', '角色管理', '1', '2', NULL, '1', '2017-09-22 17:09:12');
INSERT INTO t_sys_privilege_info (privilege_id, privilege_name, privilege_type, parent_privilege_id, privilege_entity, status, create_time) VALUES ('5', '权限管理', '1', '2', NULL, '1', '2017-09-22 17:09:28');
INSERT INTO t_sys_privilege_info (privilege_id, privilege_name, privilege_type, parent_privilege_id, privilege_entity, status, create_time) VALUES ('6', '获取用户列表', '2', '3', '/system/user/list', '1', '2017-09-22 17:10:48');
INSERT INTO t_sys_privilege_info (privilege_id, privilege_name, privilege_type, parent_privilege_id, privilege_entity, status, create_time) VALUES ('7', '新增用户', '2', '3', '/system/user/add', '1', '2017-09-22 17:10:48');
INSERT INTO t_sys_privilege_info (privilege_id, privilege_name, privilege_type, parent_privilege_id, privilege_entity, status, create_time) VALUES ('8', '更新用户信息', '2', '3', '/system/user/update', '1', '2017-09-22 17:11:38');