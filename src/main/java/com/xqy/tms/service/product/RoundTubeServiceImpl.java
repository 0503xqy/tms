package com.xqy.tms.service.product;

import com.xqy.tms.mapper.RoundTubeRepository;
import com.xqy.tms.model.product.RoundTube;
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
 * @description: RoundTubeServiceImpl
 * @date 2023/3/10 0:00
 */
@Service
public class RoundTubeServiceImpl implements BaseService {

    @Resource
    private RoundTubeRepository roundTubeRepository;

    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        RoundTube RoundTube = new RoundTube();
        BeanUtils.populate(RoundTube,map);
        roundTubeRepository.save(RoundTube);
    }

    @Override
    public Optional findById(Long id) {
        return roundTubeRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return roundTubeRepository.findAll(pageRequest);
    }
}
