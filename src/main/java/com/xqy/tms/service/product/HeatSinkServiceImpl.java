package com.xqy.tms.service.product;

import com.xqy.tms.mapper.HeatSinkRepository;
import com.xqy.tms.model.product.HeatSink;
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
 * @description: HeatSinkServiceImpl
 * @date 2023/3/10 0:00
 */
@Service
public class HeatSinkServiceImpl implements BaseService {

    @Resource
    private HeatSinkRepository heatSinkRepository;

    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        HeatSink HeatSink = new HeatSink();
        BeanUtils.populate(HeatSink,map);
        heatSinkRepository.save(HeatSink);
    }

    @Override
    public Optional findById(Long id) {
        return heatSinkRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return heatSinkRepository.findAll(pageRequest);
    }
}
