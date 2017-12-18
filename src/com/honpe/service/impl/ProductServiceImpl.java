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
import com.honpe.ext.ProductExt;
import com.honpe.mapper.OfferMapper;
import com.honpe.po.Offer;
import com.honpe.po.OfferExample;
import com.honpe.po.OfferExample.Criteria;
import com.honpe.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
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
	public List<ProductExt> selectProductsByDemandId(String demandId, String id) {
		String json = puPriceQuerySoap.getOEMProductsDetail(ERP_SERVICE_USERID, ERP_SERVICE_PWD, demandId, "AND 1=1");
		Type listType = new TypeToken<ArrayList<ProductExt>>() {
		}.getType();
		ArrayList<ProductExt> productExts = gson.fromJson(json, listType);
		for (ProductExt productExt : productExts) {
			OfferExample example = new OfferExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			criteria.andPidEqualTo(productExt.get零件编码());
			List<Offer> offers = offerMapper.selectByExample(example);
			if (offers != null && offers.size() > 0) {
				productExt.setOffer(offers.get(0));
			}
		}
		return productExts;
	}
}
