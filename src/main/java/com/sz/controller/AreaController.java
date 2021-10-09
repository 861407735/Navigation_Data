package com.sz.controller;

import com.alibaba.fastjson.JSON;
import com.sz.bean.RegionResult;
import com.sz.bean.ShipInfo;
import com.sz.common.HttpUtil;
import com.sz.result.Msg;
import com.sz.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/26  9:01
 *
 * 根据经纬度 进行区域获取 船舶详细信息
 */
@RestController
public class AreaController {

    @Autowired
    RegionService regionService;
    /**
     * 请求http
     */
    @Autowired
    HttpUtil httpUtil;

    /**
     * 通过经纬度 获取批量数据
     * @param scode 0 首次调用，后期要用服务端返回的 scode 填充
     * 如使用 Scode，每次返回的只是有更新的船舶。
     * @param xy  经纬度
     */
    @RequestMapping("regionSearch")
    public Msg regionSearch(@RequestParam(defaultValue = "0")String scode,
                            @RequestParam(defaultValue = "121203937,29954540-122327256,29962067-122278834,29934166-122319447,29920268")String xy){
        String regionUrl="http://api.shipxy.com/apicall/GetAreaShip?" +
                "v=2&k=9379c04c031642f7b2c5691bc55b22f1&enc=1&mode=0&scode=0&" +
                "xy="+xy;
        //返回区域内批量数据
        String resultRegionData = httpUtil.httpGetRequest(regionUrl);
        //Json转换为RegionResult 对象
        RegionResult regionResult = JSON.parseObject(resultRegionData, RegionResult.class);
        List<ShipInfo> shipInfos = regionResult.getData();

        int resultRow=0;
        if (null != shipInfos && shipInfos.size()>0) {
            resultRow=regionService.regionDataStorage(shipInfos);
        }
        if (resultRow >0) {return Msg.success();}
        return Msg.fail();
    }
}
