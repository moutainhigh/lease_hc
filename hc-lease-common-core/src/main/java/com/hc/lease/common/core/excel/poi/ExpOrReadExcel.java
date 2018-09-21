package com.hc.lease.common.core.excel.poi;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import com.hc.lease.common.core.excel.poi.vo.CostCheckTemplate;
import com.hc.lease.common.core.excel.poi.vo.MonthlyRentTemplate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/20<br/>
 * 说明：Excel导入、导出
 */
public class ExpOrReadExcel {
    private static Logger logger = LoggerFactory.getLogger(ExpOrReadExcel.class);
    /**
     * excel模板导出
     *
     * @param path   xml模板路径
     * @param expUrl excel模板导出路径
     */
    public static void expExcelTemplate(HttpServletResponse response, String path, String expUrl) {
        File file = new File(path);
        try (InputStream is = new FileInputStream(file)) {
            expExcelTemplate(response, expUrl, is, null);
        } catch (IOException e) {
            logger.info(e.getMessage(), e);
        }
    }

    /**
     * excel模板导出
     *
     * @param expUrl excel模板导出路径
     * @param inputSteam xml模板
     */
    public static void expExcelTemplate(HttpServletResponse response, String expUrl, InputStream inputSteam, String osAndBrowserInfo) {
        expExcelTemplate(response, expUrl, inputSteam, null, osAndBrowserInfo);
    }

    /**
     * excel模板导出
     *  @param expUrl excel模板导出路径
     * @param inputSteam xml模板
     */
    public static void expExcelTemplate(HttpServletResponse response, String expUrl, InputStream inputSteam, List<CostCheckTemplate> costCheckTemplates, String osAndBrowserInfo) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            // 解析xml文件
            Document parse = saxBuilder.build(inputSteam);
            // 创建Excel
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 获取xml文件根节点
            Element root = parse.getRootElement();
            // 获取模板名称
            String templateName = root.getAttribute("name").getValue();
            // 获取所有sheet节点
            List<Element> sheets = root.getChildren("sheet");
            for (Element sheetRoot : sheets) {
                // 获取sheet节点名称
                String sheetRootName = sheetRoot.getAttribute("name").getValue();
                // 创建sheet
                HSSFSheet sheet = workbook.createSheet(sheetRootName);

                // 设置列宽
                Element colgroup = sheetRoot.getChild("colgroup");
                if (colgroup != null) {
                    setColumnWidth(sheet, colgroup);
                }

                Integer rowNum = 0;

                // 设置标题
                Element title = sheetRoot.getChild("title");
                if (title != null) {
                    rowNum = setTitle(workbook, sheet, title, rowNum);
                }

                // 设置表头
                Element thead = sheetRoot.getChild("thead");
                rowNum = setThead(sheet, thead, rowNum);

                // 追加数据
                if (costCheckTemplates != null && costCheckTemplates.size() > 0) {
                    int totalCellNum = sheet.getRow(0).getLastCellNum();
                    addData(sheet, rowNum, totalCellNum, costCheckTemplates);
                }


                // 设置数据区域样式
                Element tbody = sheetRoot.getChild("tbody");
                if (tbody != null) {
                    setTbody(workbook, sheet, tbody, rowNum);
                }


                // 生成Excel导入模板
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                System.out.println("excel模板导出tempFile=url==="+expUrl + templateName + dateFormat.format(new Date()) + ".xls");
                File tempFile = new File(expUrl + templateName + dateFormat.format(new Date()) + ".xls");
                if (!tempFile.exists()) {
                    tempFile.mkdirs();
                }
                tempFile.delete();
                tempFile.createNewFile();
                logger.info("excel模板导出response==="+response);
                System.out.println("excel模板导出response==="+response);

                String responseHeader = URLEncoder.encode(templateName + dateFormat.format(new Date()) + ".xls", "utf-8");
                if(osAndBrowserInfo.contains("Firefox")){
                    responseHeader = new String((templateName + dateFormat.format(new Date()) + ".xls").getBytes("UTF-8"), "ISO-8859-1");
                }

                if (response == null) {
                    logger.info("===excel模板导出response===");
                    System.out.println("===excel模板导出response===");
                    FileOutputStream stream = FileUtils.openOutputStream(tempFile);
                    workbook.write(stream);
                    stream.close();
                } else {
                    response.reset();
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-disposition", "attachment;filename="+ responseHeader);
                    OutputStream stream = response.getOutputStream();
                    workbook.write(stream);
                    stream.close();
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            System.out.println("===excel模板导出e.getMessage()==="+e.getMessage());
        }
    }

