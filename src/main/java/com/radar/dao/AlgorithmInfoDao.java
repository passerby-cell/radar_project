package com.radar.dao;

import com.radar.pojo.AlgorithmInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AlgorithmInfoDao {
    int deleteByPrimaryKey(String paramName);

    int insert(AlgorithmInfo record);

    int insertSelective(AlgorithmInfo record);

    AlgorithmInfo selectByPrimaryKey(String paramName);

    int updateByPrimaryKeySelective(AlgorithmInfo record);

    int updateByPrimaryKey(AlgorithmInfo record);

    List<AlgorithmInfo> selectAll();

}