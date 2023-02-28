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
 * 圆管
 */
@Data
@Entity(name = "prd_roundtube")
@ToString
@DynamicUpdate
public class RoundTube extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 外径
    private Integer outerDiameter;
    // 内径
    private Integer innerDiameter;

    public RoundTube() {
    }
}
