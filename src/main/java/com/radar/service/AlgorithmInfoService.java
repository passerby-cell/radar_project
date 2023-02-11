package com.radar.service;

import com.radar.pojo.AlgorithmInfo;

import javax.annotation.Resource;
import java.util.List;

public interface AlgorithmInfoService {
    List<AlgorithmInfo> selectAll();
}
