package com.sz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sz.bean.ShipInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/26  10:54
 */
@Mapper
public interface ShipInfoMapper extends BaseMapper<ShipInfo> {

    @Insert("INSERT INTO shipxy_info(ship_id,`from`,mmsi,ship_type,imo,`name`,call_sign,length,width,"+
            "`left`,trail,draught,dest,dest_std,dest_code,eta,eta_std,navistat,lat,"+
            "lon,sog,cog,hdg,rot,lastTime)"+
            "VALUE(#{shipId},#{from},#{mmsi},#{shipType},#{imo},#{name},#{callSign},#{length},#{width},#{left}," +
            "#{trail},#{draught},#{dest},#{destStd},#{destCode},#{eta},#{etaStd},#{navistat},#{lat},#{lon},#{sog},#{cog},#{hdg},#{rot}," +
            "#{lastTime})")
    int insertShipInfo(ShipInfo shipInfo);

    @Select("SELECT mmsi FROM shipxy_info")
    List<Long>  selectAllMMSI();
}
