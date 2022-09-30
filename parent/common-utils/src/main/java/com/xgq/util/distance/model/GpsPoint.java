package com.xgq.util.distance.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xiegaoqiong
 * @date 2022/9/30
 * @apiNote
 */
@Data
@Accessors(chain = true)
public class GpsPoint implements Serializable {

    private Double lng;

    private Double lat;

    public GpsPoint() {}

    public GpsPoint(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

}
