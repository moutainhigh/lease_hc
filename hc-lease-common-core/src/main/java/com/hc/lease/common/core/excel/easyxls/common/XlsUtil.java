package com.hc.lease.common.core.excel.easyxls.common;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import com.hc.lease.common.core.excel.easyxls.annotation.ExcelSheet;
import com.hc.lease.common.core.excel.easyxls.bean.Column;
import com.hc.lease.common.core.excel.easyxls.bean.ExcelConfig;
import com.hc.lease.common.core.excel.easyxls.bean.Field;
import com.hc.lease.common.core.excel.easyxls.generater.GenXml;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.redis.util.RedisDataUtil;
import hc.lease.common.util.ReflectionsUtil;
import jxl.BooleanCell;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.ErrorCell;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.biff.DisplayFormat;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCell;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.DateRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/**
 * excel，对导入导出进行封装
 *
 * @author liuzh
 */
public class XlsUtil {

    public static final String EXCEL = ".xls";
    private static Map<String, ExcelConfig> cache = new HashMap<String, ExcelConfig>();

    /**
     * 获取xml配置对象
     *
     * @param xmlPath xml完整路径
     * @return xml配置对象
     */
    private static ExcelConfig getEasyExcel(String xmlPath) {
        ExcelConfig easyExcel = cache.get(xmlPath);
        if (easyExcel == null) {
            easyExcel = XmlConfig.getXmlConfig(xmlPath);
        }
        if (easyExcel == null) {
            throw new RuntimeException("无法获取xml配置文件!");
        }
        if (easyExcel.getCache() == null || easyExcel.getCache()) {
            cache.put(xmlPath, easyExcel);
        }
        return easyExcel;
    }

    /**
     * 打开代码生成器，请在项目中执行，只有这样才能加载相应的类
     */
    public static void openGenerater() {
        GenXml.run();
    }

    /**
     * 导入xml到List
     *
     * @param xmlPath xml完整路径
     * @param xlsFile xls文件路径
     * @return List对象
     * @throws Exception
     */
    public static List<?> xls2List(String xmlPath, File xlsFile) throws Exception {
        Workbook wb = null;
        List<?> list = null;
        try {
            wb = Workbook.getWorkbook(xlsFile);
            list = workbook2List(xmlPath, wb);
        } catch (Exception e) {
            throw new Exception("转换xls出错:" + e.getMessage());
        } finally {
            if (wb != null) {
                wb.close();
            }
        }
        return list;
    }

    /**
     * 导入xml到List
     *
     * @param config  配置
     * @param xlsFile xls文件路径
     * @return List对象
     * @throws Exception
     */
    public static List<?> xls2List(ExcelConfig config, File xlsFile) throws Exception {
        Workbook wb = null;
        List<?> list = null;
        try {
            wb = Workbook.getWorkbook(xlsFile);
            list = workbook2List(config, wb);
        } catch (Exception e) {
            throw new Exception("转换xls出错:" + e.getMessage());
        } finally {
            if (wb != null) {
                wb.close();
            }
        }
        return list;
    }

    /**
     * 导入xml到List
     *
     * @param xmlPath     xml完整路径
     * @param inputStream xls文件流
     * @return List对象
     * @throws Exception
     */
    public static List<?> xls2List(String xmlPath, InputStream inputStream) throws Exception {
        Workbook wb = null;
        List<?> list = null;
        try {
            wb = Workbook.getWorkbook(inputStream);
            list = workbook2List(xmlPath, wb);
        } catch (Exception e) {
            throw new Exception("转换xls出错:" + e.getMessage());
        } finally {
            if (wb != null) {
                wb.close();
            }
        }
        return list;
    }

    /**
     * 导入xml到List
     *
     * @param config      配置
     * @param inputStream xls文件流
     * @return List对象
     * @throws Exception
     */
    public static List<?> xls2List(ExcelConfig config, InputStream inputStream) throws Exception {
        Workbook wb = null;
        List<?> list = null;

        try {
            wb = Workbook.getWorkbook(inputStream);
            list = workbook2List(config, wb);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("转换xls出错:" + e.getMessage());
        } finally {
            if (wb != null) {
                wb.close();
            }
        }

        return list;
    }

    /**
     * workbook转换为list
     *
     * @param xmlPath
     * @param wb
     * @return
     * @throws Exception
     */
    public static List<?> workbook2List(String xmlPath, Workbook wb) throws Exception {
        // 获取配置文件
        ExcelConfig config = getEasyExcel(xmlPath);
        return workbook2List(config, wb);
    }

    /**
     * workbook转换为list
     *
     * @param config 配置
     * @param wb     excel
     * @return
     * @throws Exception
     */
    public static List<?> workbook2List(ExcelConfig config, Workbook wb) throws Exception {
        String[] names = config.getNames();
        String[] types = config.getTypes();
        Field key = config.getKey();

        List<Object> list = new ArrayList<Object>();
        //Sheet sheet = wb.getSheet(config.getSheetNum());//用sheet顺序读取sheet
        System.out.println("sheet名称=-=" + config.getSheet());
        if (config.getSheet() == null) {
            throw new GMException(GMExceptionConstant.EXCEL_SHEET_ERROR);
        }

        Sheet sheet = wb.getSheet(config.getSheet());//用sheet名称读取sheet
        System.out.println("sheet=-=" + sheet);
        if (sheet == null) {
            throw new GMException(GMExceptionConstant.EXCEL_SHEET_ERROR);
        }


        int length = sheet.getColumns() < names.length ? sheet.getColumns() : names.length;
        // 计算行数
        int rowLength = sheet.getRows() < config.getMaxRow() ? sheet.getRows() : (config.getMaxRow() > 0 ? (config.getMaxRow() + config.getStartRow()) : sheet.getRows());

        int rightRows = getRightRows(sheet);
        // Map类型要特殊处理
        Class clazz = Class.forName(config.getClazz());
        Map<String, java.lang.reflect.Field> fileMap = new HashMap<>();
        for (int j = 0; j < length; j++) {
            fileMap.put(names[j], clazz.getDeclaredField(names[j]));
        }
        for (int i = config.getStartRow(); i < rightRows; i++) {
            Object obj = null;
            if (Map.class.isAssignableFrom(clazz)) {
                obj = new HashMap();
            } else {
                obj = clazz.newInstance();
            }
            for (int j = 0; j < length; j++) {
                setValue(obj, fileMap.get(names[j]), types[j], sheet.getCell(j, i));
            }
            // checkKey
            if (key != null) {
                // 当主键为空时，不在继续读取excel
                if (key.get(obj) == null || "".equals(String.valueOf(key.get(obj)))) {
                    break;
                }
            }
            list.add(obj);
        }
        return list;
    }

