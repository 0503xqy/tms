package com.xqy.tms.model;

import com.xqy.tms.base.BaseModel;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 散热片
 */
@Data
@Entity(name = "prd_heatsink")
@ToString
@DynamicUpdate
public class HeatSink extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 中空
    private Integer hollow;
    // 齿数
    private Integer teethCount;
    // 齿高
    private Integer teethHeight;
    // 是否带螺孔
    private Boolean screwHole;
    // 是否对称
    private Boolean symmetrical;
    // 是否带槽
    private Boolean groove;
    // 是否梳状
    private Boolean comb;
    // 是否两侧带齿
    private Boolean teethOnBothSides;
    // 是否齿距相等
    private Boolean toothDistanceEqual;
}
