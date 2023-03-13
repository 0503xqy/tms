package com.xqy.tms.service.product;

import com.xqy.tms.mapper.CornerAluminumRepository;
import com.xqy.tms.model.product.CornerAluminum;
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
 * @description: CornerAluminumServiceImpl
 * @date 2023/3/10 0:00
 */
@Service
public class CornerAluminumServiceImpl implements BaseService {

    @Resource
    private CornerAluminumRepository cornerAluminumRepository;

    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        CornerAluminum cornerAluminum = new CornerAluminum();
        BeanUtils.populate(cornerAluminum,map);
        cornerAluminumRepository.save(cornerAluminum);
    }

    @Override
    public Optional findById(Long id) {
        return cornerAluminumRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return cornerAluminumRepository.findAll(pageRequest);
    }
}
