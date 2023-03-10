package com.xqy.tms.service.impl;

import com.xqy.tms.base.BaseModel;
import com.xqy.tms.mapper.MainRepository;
import com.xqy.tms.service.BaseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

@Service
public class MainServiceImpl implements BaseService {

    @Resource
    private MainRepository mainRepository;
    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        BaseModel baseModel = new BaseModel();
        BeanUtils.populate(baseModel,map);
        mainRepository.save(baseModel);
    }

    @Override
    public Optional findById(Long id) {
        return mainRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return mainRepository.findAll(pageRequest);
    }
}
