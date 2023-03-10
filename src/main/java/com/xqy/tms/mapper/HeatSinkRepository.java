package com.xqy.tms.mapper;

import com.xqy.tms.model.product.HeatSink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatSinkRepository extends JpaRepository<HeatSink, Long> {
}
