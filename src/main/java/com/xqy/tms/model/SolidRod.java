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
 * 实心棒
 */
@Data
@Entity(name = "prd_solidrod")
@ToString
@DynamicUpdate
public class SolidRod extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // 长外径
    private Integer longOuterDiameter;
    // 短外径
    private Integer shortOuterDiameter;
}
