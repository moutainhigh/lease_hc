package com.hc.lease.common.core.file;

import com.hc.lease.common.core.exception.GMException;
import org.apache.commons.fileupload.FileUploadBase;

import java.io.IOException;

/**
 * 文件上传
 * Created by Tong on 2017/4/27.
 */
public interface UploadService {

    /**
     * base64方式上传图片
     *
     * @param base64string
     * @param allowFileType
     * @return
     * @throws IOException
     * @throws FileUploadBase.FileSizeLimitExceededException
     */
    public String base64UploadFile(String base64string, String[] allowFileType) throws GMException;

}
