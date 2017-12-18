package com.honpe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honpe.mapper.UserRoleMapper;
import com.honpe.po.UserRoleKey;
import com.honpe.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void insertUserRole(UserRoleKey userRoleKey) {
		userRoleMapper.insert(userRoleKey);
	}

}
