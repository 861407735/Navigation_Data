package com.sz.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lyh
 * @date 2021/09/26  14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shipxy_track")
public class Track {

    private Long mmsi;

    private int dataType;
    /**
     * 时间
     */
    private Long utc;
    /**
     * 经度
     * 百万分之一度，[-
     * 180000000,18000000]
     */
    private Long lon;
    /**
     * 纬度
     * 百万分之一度，[-
     * 90000000,9000000]
     */
    private Long lat;
    /**
     * 对地速率
     * 毫米/秒, [0,52576]
     */
    private Long sog;
    /**
     * 对地航向
     * 百分之一度[0-36000]
     */
    private Long cog;
}
