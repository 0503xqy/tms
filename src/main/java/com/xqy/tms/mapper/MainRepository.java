package com.xqy.tms.mapper;

import com.xqy.tms.base.BaseModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Mapper
public interface MainRepository extends JpaRepository<BaseModel, Long> {

    List<BaseModel> findByProductNo(String productNo);

    int countByProductNo(String productNo);

    int countByProductNoAndIdIsNot(String productNo,Long id);
}
