package test.excel.entity;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import com.hc.lease.common.core.excel.easyxls.annotation.ExcelSheet;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LJ on 2018/2/24
 */
@Data
public class House implements Serializable {

    @ExcelAttribute(column = "A", name = "ID")
    private Integer id;

    @ExcelAttribute(column = "B", name = "房屋类型")
    private String houseType;

    @ExcelAttribute(column = "C", name = "面积")
    private Double houseArea;

    @ExcelAttribute(column = "D", name = "装修风格", spinnerParamName = "houseDecorationStyleList")
    private Long decorationStyle;

    @ExcelSheet(classObj = Tenant.class, connectKey = "housingId", hostKey = "id", sheetName = "租客")
    private List<Tenant> tenantList;

    @ExcelSheet(classObj = Room.class, connectKey = "houseId", hostKey = "id", sheetName = "房间")
    private List<Room> roomList;

    public House() {
    }

    public House(Integer id, String houseType, Double houseArea, Long decorationStyle) {
        this.id = id;
        this.houseType = houseType;
        this.houseArea = houseArea;
        this.decorationStyle = decorationStyle;
    }

}
