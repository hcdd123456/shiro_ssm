package com.ithc.realm;

import com.ithc.pojo.User;
import com.ithc.service.PermissionService;
import com.ithc.service.RoleService;
import com.ithc.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.context.ContextLoader;

import java.util.Set;

@Setter
public class MyRealm extends AuthorizingRealm {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();
//        RoleService roleService = ContextLoader.getCurrentWebApplicationContext().getBean("roleServiceImpl", RoleService.class);
//        PermissionService permissionService = ContextLoader.getCurrentWebApplicationContext().getBean("permissionServiceImpl", PermissionService.class);
        Set<String> roles = roleService.queryRoleByUserName(username);
        Set<String> perms = permissionService.queryAllPermissionByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.setStringPermissions(perms);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
//        UserService userService = ContextLoader.getCurrentWebApplicationContext().getBean("userServiceImpl", UserService.class);
        User user = userService.queryUserByUserName(username);
        if(user==null){
            return null;
        }else {
           return new SimpleAuthenticationInfo(user.getUsername()
                   ,user.getPassword()
                   ,ByteSource.Util.bytes(user.getSalt())
                   ,this.getName());
        }
    }
}
