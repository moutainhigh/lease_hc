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
public class Tenant implements Serializable {

    @ExcelAttribute(column = "A", name = "ID")
    private Integer id;

    @ExcelAttribute(column = "B", name = "住房ID")
    private Integer housingId;

    @ExcelAttribute(column = "C", name = "昵称")
    private String species;

    @ExcelAttribute(column = "D", name = "性别")
    private String breed;

    @ExcelAttribute(column = "E", name = "年龄")
    private Integer age;

    @ExcelAttribute(column = "F", name = "身高")
    private Double stature;

    @ExcelSheet(classObj = Pet.class, connectKey = "masterId", hostKey = "id", sheetName = "宠物")
    private List<Pet> petList;

    public Tenant() {
    }

    public Tenant(Integer id, Integer housingId, String species, String breed, Integer age, Double stature) {
        this.id = id;
        this.housingId = housingId;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.stature = stature;
    }
}
