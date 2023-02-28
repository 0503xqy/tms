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
 * 方型管
 */
@Data
@Entity(name = "prd_squaretube")
@ToString
@DynamicUpdate
public class SquareTube extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 形状
    private String shape;
    // 水平壁厚度
    private Integer horizontalWallThickness;
    // 竖直壁厚度
    private Integer verticalWallThickness;
    // 管壁是否光滑
    private Boolean smoothWall;
}
