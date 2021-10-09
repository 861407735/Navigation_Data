package com.sz.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Lyh
 * @date 2021/09/24  17:47
 * 船只信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shipxy_info")
public class ShipInfo {

    /**
     * 船舶id
     */
    private Long shipId;
    /**
     * 数据来源，0 代表 AIS，1 代表卫星
     */
    private int from;
    /**
     * 船舶 MMSI，9 位数字
     */
    private Long mmsi;
    /**
     * 船舶类型
     */
    private int shipType;
    /**
     * 0= Not available (default)2147483647=Null
     */
    private Long imo;
    /**
     * 船舶名称
     */
    private String name;
    /**
     * 船舶呼号
     */
    private String callSign;
    /**
     * 船长，分米，(0-10220)
     */
    private int length;
    /**
     * 船宽，分米，(0-1260]
     */
    private int width;
    /**
     * 左舷距，分米,(0-630]
     */
    private int left;
    /**
     * 尾距，分米，(0-5110)
     */
    private int trail;
    /**
     * 吃水，毫米，(0-25500]
     */
    private int draught;
    /**
     * 目的地
     */
    private String dest;
    /**
     * 标准化后的目的地（只有返回json 格式时包含此信息）：
     * 根据 dest 内容匹配到船讯网港口库
     */
    private String destStd;
    /**
     * 标准化后的目的地港口编码
     */
    private String destCode;
    /**
     * 预到时间：[MM][DD][HH][MM]
     */
    private String eta;
    /**
     * 标准化后的预到时间 对 eta 标准化处理，
     * 格式为[YYYY] [MM][DD][HH][MM]
     */
    private String etaStd;
    /**
     * 船舶航行状态
     */
    private int navistat;
    /**
     * 纬度，1/1000000 度,[-90000000,90000000]
     */
    private Long lat;
    /**
     * 经度，1/1000000 度,[-180000000,180000000]
     */
    private Long lon;
    /**
     * 速度，毫米/秒, [0,52576]
     */
    private int sog;
    /**
     * 航迹向，1/100 度, [0,35990]
     */
    private int cog;
    /**
     * 船首向，1/100 度, [0,35900]
     */
    private int hdg;
    /**
     * 转向率，1/100 度/秒, [-1200,1200]
     */
    private int rot;
    /**
     * 更新时间，unix 时间戳
     */
    private Long lastTime;
}
