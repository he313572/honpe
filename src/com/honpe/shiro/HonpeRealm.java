package com.honpe.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.honpe.mapper.AuthFunctionMapper;
import com.honpe.mapper.TUserMapper;
import com.honpe.po.AuthFunction;
import com.honpe.po.TUser;
import com.honpe.po.TUserExample;
import com.honpe.po.TUserExample.Criteria;

public class HonpeRealm extends AuthorizingRealm {
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private AuthFunctionMapper authFunctionMapper;

	/**
	 * 用户授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		TUser user = (TUser) principals.getPrimaryPrincipal();
		if (user != null) {
			List<AuthFunction> fList = authFunctionMapper.selectAuthFunctionByUserId(user.getId(), null);
			for (AuthFunction authFunction : fList) {
				info.addStringPermission(authFunction.getCode());
			}
		}
		return info;
	}

	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andIsactiveEqualTo((byte) 1);
		List<TUser> list = tUserMapper.selectByExample(example);
		TUser tUser = list.get(0);
		if (tUser != null) {
			String password = tUser.getPassword();
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(tUser, password, this.getClass().getSimpleName());
			return info;
		} else {
			return null;
		}
	}
}
