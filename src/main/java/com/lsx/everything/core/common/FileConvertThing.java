package com.lsx.everything.core.common;

import com.lsx.everything.core.model.FileType;
import com.lsx.everything.core.model.Thing;

import java.io.File;

/**
 * 辅助工具类：将File对象转换成Thing对象
 */

public final class FileConvertThing {

    private FileConvertThing(){}

    public static Thing covert(File file){
        Thing thing  = new Thing();
        thing.setName(file.getName());
        thing.setPath(file.getAbsolutePath());
        thing.setDepth(computeFileDepth(file));
        thing.setFileType(computeFileType(file));

        return thing;
    }

    private static int computeFileDepth(File file){
        int depth = 0;
        String[] segments =  file.getAbsolutePath().split(File.separator);
       //windows下 String[] segments =  file.getAbsolutePath().split("\\\\");
        depth = segments.length;
        return depth;
    }
    private static FileType computeFileType(File file){
        if(file.isDirectory()){
            return FileType.OTHER;
        }
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        if(index != -1 && index < fileName.length()-1){
            String extend = fileName.substring(index+1);//
            return FileType.lookup(extend);
        }else {
            return FileType.OTHER;
        }
    }

}
