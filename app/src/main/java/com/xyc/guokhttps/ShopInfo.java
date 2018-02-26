package com.xyc.guokhttps;

/**
 * Created by hasee on 2018/1/8.
 */

public class ShopInfo {

    private int id;//商家id
    private String name;//商家名称
    private String leader;//负责人姓名(多个时,以逗号分隔)
    private String leaderTel;//负责人电话(多个时,以逗号分隔)
    private String address;//店面地址
    private int status;//状态:0-审核不通过,1-审核通过,2未审核,4-审核中
    private int creatorId;//BD人员ID
    private String bdName;//BD用户名
    private String location;//区域(地段)
    private int member;//会员数
    private int area;//商家面积
    private String customerFlow;//客流
    private String leaderWechat;// 负责人微信
    private int sendLevel;//派送等级:0-加急,1-正常
    private int isMultipleShop;//是否连锁:0-否,1-是
    private int collaborateNumber;//可合作商家数,选填
    private String signTime;// 签约时间
    private String envImage1;//商家实景图1
    private String envImage2;//商家实景图2
    private String envImage3;//商家实景图3
    private String contractImg;//合同照片
    private String exploitReason;//开拓理由
    private String contact;//商家联系人
    private String telephone;//联系人电话
    private String serviceStartTime;//服务开始时间
    private String serviceEndTime;//服务结束时间
    private String remark;//商家简介
    private String imgLogo;//商家LOGO图
    private String advertisingMap;//商家宣传图1,选填
    private String advertisingMap2;//商家宣传图2,选填

    private int province;//省code
    private int city;//市code
    private int direct;//区code
    private String provinceName;//省名
    private String cityName;//市名
    private String directName;// 区名

    private double longitude;//经度
    private double latitude;//纬度
    private int firstTradeId;//所属行业第一级ID
    private String firstTradeName;//所属行业第一级名称
    private int secondTradeId;//所属行业第二级ID
    private String secondTradeName;//所属行业第二级名称
    private int orgId;//机构id
    private String orgName;//机构名
    private String creatorName;//所属Bd人员的名称
     private String envImage1Short;//商家实景图1相对路径
     private String envImage2Short;//实景图2相对路径
     private String envImage3Short;//实景图3相对路径
     private String contractImgShort;//合同照片
     private String imgLogoShort;//商家LOGO图相对路径
     private String advertisingMapShort;//商家宣传图1相对路径
     private String advertisingMap2Short;//商家宣传图2相对路径

    public ShopInfo() {    }


    public void setFirstTradeName(String firstTradeName) {
        this.firstTradeName = firstTradeName;
    }

