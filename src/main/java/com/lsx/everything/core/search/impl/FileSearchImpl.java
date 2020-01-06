package com.lsx.everything.core.search.impl;

import com.lsx.everything.core.dao.FileIndexDao;
import com.lsx.everything.core.model.Condition;
import com.lsx.everything.core.model.Thing;
import com.lsx.everything.core.search.FileSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务层
 */
public class FileSearchImpl implements FileSearch {


    private final FileIndexDao fileIndexDao;

    public FileSearchImpl(FileIndexDao fileIndexDao) {
        this.fileIndexDao = fileIndexDao;
    }

    @Override
    public List<Thing> search(Condition condition) {

        return this.fileIndexDao.search(condition);
    }
}
