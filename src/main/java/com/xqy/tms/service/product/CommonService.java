package com.xqy.tms.service.product;

import com.xqy.tms.Factory.ServiceFactory;
import com.xqy.tms.base.BaseException;
import com.xqy.tms.base.BaseModel;
import com.xqy.tms.enums.CustomExceptionEnum;
import com.xqy.tms.exception.CustomException;
import com.xqy.tms.mapper.*;
import com.xqy.tms.service.BaseService;
import com.xqy.tms.service.file.FileUtilService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

@Service
public class CommonService {

    @Resource
    private ServiceFactory serviceFactory;

    @Resource
    private MainRepository mainRepository;

    @Resource
    private FileUtilService fileUtilService;


    @Transactional
    public void saveOrUpdate(Map map, String type) throws InvocationTargetException, IllegalAccessException {
        BaseModel baseModel = new BaseModel();
        BeanUtils.populate(baseModel,map);
        Optional<BaseModel> oldBaseModel = null;
        BaseService service = serviceFactory.mType.get(type);
        if (null == service) throw new CustomException(CustomExceptionEnum.TYPE_NOTFOUND);
        if (null != baseModel.getId()){
            oldBaseModel = service.findById(baseModel.getId());
            if (Optional.empty().equals(oldBaseModel)){
                throw new CustomException(CustomExceptionEnum.PRD_NOTFOUND);
            }
        }
        int count = null != baseModel.getId() ? mainRepository.countByProductNoAndIdIsNot(baseModel.getProductNo(),baseModel.getId()) :
                mainRepository.countByProductNo(baseModel.getProductNo());
        if (count > 0) throw new CustomException(CustomExceptionEnum.PRD_REPEAT);
        if (null != baseModel.getId()){
            if (oldBaseModel.get().getImagePath() != (baseModel.getImagePath())){
                fileUtilService.moveFile(baseModel.getImagePath());
            }
        }else {
            fileUtilService.moveFile(baseModel.getImagePath());
        }
        service.saveOrUpdate(map);
    }


    public Optional findById(Long id,String type) {
        Optional optional = Optional.empty();
        BaseService service = serviceFactory.mType.get(type);
        if (null == service) throw new CustomException(CustomExceptionEnum.TYPE_NOTFOUND);
        optional= service.findById(id);
        if (Optional.empty().equals(optional))throw new CustomException(CustomExceptionEnum.PRD_NOTFOUND);
        return optional;
    }


    public Page findPage(Integer pageNumber, Integer pageSize,String type){
        BaseService service = serviceFactory.mType.get(type);
        if (null == service) throw new CustomException(CustomExceptionEnum.TYPE_NOTFOUND);
        return service.findPage(pageNumber,pageSize);
    }
}
