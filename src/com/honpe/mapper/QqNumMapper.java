package com.honpe.mapper;

import com.honpe.po.QqNum;
import com.honpe.po.QqNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QqNumMapper {
    int countByExample(QqNumExample example);

    int deleteByExample(QqNumExample example);

    int deleteByPrimaryKey(Integer qid);

    int insert(QqNum record);

    int insertSelective(QqNum record);

    List<QqNum> selectByExample(QqNumExample example);

    QqNum selectByPrimaryKey(Integer qid);

    int updateByExampleSelective(@Param("record") QqNum record, @Param("example") QqNumExample example);

    int updateByExample(@Param("record") QqNum record, @Param("example") QqNumExample example);

    int updateByPrimaryKeySelective(QqNum record);

    int updateByPrimaryKey(QqNum record);
}