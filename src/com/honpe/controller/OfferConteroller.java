package com.honpe.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.honpe.ext.OfferDetailExt;
import com.honpe.interceptor.SameUrlData;
import com.honpe.po.Offer;
import com.honpe.po.Supplier;
import com.honpe.po.TUser;
import com.honpe.pojo.Attachment;
import com.honpe.pojo.OfferDetail;
import com.honpe.pojo.OfferVO;
import com.honpe.pojo.PageBean;
import com.honpe.service.DemandService;
import com.honpe.service.OfferService;
import com.honpe.service.SupplierService;
import com.honpe.service.TUserService;

/**
 * 
 * <p>Title: OfferConteroller</p>
 * <p>Description:订单Controller </p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
@Controller
public class OfferConteroller {
	@Autowired
	private OfferService offerService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private Gson gson;
	@Autowired
	private TUserService tUserService;
	@Autowired
	private DemandService demandService;
	@Value("${OFFER_PAGE_SIZE}")
	private String OFFER_PAGE_SIZE;
	@Value("${PAGE_SIZE}")
	private String PAGE_SIZE;

	/**
	 * 
	 * <p>Title: offer</p>
	 * <p>Description:保存报价 </p>
	 * @param pids
	 * @param taxrates
	 * @param prices
	 * @param dates
	 * @param demandId
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@SameUrlData
	@RequestMapping("offer/save")
	public @ResponseBody String offer(String pids, String taxrates, String prices, String dates,
			String demandId, HttpSession session) throws ParseException {
		String[] pidArr = pids.substring(0).split(",");
		String[] taxrateArr = taxrates.split(",");
		String[] priceArr = prices.split(",");
		String[] dateArr = dates.split(",");
		TUser tUser = (TUser) session.getAttribute("user");
		List<Offer> list = new ArrayList<Offer>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < pidArr.length; i++) {
			Offer offer = new Offer();
			offer.setId(tUser.getId());
			// 0表示删除1表示未删除
			offer.setIsdel((byte) 1);
			offer.setOid(UUID.randomUUID().toString().replace("-", ""));
			offer.setPid(pidArr[i]);
			offer.setPrice(Double.parseDouble(priceArr[i]));
			offer.setTaxrate(Double.parseDouble(taxrateArr[i]));
			offer.setUpdatetime(new Date());
			offer.setCreatetime(new Date());
			offer.setOffertime(simpleDateFormat.parse(dateArr[i]));
			offer.setDid(demandId);
			list.add(offer);
		}
		// 1表示成功
		String result = "1";
		try {
			offerService.saveOffers(list);
		} catch (Exception e) {
			e.printStackTrace();
			// 0表示失败
			result = "0";
		}
		return result;
	}

	/**
	 * 
	 * <p>Title: saveOffer</p>
	 * <p>Description: 提交报价</p>
	 * @param pids
	 * @param taxrates
	 * @param prices
	 * @param dates
	 * @param nums
	 * @param demandId
	 * @param session
	 * @return
	 */
	@SameUrlData
	@RequestMapping("offer/offer")
	public @ResponseBody String saveOffer(String pids, String taxrates, String prices, String dates,
			String nums, String demandId, HttpSession session) {
		String[] pidArr = pids.split(",");
		String[] taxrateArr = taxrates.split(",");
		String[] priceArr = prices.split(",");
		String[] dateArr = dates.split(",");
		String[] numArr = nums.split(",");
		TUser tUser = (TUser) session.getAttribute("user");
		Supplier supplier = supplierService.selectSupplierById(tUser.getSid());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		List<OfferDetail> offerDetails = new ArrayList<OfferDetail>();
		double totalPrice = 0;
		for (int i = 0; i < pidArr.length; i++) {
			OfferDetail offerDetail = new OfferDetail();
			offerDetail.set零件编码(pidArr[i]);
			offerDetail.set数量(numArr[i]);
			offerDetail.set报价单价(priceArr[i]);
			offerDetail.set交货日期(dateArr[i]);
			offerDetail.set备注("");
			offerDetail.set税率(taxrateArr[i]);
			offerDetails.add(offerDetail);
			totalPrice += Double.parseDouble(priceArr[i]) * (Float.parseFloat(taxrateArr[i]) + 1)
					* Integer.parseInt(numArr[i]);
		}
		totalPrice = Math.round(totalPrice);
		OfferVO offerVO = new OfferVO();
		offerVO.set申请单号(demandId);
		offerVO.set报价单号("");
		Date date = new Date();
		offerVO.set报价日期(simpleDateFormat.format(date));
		offerVO.set报价人(tUser.getId());
		offerVO.set供应商代码(supplier.getSid());
		offerVO.set供应商名称(supplier.getCompany());
		offerVO.set报价金额(totalPrice + "");
		offerVO.set交货日期("");
		offerVO.set报价明细(offerDetails);
		String json = gson.toJson(offerVO);
		// 1表示成功
		String result = "1";
		String ok = offerService.insertOffer(json);
		if (!"OK".equals(ok)) {
			// 0表示失败
			result = "0";
		}
		return result;
	}

	/**
	 * 
	 * <p>Title: salesmanCurrentOffer</p>
	 * <p>Description:业务员查看当前报价 </p>
	 * @param page
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("offer/currentOffer/{page}")
	public String salesmanCurrentOffer(@PathVariable Integer page, HttpSession session,
			Model model) {
		TUser tUser = (TUser) session.getAttribute("user");
		String condition = " AND 中标状态=0";
		PageBean pageBean = offerService.selectOfferByUserId(tUser.getId(), condition,
				Integer.parseInt(OFFER_PAGE_SIZE), page);
		model.addAttribute("pageBean", pageBean);
		return "salesman/current_offer";
	}

	/**
	 * 
	 * <p>Title: salesmanHistoryOffer</p>
	 * <p>Description:业务员查看历史报价 </p>
	 * @param page
	 * @param startdate
	 * @param enddate
	 * @param demandId
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("offer/historyOffer")
	public String salesmanHistoryOffer(@RequestParam(defaultValue = "1") Integer page,
			String startdate, String enddate, String demandId, HttpSession session, Model model) {
		TUser tUser = (TUser) session.getAttribute("user");
		StringBuffer buffer = new StringBuffer(" AND 中标状态!=0");
		if (StringUtils.isNotBlank(startdate)) {
			buffer.append(" AND 报价日期>='" + startdate + "'");
		}
		if (StringUtils.isNotBlank(enddate)) {
			buffer.append(" AND 报价日期<='" + enddate + "'");
		}
		if (StringUtils.isNotBlank(demandId)) {
			buffer.append(" AND 申请单号 like '%" + demandId + "%'");
		}
		String condition = buffer.toString();
		PageBean pageBean = offerService.selectOfferByUserId(tUser.getId(), condition,
				Integer.parseInt(OFFER_PAGE_SIZE), page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("startdate", startdate);
		model.addAttribute("enddate", enddate);
		model.addAttribute("demandId", demandId);
		return "salesman/history_offer";
	}

	/**
	 * 
	 * <p>Title: supplierMyOffer</p>
	 * <p>Description:供应商我的报价页面 </p>
	 * @param page
	 * @param demandId
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("offer/sup_myoffer")
	public String supplierMyOffer(@RequestParam(defaultValue = "1") Integer page, String demandId,
			HttpSession session, Model model) {
		TUser tUser = (TUser) session.getAttribute("user");
		PageBean pageBean = offerService.selectOfferBySid(tUser.getSid(), demandId,
				Integer.parseInt(PAGE_SIZE), page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("demandId", demandId);
		return "supplier/supplier_myoffer";
	}

	/**
	 * 
	 * <p>Title: supplierOfferDetail</p>
	 * <p>Description:供应商查询报价单明细 </p>
	 * @param offerId
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("offer/detail/{offerId}/{userId}")
	public String supplierOfferDetail(@PathVariable String offerId, @PathVariable String userId,
			Model model) {
		List<OfferDetailExt> offerDetailExts = offerService.selectOfferDetailByOid(offerId);
		TUser tUser = tUserService.selectUserById(userId);
		List<Attachment> attachments = demandService
				.selectAttachmentsByDemandId(offerDetailExts.get(0).get申请单号());
		model.addAttribute("offerDetailExts", offerDetailExts);
		model.addAttribute("offerName", tUser.getName());
		model.addAttribute("attachments", attachments);
		return "supplier/supplier_detail";
	}
}
