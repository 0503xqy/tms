package com.xqy.tms.mapper;

import com.xqy.tms.model.product.FlatBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatBarRepository extends JpaRepository<FlatBar, Long> {
}
