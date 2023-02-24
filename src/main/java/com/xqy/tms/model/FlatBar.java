package com.xqy.tms.model;

import com.xqy.tms.base.BaseModel;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 扁条
 */
@Data
@Entity(name = "prd_flatbar")
@ToString
public class FlatBar extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 形状
    private String shape;

    public FlatBar() {
    }
}