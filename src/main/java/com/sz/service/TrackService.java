package com.sz.service;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sz.bean.Track;
import com.sz.mapper.ShipInfoMapper;
import com.sz.mapper.TrackMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/26  15:15
 */
@Service
public class TrackService {
    @Autowired
    TrackMapper trackMapper;

    @Autowired
    ShipInfoMapper shipInfoMapper;

    public List<Long>  getsMMSI(){
       return shipInfoMapper.selectAllMMSI();
    }

    public int insert(Long id,List<Track> tracks) {

        for (Track track : tracks) {
            track.setMmsi(id);
            trackMapper.insert(track);
        }
        System.out.println("执行成功！");
        return 1;
    }
}
