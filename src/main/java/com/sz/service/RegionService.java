package com.sz.service;

import com.sz.bean.ShipInfo;
import com.sz.mapper.ShipInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/26  9:50
 */
@Service
public class RegionService {

    @Autowired
    ShipInfoMapper shipInfoMapper;

    /**
     * 批量插入
     * @param shipInfos
     */
    @Transactional(rollbackFor = Exception.class)
    public int regionDataStorage(List<ShipInfo> shipInfos) {
        int r =0;
        for (ShipInfo shipInfo : shipInfos) {
            System.out.println(shipInfo.toString());
            r=shipInfoMapper.insertShipInfo(shipInfo);
        }
        System.out.println("插入成功！");
        return r;
    }
}
