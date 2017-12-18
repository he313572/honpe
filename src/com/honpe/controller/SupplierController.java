package com.honpe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.honpe.po.Supplier;
import com.honpe.po.TUser;
import com.honpe.service.SupplierService;

/**
 * 
 * <p>Title: SupplierController</p>
 * <p>Description:供应商信息管理Controller </p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	/**
	 * 
	 * <p>Title: goModifySupplierData</p>
	 * <p>Description:展示供应商修改信息页面 </p>
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/supplier/gomodify")
	public String goModifySupplierData(HttpSession session, Model model) {
		TUser tUser = (TUser) session.getAttribute("user");
		String sid = tUser.getSid();
		Supplier supplier = supplierService.selectSupplierById(sid);
		model.addAttribute("supplier", supplier);
		return "supplier/update_datum";
	}
	/**
	 * 
	 * <p>Title: modifySupplierData</p>
	 * <p>Description:供应商修改公司信息 </p>
	 * @param supplier
	 * @return
	 */
	@RequestMapping("/supplier/modify")
	public String modifySupplierData(Supplier supplier) {
		supplierService.updateSupplier(supplier);
		return "redirect:/demand/list";
	}
}
