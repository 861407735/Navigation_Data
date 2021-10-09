package com.sz.service;

import com.sz.bean.ReachPort;
import com.sz.mapper.ReachPortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/27  14:51
 */
@Service
public class ReachPortService {

    @Autowired
    ReachPortMapper reachPortMapper;

    public int reachPortDataStorage(List<ReachPort> records) {

        for (ReachPort record : records) {
            reachPortMapper.insertReachPort(record);
        }
        return 1;
    }

}
