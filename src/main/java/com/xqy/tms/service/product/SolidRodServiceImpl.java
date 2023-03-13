package com.xqy.tms.service.product;

import com.xqy.tms.mapper.SolidRodRepository;
import com.xqy.tms.model.product.SolidRod;
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
 * @description: SolidRodServiceImpl
 * @date 2023/3/10 0:00
 */
@Service
public class SolidRodServiceImpl implements BaseService {

    @Resource
    private SolidRodRepository solidRodRepository;

    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        SolidRod SolidRod = new SolidRod();
        BeanUtils.populate(SolidRod,map);
        solidRodRepository.save(SolidRod);
    }

    @Override
    public Optional findById(Long id) {
        return solidRodRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return solidRodRepository.findAll(pageRequest);
    }
}
