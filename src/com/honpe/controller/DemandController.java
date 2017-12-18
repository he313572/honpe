package com.honpe.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.honpe.po.QqNum;
import com.honpe.po.TUser;
import com.honpe.pojo.Demand;
import com.honpe.pojo.PageBean;
import com.honpe.service.DemandService;
import com.honpe.service.QqService;
import com.honpe.service.SupplierService;

/**
 * 
 * <p>Title: DemandController</p>
 * <p>Description:采购单列表Controller</p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class DemandController {
	@Autowired
	private DemandService demandService;
	@Autowired
	private QqService qqService;
	@SuppressWarnings("unused")
	@Autowired
	private SupplierService supplierService;

	/**
	 * 
	 * <p>Title: list</p>
	 * <p>Description:查询索引需求列表 条件查询需求列表 </p>
	 * @param page
	 * @param model
	 * @param keyword
	 * @param fieldclass
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/demand/list")
	public String list(Integer page, Model model, String keyword, String fieldclass,
			HttpSession session) throws IOException {
		if (page == null) {
			page = 1;
		}
		TUser tUser = (TUser) session.getAttribute("user");
		StringBuffer buffer = new StringBuffer("AND 1=1");
		if (StringUtils.isNotBlank(fieldclass)) {
			model.addAttribute("fieldclass", fieldclass);
		}
		if (StringUtils.isNotBlank(keyword)) {
			buffer.append(" AND " + fieldclass + " like '%" + keyword + "%'");
			model.addAttribute("keyword", keyword);
		}
		String condition = buffer.toString();
		PageBean<Demand> pageBean = demandService.findPageList(page, condition, tUser.getSid());
		model.addAttribute("pageBean", pageBean);
		List<QqNum> qqList = qqService.findAllQq();
		model.addAttribute("qqlist", qqList);
		return "demands";
	}
}
