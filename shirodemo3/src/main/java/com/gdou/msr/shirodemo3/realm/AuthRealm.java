package com.gdou.msr.shirodemo3.realm;

import com.gdou.msr.shirodemo3.pojo.Permission;
import com.gdou.msr.shirodemo3.pojo.Role;
import com.gdou.msr.shirodemo3.pojo.UserInfo;
import com.gdou.msr.shirodemo3.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/19 20:20
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    /**
     * 授权是时使用
     * @param principals principal
     * @return 返回
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo (PrincipalCollection principals) {

        UserInfo userInfo = (UserInfo) principals.fromRealm(this.getClass().getName()).iterator().next();

        List<String> permissionList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();

        List<Role> roles = userInfo.getRoles();

        if (!CollectionUtils.isEmpty(roles)){
            for (Role role : roles){
                roleNameList.add(role.getRname());
                List<Permission> permissions = role.getPermissions();
                if (!CollectionUtils.isEmpty(permissions)){
                    for (Permission permission : permissions) {
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }

    /**
     * 认证登录
     * @param token token
     * @return 返回
     * @throws AuthenticationException 异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        UserInfo userInfo = userService.findByUserName(username);
        return new SimpleAuthenticationInfo(userInfo,userInfo.getPassword(),this.getClass().getName());
    }
}
