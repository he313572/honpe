package com.honpe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honpe.mapper.AuthFunctionMapper;
import com.honpe.po.AuthFunction;
import com.honpe.service.AuthFunctionService;

@Service
public class AuthFunctionServiceImpl implements AuthFunctionService {
	@Autowired
	private AuthFunctionMapper authFunctionMapper;

	@Override
	public List<AuthFunction> findUserMenu(String userId, String generatemenu) {
		List<AuthFunction> authFunctions = authFunctionMapper.selectAuthFunctionByUserId(userId, generatemenu);
		return authFunctions;
	}

}
