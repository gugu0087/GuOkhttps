package com.xyc.guokhttps;

import java.util.List;

/**
 * Created by hasee on 2018/3/5.
 */

public class GetMyVerifyDataModel {
    private int total;
    private List<MyVerify> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MyVerify> getData() {
        return data;
    }

    public void setData(List<MyVerify> data) {
        this.data = data;
    }

    private class  MyVerify{
        private int id; // 商家id
        private String name;//商家名称
        private String leader;//负责人姓名(多个时,以逗号分隔)
        private String address;//店面地址
        private String leaderTel;//负责人电话(多个时,以逗号分隔)
        private String creatorName;//负责人(多个时,以逗号分隔)
        private long createTime;//创建时间
        private int status;//状态:0-审核不通过,1-审核通过,4-待审核
        public boolean isCheck;
        private long lastUpdateTime;//提交审核时间

        private String envImage1;//商家实景图1
        private String envImage2;//商家实景图2
        private String envImage3;//商家实景图3
        public MyVerify() {
        }

        public String getCreatorName() {
            return creatorName;
        }

        public void setCreatorName(String creatorName) {
            this.creatorName = creatorName;
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

        public long getLastUpdateTime() {
            return lastUpdateTime;
        }

        public void setLastUpdateTime(long lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLeaderTel() {
            return leaderTel;
        }

        public void setLeaderTel(String leaderTel) {
            this.leaderTel = leaderTel;
        }

        @Override
        public String toString() {
            return "MyVerify{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", leader='" + leader + '\'' +
                    ", address='" + address + '\'' +
                    ", leaderTel='" + leaderTel + '\'' +
                    ", createTime=" + createTime +
                    ", status=" + status +
                    ", isCheck=" + isCheck +
                    ", creatorName='" + creatorName + '\'' +
                    ", lastUpdateTime=" + lastUpdateTime +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "GetMyVerifyDataModel{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
