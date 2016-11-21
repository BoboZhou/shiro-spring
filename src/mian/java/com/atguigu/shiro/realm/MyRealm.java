package com.atguigu.shiro.realm;

import java.util.HashSet;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

public class MyRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Object principal = principals.getPrimaryPrincipal();
		HashSet<String> roleSet = new HashSet<String>();
		if ("admin".equals(principal)) {
			roleSet.add("admin");
		} else if ("user".equals(principal)) {
			roleSet.add("user");
		}

		return new SimpleAuthorizationInfo(roleSet);
	}

	/**
	 * 认证的过程： 1、构造前台的页面，通过一个表单提交数据，表单中包含（用户名和密码） 2、编写后台的Controller方法，接受（用户名和密码）
	 * 3、参照Quickstart，核心登录方法是Subject中的login(token);
	 * 注意：该token的类型是UsernamePasswordToken 4、编写realm类中的doGetAuthenticationInfo方法：
	 * ① 方法中的类型是AuthenticationToken，需要强制转换token为UsernamePasswordToken类型 ②
	 * 通过token获取用户的实体信息，本例是获取用户名。 ③ 通过用户的信息，从数据库中查询密码。 密码的比对交给shiro来判断。 ⑤
	 * 需要构造AuthenticationInfo的子类SimpleAuthenticationInfo,并返回。
	 * 
	 * 
	 * 关于密码的比对： ① 通过SimpleCredentialsMatcher的doCredentialsMatch进行密码的比对。
	 */
	// 认证的回调方法S
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		AuthenticationToken UsernamePasswordToken = (UsernamePasswordToken) token;
		Object principal = UsernamePasswordToken.getPrincipal();
		String credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
		if ("admin".equals(principal)) {
			credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
		}
		return new SimpleAuthenticationInfo(principal, credentials, getName());

	}

}
