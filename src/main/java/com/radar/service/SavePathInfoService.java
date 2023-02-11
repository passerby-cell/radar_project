package com.radar.service;

import com.radar.pojo.SavePathInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SavePathInfoService {
    List<SavePathInfo> selectAll();
}
