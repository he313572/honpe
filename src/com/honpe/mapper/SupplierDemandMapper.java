package com.honpe.mapper;

import com.honpe.po.SupplierDemand;
import com.honpe.po.SupplierDemandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierDemandMapper {
    int countByExample(SupplierDemandExample example);

    int deleteByExample(SupplierDemandExample example);

    int deleteByPrimaryKey(String did);

    int insert(SupplierDemand record);

    int insertSelective(SupplierDemand record);

    List<SupplierDemand> selectByExample(SupplierDemandExample example);

    SupplierDemand selectByPrimaryKey(String did);

    int updateByExampleSelective(@Param("record") SupplierDemand record, @Param("example") SupplierDemandExample example);

    int updateByExample(@Param("record") SupplierDemand record, @Param("example") SupplierDemandExample example);

    int updateByPrimaryKeySelective(SupplierDemand record);

    int updateByPrimaryKey(SupplierDemand record);
}