    private static void addData(HSSFSheet sheet, int rowNum, int totalCellNum, List<CostCheckTemplate> costCheckTemplates) {
        for (CostCheckTemplate costCheckTemplate : costCheckTemplates) {
            HSSFRow nextRow = sheet.createRow(rowNum);
            for (int i = 0; i < totalCellNum; i++) {
                HSSFCell cell = nextRow.createCell(i);
                switch (i) {
                    case 0 : cell.setCellValue(StringUtils.isEmpty(costCheckTemplate.getCardFrameNumber()) ? "" : costCheckTemplate.getCardFrameNumber());break;
                    case 1 : cell.setCellValue(costCheckTemplate.getInvoicedCarPrice() == null ? "" : costCheckTemplate.getInvoicedCarPrice().toString());break;
                    case 2 : cell.setCellValue(costCheckTemplate.getPurchaseTax() == null ? "" : costCheckTemplate.getPurchaseTax().toString());break;
                    case 3 : cell.setCellValue(StringUtils.isEmpty(costCheckTemplate.getInvoiceNumber()) ? "" : costCheckTemplate.getInvoiceNumber());break;
                    case 4 : cell.setCellValue(StringUtils.isEmpty(costCheckTemplate.getUpdateState()) ? "" : costCheckTemplate.getUpdateState());break;
                    default: logger.info("字段数量不匹配！");break;
                }
            }
            rowNum ++;
        }

    }

