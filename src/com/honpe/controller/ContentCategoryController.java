package com.honpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.honpe.po.ContentCategory;
import com.honpe.service.ContentCategoryService;

/**
 * 
 * <p>Title: ContentCategoryController</p>
 * <p>Description:内容类别 </p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
@Controller
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;

	/**
	 * <p>Title:list</p>
	 * <p>Description:查询所有内容类别</p>
	 * @return
	 */
	@RequestMapping("/category/list")
	public @ResponseBody String list() {
		List<ContentCategory> categories = contentCategoryService.selectCategorys();
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				return f.getName().contains("createdate") | f.getName().contains("updatedate");
			}
			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				return false;
			}
		}).create();
		String json = gson.toJson(categories);
		return json;
	}
}
