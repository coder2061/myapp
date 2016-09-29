package com.web.myapp.demo.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.myapp.module.entity.Member;
import com.web.myapp.module.service.MemberService;

/**   
 * 自定义Shiro
 * @author jiangyf   
 * @since 2016年9月22日 下午12:49:55 
 * @version V1.0   
 */
public class ShiroRealm extends AuthorizingRealm {
	private static final Logger log = LoggerFactory.getLogger(ShiroRealm.class);
	
	@Resource
	private MemberService memberService;

	/**  
	* 为当前登录的用户授予角色和权限
	* @param principal
	*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取当前登录用户名
		String currentUserName = principals.getPrimaryPrincipal().toString();
//		String currentUserName = (String) principals.fromRealm(this.getName()).iterator().next();
//		String currentUserName = (String) super.getAvailablePrincipal(principals);
		// 获取当前用户的角色和权限
		String role = this.memberService.getRolesByName(currentUserName) ;
		String permission = this.memberService.getPermissionsByName(currentUserName) ;
		// 为当前用户授予角色和权限
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole(role);
		info.addStringPermission(permission);
		/*
		info.addRoles(roles);
		info.addStringPermissions(permissions);
		info.addObjectPermission(permission);
		info.addObjectPermissions(permissions);
        info.setRoles(roles);
		info.setStringPermissions(permissions);
		info.setObjectPermissions(objectPermissions);
		*/
		log.info("为当前登录的用户授予角色和权限成功");
		return info;
	}

	/**  
	* 验证当前登录的用户
	* @param token
	* @throws AuthenticationException
	*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		// 获取当前登录用户名
		String currentUserName = token.getPrincipal().toString();
//		UsernamePasswordToken upTtoken = (UsernamePasswordToken) token;
//		String currentUserName = upTtoken.getUsername();
		Member member = this.memberService.getMember(currentUserName);
		AuthenticationInfo info = null;
		if (member == null) {
			log.info("当前登录的用户属于未知账户");
            throw new UnknownAccountException();
        } else if (member.getIslock()) {
        	log.info("当前登录的用户已锁定，请与管理员联系");
            throw new LockedAccountException();
        } else  {
			// 将当前登录用户信息保存，以后用于验证权限
			info = new SimpleAuthenticationInfo(member.getName(), member.getPasswd(), this.getName());
			log.info("当前登录的用户验证成功");
		}
		return info;
	}
	
	/**
     * 更新授权信息缓存
     * @param principal
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, this.getName());
        clearCachedAuthorizationInfo(principals);
    }
 
    /**
     * ShiroSession设置(使用时直接用HttpSession.getAttribute(key)就可以取到)
     * @param key
     * @param value
     */
    public void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null) {
            Session session = currentUser.getSession();
            if (session != null) {
                session.setAttribute(key, value);
            }
        }
    }

}
