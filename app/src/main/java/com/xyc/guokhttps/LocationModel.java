package com.xyc.guokhttps;

/**
 * Created by hasee on 2018/1/15.
 */

public class LocationModel {
    private double latitude;//纬度
    private double longitude;//经度
    private String address;//详细地址
    private String remark;//备注
    private String province;//省
    private int provinceId;//省id
    private String city;//地址市
    private int cityId;//地址市id
    private String direct; //地址区
    private int directId;//地址区id
    private String street;//地址街道
    private int streetId;//地址街道id

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public int getDirectId() {
        return directId;
    }

    public void setDirectId(int directId) {
        this.directId = directId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", province='" + province + '\'' +
                ", provinceId=" + provinceId +
                ", city='" + city + '\'' +
                ", cityId=" + cityId +
                ", direct='" + direct + '\'' +
                ", directId=" + directId +
                ", street='" + street + '\'' +
                ", streetId=" + streetId +
                '}';
    }
}