    public static List<?> workbookToList(ExcelConfig config, Workbook wb) throws Exception {
        Map<String, List> sheetListMap = new HashMap<>();
        return sheetObjFill(wb, config.getSheet(), sheetListMap, Class.forName(config.getClazz()));
    }

    /**
     * 返回去掉空行的记录数
     * 如果EXCEL表设置了数据验证但是这些行没有填数据，则要把这些行去掉，否则这些空数据也会被读取
     *
     * @param sheet
     * @return
     */
    private static int getRightRows(Sheet sheet) {
        int rsCols = sheet.getColumns(); //列数
        int rsRows = sheet.getRows(); //行数
        int nullCellNum;
        int afterRows = rsRows;
        for (int i = 1; i < rsRows; i++) { //统计行中为空的单元格数
            nullCellNum = 0;
            for (int j = 0; j < rsCols; j++) {
                String val = sheet.getCell(j, i).getContents();
                val = StringUtils.trimToEmpty(val);
                if (StringUtils.isBlank(val))
                    nullCellNum++;
            }
            if (nullCellNum >= rsCols) { //如果nullCellNum大于或等于总的列数
                afterRows--;          //行数减一
            }
        }
        return afterRows;
    }

    /**
     * 检测Excel行数是否超限
     * 如果EXCEL表设置了数据验证但是这些行没有填数据，则要把这些行去掉，否则这些空数据也会被读取
     *
     * @param config
     * @param inputStream
     * @param limitExcelDateRowsOver               限制的行数
     * @param checkExcelDateRowsOverLimitSheetName 有sheetName 则用sheetName获取Sheet
     * @return
     * @throws Exception
     */
    public static boolean checkExcelDateRowsOverLimit(ExcelConfig config, InputStream inputStream, String limitExcelDateRowsOver, String checkExcelDateRowsOverLimitSheetName) throws Exception {
        Workbook wb = null;
        int afterRows = 0;
        try {
            wb = Workbook.getWorkbook(inputStream);
            Sheet sheet = null;
            if (checkExcelDateRowsOverLimitSheetName == null) {
                sheet = wb.getSheet(config.getSheetNum());
            } else {
                sheet = wb.getSheet(checkExcelDateRowsOverLimitSheetName);
            }
            int rsCols = sheet.getColumns(); //列数
            int rsRows = sheet.getRows(); //行数
            int nullCellNum;
            afterRows = rsRows;
            for (int i = 1; i < rsRows; i++) { //统计行中为空的单元格数
                nullCellNum = 0;
                for (int j = 0; j < rsCols; j++) {
                    String val = sheet.getCell(j, i).getContents();
                    val = StringUtils.trimToEmpty(val);
                    if (StringUtils.isBlank(val))
                        nullCellNum++;
                }
                if (nullCellNum >= rsCols) { //如果nullCellNum大于或等于总的列数
                    afterRows--;          //行数减一
                }
            }
        } catch (Exception e) {
            throw new Exception("转换xls出错:" + e.getMessage());
        }
        System.out.println("afterRows===" + afterRows);
        if (Integer.parseInt(limitExcelDateRowsOver) < afterRows - 1) {
            //wb.close();
            return false;
        }
        return true;
    }

    /**
     * 获取单元格的数据
     *
     * @param cell
     * @return
     * @throws Exception
     */
    private static Object getCellValue(Cell cell) throws Exception {
        Object value = null;
        if (cell instanceof ErrorCell) {
            value = null;
        } else if (cell instanceof LabelCell) {
            value = ((LabelCell) cell).getString();
        } else if (cell instanceof NumberCell) {
            value = ((NumberCell) cell).getValue();
        } else if (cell instanceof DateCell) {
            //((DateCell) cell).getDate() 获取的日期与实际填写日期相差8小时
            TimeZone gmt = TimeZone.getTimeZone("GMT");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            dateFormat.setTimeZone(gmt);
            value = dateFormat.format(((DateCell) cell).getDate());
            //value = ((DateCell) cell).getDate();
        } else if (cell instanceof BooleanCell) {
            value = ((BooleanCell) cell).getValue();
        } /*
         * else if (cell instanceof FormulaCell) { value = ((FormulaCell) cell).getFormula(); }
         */ else {
            value = cell.getContents();
        }
        return value;
    }

    /**
     * 跟对象obj的某个field赋值value
     *
     * @param obj   属性对象
     * @param field 字段
     * @param cell  单元格
     * @throws Exception
     */
    private static void setValue(Object obj, java.lang.reflect.Field field, String type, Cell cell) throws Exception {
        Object cellValue = getCellValue(cell);
        Object val = null;
        ExcelAttribute excelAttribute = field.getAnnotation(ExcelAttribute.class);
        boolean isDual = false;
        if (excelAttribute != null) {
            if (!StringUtils.isEmpty(excelAttribute.dictType())) {
                isDual = true;
            }
        }
        if (isDual) {
            val = RedisDataUtil.getRedisDictIdByDictTypeAndDictValue(excelAttribute.dictType(), cellValue.toString());
            val = null != val ? fileValAdaptive(field.getType(), val) : val;
        } else if (cellValue != null) {
            if (Object.class.getCanonicalName().equals(type)) {
                // 类型一致的直接使用
                val = cellValue;
            } else if (cellValue.getClass().getName().equals(type)) {
                // 类型一致的直接使用
                val = cellValue;
            } else {
                // 类型不一致进行转换
                String value = cellValue.toString();
                if (value != null && !value.trim().equals("")) {
                    value = value.trim();
                    /**
                     * 对类型进行转换，支持int,long,float,double,boolean,Integer,Long,Double,Float,Date,String
                     */
                    if (type.equals("int")) {
                        val = new BigDecimal(value).intValue();
                    } else if (type.equals("long")) {
                        val = new BigDecimal(value).longValue();
                    } else if (type.equals("float")) {
                        val = new BigDecimal(value).floatValue();
                    } else if (type.equals("double")) {
                        val = new BigDecimal(value).doubleValue();
                    } else if (type.equals("boolean")) {
                        val = Boolean.parseBoolean(value);
                    } else {
                        Class clazz = Class.forName(type);
                        System.out.println("clazz====" + clazz);
                        if (!clazz.equals(String.class)) {
                            val = fileValAdaptive(clazz, cellValue);
                        } else {
                            CellType cellType = cell.getType();
                            if (cellType.equals(CellType.NUMBER)) {
                                BigDecimal db = new BigDecimal(value);
                                //val = db.toPlainString();
                                val = db.toBigInteger();
                                val = String.valueOf(val);
                            } else {
                                val = value;
                            }
                        }
                    }
                }
            }
        }
        //field.set(obj, val);
        Field field1 = FieldUtil.getField(obj, field.getName());
        if (field1 != null) {
            field1.set(obj, val);
        }
    }

