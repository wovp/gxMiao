package com.gx.gxmiao.base;

/**
 * ClassName: StpInterfaceImpl
 * Package: com.gx.gxmiao.base
 * Description:
 * Author: gx
 * Creat: 2024/2/15 16:14
 */

import cn.dev33.satoken.stp.StpInterface;
import com.gx.gxmiao.dao.gxRoleMapper;
import com.gx.gxmiao.model.gxRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限加载接口实现类
 * @author 11
 */
@Component    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private gxRoleMapper gxRolesMapper;
    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 本 list 仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        List<gxRole> gxRoles = gxRolesMapper.selectList(null);
        for (gxRole role : gxRoles) {
            list.add(role.getRoleName());
        }
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 本 list 仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<String>();
        list.add("admin");
        list.add("super-admin");
        return list;
    }

}
