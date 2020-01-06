package com.lsx.everything.core.model;

import lombok.Data;

@Data
public class Condition {

    private String name;

    private String fileType;

    private Integer limit;
    /**
     * 检索文件的文件信息depth排序规则
     * 默认是true -> asc
     *      false -> desc
     */
    private Boolean orderByAsc;
}
