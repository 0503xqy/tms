package com.xqy.tms.service.product;

import com.xqy.tms.mapper.FlatBarRepository;
import com.xqy.tms.model.product.FlatBar;
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
 * @description: FlaBarServiceImpl
 * @date 2023/3/10 0:00
 */
@Service
public class FlaBarServiceImpl implements BaseService {

    @Resource
    private FlatBarRepository flatBarRepository;

    @Override
    public void saveOrUpdate(Map map) throws InvocationTargetException, IllegalAccessException {
        FlatBar FlaBar = new FlatBar();
        BeanUtils.populate(FlaBar,map);
        flatBarRepository.save(FlaBar);
    }

    @Override
    public Optional findById(Long id) {
        return flatBarRepository.findById(id);
    }

    @Override
    public Page findPage(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return flatBarRepository.findAll(pageRequest);
    }
}
