package com.xqy.tms.model.product;

import com.xqy.tms.base.BaseModel;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 花管
 */
@Data
@Entity(name = "prd_flowertube")
@ToString
@DynamicUpdate
public class FlowerTube extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 外径
    private Integer outerDiameter;
    // 内径
    private Integer innerDiameter;
    // 最大厚壁
    private Integer maxWallThickness;
    // 最小厚壁
    private Integer minWallThickness;

    public FlowerTube() {
    }
}
