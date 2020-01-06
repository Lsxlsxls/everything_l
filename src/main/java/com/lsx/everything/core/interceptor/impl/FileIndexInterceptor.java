package com.lsx.everything.core.interceptor.impl;

import com.lsx.everything.core.common.FileConvertThing;
import com.lsx.everything.core.dao.FileIndexDao;
import com.lsx.everything.core.interceptor.FileInterceptor;
import com.lsx.everything.core.model.Thing;

import java.io.File;

public class FileIndexInterceptor implements FileInterceptor {

    private final FileIndexDao fileIndexDao;

    public FileIndexInterceptor(FileIndexDao fileIndexDao) {
        this.fileIndexDao = fileIndexDao;
    }

    @Override
    public void apply(File file) {
        Thing thing = FileConvertThing.covert(file);
        System.out.println("Thing-->"+ thing);
        fileIndexDao.insert(thing);
    }
}
