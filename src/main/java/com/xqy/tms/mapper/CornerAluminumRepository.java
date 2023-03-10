package com.xqy.tms.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xqy.tms.model.CornerAluminum;
import org.springframework.stereotype.Repository;

@Repository
public interface CornerAluminumRepository extends JpaRepository<CornerAluminum,Long> {
}
