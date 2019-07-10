package com.gdou.msr.shirodemo3.Utils;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author maishuren
 * @date 2019/6/19 20:40
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch (AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password  = new String(usernamePasswordToken.getPassword());
        String dbPassword = (String) info.getCredentials();
        return this.equals(password,dbPassword);
    }
}
