package test.excel;

import com.hc.lease.common.core.excel.easyxls.bean.ExcelConfig;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.excel.easyxls.common.XlsUtil;
import jxl.Workbook;
import org.joda.time.DateTime;
import test.base.BaseTest;
import test.excel.entity.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Excel 工具类导入导出测试类
 * ps:测试前需将 hc-lease-baseInfo-adapter 模块启动，将字典数据存入Redis缓存中。
 * Created by LJ on 2018/3/5
 */
//@Slf4j
public class ExcelTest extends BaseTest {

    /**
     * 所有关联对象导出
     */
    //@Test
    public void allRelevanceObjExcelExport() {
        ExcelObj excelObj = new ExcelObj();
        excelObj.setHouseList(getHouses());
        excelObj.setPetList(getPets());
        excelObj.setRoomList(getRooms());
        excelObj.setTenantList(getTenants());
        //XlsUtil.objToXls(getExcelConfig(), excelObj, "E:\\", DateUtil.getDateYmd(DateTime.now().toDate()) + "_1", getMap());
    }

    /**
     * 组合关联列表导入
     */
    //@Test
    public void combinationRelevanceObjExcelImport() throws Exception {
        //log.info("list: {}", excelImport());
    }

    /**
     * 组合关联列表导出
     */
    //@Test
    public void combinationRelevanceObjExcelExport() throws Exception {
        List<House> houses = excelImport();
        XlsUtil.listToXls(getExcelConfig(), houses, "E:\\", DateUtil.getDateYmd(DateTime.now().toDate()) + "_2", null);
    }

    /**
     * Excel模板导出
     */
    //@Test
    public void excelTemplateExport() throws Exception {
        ExcelObj excelObj = new ExcelObj();
        //XlsUtil.objToXls(getExcelConfig(), excelObj, "E:\\", DateUtil.getDateYmd(DateTime.now().toDate()) + "_3", getMap());
    }

    private List<House> excelImport() throws Exception {
        allRelevanceObjExcelExport();
        String filePath = "E:\\" + DateUtil.getDateYmd(DateTime.now().toDate()) + "_1.xls";
        Workbook wb = Workbook.getWorkbook(new File(filePath));


        List<House> list = (List<House>) XlsUtil.workbookToList(getExcelConfig(), wb);
        return list;
    }

    private ExcelConfig getExcelConfig() {
        ExcelConfig config = new ExcelConfig.Builder(House.class)
                .sheetName("住房")
                .sheetNum(0)
                .startRow(1)
                .build();
        return config;
    }

    private Map<String, List<String>> getMap() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> houseDecorationStyleList = new ArrayList<>();
        houseDecorationStyleList.add("北欧");
        houseDecorationStyleList.add("简欧");
        houseDecorationStyleList.add("新中式");
        houseDecorationStyleList.add("地中海");
        map.put("houseDecorationStyleList", houseDecorationStyleList);
        return map;
    }

    private List<House> getHouses() {
        //测试字典数据插入
//        INSERT INTO "public"."lease_dict" ("id", "parent_id", "label", "value", "type", "description", "marked_graph", "sort", "create_by", "create_time", "update_by", "update_time", "is_enable") VALUES ('44', NULL, '1', '北欧', 'DecorationStyle', '装修风格', '', '1', '1', '2018-02-28 16:22:46.647411', '1', '2018-02-28 16:22:46.647411', 't');
//        INSERT INTO "public"."lease_dict" ("id", "parent_id", "label", "value", "type", "description", "marked_graph", "sort", "create_by", "create_time", "update_by", "update_time", "is_enable") VALUES ('45', NULL, '2', '简欧', 'DecorationStyle', '装修风格', '', '1', '1', '2018-02-28 16:22:46.647411', '1', '2018-02-28 16:22:46.647411', 't');
//        INSERT INTO "public"."lease_dict" ("id", "parent_id", "label", "value", "type", "description", "marked_graph", "sort", "create_by", "create_time", "update_by", "update_time", "is_enable") VALUES ('46', NULL, '3', '新中式', 'DecorationStyle', '装修风格', '', '1', '1', '2018-02-28 16:22:46.647411', '1', '2018-02-28 16:22:46.647411', 't');
//        INSERT INTO "public"."lease_dict" ("id", "parent_id", "label", "value", "type", "description", "marked_graph", "sort", "create_by", "create_time", "update_by", "update_time", "is_enable") VALUES ('47', NULL, '4', '地中海', 'DecorationStyle', '装修风格', '', '1', '1', '2018-02-28 16:23:19.458003', '1', '2018-02-28 16:23:19.458003', 't');
        List<House> houses = new ArrayList<>();
        House house1 = new House(1, "别墅", 1000D, 45L);
        House house2 = new House(2, "公寓", 80D, 46L);
        House house3 = new House(3, "奢华豪宅", 10000D, 47L);
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        return houses;
    }

    private List<Room> getRooms() {
        return new ArrayList<>();
    }

    private List<Pet> getPets() {
        List<Pet> pets = new ArrayList<>();
        Pet pet1 = new Pet(1, 1, "狗", "萨摩耶", "纯白", 1d);
        Pet pet2 = new Pet(2, 1, "猫", "布偶", "纯白", 1d);
        Pet pet3 = new Pet(3, 2, "狗", "金毛", "金黄", 2d);
        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        return pets;
    }

    private List<Tenant> getTenants() {
        List<Tenant> tenants = new ArrayList<>();
        Tenant tenant1 = new Tenant(1, 1, "小溪", "男", 23, 178d);
        Tenant tenant2 = new Tenant(2, 2, "小岸", "男", 21, 180d);
        Tenant tenant3 = new Tenant(3, 1, "小雪", "女", 20, 168d);
        tenants.add(tenant1);
        tenants.add(tenant2);
        tenants.add(tenant3);
        return tenants;
    }


}
