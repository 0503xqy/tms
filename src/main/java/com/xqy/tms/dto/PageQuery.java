package com.xqy.tms.dto;

import com.xqy.tms.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xqy
 * @description: 分页查询
 * @date 2023/3/5 16:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery{

    private Integer pageNumber;

    private Integer pageSize;
}
