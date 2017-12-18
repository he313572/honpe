package com.honpe.service;

import com.honpe.po.Supplier;

public interface SupplierService {
	void createSupplier(Supplier supplier);

	Supplier selectSupplierById(String sid);

	void updateSupplier(Supplier supplier);
}