    private static Object fileValAdaptive(Class fileType, Object val) {
        String value = val.toString();

        if (fileType.equals(Date.class)) {
            return DateUtil.smartFormat(value);
        }

        if (fileType.equals(Integer.class)) {
            return new BigDecimal(value).intValue();
        }

        if (fileType.equals(Long.class)) {
            return new BigDecimal(value).longValue();
        }

        if (fileType.equals(Float.class)) {
            return new BigDecimal(value).floatValue();
        }

        if (fileType.equals(Double.class)) {
            return new BigDecimal(value).doubleValue();
        }

        if (fileType.equals(Boolean.class)) {
            return Boolean.parseBoolean(value);
        }

        if (fileType.equals(BigDecimal.class)) {
            return new BigDecimal(value);
        }
        return value;
    }

    /**
     * 导出list对象到excel
     *
     * @param list                导出的list
     * @param xmlPath             xml完整路径
     * @param filePath            保存xls路径
     * @param fileName            保存xls文件名
     * @param params              数据验证数据
     * @param setDateVerification 是否有数据验证
     * @return 处理结果，true成功，false失败
     * @throws Exception
     */
    public static boolean list2Xls(List<?> list, String xmlPath, String filePath, String fileName, Map params, boolean setDateVerification) throws Exception {
        // 创建目录
        File file = new File(filePath);
        if (!(file.exists())) {
            if (!file.mkdirs()) {
                throw new RuntimeException("创建导出目录失败!");
            }
        }
        try {
            ExcelConfig config = getEasyExcel(xmlPath);
            list2Xls(config, list, filePath, fileName, params, setDateVerification);
        } catch (Exception e1) {
            return false;
        }
        return true;
    }

    /**
     * 导出list对象到excel
     * 创建一个sheet
     *
     * @param config              配置
     * @param list                导出的list
     * @param filePath            保存xls路径
     * @param fileName            保存xls文件名
     * @param params              数据验证数据
     * @param setDateVerification 是否有数据验证
     * @return 处理结果，true成功，false失败
     * @throws Exception
     */
    public static boolean list2Xls(ExcelConfig config, List<?> list, String filePath, String fileName, Map params, boolean setDateVerification) throws Exception {
        // 创建目录
        File file = new File(filePath);
        if (!(file.exists())) {
            if (!file.mkdirs()) {
                throw new RuntimeException("创建导出目录失败!");
            }
        }
        try {
            String[] header = config.getHeaders();
            String[] names = config.getNames();

            if (!fileName.toLowerCase().endsWith(EXCEL)) {
                fileName += EXCEL;
            }
            File excelFile = new File(filePath + "/" + fileName);
            WritableWorkbook wb = Workbook.createWorkbook(excelFile);
            String sheetName = (config.getSheet() != null && !config.getSheet().equals("")) ? config.getSheet() : ("sheet" + config.getSheetNum());
            //WritableSheet sheet = wb.createSheet(sheetName, 0);
            ////
            WritableSheet sheet = dualList2Xls(wb, config, list, params, setDateVerification);

            //如果数据不够100行，则单独处理剩余的行加入数据验证//
            if (setDateVerification) {
                if (list.size() < 100) {
                    //int row = 0;
                    int rowadd = 1;
                    int column = 0;
                    // 写入内容//行
                    for (int row = list.size(); row < 101; row++) {
                        // 列
                        for (column = 0; column < names.length; column++) {
                            sheet = getExcelModelCellStyle(row, column, rowadd, config, sheet, params);
                        }
                    }
                }
                // 写入内容//行
            }
            //如果数据不够100行，则单独处理剩余的行加入数据验证//

            ////
            wb.write();
            wb.close();
        } catch (Exception e1) {
            return false;
        }
        return true;
    }

