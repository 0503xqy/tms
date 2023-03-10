package com.xqy.tms.service;

import org.springframework.data.domain.Page;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

public interface BaseService {
    void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException;
    Optional findById(Long id);
    Page findPage(Integer pageNumber, Integer pageSize);
}
