package com.radar.controller;

import ThirdPartMatlab.DrawDIXiaoMan;
import cn.hutool.core.io.FileUtil;
import com.mathworks.toolbox.javabuilder.MWException;
import com.radar.utils.Result;
import com.radar.utils.StatusCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/third")
public class SecondMatLabController {
    @Value("${filemanager.file}")
    private String outputDir;
    @GetMapping("/dixiaomansix")
    public Result dixiaomansix(@RequestParam("p") Integer p) {
        deleteFile(outputDir + "8.jpg");
        try {    DrawDIXiaoMan drawDIXiaoMan = new DrawDIXiaoMan();
            drawDIXiaoMan.part6(outputDir, p);
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    @GetMapping("/dixiaomanfive")
    public Result dixiaomanfive(@RequestParam("p") Integer p, @RequestParam("v") Integer v) {
        deleteFile(outputDir + "7.jpg");
        try {    DrawDIXiaoMan drawDIXiaoMan = new DrawDIXiaoMan();
            drawDIXiaoMan.part5(outputDir, p, v);
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    @GetMapping("/dixiaomanfour")
    public Result dixiaomanfour(@RequestParam("p") Integer p, @RequestParam("v") Integer v) {
        deleteFile(outputDir + "6.jpg");
        try {    DrawDIXiaoMan drawDIXiaoMan = new DrawDIXiaoMan();
            drawDIXiaoMan.part4(outputDir, p, v);
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    @GetMapping("/dixiaomanthree")
    public Result dixiaomanthree(@RequestParam("p") Integer p) {
        deleteFile(outputDir + "5.jpg");
        try {    DrawDIXiaoMan drawDIXiaoMan = new DrawDIXiaoMan();
            drawDIXiaoMan.part3(outputDir, p);
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    @GetMapping("/dixiaomantwo")
    public Result dixiaomantwo() {
        deleteFile(outputDir + "3.jpg");
        deleteFile(outputDir + "4.jpg");
        try {    DrawDIXiaoMan drawDIXiaoMan = new DrawDIXiaoMan();
            drawDIXiaoMan.part2(outputDir);
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    @GetMapping("/dixiaomanone")
    public Result dixiaomanone() {
        deleteFile(outputDir + "1.jpg");
        deleteFile(outputDir + "2.jpg");
        try {    DrawDIXiaoMan drawDIXiaoMan = new DrawDIXiaoMan();
            drawDIXiaoMan.part1(outputDir);
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    public void deleteFile(String... a) {
        for (String path : a) {
            FileUtil.del(path);
        }
    }
}
