package com.lsx.everything.core.index.impl;

import com.lsx.everything.config.Everything_lConfig;
import com.lsx.everything.core.dao.DataSourceFactory;
import com.lsx.everything.core.dao.impl.FileIndexDaoImpl;
import com.lsx.everything.core.index.FileScan;
import com.lsx.everything.core.interceptor.FileInterceptor;
import com.lsx.everything.core.interceptor.impl.FileIndexInterceptor;
import com.lsx.everything.core.interceptor.impl.FilePrintInterceptor;
import com.lsx.everything.core.model.Thing;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileScanImpl implements FileScan {

    private Everything_lConfig config = Everything_lConfig.getInstance();

    private LinkedList<FileInterceptor> interceptors = new LinkedList<>();

    @Override
    public void index(String path) {
        File file = new File(path);
       // List<File> fileList = new ArrayList<>();

        if(file.isFile()){
            if(config.getExcludepath().contains(file.getParent())) {
                return;
            }
        }else {
            if(config.getExcludepath().contains(path)) {
                return;
            }else {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        index(f.getAbsolutePath());
                    }
                }
            }
        }
        //File Directory
        for (FileInterceptor interceptor:this.interceptors) {
            interceptor.apply(file);
        }
    }

    public void addFileInterceptor(FileInterceptor fileInterceptor){
        this.interceptors.add(fileInterceptor);
    }

    public static void main(String[] args) {
        FileScanImpl scan = new FileScanImpl();
        FileInterceptor printInterceptor = new FilePrintInterceptor();
        scan.addFileInterceptor(printInterceptor);

        FileInterceptor fileInterceptor = new FileIndexInterceptor(new FileIndexDaoImpl(DataSourceFactory.dataSource()));
        scan.addFileInterceptor(fileInterceptor);

        scan.index("/Users/lsx/Desktop");
    }
}
