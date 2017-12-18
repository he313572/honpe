package com.honpe.service;

import java.util.List;

import com.honpe.po.QqNum;

public interface QqService {
	List<QqNum> findAllQq();
	void updateQq(QqNum qqNum);
}
