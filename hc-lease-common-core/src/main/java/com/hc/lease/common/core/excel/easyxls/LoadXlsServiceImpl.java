package com.hc.lease.common.core.excel.easyxls;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 导入excel
 * Created by tong on 2017/5/31.
 */
public class LoadXlsServiceImpl {

    public String loadXls(HttpServletRequest request, RedirectAttributes redirectAttributes) throws GMException {
        String path;
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile mFile = multipartRequest.getFile("file");
            path = LoadXlsServiceImpl.class.getResource("/").getPath() + "temp.xls";
            String extension = FilenameUtils.getExtension(mFile.getOriginalFilename());
            if (!extension.equals("xls")) {
                throw new GMException(GMExceptionConstant.UPLOAD_EXCEL);
            }
            long size = mFile.getSize();
            if (size > 1024 * 1024 * 50) {
                throw new GMException(GMExceptionConstant.UPLOAD_EXCEL_SIZE);
            }
            InputStream inputStream = mFile.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(path);
            byte[] b = new byte[1024];
            while ((inputStream.read(b)) != -1) {
                outputStream.write(b);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new GMException(GMExceptionConstant.EXCEL_FAILE_UPLOAD);
        }
        try {
            String configPath = LoadXlsServiceImpl.class.getResource("/OrderSigned.xml").getPath();
            List list = EasyXls.xls2List(configPath, new File(path));

            return "";
        } catch (Exception e) {
            e.printStackTrace();
            throw new GMException(GMExceptionConstant.EXCEL_FORMAT_ERROR);
        }
    }

}
