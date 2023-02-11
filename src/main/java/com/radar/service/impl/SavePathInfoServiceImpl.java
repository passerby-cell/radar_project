package com.radar.service.impl;

import com.radar.dao.SavePathInfoDao;

import com.radar.pojo.SavePathInfo;
import com.radar.service.SavePathInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SavePathInfoServiceImpl implements SavePathInfoService {
    @Resource
    private SavePathInfoDao savePathInfoDao;


    @Override
    public List<SavePathInfo> selectAll() {

        return savePathInfoDao.selectAll();
    }


}
