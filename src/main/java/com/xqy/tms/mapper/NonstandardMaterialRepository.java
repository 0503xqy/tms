package com.xqy.tms.mapper;

import com.xqy.tms.model.product.NonstandardMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonstandardMaterialRepository extends JpaRepository<NonstandardMaterial, Long> {
}
