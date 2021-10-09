package com.sz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Lyh
 * @date 2021/09/26  17:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackResult {

    private int status;

    private int notall;

    private List<Track> points;
}
