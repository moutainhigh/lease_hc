package test.excel.entity;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import lombok.Data;

/**
 * Created by LJ on 2018/2/27
 */
@Data
public class Room {

    /**
     * 归属房子ID
     */
    @ExcelAttribute(column = "A", name = "归属房子ID")
    private Integer houseId;

    /**
     * 房间名称
     */
    @ExcelAttribute(column = "B", name = "房间名称")
    private String roomName;

    /**
     * 房间面积
     */
    @ExcelAttribute(column = "C", name = "房间面积")
    private Integer roomArea;

    /**
     * 装饰风格
     */
    @ExcelAttribute(column = "D", name = "装饰风格")
    private String decorativeStyle;
}
