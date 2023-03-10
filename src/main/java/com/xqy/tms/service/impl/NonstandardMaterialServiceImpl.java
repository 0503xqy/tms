package com.xqy.tms.service.impl;

import com.xqy.tms.mapper.NonstandardMaterialRepository;
import com.xqy.tms.model.product.NonstandardMaterial;
import com.xqy.tms.service.BaseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

/**
 * @author xqy
 * @description: NonstandardMaterialServiceImpl
 * @date 2023/3/10 0:00
 */
@Service
public class NonstandardMaterialServiceImpl implements BaseService {

    @Resource
    private NonstandardMaterialRepository nonstandardMaterialRepository;

    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        NonstandardMaterial NonstandardMaterial = new NonstandardMaterial();
        BeanUtils.populate(NonstandardMaterial,map);
        nonstandardMaterialRepository.save(NonstandardMaterial);
    }

    @Override
    public Optional findById(Long id) {
        return nonstandardMaterialRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return nonstandardMaterialRepository.findAll(pageRequest);
    }
}
