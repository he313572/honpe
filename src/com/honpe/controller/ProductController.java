package com.honpe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.honpe.ext.HistoryOfferExt;
import com.honpe.ext.ProductExt;
import com.honpe.po.TUser;
import com.honpe.pojo.Attachment;
import com.honpe.pojo.Demand;
import com.honpe.service.DemandService;
import com.honpe.service.OfferService;
import com.honpe.service.ProductService;

/**
 * 
 * <p>Title: ProductController</p>
 * <p>Description: 显示报价单商品明细Controller</p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private DemandService demandService;
	@Autowired
	private OfferService offerService;

	/**
	 * 
	 * <p>Title: list</p>
	 * <p>Description:显示商品明细 </p>
	 * @param demandId
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("product/list")
	public String list(String demandId, HttpSession session, Model model) {
		TUser tUser = (TUser) session.getAttribute("user");
		Demand demand = demandService.selectDemandById(demandId, tUser.getSid());
		List<ProductExt> productExts = productService.selectProductsByDemandId(demandId,
				tUser.getId());
		List<Attachment> attachments = demandService.selectAttachmentsByDemandId(demandId);
		List<HistoryOfferExt> historyOffers = offerService.selectHistoryOffer(demandId,
				tUser.getSid());
		model.addAttribute("demand", demand);
		model.addAttribute("productExts", productExts);
		model.addAttribute("attachments", attachments);
		model.addAttribute("historyOffers", historyOffers);
		return "products";
	}

}
