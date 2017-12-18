package com.honpe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.honpe.ext.ContentExt;
import com.honpe.po.Content;
import com.honpe.pojo.ContentVO;
import com.honpe.service.ContentService;

/**
 * 
 * <p>Title: ContentController</p>
 * <p>Description: 内容管理Controller</p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class ContentController {
	@Autowired
	private ContentService contentService;
	@Autowired
	private Gson gson;

	/** 
	 * 
	 * <p>Title: list</p>
	 * <p>Description:显示内容列表 </p>
	 * @param model
	 * @return
	 */
	@RequestMapping("/content/list")
	public String list(Model model) {
		List<ContentExt> contentList = contentService.FindAllContents();
		model.addAttribute("contentList", contentList);
		return "admin/content";
	}

	/**
	 * 
	 * <p>Title: addContent</p>
	 * <p>Description:添加内容 </p>
	 * @param content
	 */
	@RequestMapping("/content/add")
	public void addContent(Content content) {
		contentService.insertContent(content);
	}

	/**
	 * 
	 * <p>Title: editContent</p>
	 * <p>Description:修改内容 </p>
	 * @param content
	 */
	@RequestMapping("/content/edit")
	public void editContent(Content content) {
		contentService.updateContent(content);
	}

	/**
	 * 
	 * <p>Title: removeContent</p>
	 * <p>Description:删除内容 </p>
	 * @param cid
	 * @return
	 */
	@RequestMapping("/content/remove")
	public @ResponseBody String removeContent(Integer cid) {
		contentService.deleteContent(cid);
		return "";
	}

	/**
	 * 
	 * <p>Title: previewContent</p>
	 * <p>Description:显示内容 </p>
	 * @param cid
	 * @param model
	 * @return
	 */
	@RequestMapping("/content/preview/{cid}")
	public String previewContent(@PathVariable Integer cid, Model model) {
		Content content = contentService.selectContentById(cid);
		model.addAttribute("content", content);
		return "natice_content";
	}

	/**
	 * 
	 * <p>Title: showContentTitle</p>
	 * <p>Description: 登录页显示须知导航栏</p>
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/content/title")
	public @ResponseBody ContentVO showContentTitle() {
		List<Content> group1 = contentService.selectContentByCaid(1);
		List<Content> group2 = contentService.selectContentByCaid(2);
		List<Content> group3 = contentService.selectContentByCaid(3);
		String json1 = gson.toJson(group1);
		String json2 = gson.toJson(group2);
		String json3 = gson.toJson(group3);
		ContentVO contentVO = new ContentVO();
		contentVO.setGroup1(group1);
		contentVO.setGroup2(group2);
		contentVO.setGroup3(group3);
		return contentVO;
	}

	/**
	 * 
	 * <p>Title: natice</p>
	 * <p>Description:展示须知页面 </p>
	 * @param cid
	 * @param model
	 * @return
	 */
	@RequestMapping("/natice/{cid}")
	public String natice(@PathVariable Integer cid, Model model) {
		List<Content> group1 = contentService.selectContentByCaid(1);
		List<Content> group2 = contentService.selectContentByCaid(2);
		List<Content> group3 = contentService.selectContentByCaid(3);
		model.addAttribute("group1", group1);
		model.addAttribute("group2", group2);
		model.addAttribute("group3", group3);
		model.addAttribute("cid", cid);
		return "natice";
	}
}
