package com.sz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sz.bean.ReachPort;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lyh
 * @date 2021/09/27  14:34
 */
@Mapper
public interface ReachPortMapper extends BaseMapper<ReachPort> {


    @Insert("INSERT INTO shipxy_reachport(ship_name,call_sign,imo,mmsi,ship_type_cn,ship_type_en,port_name_cn,port_name_en," +
            "portid,port_time_zone,port_code,terminal_name,berth_name,country_cn,country_en,country_code," +
            "arriveanchorage,ata,atb,atd,arrival_draught,departure_draught," +
            "stayin_port,stayin_terminal)" +
            "VALUE(#{shipName},#{callSign},#{imo},#{mmsi},#{shipTypeCn},#{shipTypeEn},#{portNameCn},#{portNameEn}," +
            "#{portId},#{portTimeZone},#{portCode},#{terminalName},#{berthName},#{countryCn}," +
            "#{countryEn},#{countryCode},#{arriveanchorage},#{ata},#{atb},#{atd}," +
            "#{arrivalDraught},#{departureDraught},#{stayinPort},#{stayinTerminal})")
    int insertReachPort(ReachPort reachPort);
}
