package com.honpe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honpe.mapper.ContentCategoryMapper;
import com.honpe.po.ContentCategory;
import com.honpe.po.ContentCategoryExample;
import com.honpe.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private ContentCategoryMapper contentCategoryMapper;

	@Override
	public List<ContentCategory> selectCategorys() {
		ContentCategoryExample example = new ContentCategoryExample();
		return contentCategoryMapper.selectByExample(example);
	}

}
