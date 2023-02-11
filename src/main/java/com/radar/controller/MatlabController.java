package com.radar.controller;

import MatlabFunction.MatlabUtils;
import com.mathworks.toolbox.javabuilder.MWException;
import com.radar.utils.Result;
import com.radar.utils.StatusCode;
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

    private String outputDir="D:\\output\\";
    @Value("${output.data.detectiondata}")
    private String detectionData;
    /**
     * 脉冲压缩
     * @param num
     * @return
     * @throws MWException
     */
    @GetMapping("/pcprocess")
    public Result maichongyasuo(@RequestParam("num") String num) throws MWException {
        MatlabUtils matlabUtils = new MatlabUtils();
        matlabUtils.loaddata(dataDir+ num +".mat", outputDir+"origClutterData.jpg");
        matlabUtils.PCprocess(dataDir+ num +".mat", outputDir+"PCData.jpg");
        return new Result<>(true, StatusCode.OK, "成功");
    }

    @GetMapping("/addtarget")
    public Result addTarget(@RequestParam("num") String num,@RequestParam("snr")double snr) throws MWException {
        MatlabUtils matlabUtils = new MatlabUtils();

        matlabUtils.AddTarget(dataDir+ num +".mat", snr, outputDir+"afterAddTarget.jpg", outputDir+"TotalData_afterPC.mat");
        return new Result<>(true, StatusCode.OK, "成功");
    }

    /**
     * 杂波建模
     * @param clun
     * @param clumode
     * @return
     * @throws MWException
     */
    @GetMapping("/modeling")
    public Result modeling(@RequestParam("clun") double clun,@RequestParam("clumode")double clumode) throws MWException {
        MatlabUtils matlabUtils = new MatlabUtils();
        //Number of clusters,range can be 1:16
//        double CluN = 6;
        //建模方式，1表示Kmeans,2表示GMM
//        double CluMode = 1;
        matlabUtils.BulidModel(outputDir+"TotalData_afterPC.mat", clun, clumode, outputDir+"afterModeling.jpg", outputDir+"clusterResult.jpg");
        return new Result<>(true, StatusCode.OK, "成功");
    }

    @GetMapping("/objectdetection")
    public Result objectDetection(@RequestParam("clustermode") double clustermode,@RequestParam("cyclenum") double cyclenum,@RequestParam("snr") double snr,@RequestParam("clun") double clun) throws MWException {
        MatlabUtils matlabUtils = new MatlabUtils();
        //取1 or 2
//        double clusterMode = 1;
        //36:1:50
//        double CycleNum = 41;
        //-10:5:10
//        double SNR = 10;
        //1:1:16
//        double CluN = 4;
        matlabUtils.targetDetection(detectionData+(int)cyclenum+"_r"+(int)snr+".mat", "D:\\output\\Code\\TargetLoc.mat", clun, clustermode, outputDir+"targetClusterResult.jpg", outputDir+"clusterCenter.jpg", outputDir+"detectionResult.jpg");
        return new Result<>(true, StatusCode.OK, "成功");
    }
}
