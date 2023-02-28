package com.xqy.tms.mapper;

import com.xqy.tms.model.FlowerTube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerTubeRepository extends JpaRepository<FlowerTube, Long> {
}
