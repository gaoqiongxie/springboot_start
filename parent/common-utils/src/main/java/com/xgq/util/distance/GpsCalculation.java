package com.xgq.util.distance;

import com.xgq.util.distance.model.GpsPoint;

import java.math.BigDecimal;

/**
 * @author xiegaoqiong
 * @date 2022/9/30
 * @apiNote
 */
public final class GpsCalculation {
    private static final double EARTH_RADIUS = 637_8137.00D;

    private static final double RADIAN = Math.PI / 180.00D;

    private static final double HALF = 0.5D;

    /**
     * <p> 计算两坐标点之间的直线距离 </p>
     * @param p1: 坐标1
	 * @param p2: 坐标2
     * @return :java.lang.Double 直线距离(米)
     * @author :xiegaoqiong
     * @date :2022/9/30 14:02
     */
    public static Double distance(GpsPoint p1, GpsPoint p2) {
        double lat1 = p1.getLat();
        double lng1 = p1.getLng();
        double lat2 = p2.getLat();
        double lng2 = p2.getLng();
        double x, y, a, b, distance;
        lat1 *= RADIAN;
        lat2 *= RADIAN;
        x = lat1 - lat2;
        y = lng1 - lng2;
        y *= RADIAN;
        a = Math.sin(x * HALF);
        b = Math.sin(y * HALF);
        distance = EARTH_RADIUS * Math.asin(Math.sqrt(a * a + Math.cos(lat1) * Math.cos(lat2) * b * b)) / HALF;
        return BigDecimal.valueOf(distance).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * <p> 根据经纬度和半径计算经纬度范围 </p>
     * @param lat:
	 * @param lng:
	 * @param raidus:
     * @return :double[]
     * @author :xiegaoqiong
     * @date :2022/9/30 14:02
     */
    public static double[] getAround(double lat, double lng, int raidus) {

        Double latitude = lat;
        Double longitude = lng;

        Double degree = (24901 * 1609) / 360.0;
        double raidusMile = raidus;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        Double mpdLng = degree * Math.cos(latitude * (RADIAN));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        return new double[]{minLat, minLng, maxLat, maxLng};
    }

}
