package com.lsx.everything.config;

import lombok.Getter;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Getter
public class Everything_lConfig {

    private static volatile Everything_lConfig config;

    private Set<String> includepath = new HashSet<>();//建立索引的路径
    private Set<String> excludepath = new HashSet<>();//排除索引的路径

    private Everything_lConfig(){

    }

    public static Everything_lConfig getInstance(){

        if(config == null){
            synchronized (Everything_lConfig.class){
                if(config == null){
                    config = new Everything_lConfig();

                    //1.获取文件系统
                    FileSystem fileSystem =FileSystems.getDefault();

                    //遍历的目录
                    Iterable<Path> iterable = fileSystem.getRootDirectories();
                    iterable.forEach(path -> config.getIncludepath().add(path.toString()));

                    //排除的目录
                    //windows   C:\Windows  C:\Program Files (x86)  C:\Program Files    C:\ProgramData

                    //linux     /tmp   /etc

                    //unix
                    String osname = System.getProperty("os.name");
                    if(osname.startsWith("Windows")){
                        config.getExcludepath().add("C:\\Windows");
                        config.getExcludepath().add("C:\\Program Files (x86)");
                        config.getExcludepath().add("C:\\Program Files");
                        config.getExcludepath().add("C:\\ProgramData");
                    }else {
                        config.getExcludepath().add("/tmp");
                        config.getExcludepath().add("/etc");
                    }

                }
            }
        }

        return config;
    }
}
