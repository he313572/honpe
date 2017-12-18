package com.honpe.service;

import com.honpe.po.TUser;
import com.honpe.pojo.PageBean;

public interface TUserService {
	int updatePossword(TUser tUser);

	void createUser(TUser tUser) throws Exception;

	TUser selectUserByEmail(String email);

	void updatePosswordByEmail(String password, String email);

	TUser selectTUserByInfo(String username, String email, String phone);

	void insertUser(TUser tUser);

	PageBean<TUser> selectUsers(String sid, Integer currentPage, String name, String id);

	TUser selectUserById(String id);

	void updateUser(TUser tUser);

	void deleteUserById(String id);

	TUser selectUserByUsername(String username);
}
