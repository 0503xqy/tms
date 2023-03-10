package com.xqy.tms.mapper;

import com.xqy.tms.model.product.RoundTube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundTubeRepository extends JpaRepository<RoundTube, Long> {
}
