package com.lsx.everything.core.index;

import com.lsx.everything.core.dao.DataSourceFactory;
import com.lsx.everything.core.dao.impl.FileIndexDaoImpl;
import com.lsx.everything.core.index.impl.FileScanImpl;
import com.lsx.everything.core.interceptor.FileInterceptor;
import com.lsx.everything.core.interceptor.impl.FileIndexInterceptor;
import com.lsx.everything.core.interceptor.impl.FilePrintInterceptor;
import com.lsx.everything.core.model.Thing;

public interface FileScan {
    /**
     * 遍历path
     *
     *
     * @param path
     */
    void index(String path);

    /**
     * 遍历的拦截器
     *
     * @param interceptor
     */
    void interceptor(FileInterceptor interceptor);

    public static void main(String[] args) {

        FileScan scan = new FileScanImpl();
        FileInterceptor printInterceptor = new FilePrintInterceptor();
        scan.interceptor(printInterceptor);

        FileInterceptor fileInterceptor = new FileIndexInterceptor(new FileIndexDaoImpl(DataSourceFactory.dataSource()));
        scan.interceptor(fileInterceptor);

        scan.index("/Users/lsx/Desktop");
    }
//

}
