package com.lsx.everything.core.search;

import com.lsx.everything.core.dao.DataSourceFactory;
import com.lsx.everything.core.dao.impl.FileIndexDaoImpl;
import com.lsx.everything.core.model.Condition;
import com.lsx.everything.core.model.Thing;
import com.lsx.everything.core.search.impl.FileSearchImpl;

import java.util.List;

public interface FileSearch {
    /**
     * 根据condition条件进行数据库的检索
     */
    List<Thing> search(Condition condition);
//
//    public static void main(String[] args) {
//        FileSearch fileSearch = new FileSearchImpl(new FileIndexDaoImpl(DataSourceFactory.dataSource()));
//        List<Thing> list = fileSearch.search(new Condition());
//        System.out.println(list);
//
//    }
}
