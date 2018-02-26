package com.xyc.guokhttps;

import java.util.List;

/**
 * Created by hasee on 2018/1/9.
 */

public class CommonModel {
    private int total;
    private List<ShopInfo> data;

    public CommonModel() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ShopInfo> getData() {
        return data;
    }

    public void setData(List<ShopInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommomModel{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
