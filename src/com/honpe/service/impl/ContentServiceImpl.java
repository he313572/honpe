package com.honpe.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.honpe.ext.ContentExt;
import com.honpe.mapper.ContentMapper;
import com.honpe.po.Content;
import com.honpe.po.ContentExample;
import com.honpe.po.ContentExample.Criteria;
import com.honpe.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentMapper contentMapper;

	@Override
	public List<ContentExt> FindAllContents() {
		return contentMapper.selectContents();
	}

	@Override
	public void insertContent(Content content) {
		content.setCreatetime(new Date());
		content.setUpdatetime(new Date());
		contentMapper.insertSelective(content);
	}

	@Override
	public void updateContent(Content content) {
		content.setUpdatetime(new Date());
		contentMapper.updateByPrimaryKeySelective(content);
	}

	@Override
	public void deleteContent(Integer cid) {
		contentMapper.deleteByPrimaryKey(cid);
	}

	@Override
	public Content selectContentById(Integer cid) {
		return contentMapper.selectByPrimaryKey(cid);
	}

	@Override
	public List<Content> selectContentByCaid(Integer caid) {
		ContentExample example = new ContentExample();
		example.setOrderByClause("cid");
		Criteria criteria = example.createCriteria();
		criteria.andCaidEqualTo(caid);
		List<Content> contents = contentMapper.selectByExample(example);
		return contents;
	}

}
