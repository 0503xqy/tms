package com.xqy.tms.base;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@MappedSuperclass
public class BaseModel {
    
    private String productNo;

    private String imagePath;

    private String imageNumber;


    /*理论重量*/
    private Double theoryWeight;


    private Date createTime;


    private Date updateTime;


    private Long createUserId;

    private String createUsername;

    private int height;


    private int width;


    private String status;


}
