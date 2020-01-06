package com.lsx.everything.core.dao;

import com.lsx.everything.core.model.Condition;
import com.lsx.everything.core.model.Thing;

import java.util.List;

/**
 * 业务层访问数据库的CRUD
 */

public interface FileIndexDao {
    /**
     * 插入数据
     * @param thing
     */
    void insert(Thing thing);

    /**
     * 根据condition条件进行数据库的检索
     */
    List<Thing> search(Condition condition);


}
