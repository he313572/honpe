package com.honpe.mapper;

import com.honpe.po.AuthFunction;
import com.honpe.po.AuthFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthFunctionMapper {
    int countByExample(AuthFunctionExample example);

    int deleteByExample(AuthFunctionExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthFunction record);

    int insertSelective(AuthFunction record);

    List<AuthFunction> selectByExample(AuthFunctionExample example);

    AuthFunction selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByExample(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByPrimaryKeySelective(AuthFunction record);

    int updateByPrimaryKey(AuthFunction record);
    /**
     * 用户id查找用户权限
     * @param userId
     * @param menu
     * @return
     */
    List<AuthFunction> selectAuthFunctionByUserId(@Param("userId") String userId,@Param("generatemenu") String generatemenu);
}