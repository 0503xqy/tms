package com.xqy.tms.service.product;

import com.xqy.tms.mapper.SquareTubeRepository;
import com.xqy.tms.model.product.SquareTube;
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
 * @description: SquareTubeServiceImpl
 * @date 2023/3/10 0:00
 */
@Service
public class SquareTubeServiceImpl implements BaseService {

    @Resource
    private SquareTubeRepository squareTubeRepository;

    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        SquareTube SquareTube = new SquareTube();
        BeanUtils.populate(SquareTube,map);
        squareTubeRepository.save(SquareTube);
    }

    @Override
    public Optional findById(Long id) {
        return squareTubeRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return squareTubeRepository.findAll(pageRequest);
    }
}
