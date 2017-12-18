package com.honpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.honpe.po.QqNum;
import com.honpe.service.QqService;

/**
 * 
 * <p>Title: QqNumComtroller</p>
 * <p>Description: QQ号码管理Controller</p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class QqNumController {
	@Autowired
	private QqService qqService;

	/**
	 * 
	 * <p>Title: list</p>
	 * <p>Description:显示QQ号码列表</p>
	 * @param model
	 * @return
	 */
	@RequestMapping("/qq/list")
	public String list(Model model) {
		List<QqNum> list = qqService.findAllQq();
		model.addAttribute("qqlist", list);
		return "admin/qq";
	}

	/**
	 * 
	 * <p>Title: reviseQq</p>
	 * <p>Description:修改采购QQ号码 </p>
	 * @param qqNum
	 */
	@RequestMapping("/qq/reviseQq")
	public void reviseQq(QqNum qqNum) {
		qqService.updateQq(qqNum);
	}
}
