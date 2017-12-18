package com.honpe.service;

import java.util.List;
import com.honpe.ext.ContentExt;
import com.honpe.po.Content;

public interface ContentService {
	List<ContentExt> FindAllContents();

	void insertContent(Content content);

	void updateContent(Content content);

	void deleteContent(Integer cid);

	Content selectContentById(Integer cid);

	List<Content> selectContentByCaid(Integer caid);
}
