package com.radar.controller;

import MatlabFunction.MatlabUtils;
import ThirdPartMatlab.DrawDIXiaoMan;
import cn.hutool.core.io.FileUtil;
import com.mathworks.toolbox.javabuilder.MWException;
import com.radar.utils.Result;
import com.radar.utils.StatusCode;
import draw_detectResults.DrawMatlab;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matlab")
public class MatlabController {
    @Value("${output.data.origdata}")
    private String dataDir;

    @Value("${filemanager.file}")
    private String outputDir;
    @Value("${output.data.detectiondata}")
    private String detectionData;

    DrawMatlab drawMatlab = new DrawMatlab();


    public MatlabController() throws MWException {
    }

    /**
     * 第二期：
     *
     * @param cc
     * @param vv
     * @param pp
     * @return
     */
    @GetMapping("/draw")
    public Result drawDetectResults(@RequestParam("cc") double cc, @RequestParam("vv") Integer vv, @RequestParam("pp") Integer pp) {
        try {
            drawMatlab.draw_detectResults(cc, vv, pp, outputDir);
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    /**
     * 脉冲压缩
     *
     * @param num
     * @return
     * @throws Exception
     */
    @GetMapping("/load")
    public Result load(@RequestParam("num") String num) {
        deleteFile(outputDir + "origClutterData.jpg");
        try {
            MatlabUtils matlabUtils = new MatlabUtils();
            matlabUtils.loaddata(dataDir + num + ".mat", outputDir + "origClutterData.jpg");
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    /**
     * 脉冲压缩
     *
     * @param num
     * @return
     * @throws Exception
     */
    @GetMapping("/pcprocess")
    public Result maichongyasuo(@RequestParam("num") String num) {
        deleteFile(outputDir + "PCData.jpg");
        try {
            MatlabUtils matlabUtils = new MatlabUtils();
            matlabUtils.PCprocess(dataDir + num + ".mat", outputDir + "PCData.jpg");
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    @GetMapping("/addtarget")
    public Result addTarget(@RequestParam("num") String num, @RequestParam("snr") double snr) {
        deleteFile(outputDir + "afterAddTarget.jpg", outputDir + "TotalData_afterPC.mat");
        try {
            MatlabUtils matlabUtils = new MatlabUtils();
            matlabUtils.AddTarget(dataDir + num + ".mat", snr, outputDir + "afterAddTarget.jpg", outputDir + "TotalData_afterPC.mat");
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }

    }

    /**
     * 杂波建模
     *
     * @param clun
     * @param clumode
     * @return
     * @throws Exception
     */
    @GetMapping("/modeling")
    public Result modeling(@RequestParam("clun") double clun, @RequestParam("clumode") double clumode) {
        deleteFile(outputDir + "afterModeling.jpg", outputDir + "clusterResult.jpg");
        try {
            MatlabUtils matlabUtils = new MatlabUtils();
            matlabUtils.BulidModel(outputDir + "TotalData_afterPC.mat", clun, clumode, outputDir + "afterModeling.jpg", outputDir + "clusterResult.jpg");
            return new Result<>(true, StatusCode.OK, "成功");
        } catch (Exception e) {
            return new Result<>(false, StatusCode.ERROR, "matlab程序调用出错", new RuntimeException(e));
        }
    }

    @GetMapping("/objectdetection")
    public Result objectDetection(@RequestParam("clustermode") double clustermode, @RequestParam("cyclenum") double cyclenum, @RequestParam("snr") double snr, @RequestParam("clun") double clun) {
        deleteFile(outputDir + "targetClusterResult.jpg", outputDir + "clusterCenter.jpg", outputDir + "detectionResult.jpg");
        try {
            MatlabUtils matlabUtils = new MatlabUtils();
            matlabUtils.targetDetection(detectionData + (int) cyclenum + "_r" + (int) snr + ".mat", "D:\\output\\Code\\TargetLoc.mat", clun, clustermode, outputDir + "targetClusterResult.jpg", outputDir + "clusterCenter.jpg", outputDir + "detectionResult.jpg");
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
