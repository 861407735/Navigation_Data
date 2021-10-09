package com.sz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/26  9:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionResult {

    private int status;
    private Long serviceTime;
    private int scode;
    private List<ShipInfo> data;
}
