package com.ssm.bean;

import java.util.List;

/**
 * @author ZhangRunKai
 * @date 2020/7/8 14:52
 */
public class PageBean<T>{
    private int currPage;//当前页数
    private int pageSize;//每页显示的记录数
    private int total; //总计录数
    private int totalPage;//总页数
    private List<T> data;//每页显示的数据

    public PageBean() {
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
