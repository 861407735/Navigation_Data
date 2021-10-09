package com.sz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lyh
 * @date 2021/09/27  10:15
 *
 * 船舶靠港记录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReachPort {
    //船舶名称
    private String shipName;
    // 船舶呼号
    private String callSign;
    // 船舶 IMO
    private Long imo;
    // 船舶 MMSI，唯一识别码
    private Long mmsi;
    // 船舶类型中文
    private String shipTypeCn;
    // 船舶类型英文
    private String shipTypeEn;
    // 港口中文名称
    private String portNameCn;
    //港口英文名称
    private String portNameEn;
    // 港口唯一 id
    private Long portId;
    /**
     * 港口时区
     */
    private String portTimeZone;
    // 港口标准 CODE 值
    private String portCode;
    // 靠泊的码头名称
    private String terminalName;
    // 靠泊的泊位名称
    private String berthName;
    // 港口所属国家中文名
    private String countryCn;
    // 港口所属国家英文名
    private String countryEn;
    // 国家标准 CODE 值
    private String countryCode;

    private String arriveanchorage;  //文档中未表明  接口返回为空
    // 实际到达港口的时间
    private String ata;
    // 实际到达码头的时间
    private String atb;
    // 实际离开港口的时间，根据 timetype 参数不同，返 回时间时区不同
    private String atd;
    // 到达港口时的吃水
    private Long arrivalDraught;
    // 离开港口时的吃水
    private Long departureDraught;
    // 在港口的停留时间，单位小时，ATD-ATA
    private String stayinPort;
    // 在码头的停留时间，单位小时，ATD-ATB
    private String stayinTerminal;
}
