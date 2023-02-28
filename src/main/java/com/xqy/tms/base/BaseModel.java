package com.xqy.tms.base;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity(name = "prd_main")
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNo;

    private String imagePath;

    private String imageNumber;


    /*理论重量*/
    private Double theoryWeight;


    private String createTime;


    private String updateTime;


    private Long createUserId;

    private String createUsername;

    private int height;


    private int width;


    private String status;


}
