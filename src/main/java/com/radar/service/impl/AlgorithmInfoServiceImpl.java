package com.radar.service.impl;

import com.radar.dao.AlgorithmInfoDao;
import com.radar.pojo.AlgorithmInfo;
import com.radar.service.AlgorithmInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AlgorithmInfoServiceImpl implements AlgorithmInfoService {
    @Resource
    private AlgorithmInfoDao algorithmInfoDao;
    @Override
    public List<AlgorithmInfo> selectAll() {
        return algorithmInfoDao.selectAll();
    }
}
