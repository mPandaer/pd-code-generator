package com.pandaer.marker.model;

import lombok.Data;

@Data
public class DataModel {
    /**
     * 作者
     */
    private String author;

    /**
     * 输出内容
     */
    private String output;

    /**
     * 是否生产循环代码
     */
    private boolean loop;
}
