package com.shop24.api.util;

public class Helpers {
    public static double calculateDistance(double lng1,double lt1,double lng2,double lt2){
        double R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lt2-lt1);  // deg2rad below
        double dLon = deg2rad(lng2-lng1);
        double a =
                Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(deg2rad(lt1)) * Math.cos(deg2rad(lt2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c; // Distance in km
        return d;
    }
    public static double deg2rad(double deg) {
        return deg * (Math.PI/180);
    }
}
