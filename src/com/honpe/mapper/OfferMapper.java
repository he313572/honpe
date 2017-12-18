package com.honpe.mapper;

import com.honpe.po.Offer;
import com.honpe.po.OfferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfferMapper {
    int countByExample(OfferExample example);

    int deleteByExample(OfferExample example);

    int deleteByPrimaryKey(String oid);

    int insert(Offer record);

    int insertSelective(Offer record);

    List<Offer> selectByExample(OfferExample example);

    Offer selectByPrimaryKey(String oid);

    int updateByExampleSelective(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByExample(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByPrimaryKeySelective(Offer record);

    int updateByPrimaryKey(Offer record);
}