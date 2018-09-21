package com.hc.lease.common.core.file;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import hc.lease.common.util.FileUtil;
import hc.lease.common.util.ImgBase64;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传
 * Created by Tong on 2017/4/27.
 */

@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径

    /**
     * base64方式上传图片
     *
     * @param base64string
     * @param allowFileType 文件类型限制
     * @return
     * @throws IOException
     * @throws FileUploadBase.FileSizeLimitExceededException
     */
    public String base64UploadFile(String base64string, String[] allowFileType) throws GMException {
        String filePath = "";
        if (StringUtils.isNoneEmpty(base64string)) {
            InputStream inputStream = ImgBase64.byteToInputStream(base64string);//图片base64转InputStream
            long fileLength = FileUtil.checkBase64FileSize(inputStream);
            if (fileLength > Long.parseLong(maxSize)) {
                throw new GMException(GMExceptionConstant.UPLOAD_IMG_SIZE);
            }
            filePath = FileUtil.writeToFile(inputStream, fileImgFolder, null);
        }
        return filePath;
    }

}
