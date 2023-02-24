package com.xqy.tms.model;

import com.xqy.tms.base.BaseModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 异型材
 */
@Data
@Entity(name = "prd_nonstandardmaterial")
@ToString
public class NonstandardMaterial extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 中空距离
    private Integer hollowDistance;
    // 齿数
    private Integer teethCount;
    // 是否带螺孔
    private Boolean screwHole;
    // 是否有圆孔
    private Boolean roundHole;
    // 是否有方孔
    private Boolean squareHole;
}
