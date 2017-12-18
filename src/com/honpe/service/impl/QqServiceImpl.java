package com.honpe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honpe.mapper.QqNumMapper;
import com.honpe.po.QqNum;
import com.honpe.po.QqNumExample;
import com.honpe.service.QqService;
@Service
public class QqServiceImpl implements QqService {
	@Autowired
	private QqNumMapper qqNumMapper;
	@Override
	public List<QqNum> findAllQq() {
		QqNumExample example = new QqNumExample();
		return qqNumMapper.selectByExample(example);
	}
	@Override
	public void updateQq(QqNum qqNum) {
		qqNumMapper.updateByPrimaryKey(qqNum);
	}
}
