package com.honpe.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <p>Title: PageController</p>
 * <p>Description: 显示静态页面Controller</p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class PageController {
	/**
	 * 
	 * <p>Title: showLogin</p>
	 * <p>Description:首页 </p>
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String showLogin(HttpServletRequest request, Model model) {
		return "login";
	}

	/**
	 * 
	 * <p>Title: showPage</p>
	 * <p>Description:访问其他页面 </p>
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

	/**
	 * 
	 * <p>Title: supplierPage</p>
	 * <p>Description:供应商页面 </p>
	 * @param page
	 * @return
	 */
	@RequestMapping("/supplier/{page}")
	public String supplierPage(@PathVariable String page) {
		return "supplier/" + page;
	}

	/**
	 * 
	 * <p>Title: salesmanMyOffer</p>
	 * <p>Description:业务员我的报价页面 </p>
	 * @return
	 */
	@RequestMapping("offer/sal_myoffer")
	public String salesmanMyOffer() {
		return "salesman/salesman_myoffer";
	}
}
