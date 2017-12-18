package com.honpe.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.mapper.TUserMapper;
import com.honpe.po.TUser;
import com.honpe.po.TUserExample;
import com.honpe.po.TUserExample.Criteria;
import com.honpe.pojo.PageBean;
import com.honpe.service.TUserService;

@Service
public class TUserServiceImpl implements TUserService {
	@Autowired
	private TUserMapper tUserMapper;
	@Value("${PAGE_SIZE}")
	private String PAGE_SIZE;

	@Override
	public int updatePossword(TUser tUser) {
		// 0表示失败
		int i = 0;
		try {
			tUserMapper.updateByPrimaryKey(tUser);
			// 表示成功
			i = 1;
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	@Override
	public void createUser(TUser tUser) throws Exception {
		String id = UUID.randomUUID().toString().replace("-", "");
		tUser.setId(id);
		tUserMapper.insertSelective(tUser);
	}

	@Override
	public TUser selectUserByEmail(String email) {
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		List<TUser> list = tUserMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void updatePosswordByEmail(String password, String email) {
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		TUser tUser = new TUser();
		tUser.setPassword(password);
		tUserMapper.updateByExampleSelective(tUser, example);
	}

	@Override
	public void insertUser(TUser tUser) {
		String id = UUID.randomUUID().toString().replace("-", "");
		tUser.setId(id);
		tUserMapper.insert(tUser);
	}

	@Override
	public PageBean<TUser> selectUsers(String sid, Integer currentPage, String name, String id) {
		int pageSize = Integer.parseInt(PAGE_SIZE);
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andSidEqualTo(sid);
		// 0表示激活1表示未激活
		criteria.andIsactiveEqualTo((byte) 1);
		criteria.andIdNotEqualTo(id);
		if (StringUtils.isNotBlank(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		PageHelper.startPage(currentPage, pageSize);
		List<TUser> list = tUserMapper.selectByExample(example);
		PageInfo<TUser> pageInfo = new PageInfo<TUser>(list);
		int totalRecord = (int) pageInfo.getTotal();
		PageBean<TUser> pageBean = new PageBean<>(currentPage, totalRecord, pageSize);
		pageBean.setData(list);
		return pageBean;
	}

	@Override
	public TUser selectTUserByInfo(String username, String email, String phone) {
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(username)) {
			criteria.andUsernameEqualTo(username);
		} else if (StringUtils.isNotBlank(email)) {
			criteria.andEmailEqualTo(email);
		} else if (StringUtils.isNotBlank(phone)) {
			criteria.andPhoneEqualTo(phone);
		}
		List<TUser> tUsers = tUserMapper.selectByExample(example);
		if (tUsers != null && tUsers.size() > 0) {
			return tUsers.get(0);
		}
		return null;
	}

	@Override
	public TUser selectUserById(String id) {
		return tUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(TUser tUser) {
		tUserMapper.updateByPrimaryKeySelective(tUser);
	}

	@Override
	public void deleteUserById(String id) {
		TUser tUser = new TUser();
		// 0表示激活1表示未激活
		tUser.setIsactive((byte) 0);
		tUser.setId(id);
		tUserMapper.updateByPrimaryKeySelective(tUser);
	}

	@Override
	public TUser selectUserByUsername(String username) {
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TUser> list = tUserMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
