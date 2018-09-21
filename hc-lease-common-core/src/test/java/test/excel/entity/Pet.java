package test.excel.entity;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by LJ on 2018/2/24
 */
@Data
public class Pet implements Serializable {

    @ExcelAttribute(column = "A", name = "ID")
    private Integer id;

    @ExcelAttribute(column = "B", name = "主人ID")
    private Integer masterId;

    @ExcelAttribute(column = "C", name = "物种")
    private String species;

    @ExcelAttribute(column = "D", name = "品种")
    private String breed;

    @ExcelAttribute(column = "E", name = "颜色")
    private String houseArea;

    @ExcelAttribute(column = "F", name = "年龄")
    private Double age;

    public Pet() {
    }

    public Pet(Integer id, Integer masterId, String species, String breed, String houseArea, Double age) {
        this.id = id;
        this.masterId = masterId;
        this.species = species;
        this.breed = breed;
        this.houseArea = houseArea;
        this.age = age;
    }
}
