package com.gdou.msr.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

/**
 * @author maishuren
 * @date 2019/6/18 15:33
 */
public class SecondRealm implements Realm {
    @Override
    public String getName () {
        return null;
    }

    @Override
    public boolean supports (AuthenticationToken authenticationToken) {
        return false;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo (AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
