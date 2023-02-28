package com.xqy.tms.mapper;

import com.xqy.tms.model.NonstandardMaterial;
import com.xqy.tms.model.SolidRod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolidRodRepository extends JpaRepository<SolidRod, Long> {
}
