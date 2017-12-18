package com.honpe.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honpe.erp.PuPriceQuerySoap;
import com.honpe.po.Supplier;
import com.honpe.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private PuPriceQuerySoap puPriceQuerySoap;
	@Autowired
	private Gson gson;
	@Value("${ERP_SERVICE_USERID}")
	private String ERP_SERVICE_USERID;
	@Value("${ERP_SERVICE_PWD}")
	private String ERP_SERVICE_PWD;

	@Override
	public void createSupplier(Supplier supplier) {
		supplier.setSid(supplier.getCompany());
		String supplierInfo = gson.toJson(supplier);
		puPriceQuerySoap.addPuSuppliersItem(ERP_SERVICE_USERID, ERP_SERVICE_PWD, supplierInfo);
	}

	@Override
	public Supplier selectSupplierById(String sid) {
		String json = puPriceQuerySoap.getPuSuppliersItem(ERP_SERVICE_USERID, ERP_SERVICE_PWD, sid);
		if (json.contains("NOOK")) {
			return null;
		}
		Type listType = new TypeToken<ArrayList<Supplier>>() {
		}.getType();
		ArrayList<Supplier> suppliers = gson.fromJson(json, listType);
		if (suppliers != null && suppliers.size() > 0) {
			return suppliers.get(0);
		}
		return null;
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		String queryInfo = gson.toJson(supplier);
		puPriceQuerySoap.editPuSuppliersItem(ERP_SERVICE_USERID, ERP_SERVICE_PWD, queryInfo);
	}
}
