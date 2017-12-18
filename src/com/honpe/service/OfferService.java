package com.honpe.service;

import java.util.List;

import com.honpe.ext.HistoryOfferExt;
import com.honpe.ext.OfferDetailExt;
import com.honpe.po.Offer;
import com.honpe.pojo.PageBean;

public interface OfferService {
	void saveOffers(List<Offer> list);

	String insertOffer(String json);

	@SuppressWarnings("rawtypes")
	PageBean selectOfferByUserId(String uId, String condition, int pageSize, int page);

	@SuppressWarnings("rawtypes")
	PageBean selectOfferBySid(String sid, String demandId, int pageSize, int page);

	List<OfferDetailExt> selectOfferDetailByOid(String oId);

	List<HistoryOfferExt> selectHistoryOffer(String demandId, String sid);
}
