package com.radar.controller;

import com.radar.pojo.SavePathInfo;
import com.radar.service.impl.SavePathInfoServiceImpl;
import com.radar.utils.Result;
import com.radar.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/savepath")
@RestController
public class SavePathInfoController {
    @Autowired
    private SavePathInfoServiceImpl savePathInfoService;

    @GetMapping
    public Result<List<SavePathInfo>> selectAll(){
        return new Result(true, StatusCode.OK,"查询成功",savePathInfoService.selectAll());
    }

}