    public void setSecondTradeName(String secondTradeName) {
        this.secondTradeName = secondTradeName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDirectName() {
        return directName;
    }

    public void setDirectName(String directName) {
        this.directName = directName;
    }

    public String getEnvImage1Short() {
        return envImage1Short;
    }

    public void setEnvImage1Short(String envImage1Short) {
        this.envImage1Short = envImage1Short;
    }

    public String getEnvImage2Short() {
        return envImage2Short;
    }

    public void setEnvImage2Short(String envImage2Short) {
        this.envImage2Short = envImage2Short;
    }

    public String getEnvImage3Short() {
        return envImage3Short;
    }

    public void setEnvImage3Short(String envImage3Short) {
        this.envImage3Short = envImage3Short;
    }

    public String getContractImgShort() {
        return contractImgShort;
    }

    public void setContractImgShort(String contractImgShort) {
        this.contractImgShort = contractImgShort;
    }

    public String getImgLogoShort() {
        return imgLogoShort;
    }

    public void setImgLogoShort(String imgLogoShort) {
        this.imgLogoShort = imgLogoShort;
    }

    public String getAdvertisingMapShort() {
        return advertisingMapShort;
    }

    public void setAdvertisingMapShort(String advertisingMapShort) {
        this.advertisingMapShort = advertisingMapShort;
    }

    public String getAdvertisingMap2Short() {
        return advertisingMap2Short;
    }

    public void setAdvertisingMap2Short(String advertisingMap2Short) {
        this.advertisingMap2Short = advertisingMap2Short;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getFirstTradeName() {
        return firstTradeName;
    }

    public String getSecondTradeName() {
        return secondTradeName;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeaderTel() {
        return leaderTel;
    }

    public void setLeaderTel(String leaderTel) {
        this.leaderTel = leaderTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCustomerFlow() {
        return customerFlow;
    }

    public void setCustomerFlow(String customerFlow) {
        this.customerFlow = customerFlow;
    }

    public String getLeaderWechat() {
        return leaderWechat;
    }

    public void setLeaderWechat(String leaderWechat) {
        this.leaderWechat = leaderWechat;
    }

    public int getSendLevel() {
        return sendLevel;
    }

    public void setSendLevel(int sendLevel) {
        this.sendLevel = sendLevel;
    }

    public int getIsMultipleShop() {
        return isMultipleShop;
    }

    public void setIsMultipleShop(int isMultipleShop) {
        this.isMultipleShop = isMultipleShop;
    }

    public int getCollaborateNumber() {
        return collaborateNumber;
    }

    public void setCollaborateNumber(int collaborateNumber) {
        this.collaborateNumber = collaborateNumber;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getEnvImage1() {
        return envImage1;
    }

    public void setEnvImage1(String envImage1) {
        this.envImage1 = envImage1;
    }

    public String getEnvImage2() {
        return envImage2;
    }

    public void setEnvImage2(String envImage2) {
        this.envImage2 = envImage2;
    }

    public String getEnvImage3() {
        return envImage3;
    }

    public void setEnvImage3(String envImage3) {
        this.envImage3 = envImage3;
    }

    public String getContractImg() {
        return contractImg;
    }

    public void setContractImg(String contractImg) {
        this.contractImg = contractImg;
    }

    public String getExploitReason() {
        return exploitReason;
    }

    public void setExploitReason(String exploitReason) {
        this.exploitReason = exploitReason;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(String serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public String getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(String serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }

    public String getAdvertisingMap() {
        return advertisingMap;
    }

    public void setAdvertisingMap(String advertisingMap) {
        this.advertisingMap = advertisingMap;
    }

    public String getAdvertisingMap2() {
        return advertisingMap2;
    }

    public void setAdvertisingMap2(String advertisingMap2) {
        this.advertisingMap2 = advertisingMap2;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getFirstTradeId() {
        return firstTradeId;
    }

    public void setFirstTradeId(int firstTradeId) {
        this.firstTradeId = firstTradeId;
    }

    public int getSecondTradeId() {
        return secondTradeId;
    }

    public void setSecondTradeId(int secondTradeId) {
        this.secondTradeId = secondTradeId;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leader='" + leader + '\'' +
                ", leaderTel='" + leaderTel + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", creatorId=" + creatorId +
                ", bdName='" + bdName + '\'' +
                ", location='" + location + '\'' +
                ", member=" + member +
                ", area=" + area +
                ", customerFlow='" + customerFlow + '\'' +
                ", leaderWechat='" + leaderWechat + '\'' +
                ", sendLevel=" + sendLevel +
                ", isMultipleShop=" + isMultipleShop +
                ", collaborateNumber=" + collaborateNumber +
                ", signTime='" + signTime + '\'' +
                ", envImage1='" + envImage1 + '\'' +
                ", envImage2='" + envImage2 + '\'' +
                ", envImage3='" + envImage3 + '\'' +
                ", contractImg='" + contractImg + '\'' +
                ", exploitReason='" + exploitReason + '\'' +
                ", contact='" + contact + '\'' +
                ", telephone='" + telephone + '\'' +
                ", serviceStartTime='" + serviceStartTime + '\'' +
                ", serviceEndTime='" + serviceEndTime + '\'' +
                ", remark='" + remark + '\'' +
                ", imgLogo='" + imgLogo + '\'' +
                ", advertisingMap='" + advertisingMap + '\'' +
                ", advertisingMap2='" + advertisingMap2 + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", direct='" + direct + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", firstTradeId=" + firstTradeId +
                ", firstTradeName='" + firstTradeName + '\'' +
                ", secondTradeId=" + secondTradeId +
                ", secondTradeName='" + secondTradeName + '\'' +
                ", orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", creatorName='" + creatorName + '\'' +
                '}';
    }
}
