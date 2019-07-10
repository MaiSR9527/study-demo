package com.gdou.msr.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * @author maishuren
 * @date 2019/6/18 15:31
 */
public class ShiroRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken token) throws AuthenticationException {
        // 强转为UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //从UsernamePasswordToken中取出用户信息
        String username = usernamePasswordToken.getUsername();
//        String password = usernamePasswordToken.getPassword();
        //和数据库中的用户信息做比较

        //若用户不存在，抛出UnknownAccountException异常

        //根据用户信息情况，决定是否抛出其他异常，如用户被锁定

        //根据用户情况，来构建AuthenticationInfo对象并返回

        return null;
    }
}
