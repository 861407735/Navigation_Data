package com.sz.controller;

import com.alibaba.fastjson.JSON;
import com.sz.bean.ReachPort;
import com.sz.bean.ReachPortResult;
import com.sz.common.HttpUtil;
import com.sz.result.Msg;
import com.sz.service.ReachPortService;
import com.sz.service.RegionService;
import com.sz.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author Lyh
 * @date 2021/09/27  10:50
 * 根据mmsi查询船舶的靠港记录
 */
@RestController
public class ReachPortController {

    private static Logger logger = Logger.getLogger(ReachPortController.class.getName());

    @Autowired
    private HttpUtil httpUtil;

    @Autowired
    private ReachPortService reachPortService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private TrackService trackService;

    @RequestMapping("getReachPort")
    public Msg getReachPort(Long mmsi ,
                            @RequestParam(defaultValue = "1609465560")long begin,
                            @RequestParam(defaultValue = "1632707160")long end){

        String reachPortUrl="http://api.shipxy.com/apicall/GetPortOfCallByShip?" +
                "k=9379c04c031642f7b2c5691bc55b22f1" +
                "&mmsi="
                + mmsi +
                "&begin=1609465560&end=1632707160&timetype=2";
        String reachPorts = httpUtil.httpGetRequest(reachPortUrl);
        ReachPortResult reachPortResult = JSON.parseObject(reachPorts, ReachPortResult.class);
        //靠港记录集合
        List<ReachPort> records = reachPortResult.getRecords();
        int result=0;
        if (null != records && records.size()>0) {
            result = reachPortService.reachPortDataStorage(reachPortResult.getRecords());
        }else {
            logger.info("靠港记录为空");
        }
        if (result>0){ return Msg.success();}
        return Msg.fail();
    }

    /**
     * 获取数据库中所有船舶靠港记录
     * 开始时间结束时间由请求控制
     * @return
     */
    public Msg getAllReachPort(@RequestParam(defaultValue = "") String begin,
                               @RequestParam(defaultValue = "") String end){
        List<Long> longs = trackService.getsMMSI();

        for (Long aLong : longs) {
            //遍历获取改船舶的靠港记录
//            getReachPort(aLong,1609465560,1632707160); //开始时间为2021-1-1 结束时间2021-09-27
            //若时间范围可以设置很大的 可以直接写死  在此处再调用并修改参数开始时间及结束时间
        }
        return Msg.success();
    }
}
