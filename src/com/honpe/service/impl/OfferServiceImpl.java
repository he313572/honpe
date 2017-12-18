package com.honpe.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honpe.erp.PuPriceQuerySoap;
import com.honpe.ext.HistoryOfferExt;
import com.honpe.ext.OfferDetailExt;
import com.honpe.ext.OfferExt;
import com.honpe.mapper.OfferMapper;
import com.honpe.po.Offer;
import com.honpe.po.OfferExample;
import com.honpe.po.OfferExample.Criteria;
import com.honpe.pojo.PageBean;
import com.honpe.service.OfferService;

@Service
public class OfferServiceImpl implements OfferService {
	@Autowired
	private OfferMapper offerMapper;
	@Autowired
	private PuPriceQuerySoap puPriceQuerySoap;
	@Autowired
	private Gson gson;
	@Value("${ERP_SERVICE_USERID}")
	private String ERP_SERVICE_USERID;
	@Value("${ERP_SERVICE_PWD}")
	private String ERP_SERVICE_PWD;

	@Override
	public void saveOffers(List<Offer> list) {
		if (list != null && list.size() > 0) {
			for (Offer offer : list) {
				OfferExample example = new OfferExample();
				Criteria criteria = example.createCriteria();
				criteria.andPidEqualTo(offer.getPid());
				List<Offer> list1 = offerMapper.selectByExample(example);
				if (list1 != null && list1.size() > 0) {
					offerMapper.deleteByPrimaryKey(list1.get(0).getOid());
				}
				offerMapper.insertSelective(offer);
			}
		}
	}

	@Override
	public String insertOffer(String json) {
		return puPriceQuerySoap.addPuPriceItems(ERP_SERVICE_USERID, ERP_SERVICE_PWD, json);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PageBean selectOfferByUserId(String uId, String condition, int pageSize, int page) {
		StringBuffer buffer = new StringBuffer("AND 报价人='" + uId + "'");
		if (StringUtils.isNotBlank(condition)) {
			buffer.append(condition);
		}
		String querycondition = buffer.toString();
		PageBean<OfferExt> pageBean = executeSelect(querycondition, pageSize, page);
		return pageBean;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PageBean selectOfferBySid(String sid, String demandId, int pageSize, int page) {
		StringBuffer buffer = new StringBuffer("AND 供应商代码 ='" + sid + "'");
		if (StringUtils.isNotBlank(demandId)) {
			buffer.append(" AND 申请单号 like'%" + demandId + "%'");
		}
		String querycondition = buffer.toString();
		PageBean<OfferExt> pageBean = executeSelect(querycondition, pageSize, page);
		return pageBean;
	}

	private PageBean<OfferExt> executeSelect(String querycondition, int pageSize, int currentPage) {
		String json = puPriceQuerySoap.getPuPriceItem(ERP_SERVICE_USERID, ERP_SERVICE_PWD,
				querycondition, pageSize, currentPage);
		Type listType = new TypeToken<ArrayList<OfferExt>>() {
		}.getType();
		ArrayList<OfferExt> OfferExts = gson.fromJson(json, listType);
		String Record = puPriceQuerySoap.getPuPriceItemTotal(ERP_SERVICE_USERID, ERP_SERVICE_PWD,
				querycondition);
		int totalRecord = Integer.parseInt(Record);
		PageBean<OfferExt> pageBean = new PageBean<OfferExt>(currentPage, totalRecord, pageSize);
		pageBean.setData(OfferExts);
		return pageBean;
	}

	@Override
	public List<OfferDetailExt> selectOfferDetailByOid(String oId) {
		String json = puPriceQuerySoap.getPuPriceItemDetails(ERP_SERVICE_USERID, ERP_SERVICE_PWD,
				oId);
		Type listType = new TypeToken<ArrayList<OfferDetailExt>>() {
		}.getType();
		ArrayList<OfferDetailExt> OfferDetailExts = gson.fromJson(json, listType);
		return OfferDetailExts;
	}

	@Override
	public List<HistoryOfferExt> selectHistoryOffer(String demandId, String sid) {
		String json = puPriceQuerySoap.getPuPriceItemRecord(ERP_SERVICE_USERID, ERP_SERVICE_PWD,
				demandId, sid);
		Type listType = new TypeToken<ArrayList<HistoryOfferExt>>() {
		}.getType();
		ArrayList<HistoryOfferExt> historyOfferExts = gson.fromJson(json, listType);
		return historyOfferExts;
	}

}
