package com.xqy.tms.service.impl;

import com.xqy.tms.mapper.FlowerTubeRepository;
import com.xqy.tms.model.product.FlowerTube;
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
 * @description: flowerTubeRepository
 * @date 2023/3/10 0:00
 */
@Service
public class FlowerTubeServiceImpl implements BaseService {

    @Resource
    private FlowerTubeRepository flowerTubeRepository;

    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        FlowerTube flowerTube = new FlowerTube();
        BeanUtils.populate(flowerTube,map);
        flowerTubeRepository.save(flowerTube);
    }

    @Override
    public Optional findById(Long id) {
        return flowerTubeRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return flowerTubeRepository.findAll(pageRequest);
    }
}
