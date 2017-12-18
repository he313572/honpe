package com.honpe.mapper;

import com.honpe.ext.ContentExt;
import com.honpe.po.Content;
import com.honpe.po.ContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
	int countByExample(ContentExample example);

	int deleteByExample(ContentExample example);

	int deleteByPrimaryKey(Integer cid);

	int insert(Content record);

	int insertSelective(Content record);

	List<Content> selectByExampleWithBLOBs(ContentExample example);

	List<Content> selectByExample(ContentExample example);

	Content selectByPrimaryKey(Integer cid);

	int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

	int updateByExampleWithBLOBs(@Param("record") Content record, @Param("example") ContentExample example);

	int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

	int updateByPrimaryKeySelective(Content record);

	int updateByPrimaryKeyWithBLOBs(Content record);

	int updateByPrimaryKey(Content record);

	/**
	 * 查询所有的内容
	 * 
	 * @param record
	 * @return
	 */
	List<ContentExt> selectContents();
}