    /**
     * excel数据导入
     * @param excelFile excel文件
     * @param xmlFile xml配置文件
     * @param cla 存放实体类（实体类为单类，里面不允许存在其他实体类）
     */
    public static <T> List readExcelTemplate(InputStream excelFile, InputStream xmlFile, T cla) throws Exception {
        List<T> dateList = new ArrayList<>();
        try {
            // 创建excel，读取文件内容
            HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
            // 解析xml文件
            SAXBuilder saxBuilder = new SAXBuilder();
            Document parse = saxBuilder.build(xmlFile);
            // 获取xml文件根节点
            Element root = parse.getRootElement();
            // 获取excel工作表数量
            int sheetNum = workbook.getNumberOfSheets();
            if (sheetNum > 0) {
                for (int i = 0; i < sheetNum; i++) {

                    HSSFSheet sheet = workbook.getSheetAt(i);
                    // 获取工作表名称
                    String sheetName = sheet.getSheetName();

                    Field[] declaredFields = ((Class) cla).getDeclaredFields();
                    Map<String, String> fileMap = new HashMap<>();
                    Map<Integer, String> fileIndexMap = new HashMap<>();
                    for (Field field : declaredFields) {
                        CostCheckExcelCol annotation = field.getAnnotation(CostCheckExcelCol.class);
                        fileMap.put(annotation.value(), field.getName());
                    }

                    // 获取所有xml sheet节点
                    List<Element> xmlSheets = root.getChildren("sheet");
                    Element xmlSheetRoot = xmlSheets.get(i);
                    // 获取sheet节点名称
                    String xmlSheetRootName = xmlSheetRoot.getAttribute("name").getValue();
                    // 判断是否是同一个工作表
                    if (sheetName.equals(xmlSheetRootName)) {
                        // 获取sheet中最后一行的行号
                        int lastRowNum = sheet.getLastRowNum();
                        for (int j = 0; j <= lastRowNum; j++) {
                            HSSFRow row = sheet.getRow(j);
                            // 获取当前行最后单元行列好
                            int lastCellNum = sheet.getRow(0).getLastCellNum();

                            // 设置表头
                            Element thead = xmlSheetRoot.getChild("thead");
                            List<Element> trs = thead.getChildren("tr");
                            List<Element> ths = trs.get(0).getChildren("th");
                            int xmlLastCellNum = ths.size();
                            // 判断xml列数与excel列数是否相符
                            if (lastCellNum == xmlLastCellNum) {
                                T obj = (T) ((Class) cla).newInstance();
                                for (int k = 0; k < lastCellNum; k++) {
                                    HSSFCell cell = row.getCell(k);

                                    if (0 == j) {
                                        String s = fileMap.get(cell.getStringCellValue());
                                        fileIndexMap.put(k, s);

                                    }else{
                                        String fileName = fileIndexMap.get(k);
                                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fileName, ((Class) cla));
                                        if (cell == null) {
                                            continue;
                                        }
                                        String a = propertyDescriptor.getPropertyType().getName();
                                        String b = getStringCellValue(cell).getClass().getName();
                                        if (!a.equals(b)) {
                                            propertyDescriptor.getWriteMethod().invoke(obj, new BigDecimal(cell.getNumericCellValue()).setScale(0,BigDecimal.ROUND_HALF_UP).toString());
                                        } else {
                                            propertyDescriptor.getWriteMethod().invoke(obj, getStringCellValue(cell));
                                        }
                                    }
                                 }
                                 if (0 != j) {
                                     dateList.add(obj);
                                 }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            throw new Exception(e);
        }
        return dateList;
    }

    /**
     * 设置列宽
     *
     * @param sheet    工作表
     * @param colgroup 列宽节点
     */
    private static void setColumnWidth(HSSFSheet sheet, Element colgroup) {
        List<Element> cols = colgroup.getChildren("col");
        for (int i = 0; i < cols.size(); i++) {
            Element col = cols.get(i);
            Attribute width = col.getAttribute("width");
            String unit = width.getValue().replaceAll("[0-9,\\.]", "");
            String value = width.getValue().replaceAll(unit, "");
            int v = 0;
            if (StringUtils.isBlank(unit) || "px".endsWith(unit)) {
                v = Math.round(Float.parseFloat(value) * 37F);
            } else if ("em".endsWith(unit)) {
                v = Math.round(Float.parseFloat(value) * 267.5F);
            }
            sheet.setColumnWidth(i, v);
        }
    }

    /**
     * 设置标题
     *
     * @param workbook excel
     * @param sheet    工作表
     * @param title    标题节点
     * @param rowNum   行数
     */
    private static Integer setTitle(HSSFWorkbook workbook, HSSFSheet sheet, Element title, Integer rowNum) {
        try {
            List<Element> trs = title.getChildren("tr");
            for (Element tr : trs) {
                List<Element> tds = tr.getChildren("td");
                HSSFRow row = sheet.createRow(rowNum);
                // 定义单元格样式
                HSSFCellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                for (Integer colNum = 0; colNum < tds.size(); colNum++) {
                    Element td = tds.get(colNum);
                    HSSFCell cell = row.createCell(colNum);
                    Attribute rowSpan = td.getAttribute("rowspan");
                    Attribute colSpan = td.getAttribute("colspan");
                    Attribute value = td.getAttribute("value");
                    if (value != null) {
                        String val = value.getValue();
                        cell.setCellValue(val);
                        int rspan = rowSpan.getIntValue() - 1;
                        int cspan = colSpan.getIntValue() - 1;
                        // 设置字体
                        HSSFFont font = workbook.createFont();
                        font.setFontName("仿宋_GB2312");
                        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 字体加粗
                        font.setFontHeightInPoints((short) 12);
                        cellStyle.setFont(font);
                        cell.setCellStyle(cellStyle);

                        // 合并单元格
                        sheet.addMergedRegion(new CellRangeAddress(rspan, rspan, 0, cspan));
                    }
                }
                rowNum++;
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return rowNum;
    }

    /**
     * 设置表头
     *
     * @param sheet  工作表
     * @param thead  表头节点
     * @param rowNum 行数
     */
    private static Integer setThead(HSSFSheet sheet, Element thead, Integer rowNum) {
        List<Element> trs = thead.getChildren("tr");
        for (Element tr : trs) {
            HSSFRow row = sheet.createRow(rowNum);
            List<Element> ths = tr.getChildren("th");
            for (int colNum = 0; colNum < ths.size(); colNum++) {
                Element th = ths.get(colNum);
                Attribute valueAttr = th.getAttribute("value");
                HSSFCell cell = row.createCell(colNum);
                if (valueAttr != null) {
                    String value = valueAttr.getValue();
                    cell.setCellValue(value);
                }
            }
            rowNum++;
        }
        return rowNum;
    }

    /**
     * 设置数据区域样式
     *
     * @param workbook excel
     * @param sheet    工作表
     * @param tbody    数据节点
     * @param rowNum   行数
     */
    private static void setTbody(HSSFWorkbook workbook, HSSFSheet sheet, Element tbody, Integer rowNum) {
        try {
            Element tr = tbody.getChild("tr");
            // 初始化数据有多少行
            int repeat = tr.getAttribute("repeat").getIntValue();
            List<Element> tds = tr.getChildren("td");
            for (int i = 0; i < repeat; i++) {
                HSSFRow row = sheet.createRow(rowNum);
                for (int colNum = 0; colNum < tds.size(); colNum++) {
                    Element td = tds.get(colNum);
                    HSSFCell cell = row.createCell(colNum);
                    // 设置单元格样式
                    setType(workbook, sheet, cell, td);
                }
                rowNum++;
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
    }

    /**
     * 设置单元格样式
     *
     * @param workbook excel
     * @param sheet    工作表
     * @param cell     单元格
     * @param td       td节点
     */
    private static void setType(HSSFWorkbook workbook, HSSFSheet sheet, HSSFCell cell, Element td) {
        Attribute typeAttr = td.getAttribute("type");
        String type = typeAttr.getValue();
        // 定义格式化
        HSSFDataFormat format = workbook.createDataFormat();
        // 定义单元格样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        if ("NUMERIC".equalsIgnoreCase(type)) {
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            Attribute formatAttr = td.getAttribute("format");
            String formatValue = formatAttr.getValue();
            formatValue = StringUtils.isNoneBlank(formatValue) ? formatValue : "";
            cellStyle.setDataFormat(format.getFormat(formatValue));
        } else if ("STRING".equalsIgnoreCase(type)) {
            cell.setCellValue("");
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellStyle.setDataFormat(format.getFormat("@"));
        } else if ("DATE".equalsIgnoreCase(type)) {
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
        } else if ("ENUM".equalsIgnoreCase(type)) {
            CellRangeAddressList regions = new CellRangeAddressList(cell.getRowIndex(), cell.getRowIndex(), cell.getColumnIndex(), cell.getColumnIndex());
            Attribute enumAttr = td.getAttribute("format");
            String enumValue = enumAttr.getValue();
            // 加载下拉列表内容
            DVConstraint constraint = DVConstraint.createExplicitListConstraint(enumValue.split(","));
            // 数据有效性对象
            HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
            sheet.addValidationData(dataValidation);
        }
        cell.setCellStyle(cellStyle);
    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     * @param cell Excel单元格
     */
    private static Object getStringCellValue(HSSFCell cell) {
        Object strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = new BigDecimal(cell.getNumericCellValue()).setScale(2,BigDecimal.ROUND_HALF_UP);
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = cell.getBooleanCellValue();
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        return strCell;
    }



    /**
     * excel模板导出
     *  @param expUrl excel模板导出路径
     * @param inputSteam xml模板
     */
    public static void expMonthlyRentExcelTemplate(HttpServletResponse response, String expUrl, InputStream inputSteam, List<MonthlyRentTemplate> monthlyRentTemplates, String osAndBrowserInfo) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            // 解析xml文件
            Document parse = saxBuilder.build(inputSteam);
            // 创建Excel
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 获取xml文件根节点
            Element root = parse.getRootElement();
            // 获取模板名称
            String templateName = root.getAttribute("name").getValue();
            // 获取所有sheet节点
            List<Element> sheets = root.getChildren("sheet");
            for (Element sheetRoot : sheets) {
                // 获取sheet节点名称
                String sheetRootName = sheetRoot.getAttribute("name").getValue();
                // 创建sheet
                HSSFSheet sheet = workbook.createSheet(sheetRootName);

                // 设置列宽
                Element colgroup = sheetRoot.getChild("colgroup");
                if (colgroup != null) {
                    setColumnWidth(sheet, colgroup);
                }

                Integer rowNum = 0;

                // 设置标题
                Element title = sheetRoot.getChild("title");
                if (title != null) {
                    rowNum = setTitle(workbook, sheet, title, rowNum);
                }

                // 设置表头
                Element thead = sheetRoot.getChild("thead");
                rowNum = setThead(sheet, thead, rowNum);

                // 追加数据
                if (monthlyRentTemplates != null && monthlyRentTemplates.size() > 0) {
                    int totalCellNum = sheet.getRow(0).getLastCellNum();
                    addMonthlyRentData(sheet, rowNum, totalCellNum, monthlyRentTemplates);
                }


                // 设置数据区域样式
                Element tbody = sheetRoot.getChild("tbody");
                if (tbody != null) {
                    setTbody(workbook, sheet, tbody, rowNum);
                }


                // 生成Excel导入模板
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                System.out.println("excel模板导出tempFile=url==="+expUrl + templateName + dateFormat.format(new Date()) + ".xls");
                File tempFile = new File(expUrl + templateName + dateFormat.format(new Date()) + ".xls");
                if (!tempFile.exists()) {
                    tempFile.mkdirs();
                }
                tempFile.delete();
                tempFile.createNewFile();
                logger.info("excel模板导出response==="+response);
                System.out.println("excel模板导出response==="+response);

                String responseHeader = URLEncoder.encode(templateName + dateFormat.format(new Date()) + ".xls", "utf-8");
                if(osAndBrowserInfo.contains("Firefox")){
                    responseHeader = new String((templateName + dateFormat.format(new Date()) + ".xls").getBytes("UTF-8"), "ISO-8859-1");
                }

                if (response == null) {
                    logger.info("===excel模板导出response===");
                    System.out.println("===excel模板导出response===");
                    FileOutputStream stream = FileUtils.openOutputStream(tempFile);
                    workbook.write(stream);
                    stream.close();
                } else {
                    response.reset();
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-disposition", "attachment;filename="+ responseHeader);
                    OutputStream stream = response.getOutputStream();
                    workbook.write(stream);
                    stream.close();
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            System.out.println("===excel模板导出e.getMessage()==="+e.getMessage());
        }
    }

    private static void addMonthlyRentData(HSSFSheet sheet, int rowNum, int totalCellNum, List<MonthlyRentTemplate> monthlyRentTemplates) {
        for (MonthlyRentTemplate monthlyRentTemplate : monthlyRentTemplates) {
            HSSFRow nextRow = sheet.createRow(rowNum);
            for (int i = 0; i < totalCellNum; i++) {
                HSSFCell cell = nextRow.createCell(i);
                switch (i) {
                    case 0 : cell.setCellValue(StringUtils.isEmpty(monthlyRentTemplate.getContractNumber()) ? "" : monthlyRentTemplate.getContractNumber());break;
                    case 1 : cell.setCellValue(monthlyRentTemplate.getAccount() == null ? "" : monthlyRentTemplate.getAccount());break;
                    case 2 : cell.setCellValue(monthlyRentTemplate.getPhone() == null ? "" : monthlyRentTemplate.getPhone());break;
                    case 3 : cell.setCellValue(monthlyRentTemplate.getPayDate());break;
                    case 4 : cell.setCellValue(monthlyRentTemplate.getPeriod());break;
                    case 5 : cell.setCellValue(monthlyRentTemplate.getMonthlyRent() == null ? "" : monthlyRentTemplate.getMonthlyRent().toString());break;
                    case 6 : cell.setCellValue(monthlyRentTemplate.getIdCard() == null ? "" : monthlyRentTemplate.getIdCard());break;
                    case 7 : cell.setCellValue(monthlyRentTemplate.getBankCode() == null ? "" : monthlyRentTemplate.getBankCode());break;
                    case 8 : cell.setCellValue(monthlyRentTemplate.getAccountBank() == null ? "" : monthlyRentTemplate.getAccountBank());break;
                    case 9 : cell.setCellValue(monthlyRentTemplate.getPlateNumber() == null ? "" : monthlyRentTemplate.getPlateNumber());break;
                    case 10 : cell.setCellValue(monthlyRentTemplate.getLeaseStartTime()== null ? "" : monthlyRentTemplate.getLeaseStartTime().toString());break;
                    case 11 : cell.setCellValue(monthlyRentTemplate.getLeaseEndTime()== null ? "" : monthlyRentTemplate.getLeaseEndTime().toString());break;
                    case 12 : cell.setCellValue(StringUtils.isEmpty(monthlyRentTemplate.getUpdateState()) ? "" : monthlyRentTemplate.getUpdateState());break;
                    default: logger.info("字段数量不匹配！");break;
                }
            }
            rowNum ++;
        }

    }

















}
