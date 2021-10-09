package com.sz.controller;

import com.alibaba.fastjson.JSON;
import com.sz.bean.TrackResult;
import com.sz.common.HttpUtil;
import com.sz.common.TimeCycle;
import com.sz.result.Msg;
import com.sz.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/26  14:24
 * 轨迹获取
 */
@RestController
public class TrackController {

    @Autowired
    TrackService trackService;

    @Autowired
    TimeCycle timeCycle;

    /**
     * 请求http
     */
    @Autowired
    HttpUtil httpUtil;
    /**
     * 根据时间获取
     * 获取单个轨迹数据
     * @return
     */
    @RequestMapping("trackGain")
    public Msg trackGain(Long id,
                         @RequestParam(defaultValue = "1632563160") Long btm,
                         @RequestParam(defaultValue = "1632638086") Long etm){
        String trackUrl="http://api.shipxy.com/apicall/GetShipTrack?k=9379c04c031642f7b2c5691bc55b22f1" +
                "&enc=1&cut=0&id="+id+"&btm=1632563160&etm=1632638086";

        //返回区域内批量数据
        String resultRegionData = httpUtil.httpGetRequest(trackUrl);

        TrackResult trackResult = JSON.parseObject(resultRegionData, TrackResult.class);
        int resultRow=0;
        if ( null != trackResult.getPoints() && trackResult.getPoints().size()>0) {
            resultRow = trackService.insert(id, trackResult.getPoints());
        }
        if (resultRow>0){return Msg.success();}
        return Msg.fail();
    }

    /**
     * 获取数据库中的所有MMSI
     * 避免参数写死 ,可以将入参 交由请求控制 开始时间 结束时间
     * @param btm  开始时间
     * @param etm  结束时间
     * @return
     */
    public Msg trackGains(@RequestParam(defaultValue = "") String btm,
                          @RequestParam(defaultValue = "") String etm){
        List<Long> MMISs = trackService.getsMMSI();
        timeCycle.TimeTOStamp(btm);  //开始时间转换为时间戳
        timeCycle.TimeTOStamp(etm);  //结束时间

        //拿到库中所有
        for (Long mmiSs : MMISs) {
//            trackGain(mmiSs);  //  若时间返回可以控制很大 直接在这里将时间分段写死
//            trackGain(mmiSs);  //

        }
        return null;
    }

}
