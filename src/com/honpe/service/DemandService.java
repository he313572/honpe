package com.honpe.service;

import java.util.List;

import com.honpe.pojo.Attachment;
import com.honpe.pojo.Demand;
import com.honpe.pojo.PageBean;

public interface DemandService {
	PageBean<Demand> findPageList(Integer page, String condition, String sid);

	Demand selectDemandById(String demandId, String sid);

	List<Attachment> selectAttachmentsByDemandId(String demandId);
}
