package com.xyc.guokhttps;

import java.util.List;

/**
 * Created by hasee on 2017/12/19.
 */

public class User {

    private int isOps;// 是否有绑定设备的权限 0，无，1有
    private int deptId;//部门id
    private int roleNumber;//0表示bdm，1表示bd,3表示ops;
    private String token;
    private List<String> tag;////标签，用于群发推送
    private String userName;//用户名

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public int getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(int roleNumber) {
        this.roleNumber = roleNumber;
    }

    public int getIsOps() {
        return isOps;
    }

    public void setIsOps(int isOps) {
        this.isOps = isOps;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "isOps=" + isOps +
                ", deptId=" + deptId +
                ", roleNumber=" + roleNumber +
                ", token='" + token + '\'' +
                ", tag=" + tag +
                '}';
    }
}
