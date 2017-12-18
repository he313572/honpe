package com.honpe.service;

import java.util.List;

import com.honpe.ext.ProductExt;
public interface ProductService {
	public List<ProductExt> selectProductsByDemandId(String demandId,String id);
	
}
