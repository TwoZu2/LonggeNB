package com.sjiag.Shiro;

import com.sjiag.Beans.User;
import com.sjiag.Dao.PermissionDao;
import com.sjiag.Dao.RoleDao;
import com.sjiag.Dao.UserDao;
import lombok.SneakyThrows;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 创建一个类继承AuthorizingRealm类(实现了Realm接口的类)
 * 重写AuthorizationInfo AuthenticationInfo方法
 * 重写getName方法 返回一个当前realm的自定义名称
 */
public class MyRealm extends AuthorizingRealm {
    @Resource
    UserDao userDao;
    @Resource
    RoleDao roleDao;
    @Resource
    PermissionDao permissionDao;
    public String getName(){
        return "myRealm";
    }

    /**
     * 获取授权数据(将当前用户的角色及权限信息查询出来)
     *
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户的用户名
        String username = (String) principalCollection.iterator().next();
        //根据用户名查询角色列表
        Set<String> roleNames = roleDao.queryRoleNamesByUsername(username);
        //根据用户名查询权限列表
        Set<String> ps = permissionDao.queryPermissionByUsername(username);
        System.out.println("查询角色信息");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleNames);
        info.addStringPermissions(ps);

        return info;
    }

    /**
     * 获取认证数据(从数据库查询用户的正确数据)
     *
     */
    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //根据用户名 从数据库查询安全数据
        User user = userDao.queryUserByUsername(username);
        if(user == null){
            return null;
        }
        if(user.getPwdSalt()==null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                    username,
                    user.getUserPwd(),
                    getName());
            return info;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                username,
                user.getUserPwd(),
                ByteSource.Util.bytes(user.getPwdSalt()),
                getName());
        return info;
    }
}
