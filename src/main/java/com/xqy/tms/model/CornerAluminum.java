package com.xqy.tms.model;

import com.xqy.tms.base.BaseModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 角铝
 */
@Data
@Entity(name = "prd_corneraluminum")
@ToString
public class CornerAluminum extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 形状
    private String shape;
    // 是否带齿
    private Boolean withTeeth;
    // 是否壁厚均匀
    private Boolean uniformWallThickness;

    public CornerAluminum() {
    }
}