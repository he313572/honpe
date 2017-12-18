package com.honpe.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honpe.erp.PuPriceQuerySoap;
import com.honpe.pojo.Attachment;
import com.honpe.pojo.Demand;
import com.honpe.pojo.PageBean;
import com.honpe.service.DemandService;

@Service
public class DemandServiceImpl implements DemandService {
	@Value("${PAGE_SIZE}")
	private String PAGE_SIZE;
	@Value("${ERP_SERVICE_USERID}")
	private String ERP_SERVICE_USERID;
	@Value("${ERP_SERVICE_PWD}")
	private String ERP_SERVICE_PWD;
	@Autowired
	private PuPriceQuerySoap puPriceQuerySoap;
	@Autowired
	private Gson gson;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean<Demand> findPageList(Integer page, String condition, String sid) {
		String json = puPriceQuerySoap.getOEMProducts(ERP_SERVICE_USERID, ERP_SERVICE_PWD, condition,
				Integer.parseInt(PAGE_SIZE), page, sid);
		Type listType = new TypeToken<ArrayList<Demand>>() {
		}.getType();
		ArrayList<Demand> demands = gson.fromJson(json, listType);
		String count = puPriceQuerySoap.getOEMProductsTotal(ERP_SERVICE_USERID, ERP_SERVICE_PWD, condition, sid);
		PageBean pageBean = new PageBean<Demand>(page, Integer.parseInt(count), Integer.parseInt(PAGE_SIZE));
		pageBean.setCurrentPage(page);
		pageBean.setData(demands);
		return pageBean;
	}

	@Override
	public Demand selectDemandById(String demandId, String sid) {
		String condition = "AND 申请单号='" + demandId + "'";
		String json = puPriceQuerySoap.getOEMProducts(ERP_SERVICE_USERID, ERP_SERVICE_PWD, condition, 1, 1, sid);
		Type listType = new TypeToken<ArrayList<Demand>>() {
		}.getType();
		ArrayList<Demand> demands = gson.fromJson(json, listType);
		Demand demand = null;
		if (demands != null && demands.size() > 0) {
			demand = demands.get(0);
		}
		return demand;
	}

	@Override
	public List<Attachment> selectAttachmentsByDemandId(String demandId) {
		String json = puPriceQuerySoap.getOEMAttachs(ERP_SERVICE_USERID, ERP_SERVICE_PWD, demandId);
		Type listType = new TypeToken<ArrayList<Attachment>>() {
		}.getType();
		ArrayList<Attachment> list = gson.fromJson(json, listType);
		return list;
	}
}
