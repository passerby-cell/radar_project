package com.radar.controller;

import com.radar.pojo.AlgorithmInfo;
import com.radar.pojo.SavePathInfo;
import com.radar.service.impl.AlgorithmInfoServiceImpl;
import com.radar.service.impl.SavePathInfoServiceImpl;
import com.radar.utils.Result;
import com.radar.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/algroithminfo")
@RestController
public class AlgroithmInfoController {
    @Autowired
    private AlgorithmInfoServiceImpl algorithmInfoService;

    @GetMapping
    public Result<List<AlgorithmInfo>> selectAll(){
        return new Result(true, StatusCode.OK,"查询成功",algorithmInfoService.selectAll());
    }

}
