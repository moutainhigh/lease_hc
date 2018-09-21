package com.hc.lease.common.core.file;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import hc.lease.common.util.FileUtil;
import hc.lease.common.util.ImgBase64;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 图片base64方式上传
 * Created by tong on 2017/6/14.
 */
public class UploadFileUtil {

    /**
     * 处理多个图片拼接,用逗号隔开
     *
     * @param imgs
     * @return
     * @throws GMException
     */
    public static String dualImgs(List<String> imgs, String maxSize, String fileImgFolder, String itemImgFolder, String imgUrl) throws GMException {
        StringBuffer str = new StringBuffer();
        String strBack = null;
        if (imgs != null) {
            if (imgs.size() > 0) {
                for (String img : imgs) {
                    String filePath = base64UploadFile(img, FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, itemImgFolder, imgUrl);
                    str.append(filePath).append(",");
                }
                strBack = str.toString().substring(0, str.length() - 1);
            }
        }
        return strBack;
    }

    /**
     * base64方式上传图片
     *
     * @param base64string
     * @param allowFileType 文件类型限制
     * @return
     * @throws IOException
     * @throws FileUploadBase.FileSizeLimitExceededException
     */
    public static String base64UploadFile(String base64string, String[] allowFileType, String maxSize, String fileImgFolder, String itemImgFolder, String imgUrl) throws GMException {
        String filePath = "";
        if (StringUtils.isNoneEmpty(base64string)) {
            //如果是url则是更新提交的数据/如果是base64则是新增提交的数据
            if (!base64OrUrl(base64string, imgUrl)) {
                InputStream inputStream = ImgBase64.byteToInputStream(base64string);//图片base64转InputStream
                long fileLength = FileUtil.checkBase64FileSize(inputStream);
                if (fileLength > Long.parseLong(maxSize)) {
                    throw new GMException(GMExceptionConstant.UPLOAD_IMG_SIZE);
                }
                filePath = FileUtil.writeToFile(inputStream, fileImgFolder, itemImgFolder);
            } else {
                filePath = base64string.substring(imgUrl.length(), base64string.length());
            }
        }
        return filePath;
    }

    /**
     * 字符串 是 url 或者 base64
     * 如果是url则是更新提交的数据
     * 如果是base64则是新增提交的数据
     *
     * @param str
     * @return
     */
    public static Boolean base64OrUrl(String str, String imgUrl) {
        if (str.contains(imgUrl)) {
            return true;
        }
        return false;
    }

}
