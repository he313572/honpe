package com.honpe.service;

import java.util.List;

import com.honpe.po.AuthFunction;

public interface AuthFunctionService {
	List<AuthFunction> findUserMenu(String userId,String generatemenu);
}
