package com.radar.dao;

import com.radar.pojo.SavePathInfo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface SavePathInfoDao {
    int deleteByPrimaryKey(Integer algId);

    int insert(SavePathInfo record);

    int insertSelective(SavePathInfo record);

    SavePathInfo selectByPrimaryKey(Integer algId);

    int updateByPrimaryKeySelective(SavePathInfo record);

    int updateByPrimaryKey(SavePathInfo record);

    List<SavePathInfo> selectAll();
}