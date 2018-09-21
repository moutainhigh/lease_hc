package test.excel.entity;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelSheet;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LJ on 2018/2/28
 */
@Data
public class ExcelObj {

    @ExcelSheet(classObj = House.class, sheetName = "住房")
    List<House> houseList = new ArrayList<>();

    @ExcelSheet(classObj = Tenant.class, sheetName = "租客")
    List<Tenant> tenantList = new ArrayList<>();

    @ExcelSheet(classObj = Room.class, sheetName = "房间")
    List<Room> roomList = new ArrayList<>();

    @ExcelSheet(classObj = Pet.class, sheetName = "宠物")
    List<Pet> petList = new ArrayList<>();

}
