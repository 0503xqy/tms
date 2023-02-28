package com.xqy.tms.mapper;

import com.xqy.tms.model.NonstandardMaterial;
import com.xqy.tms.model.RoundTube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundTubeRepository extends JpaRepository<RoundTube, Long> {
}