    /**
     * 导出Obj对象到excel
     *
     * @param config 配置
     * @param obj    导出的list
     * @param
     * @param
     * @return 处理结果，true成功，false失败
     */
    public static boolean objToXls(ExcelConfig config, Object obj, OutputStream outputStream, Map<String, List<String>> params) {
        try {
            WritableWorkbook wb = Workbook.createWorkbook(outputStream);
            dualObjToXls(wb, config, obj, params);
            wb.write();
            wb.close();
        } catch (Exception e1) {
            e1.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 导出Obj对象到excel
     *
     * @param config   配置
     * @param obj      导出的list
     * @param filePath 保存xls路径
     * @param fileName 保存xls文件名
     * @return 处理结果，true成功，false失败
     */
    public static boolean objToXls(ExcelConfig config, Object obj, String filePath, String fileName, Map<String, List<String>> params) {
        // 创建目录
        File file = new File(filePath);
        if (!(file.exists())) {
            if (!file.mkdirs()) {
                throw new RuntimeException("创建导出目录失败!");
            }
        }
        try {
            if (!fileName.toLowerCase().endsWith(EXCEL)) {
                fileName += EXCEL;
            }
            File excelFile = new File(filePath + "/" + fileName);
            WritableWorkbook wb = Workbook.createWorkbook(excelFile);
            dualObjToXls(wb, config, obj, params);
            wb.write();
            wb.close();
        } catch (Exception e1) {
            e1.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 导出list对象到excel
     * 创建两个sheet
     * 一个sheet装车辆数据、一个sheet装车辆方案数据
     *
     * @param config 配置
     * @param list   导出的list
     * @return 处理结果，true成功，false失败
     */
    public static boolean listToXls(ExcelConfig config, List<?> list, OutputStream outputStream, Map<String, List<String>> params) {
        try {
            WritableWorkbook wb = Workbook.createWorkbook(outputStream);
            dualListToXls(wb, config, list, params);
            wb.write();
            wb.close();
        } catch (Exception e1) {
            e1.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 导出list对象到excel
     * 创建两个sheet
     * 一个sheet装车辆数据、一个sheet装车辆方案数据
     *
     * @param config   配置
     * @param list     导出的list
     * @param filePath 保存xls路径
     * @param fileName 保存xls文件名
     * @return 处理结果，true成功，false失败
     */
    public static boolean listToXls(ExcelConfig config, List<?> list, String filePath, String fileName, Map<String, List<String>> params) throws Exception {
        // 创建目录
        File file = new File(filePath);
        if (!(file.exists())) {
            if (!file.mkdirs()) {
                throw new RuntimeException("创建导出目录失败!");
            }
        }
        try {
            if (!fileName.toLowerCase().endsWith(EXCEL)) {
                fileName += EXCEL;
            }
            File excelFile = new File(filePath + File.separator + fileName);
            WritableWorkbook wb = Workbook.createWorkbook(excelFile);
            dualListToXls(wb, config, list, params);
            wb.write();
            wb.close();
        } catch (Exception e1) {
            e1.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 导出list对象到excel
     * 创建两个sheet
     * 一个sheet装车辆数据、一个sheet装车辆方案数据
     *
     * @param config_1            配置
     * @param config_2            配置
     * @param list_1              车辆数据
     * @param list_2              车辆方案数据
     * @param filePath            保存xls路径
     * @param fileName            保存xls文件名
     * @param params              数据验证数据
     * @param setDateVerification 是否有数据验证
     * @return 处理结果，true成功，false失败
     * @throws Exception
     */
    public static boolean list2XlsTwoSheet(ExcelConfig config_1, ExcelConfig config_2, List<?> list_1, List<?> list_2, String filePath, String fileName, Map params, boolean setDateVerification) throws Exception {

        // 创建目录
        File file = new File(filePath);
        if (!(file.exists())) {
            if (!file.mkdirs()) {
                throw new RuntimeException("创建导出目录失败!");
            }
        }

        try {
            if (!fileName.toLowerCase().endsWith(EXCEL)) {
                fileName += EXCEL;
            }
            File excelFile = new File(filePath + "/" + fileName);
            WritableWorkbook wb = Workbook.createWorkbook(excelFile);

            if (list_1 != null) {
                if (list_1.size() > 0) {
                    //sheet
                    WritableSheet sheet_1 = dualList2Xls(wb, config_1, list_1, params, setDateVerification);
                    //sheet
                }
            }

            if (list_2 != null) {
                if (list_2.size() > 0) {
                    //sheet
                    WritableSheet sheet_2 = dualList2Xls(wb, config_2, list_2, params, setDateVerification);
                    //sheet
                }
            }

            wb.write();
            wb.close();
        } catch (Exception e1) {
            return false;
        }
        return true;
    }



    /**
     * 导出list对象到excel
     * 创建两个sheet
     * 一个sheet装车辆数据、一个sheet装车辆方案数据
     *
     * @param config_1            配置
     * @param config_2            配置
     * @param list_1              车辆数据
     * @param list_2              车辆方案数据
     * @param filePath            保存xls路径
     * @param fileName            保存xls文件名
     * @param params              数据验证数据
     * @param setDateVerification 是否有数据验证
     * @return 处理结果，true成功，false失败
     * @throws Exception
     */
    public static boolean list2XlsThreeSheet(ExcelConfig config_1, ExcelConfig config_2,ExcelConfig config_3, List<?> list_1, List<?> list_2, List<?> list_3,String filePath, String fileName, Map params, boolean setDateVerification) throws Exception {

        // 创建目录
        File file = new File(filePath);
        if (!(file.exists())) {
            if (!file.mkdirs()) {
                throw new RuntimeException("创建导出目录失败!");
            }
        }

        try {
            if (!fileName.toLowerCase().endsWith(EXCEL)) {
                fileName += EXCEL;
            }
            File excelFile = new File(filePath + "/" + fileName);
            WritableWorkbook wb = Workbook.createWorkbook(excelFile);

            if (list_1 != null) {
                if (list_1.size() > 0) {
                    //sheet
                    WritableSheet sheet_1 = dualList2Xls(wb, config_1, list_1, params, setDateVerification);
                    //sheet
                }
            }

            if (list_2 != null) {
                if (list_2.size() > 0) {
                    //sheet
                    WritableSheet sheet_2 = dualList2Xls(wb, config_2, list_2, params, setDateVerification);
                    //sheet
                }
            }
            if (list_3 != null) {
                if (list_3.size() > 0) {
                    //sheet
                    WritableSheet sheet_3 = dualList2Xls(wb, config_3, list_3, params, setDateVerification);
                    //sheet
                }
            }

            wb.write();
            wb.close();
        } catch (Exception e1) {
            return false;
        }
        return true;
    }





    /**
     * 导出list对象到excel
     *
     * @param wb
     * @param config
     * @param list
     * @param params              数据验证数据
     * @param setDateVerification 是否有数据验证
     * @return
     * @throws Exception
     */
    public static WritableSheet dualList2Xls(WritableWorkbook wb, ExcelConfig config, List<?> list, Map params, boolean setDateVerification) throws Exception {

        String[] header = config.getHeaders();
        String[] names = config.getNames();
        String sheetName = (config.getSheet() != null && !config.getSheet().equals("")) ? config.getSheet() : ("sheet" + config.getSheetNum());

        WritableSheet sheet = wb.createSheet(sheetName, 0);
        String[] values;
        int row = 0;
        int column = 0;
        int rowadd = 0;
        // 写入标题
        if (config.getHeader()) {
            for (column = 0; column < header.length; column++) {
                sheet.addCell(new Label(column, row + rowadd, header[column], getHeaderCellStyle()));
                if (config.getColumn(column).getWidth() != null) {
                    sheet.setColumnView(column, config.getColumn(column).getWidth() / 7);
                }
            }
            rowadd++;
        }
        // 写入内容//行
        for (row = 0; row < list.size(); row++) {
            Object rowData = list.get(row);
            values = getObjValues(rowData, names);
            // 列
            for (column = 0; column < values.length; column++) {
                Column col = config.getColumn(column);
                String type = col.getType();
                try {
                    if (StringUtils.isNotBlank(type) && type.equals(Integer.class.getName())) {
                        DisplayFormat displayFormat = NumberFormats.INTEGER;
                        WritableCellFormat cellFormat = new WritableCellFormat(displayFormat);
                        jxl.write.Number number = new jxl.write.Number(column, row + rowadd, Integer.parseInt(values[column]), cellFormat);


                        try {
                            ////////加入数据验证//////
                            if (setDateVerification) {
                                List<String> dateVerificationList = getDateVerification(column, config, params);
                                //设置具有数据有效性的单元格
                                if (dateVerificationList != null) {
                                    if (dateVerificationList.size() > 0) {
                                        WritableCellFeatures format = new WritableCellFeatures();
                                        format.setDataValidationList(dateVerificationList);
                                        number.setCellFeatures(format);
                                    }
                                }
                                //设置具有数据有效性的单元格
                            }
                            ////////加入数据验证//////
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        sheet.addCell(number);
                    } else if (StringUtils.isNotBlank(type) && type.equals(Double.class.getName())) {
                        DisplayFormat displayFormat = NumberFormats.FLOAT;
                        WritableCellFormat cellFormat = new WritableCellFormat(displayFormat);
                        jxl.write.Number number = new jxl.write.Number(column, row + rowadd, Double.parseDouble(values[column]), cellFormat);


                        try {
                            ////////加入数据验证//////
                            if (setDateVerification) {
                                List<String> dateVerificationList = getDateVerification(column, config, params);
                                //设置具有数据有效性的单元格
                                if (dateVerificationList != null) {
                                    if (dateVerificationList.size() > 0) {
                                        WritableCellFeatures format = new WritableCellFeatures();
                                        format.setDataValidationList(dateVerificationList);
                                        number.setCellFeatures(format);
                                    }
                                }
                                //设置具有数据有效性的单元格
                            }
                            ////////加入数据验证//////
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        sheet.addCell(number);
                    } else {
                        WritableCell cell = new Label(column, row + rowadd, values[column]);

                        try {
                            ////////加入数据验证//////
                            if (setDateVerification) {
                                List<String> dateVerificationList = getDateVerification(column, config, params);
                                //设置具有数据有效性的单元格
                                if (dateVerificationList != null) {
                                    if (dateVerificationList.size() > 0) {
                                        WritableCellFeatures format = new WritableCellFeatures();
                                        format.setDataValidationList(dateVerificationList);
                                        cell.setCellFeatures(format);
                                    }
                                }
                                //设置具有数据有效性的单元格
                            }
                            ////////加入数据验证//////
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        sheet.addCell(cell);
                    }
                } catch (Exception e) {
                    WritableCell cell = new Label(column, row + rowadd, values[column]);


                    try {
                        ////////加入数据验证//////
                        if (setDateVerification) {
                            List<String> dateVerificationList = getDateVerification(column, config, params);
                            //设置具有数据有效性的单元格
                            if (dateVerificationList != null) {
                                if (dateVerificationList.size() > 0) {
                                    WritableCellFeatures format = new WritableCellFeatures();
                                    format.setDataValidationList(dateVerificationList);
                                    cell.setCellFeatures(format);
                                }
                            }
                            //设置具有数据有效性的单元格
                        }
                        ////////加入数据验证//////
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                    sheet.addCell(cell);
                }

            }
        }
        return sheet;
    }

    public static void dualListToXls(WritableWorkbook wb, ExcelConfig config, List<?> list, Map<String, List<String>> params) throws Exception {
        String sheetName = (config.getSheet() != null && !config.getSheet().equals("")) ? config.getSheet() : ("sheet" + config.getSheetNum());
        Class aClass = Class.forName(config.getClazz());
        dualListToXls(wb, config, sheetName, aClass, 0, list, params);
    }

    public static void dualObjToXls(WritableWorkbook wb, ExcelConfig config, Object object, Map<String, List<String>> params) throws Exception {
        List<java.lang.reflect.Field> declaredFields = ReflectionsUtil.getClassCoverAllSuperAllField(object.getClass());
        int sheetIndex = 0;
        for (java.lang.reflect.Field field : declaredFields) {
            ExcelSheet excelSheet = field.getAnnotation(ExcelSheet.class);
            if (null != excelSheet && excelSheet.isExport()) {
                field.setAccessible(true);
                WritableSheet sheet = wb.createSheet(excelSheet.sheetName(), sheetIndex++);
                List valList = (List) field.get(object);
                int col = 0;
                for (java.lang.reflect.Field objField : ReflectionsUtil.getClassCoverAllSuperAllField(excelSheet.classObj())) {
                    ExcelAttribute excelAttribute = objField.getAnnotation(ExcelAttribute.class);
                    if (null != excelAttribute && excelAttribute.isExport()) {
                        int row = 0;
                        objField.setAccessible(true);
                        int excelCol = StringUtils.isEmpty(excelAttribute.column()) ? col++ : getExcelCol(excelAttribute.column());
                        //根据内容自动设置列宽
                        sheet.setColumnView(excelCol, excelAttribute.name().length() * 2 + 6);
                        //是否为字典设置下拉
                        boolean isDictTypeField = !StringUtils.isEmpty(excelAttribute.dictType());
                        //是否为参数设置下拉
                        boolean isSpinnerParamField = !StringUtils.isEmpty(excelAttribute.spinnerParamName());
                        // 导出列标题
                        if (config.getHeader()) {
                            sheet.addCell(new Label(excelCol, row++, excelAttribute.name(), getHeaderCellStyle()));
                        }
                        //设置列下拉格式
                        if (isDictTypeField || isSpinnerParamField) {
                            Label writableCell = new Label(excelCol, row, null);
                            sheet.addCell(writableCell);
                            //单元格设置下拉选项
                            labelSetSelect(writableCell, isDictTypeField ? RedisDataUtil.getRedisDictValuesByDictType(excelAttribute.dictType()) : params.get(excelAttribute.spinnerParamName()));
                            //整列设置下拉选择
                            colSetSelect(sheet, writableCell);
                        }
                        if (null == valList || valList.isEmpty()) {
                            continue;
                        }
                        //导出内容
                        for (Object obj : valList) {
                            //System.out.println("******************************输出"+obj);
                            /*if(null==obj){
                                continue;
                            }*/
                            try {
                                String labelVal = isDictTypeField ? RedisDataUtil.getRedisDictValueByDictTypeAndDictId(excelAttribute.dictType(), objField.get(obj)) : objField.get(obj).toString();
                                sheet.addCell(new Label(excelCol, row++, labelVal));
                            } catch (Exception e) {
                                System.out.println("*********************输出" + e);
                            }

                        }
                    }
                }
            }
        }
    }

    /**
     * 导出list对象到excel / 创建多个sheet
     * 根据导出List数据行数计算sheet个数
     * 1000行数据算1个sheet
     *
     * @param config   配置
     * @param list     导出的list
     * @param filePath 保存xls路径
     * @param fileName 保存xls文件名
     * @return 处理结果，true成功，false失败
     * @throws Exception
     */
    public static boolean list2XlsMoreSheet(ExcelConfig config, List<?> list, String filePath, String fileName) throws Exception {
        // 创建目录
        File file = new File(filePath);
        if (!(file.exists())) {
            if (!file.mkdirs()) {
                throw new RuntimeException("创建导出目录失败!");
            }
        }
        try {
            String[] header = config.getHeaders();
            String[] names = config.getNames();
            String[] values;

            if (!fileName.toLowerCase().endsWith(EXCEL)) {
                fileName += EXCEL;
            }
            File excelFile = new File(filePath + "/" + fileName);
            WritableWorkbook wb = Workbook.createWorkbook(excelFile);

            ///开始创建sheet///
            int length = list.size(); //查询结果记录数
            //设置每个sheet显示的记录数
            int sheetSize = 1000;
            //有多少个sheet
            int sheetNum = 1;
            //计算要创建的sheet个数
            if (length % sheetSize > 0) {
                sheetNum = length / sheetSize + 1;
            } else {
                sheetNum = length / sheetSize;
            }

            for (int i = 0; i < sheetNum; i++) {
                String sheetName = (config.getSheet() != null && !config.getSheet().equals("")) ? config.getSheet() : ("sheet" + config.getSheetNum());
                WritableSheet sheet = wb.createSheet(sheetName + i, 0);

                int row = 0;//行数
                int column = 0;//列数
                int rowadd = 0;//

                // 写入标题
                if (config.getHeader()) {
                    for (column = 0; column < header.length; column++) {
                        sheet.addCell(new Label(column, row + rowadd, header[column], getHeaderCellStyle()));
                        if (config.getColumn(column).getWidth() != null) {
                            sheet.setColumnView(column, config.getColumn(column).getWidth() / 7);
                        }
                    }
                    rowadd++;
                }
                // 写入标题

                // 写入内容//行
                for (row = i * sheetSize; row < (i + 1) * sheetSize; row++) {
                    //for (int j = 0; i < sheetSize; j++) {
                    if (row < length) {
                        Object rowData = list.get(row);
                        values = getObjValues(rowData, names);
                        // 列
                        for (column = 0; column < values.length; column++) {
                            Column col = config.getColumn(column);
                            String type = col.getType();
                            try {
                                if (StringUtils.isNotBlank(type) && type.equals(Integer.class.getName())) {
                                    DisplayFormat displayFormat = NumberFormats.INTEGER;
                                    WritableCellFormat format = new WritableCellFormat(displayFormat);
                                    jxl.write.Number number = new jxl.write.Number(column, row + 1 - (i * sheetSize), Integer.parseInt(values[column]), format);
                                    sheet.addCell(number);
                                } else if (StringUtils.isNotBlank(type) && type.equals(Double.class.getName())) {
                                    DisplayFormat displayFormat = NumberFormats.FLOAT;
                                    WritableCellFormat format = new WritableCellFormat(displayFormat);
                                    jxl.write.Number number = new jxl.write.Number(column, row + 1 - (i * sheetSize), Double.parseDouble(values[column]), format);
                                    sheet.addCell(number);
                                } else {
                                    sheet.addCell(new Label(column, row + 1 - (i * sheetSize), values[column]));
                                }
                            } catch (Exception e) {
                                sheet.addCell(new Label(column, row + 1 - (i * sheetSize), values[column]));
                            }
                        }
                        // 列
                    }
                }
                // 写入内容//行
            }

            wb.write();
            wb.close();

        } catch (Exception e1) {
            return false;
        }
        return true;
    }

    /**
     * 表头单元格样式的设定
     */
    public static WritableCellFormat getHeaderCellStyle() {

        /*
         * WritableFont.createFont("宋体")：设置字体为宋体 10：设置字体大小 WritableFont.BOLD:设置字体加粗（BOLD：加粗
         * NO_BOLD：不加粗） false：设置非斜体 UnderlineStyle.NO_UNDERLINE：没有下划线
         */
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);

        WritableCellFormat headerFormat = new WritableCellFormat(NumberFormats.TEXT);
        try {
            // 添加字体设置
            headerFormat.setFont(font);
            // 设置单元格背景色：表头为黄色
            headerFormat.setBackground(Colour.YELLOW);
            // 设置表头表格边框样式
            // 整个表格线为粗线、黑色
            headerFormat.setBorder(Border.ALL, BorderLineStyle.THICK, Colour.BLACK);
            // 表头内容水平居中显示
            headerFormat.setAlignment(Alignment.CENTRE);
        } catch (WriteException e) {
            System.out.println("表头单元格样式设置失败！");
        }
        return headerFormat;
    }

    /**
     * 获取对象指定字段值
     *
     * @param source     对象
     * @param fieldnames 属性名数组
     * @return 对象的字符串数组，和属性名对应
     * @throws Exception
     */
    private static String[] getObjValues(Object source, String... fieldnames) throws Exception {
        String[] results = new String[fieldnames.length];
        Field field;
        String value;
        Object obj;
        for (int i = 0; i < fieldnames.length; i++) {
            field = FieldUtil.getField(source, fieldnames[i]);
            if (field == null) {
                continue;
            }
            obj = field.get(source);
            if (obj == null) {
                value = "";
            } else if (obj instanceof Date) {
                value = DateUtil.smartFormat((Date) obj);
            } else {
                value = String.valueOf(obj);
            }
            results[i] = value;
        }
        return results;
    }


    /**
     * 导出excel模板、带表头的空EXCEL
     *
     * @param config              配置
     * @param filePath            保存xls路径
     * @param fileName            保存xls文件名
     * @param params              数据验证数据
     * @param setDateVerification 是否有数据验证
     * @return
     * @throws Exception
     */
    public static boolean getExcelModel(ExcelConfig config, String filePath, String fileName, Map params, boolean setDateVerification) throws Exception {
        // 创建目录
        File file = new File(filePath);
        if (!(file.exists())) {
            if (!file.mkdirs()) {
                throw new RuntimeException("创建导出目录失败!");
            }
        }

        try {
            String[] header = config.getHeaders();
            String[] names = config.getNames();
            String[] values;

            if (!fileName.toLowerCase().endsWith(".xls")) {
                fileName += ".xls";
            }
            File excelFile = new File(filePath + "/" + fileName);
            WritableWorkbook wb = Workbook.createWorkbook(excelFile);
            String sheetName = (config.getSheet() != null && !config.getSheet().equals("")) ? config.getSheet() : ("sheet" + config.getSheetNum());
            WritableSheet sheet = wb.createSheet(sheetName, 0);

            int row = 0;
            int column = 0;
            int rowadd = 0;
            // 写入标题
            if (config.getHeader()) {
                for (column = 0; column < header.length; column++) {
                    sheet.addCell(new Label(column, row + rowadd, header[column], getHeaderCellStyle()));
                    if (config.getColumn(column).getWidth() != null) {
                        sheet.setColumnView(column, config.getColumn(column).getWidth() / 7);
                    }
                }
                rowadd++;
            }
            // 写入标题

            if (setDateVerification) {
                // 写入内容//行
                for (row = 0; row < 1000; row++) {
                    // 列
                    for (column = 0; column < names.length; column++) {
                        sheet = getExcelModelCellStyle(row, column, rowadd, config, sheet, params);
                    }
                }
                // 写入内容//行
            }

            wb.write();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (WriteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 内容单元格样式的设定
     * 带 设置具有数据有效性的单元格
     *
     * @param row
     * @param column excel表头的列
     * @param rowadd
     * @param config
     * @param params 其他参数
     * @return
     */
    public static WritableSheet getExcelModelCellStyle(int row, int column, int rowadd, ExcelConfig config, WritableSheet sheet, Map params) {

        /*
         * WritableFont.createFont("宋体")：设置字体为宋体 10：设置字体大小 WritableFont.BOLD:设置字体加粗（BOLD：加粗
         * NO_BOLD：不加粗） false：设置非斜体 UnderlineStyle.NO_UNDERLINE：没有下划线
         */

        List<String> dateVerificationList = getDateVerification(column, config, params);
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
        WritableCellFormat headerFormat = new WritableCellFormat(NumberFormats.TEXT);
        Label validateLabel = null;
        try {

            // 添加字体设置
            headerFormat.setFont(font);

            WritableCellFeatures format = new WritableCellFeatures();
            //validateLabel = new Label(column, row + rowadd, header[column], headerFormat);
            validateLabel = new Label(column, row + rowadd, null, headerFormat);
            //设置具有数据有效性的单元格
            if (dateVerificationList != null) {
                if (dateVerificationList.size() > 0) {
                    format.setDataValidationList(dateVerificationList);
                }
            }
            //设置具有数据有效性的单元格

            validateLabel.setCellFeatures(format);
            sheet.addCell(validateLabel);
        } catch (WriteException e) {
            e.printStackTrace();
            System.out.println("表头单元格样式设置失败！");
        }

        return sheet;
    }


    /**
     * 获取 导出excel 的 数据校验
     *
     * @param column
     * @param config
     * @param params
     * @return
     */
    public static List<String> getDateVerification(int column, ExcelConfig config, Map params) {
        List<String> leaseCarBuyFinancingerList = null;
        String dateVerification = config.getColumn(column).getDateVerification();//excel数据校验
        if (dateVerification != null && !dateVerification.isEmpty()) {
            if (params != null) {
                if (params.size() > 0) {
                    Set<String> keys = params.keySet();
                    for (String key : keys) {
                        if (key.equals(dateVerification)) {
                            leaseCarBuyFinancingerList = (List<String>) params.get(key);
                        }
                    }
                }
            }
        }
        return leaseCarBuyFinancingerList;
    }

    private static Sheet getSheet(String sheetName, Workbook wb) throws Exception {
        System.out.println("sheet名称=-=" + sheetName);
        if (sheetName == null) {
            throw new GMException(GMExceptionConstant.EXCEL_SHEET_ERROR);
        }
        Sheet sheet = wb.getSheet(sheetName);//用sheet名称读取sheet
        System.out.println("sheet=-=" + sheet);
        if (sheet == null) {
            throw new GMException(GMExceptionConstant.EXCEL_SHEET_ERROR);
        }
        return sheet;
    }

    /**
     * 将EXCEL中A,B,C,D,E列映射成0,1,2,3
     */
    private static int getExcelCol(String col) {
        col = col.toUpperCase();
        // 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。
        int count = -1;
        char[] cs = col.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
        }
        return count;
    }

    private static List<?> sheetObjFill(Workbook wb, String sheetName, Map<String, List> sheetListMap, Class clazz) throws Exception {
        List<Object> list = new ArrayList<>();
        Sheet sheet = getSheet(sheetName, wb);
        //获取类所有字段
        List<java.lang.reflect.Field> clazzFields = ReflectionsUtil.getClassCoverAllSuperAllField(clazz);
        ExcelAttribute excelAttribute;
        Map<Integer, java.lang.reflect.Field> fieldMap = new HashMap<>();
        List<java.lang.reflect.Field> fieldList = new ArrayList<>();
        int col = 0;
        for (java.lang.reflect.Field field : clazzFields) {
            field.setAccessible(true);
            excelAttribute = field.getAnnotation(ExcelAttribute.class);
            if (null != excelAttribute && excelAttribute.isExport()) {
                int excelCol = StringUtils.isEmpty(excelAttribute.column()) ? col++ : getExcelCol(excelAttribute.column());
                fieldMap.put(excelCol, field);
            } else if (field.isAnnotationPresent(ExcelSheet.class)) {
                ExcelSheet excelSheet = field.getAnnotation(ExcelSheet.class);
                sheetListMap.put(excelSheet.classObj().getCanonicalName(), sheetObjFill(wb, excelSheet.sheetName(), sheetListMap, excelSheet.classObj()));
                fieldList.add(field);
            }
        }
        int length = sheet.getColumns();
        int rightRows = getRightRows(sheet);
        Object obj;
        for (int i = 1; i < rightRows; i++) {
            obj = clazz.newInstance();
            for (int j = 0; j < length; j++) {
                Cell cell = sheet.getCell(j, i);
                java.lang.reflect.Field field = fieldMap.get(cell.getColumn());
                if (null == field) {
                    continue;
                }
                setValue(obj, field, field.getType().getCanonicalName(), cell);
            }
            //关联sheet读取
            if (!fieldList.isEmpty()) {
                for (java.lang.reflect.Field field : fieldList) {
                    ExcelSheet annotation = field.getAnnotation(ExcelSheet.class);
                    List sheetList = sheetListMap.get(annotation.classObj().getCanonicalName());
                    Field hostKeyFile = FieldUtil.getField(obj, annotation.hostKey());
                    List<Object> valueList = new ArrayList();
                    for (Object sheetObj : sheetList) {
                        if (hostKeyFile.get(obj).equals(FieldUtil.getField(sheetObj, annotation.connectKey()).get(sheetObj))) {
                            valueList.add(sheetObj);
                        }
                    }
                    field.set(obj, valueList);
                }
            }
            list.add(obj);
        }
        return list;
    }

    private static void dualListToXls(WritableWorkbook wb, ExcelConfig config, String sheetName, Class aClass, int sheetIndex, List<?> list, Map<String, List<String>> params) throws Exception {
        if (null == list) {
            list = new ArrayList<>();
        }
        List<java.lang.reflect.Field> declaredFields = ReflectionsUtil.getClassCoverAllSuperAllField(aClass);
        WritableSheet sheet = wb.createSheet(sheetName, sheetIndex);
        int row = 0;
        Map<Integer, java.lang.reflect.Field> fieldMap = new HashMap<>();
        Map<java.lang.reflect.Field, List> sheetFieldMap = new HashMap<>();
        ExcelAttribute excelAttribute;
        int col = 0;
        for (java.lang.reflect.Field field : declaredFields) {
            excelAttribute = field.getAnnotation(ExcelAttribute.class);
            if (null != excelAttribute) {
                if (excelAttribute.isExport()) {
                    int excelCol = StringUtils.isEmpty(excelAttribute.column()) ? col++ : getExcelCol(excelAttribute.column());
                    field.setAccessible(true);
                    //根据内容自动设置列宽
                    sheet.setColumnView(excelCol, excelAttribute.name().length() * 2 + 6);
                    fieldMap.put(excelCol, field);
                    // 导出列标题
                    if (config.getHeader()) {
                        sheet.addCell(new Label(excelCol, row, excelAttribute.name(), getHeaderCellStyle()));
                    }
                    //是否为字典设置下拉
                    boolean isDictTypeField = !StringUtils.isEmpty(excelAttribute.dictType());
                    //是否为参数设置下拉
                    boolean isSpinnerParamField = !StringUtils.isEmpty(excelAttribute.spinnerParamName());
                    //设置列下拉格式
                    if (isDictTypeField || isSpinnerParamField) {
                        Label label = new Label(excelCol, 1, excelAttribute.name(), getHeaderCellStyle());
                        sheet.addCell(label);
                        //单元格设置下拉选项
                        labelSetSelect(label, isDictTypeField ? RedisDataUtil.getRedisDictValuesByDictType(excelAttribute.dictType()) : params.get(excelAttribute.spinnerParamName()));
                        //整列设置下拉选择
                        colSetSelect(sheet, label);
                    }
                }
            } else {
                field.setAccessible(true);
                ExcelSheet excelSheet = field.getAnnotation(ExcelSheet.class);
                if (null != excelSheet && excelSheet.isExport()) {
                    sheetFieldMap.put(field, new ArrayList());
                }
            }
        }
        Set<Map.Entry<Integer, java.lang.reflect.Field>> fieldEntries = fieldMap.entrySet();
        Set<Map.Entry<java.lang.reflect.Field, List>> sheetFieldEntries = sheetFieldMap.entrySet();
        // 写入内容行
        for (row = 0; row < list.size(); row++) {
            Object nowObj = list.get(row);
            for (Map.Entry<Integer, java.lang.reflect.Field> fileEntry : fieldEntries) {
                String dictType = fileEntry.getValue().getAnnotation(ExcelAttribute.class).dictType();
                String labelCont = getFieldVal(fileEntry.getValue(), nowObj);
                labelCont = StringUtils.isEmpty(dictType) ? labelCont : RedisDataUtil.getRedisDictValueByDictTypeAndDictId(dictType, labelCont);
                sheet.addCell(new Label(fileEntry.getKey(), row + 1, labelCont));
            }
            for (Map.Entry<java.lang.reflect.Field, List> fileEntry : sheetFieldEntries) {
                Object fieldVal = fileEntry.getKey().get(nowObj);
                if (null != fieldVal) {
                    fileEntry.getValue().addAll((Collection) fieldVal);
                }
            }
        }
        for (Map.Entry<java.lang.reflect.Field, List> fileEntry : sheetFieldEntries) {
            ExcelSheet annotation = fileEntry.getKey().getAnnotation(ExcelSheet.class);
            dualListToXls(wb, config, annotation.sheetName(), annotation.classObj(), ++sheetIndex, fileEntry.getValue(), params);
        }
    }

    private static String getFieldVal(java.lang.reflect.Field field, Object obj) throws IllegalAccessException {
        Object valObj = field.get(obj);
        if (null != valObj) {
            if (field.getType().equals(Date.class)) {
                return DateUtil.smartFormat((Date) valObj);
            }
            return valObj.toString();
        }
        return null;
    }

    /**
     * 单元格设置下拉选项
     *
     * @param label        单元格对象
     * @param selectValues 下拉值集合
     */
    private static void labelSetSelect(WritableCell label, List<String> selectValues) {
        if (null != selectValues && !selectValues.isEmpty()) {
            WritableCellFeatures format = new WritableCellFeatures();
            format.setDataValidationList(selectValues);
            label.setCellFeatures(format);
        }
    }

    /**
     * 列设置下拉选项
     *
     * @param sheet sheet 对象
     * @param label 单元格对象
     */
    private static void colSetSelect(WritableSheet sheet, WritableCell label) throws WriteException {
        sheet.applySharedDataValidation(label, 0, -1 - label.getRow());
    }
}
