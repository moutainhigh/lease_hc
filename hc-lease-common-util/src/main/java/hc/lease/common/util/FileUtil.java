package hc.lease.common.util;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Tong on 2017/4/27.
 */
public class FileUtil {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String[] IMAGE_EXTENSION = {"bmp", "gif", "jpg", "jpeg", "png"};

    public static final String[] FLASH_EXTENSION = {"swf", "flv"};

    public static final String[] MEDIA_EXTENSION = {"swf", "flv", "mp3", "wav", "wma", "wmv", "mid", "avi", "mpg", "asf", "rm", "rmvb"};

    /**
     * 文件上传 的大小 后缀名 限制
     *
     * @param filename         上传的文件
     * @param allowedExtension 文件类型 null 表示允许所有
     * @param maxSize          最大大小 字节为单位 -1表示不限制
     * @throws
     * @throws FileUploadBase.FileSizeLimitExceededException 如果超出最大大小
     */
    public static void limitSizeAndPrefixName(String filename, String[] allowedExtension, long maxSize, long size) throws FileUploadBase.FileSizeLimitExceededException {

        String extension = FilenameUtils.getExtension(filename);

        if (allowedExtension != null && !isAllowedExtension(extension, allowedExtension)) {
            if (allowedExtension == IMAGE_EXTENSION) {
                //throw new InvalidExtensionException.InvalidImageExtensionException(allowedExtension, extension, filename);
            } else if (allowedExtension == FLASH_EXTENSION) {
                //throw new InvalidExtensionException.InvalidFlashExtensionException(allowedExtension, extension, filename);
            } else if (allowedExtension == MEDIA_EXTENSION) {
                //throw new InvalidExtensionException.InvalidMediaExtensionException(allowedExtension, extension, filename);
            } else {
                //throw new InvalidExtensionException(allowedExtension, extension, filename);
            }
        }
        //long size = file.getSize();
        if (maxSize != -1 && size > maxSize) {
            throw new FileUploadBase.FileSizeLimitExceededException("not allowed upload upload", size, maxSize);
        }
    }

    /**
     * 日期路径 即年/月/日 如2013/01/03
     */
    public static String datePath(int type) {
        Date now = new Date();
        if (type == 1)
            return DateFormatUtils.format(now, "yyyy/MM/dd");
        else if (type == 2)
            return DateFormatUtils.format(now, "yyyy/MM");
        else if (type == 3)
            return DateFormatUtils.format(now, "yyyy-MM-dd");
        else
            return DateFormatUtils.format(now, "yyyy/MM/dd");

    }

    /**
     * 判断MIME类型是否是允许的MIME类型
     */
    public static boolean isAllowedExtension(String extension, String[] allowedExtension) {
        for (String str : allowedExtension) {
            if (str.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据系统规则得到图片名称
     */
    public static String getImageName() {
        return UUID.randomUUID().toString() + ".jpg";
    }

    /**
     * 检测文件夹目录是否存在
     * @param path
     */
    public static void checkFile(String path) {
        File f = new File(path);
        // 创建文件夹
        System.out.print("f.exists==="+f.exists());
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    /**
     * 检测文件大小 单位KB
     *
     * @param inputStream
     */
    public static long checkBase64FileSize(InputStream inputStream) {
        long fileLength = 0;
        try {
            fileLength = inputStream.available() / 1024;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLength;
    }

    /**
     * 写入文件到文件夹
     *  fileImgFolder = /data/web/images
     * @param inputStream
     * @param fileImgFolder
     * @param itemImgFolder
     * @return
     */
    public static String writeToFile(InputStream inputStream, String fileImgFolder, String itemImgFolder) {
        //filePathBack = account/yyyy-MM-dd/xx.jpg
        //filePath = /data/web/images/account/yyyy-MM-dd/xx.jpg
        String filePathBack = itemImgFolder + File.separator + datePath(3) + File.separator + getImageName();
        String filePath = fileImgFolder + filePathBack;
        try {
            // /data/web/images/account/yyyy-MM-dd
            System.out.print("checkFile=="+fileImgFolder + itemImgFolder + File.separator + datePath(3));
            checkFile(fileImgFolder + itemImgFolder + File.separator + datePath(3));
            File file = new File(filePath);
            byte[] buffer = new byte[1024];
            FileOutputStream out = new FileOutputStream(file);
            int byteread = 0;
            while ((byteread = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, byteread); // 文件写操作
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePathBack;

    }

    /**
     * 获取网络图片并转为Base64编码
     *
     * @param urls
     * @return
     * @throws Exception
     */
    public static String getUrlImageToBase64(String urls) {
        String str = null;
        if (StringUtils.isNoneEmpty(urls)) {
            StringBuffer sbf = new StringBuffer();
            if (urls.contains(",")) {
                String obj[] = urls.split(",");
                for (int i = 0; i < obj.length; i++) {
                    sbf.append(doUrlImageToBase64(obj[i])).append(",");
                    System.out.println();
                }
                str = sbf.toString().substring(0, sbf.toString().length() - 1);
            } else {
                str = doUrlImageToBase64(urls);
            }
        }
        return str;
    }

    /**
     * 获取网络图片并转为Base64编码
     *
     * @param url 网络图片路径
     * @return base64编码
     * @throws Exception
     */
    public static String doUrlImageToBase64(String url) {

        byte[] data = new byte[0];
        BASE64Encoder encoder = null;
        try {
            if (url == null || "".equals(url.trim()))
                return null;
            URL u = new URL(url);
            // 打开图片路径
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            // 设置请求方式为GET
            conn.setRequestMethod("GET");
            // 设置超时响应时间为5秒
            conn.setConnectTimeout(5000);
            // 通过输入流获取图片数据
            InputStream inStream = conn.getInputStream();
            // 读取图片字节数组
            data = new byte[inStream.available()];
            inStream.read(data);
            inStream.close();
            // 对字节数组Base64编码
            encoder = new BASE64Encoder();
            // 返回Base64编码过的字节数组字符串
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encoder.encode(data);
    }

}
