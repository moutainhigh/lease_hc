package com.hc.lease.common.core.excel.easyxls.common;

import com.hc.lease.common.core.excel.easyxls.bean.ExcelConfig;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Excel导入导出处理
 *
 * @author tong
 */
public class ImportExportUtil {

    /**
     * 处理公共导出/导出excel
     * 模板、带表头的空EXCEL
     * 没有数据
     *
     * @param response
     * @param config              导出设置
     * @param filePath            导出路径
     * @param fileName            导出文件名
     * @param setDateVerification 是否设置行数据有效性的单元格
     */
    public synchronized static void exportExcelCommonModel(HttpServletRequest request, HttpServletResponse response, ExcelConfig config, String filePath, String fileName, Map params, boolean setDateVerification, String excelExportFile) {

        try {
            boolean b = XlsUtil.getExcelModel(config, excelExportFile + "/export/", filePath, params, setDateVerification);
            String fileUrl = excelExportFile + "/export/" + filePath;
            dualExportExcelCommon(request, response, fileName, b, fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 处理公共导出/处理数据到excel
     * 只创建一个sheet
     * 有数据
     *
     * @param list                导出数据
     * @param response
     * @param config              导出设置
     * @param filePath            导出路径
     * @param fileName            导出文件名
     * @param params              数据验证数据
     * @param setDateVerification 是否有数据验证
     * @param excelExportFile
     */
    public synchronized static void exportExcelCommon(HttpServletRequest request, List<?> list, HttpServletResponse response, ExcelConfig config, String filePath, String fileName, Map params, boolean setDateVerification, String excelExportFile) {

        try {
            if (list.size() < 1) {
                response.reset();
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print("没有数据");
                out.close();
                return;
            }
            boolean b = XlsUtil.list2Xls(config, list, excelExportFile + "/export/", filePath, params, setDateVerification);
            String fileUrl = excelExportFile + "/export/" + filePath;
            System.out.println("======1==========");
            dualExportExcelCommon(request, response, fileName, b, fileUrl);
            System.out.println("======2==========");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * excel导入后需要下载导入结果、先将结果以Excel文件放到服务器提供下载
     * 只创建一个sheet
     *
     * @param list     导出数据
     * @param response
     * @param config   导出设置
     * @param filePath 导出路径
     */
    public synchronized static void exportExcelCommonProvideDownload(List<?> list, HttpServletResponse response, ExcelConfig config, String filePath, Map params, boolean setDateVerification, String excelExportFile) {
        try {
            boolean b = XlsUtil.list2Xls(config, list, excelExportFile + "/export/", filePath, params, setDateVerification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * excel导入后需要下载导入结果、先将结果以Excel文件放到服务器提供下载
     * 只创建两个sheet
     *
     * @param list_1
     * @param list_2
     * @param response
     * @param config_1
     * @param config_2
     * @param filePath
     * @param excelExportFile
     */
    public synchronized static void exportExcelCommonProvideDownloadTwoSheet(List<?> list_1, List<?> list_2, HttpServletResponse response, ExcelConfig config_1, ExcelConfig config_2, String filePath, Map params, boolean setDateVerification, String excelExportFile) {
        try {
            boolean b = XlsUtil.list2XlsTwoSheet(config_1, config_2, list_1, list_2, excelExportFile + "/export/", filePath, params, setDateVerification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * excel导入后需要下载导入结果、先将结果以Excel文件放到服务器提供下载
     * 只创建三个sheet
     *
     * @param list_1
     * @param list_2
     * @param response
     * @param config_1
     * @param config_2
     * @param filePath
     * @param excelExportFile
     */
    public synchronized static void exportExcelCommonProvideDownloadThreeSheet(List<?> list_1, List<?> list_2, List<?> list_3, HttpServletResponse response, ExcelConfig config_1, ExcelConfig config_2, ExcelConfig config_3, String filePath, Map params, boolean setDateVerification, String excelExportFile) {
        try {
            boolean b = XlsUtil.list2XlsThreeSheet(config_1, config_2, config_3, list_1, list_2, list_3, excelExportFile + "/export/", filePath, params, setDateVerification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 模板
     * 处理公共导出/处理数据到excel
     * 小程序车辆导出
     * 创建两个sheet
     * 一个sheet装车辆数据、一个sheet装车辆方案数据
     *
     * @param list_1   导出数据
     * @param response
     * @param config_1 导出设置
     * @param config_2 导出设置
     * @param filePath 导出路径
     * @param fileName 导出文件名
     */
    public synchronized static void wxCarExportExcelCommon(HttpServletRequest request,List<?> list_1, List<?> list_2, HttpServletResponse response, ExcelConfig config_1, ExcelConfig config_2, String filePath, String fileName, Map params, boolean setDateVerification, String excelExportFile) {

        try {
            if (list_1.size() < 1) {
                response.reset();
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print("没有数据");
                out.close();
                return;
            }
            boolean b = XlsUtil.list2XlsTwoSheet(config_1, config_2, list_1, list_2, excelExportFile + "/export/", filePath, params, setDateVerification);

            String fileUrl = excelExportFile + "/export/" + filePath;
            dualExportExcelCommon(request,response, fileName, b, fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 模板
     * 处理公共导出/处理数据到excel
     * 小程序车辆导出
     * 创建两个sheet
     * 一个sheet装车辆数据、一个sheet装车辆方案数据
     *
     * @param list_1   导出数据
     * @param response
     * @param config_1 导出设置
     * @param config_2 导出设置
     * @param filePath 导出路径
     * @param fileName 导出文件名
     */
    public synchronized static void wxCarExportExcelCommons(HttpServletRequest request, List<?> list_1, List<?> list_2, List<?> list_3, HttpServletResponse response, ExcelConfig config_1, ExcelConfig config_2, ExcelConfig config_3, String filePath, String fileName, Map params, boolean setDateVerification, String excelExportFile) {

        try {
            if (list_1.size() < 1) {
                response.reset();
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print("没有数据");
                out.close();
                return;
            }
            boolean b = XlsUtil.list2XlsThreeSheet(config_1, config_2, config_3, list_1, list_2, list_3, excelExportFile + "/export/", filePath, params, setDateVerification);

            String fileUrl = excelExportFile + "/export/" + filePath;
            dualExportExcelCommon(request, response, fileName, b, fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 处理公共导出/输出文件
     *
     * @param response
     * @param fileName 导出的文件名
     * @param b
     * @param fileUrl  文件存放服务器路径
     */
    public synchronized static void dualExportExcelCommon(HttpServletRequest request, HttpServletResponse response, String fileName, boolean b, String fileUrl) {
        try {
            if (b) {
                File file = new File(fileUrl);
                BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
                byte[] buf = new byte[1024];
                int len;

                /*
                fileName = new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xls";
                response.reset();
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-disposition", "attachment;filename=" + fileName);
                */
                response = checkBrowserType(request, response, fileName);

                OutputStream outStream = response.getOutputStream();
                while ((len = br.read(buf)) > 0)
                    outStream.write(buf, 0, len);
                br.close();
                outStream.close();
                //清除文件
                if (file.exists()) {
                    file.delete();
                }
                //清除文件
            }
        } catch (Exception e) {

            try {
                response.reset();
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print("系统繁忙,请联系管理员");
                out.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        }

    }

    /**
     * excel导入后结果以Excel文件放到服务器提供下载
     * excel导入后需要下载导入结果、先将结果以Excel文件放到服务器提供下载
     *
     * @param response
     * @param filePath 导出路径
     */
    public synchronized static void dualExportExcelCommonProvideDownload(HttpServletResponse response, String filePath, boolean b, String excelExportFile) {
        try {
            if (b) {
                File file = new File(excelExportFile + "/export/" + filePath);
                BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
                byte[] buf = new byte[1024];
                int len;
                OutputStream outStream = response.getOutputStream();
                while ((len = br.read(buf)) > 0)
                    outStream.write(buf, 0, len);
                br.close();
                outStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检测浏览器，设置Excel导出
     *
     * @param request
     * @param response
     * @param fileName
     */
    public synchronized static HttpServletResponse checkBrowserType(HttpServletRequest request, HttpServletResponse response, String fileName) {
        String userAgent = request.getHeader("USER-AGENT");
        try {
            String finalFileName = null;
            if (StringUtils.contains(userAgent, "MSIE")) {//IE浏览器
                finalFileName = URLEncoder.encode(fileName, "UTF8") + ".xls";
            } else if (StringUtils.contains(userAgent, "Mozilla")) {//google,火狐浏览器
                finalFileName = new String(fileName.getBytes(), "ISO8859-1") + ".xls";
            } else {
                finalFileName = URLEncoder.encode(fileName, "UTF8") + ".xls";//其他浏览器
            }
            response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\"");//这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开
            response.setContentType("application/vnd.ms-excel");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
