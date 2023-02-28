package com.xqy.tms.mapper;

import com.xqy.tms.model.SolidRod;
import com.xqy.tms.model.SquareTube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquareTubeRepository extends JpaRepository<SquareTube, Long> {
}
