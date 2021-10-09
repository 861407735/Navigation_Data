package com.sz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/27  10:43
 * 靠港记录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReachPortResult {

    /**
     * 返回数据状态
     */
    private int status;
    /**
     * 靠港记录
     */
    private List<ReachPort> records;
}
