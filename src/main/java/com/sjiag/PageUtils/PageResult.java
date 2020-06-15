package com.sjiag.PageUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageResult {
//    /**
//     * 当前页码
//     */
//    private int pageNum;
//    /**
//     * 每页数量
//     */
//    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private Map content;
//    public int getPageNum() {
//        return pageNum;
//    }
//    public void setPageNum(int pageNum) {
//        this.pageNum = pageNum;
//    }
//    public int getPageSize() {
//        return pageSize;
//    }
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
    public long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public Map getContent() {
        return content;
    }
    public void setContent(List<?> content) {
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",getTotalSize());
        map.put("data",content);
        System.out.println(map);
        this.content = map;
    }
}