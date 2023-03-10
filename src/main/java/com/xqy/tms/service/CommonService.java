package com.xqy.tms.service;

import com.xqy.tms.base.BaseException;
import com.xqy.tms.base.BaseModel;
import com.xqy.tms.exception.CustomException;
import com.xqy.tms.mapper.*;
import com.xqy.tms.model.product.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

@Service
public class CommonService {

    @Resource
    private CornerAluminumRepository cornerAluminumRepository;

    @Resource
    private FlatBarRepository flatBarRepository;

    @Resource
    private FlowerTubeRepository flowerTubeRepository;

    @Resource
    private HeatSinkRepository heatSinkRepository;

    @Resource
    private NonstandardMaterialRepository nonstandardMaterialRepository;

    @Resource
    private RoundTubeRepository roundTubeRepository;

    @Resource
    private SolidRodRepository solidRodRepository;

    @Resource
    private  SquareTubeRepository squareTubeRepository;

    @Resource
    private MainRepository mainRepository;

    @Transactional
    public void saveOrUpdate(Map map, String type) throws InvocationTargetException, IllegalAccessException {
        BaseModel baseModel = new BaseModel();
        BeanUtils.populate(baseModel,map);
        int count = null != baseModel.getId() ? mainRepository.countByProductNoAndIdIsNot(baseModel.getProductNo(),baseModel.getId()) :
                mainRepository.countByProductNo(baseModel.getProductNo());

        if (count > 0){
            throw new CustomException(444,"编号重复");
        }

        switch (type){
            case "CornerAluminum": {
                CornerAluminum cornerAluminum = new CornerAluminum();
                BeanUtils.populate(cornerAluminum,map);
                cornerAluminumRepository.save(cornerAluminum);
                break;
            }
            case "FlatBar" : {
                FlatBar flatBar = new FlatBar();
                BeanUtils.populate(flatBar,map);
                flatBarRepository.save(flatBar);
                break;
            }
            case "FlowerTube" : {
                FlowerTube flowerTube = new FlowerTube();
                BeanUtils.populate(flowerTube,map);
                flowerTubeRepository.save(flowerTube);
                break;
            }
            case "HeatSink" : {
                HeatSink heatSink = new HeatSink();
                BeanUtils.populate(heatSink,map);
                heatSinkRepository.save(heatSink);
                break;
            }
            case "NonstandardMaterial" : {
                NonstandardMaterial nonstandardMaterial = new NonstandardMaterial();
                BeanUtils.populate(nonstandardMaterial,map);
                nonstandardMaterialRepository.save(nonstandardMaterial);
                break;
            }
            case "RoundTube" : {
                RoundTube roundTube = new RoundTube();
                BeanUtils.populate(roundTube,map);
                roundTubeRepository.save(roundTube);
                break;
            }
            case "SolidRod" : {
                SolidRod solidRod = new SolidRod();
                BeanUtils.populate(solidRod,map);
                solidRodRepository.save(solidRod);
                break;
            }
            case "SquareTube" : {
                SquareTube squareTube = new SquareTube();
                BeanUtils.populate(squareTube,map);
                squareTubeRepository.save(squareTube);
                break;
            }
        }
    }


    public Optional findById(Long id,String type) {
        Optional optional = Optional.empty();
        switch (type){
            case "CornerAluminum": {
                optional = cornerAluminumRepository.findById(id);
                break;
            }
            case "FlatBar" : {
                optional = flatBarRepository.findById(id);
                break;
            }
            case "FlowerTube" : {
                optional = flowerTubeRepository.findById(id);
                break;
            }
            case "HeatSink" : {
                optional = heatSinkRepository.findById(id);
                break;
            }
            case "NonstandardMaterial" : {
                optional = nonstandardMaterialRepository.findById(id);
                break;
            }
            case "RoundTube" : {
                optional = roundTubeRepository.findById(id);
                break;
            }
            case "SolidRod" : {
                optional = solidRodRepository.findById(id);
                break;
            }
            case "SquareTube" : {
                optional = squareTubeRepository.findById(id);
                break;
            }
        }
        if (Optional.empty().equals(optional)){
            throw new BaseException(403,"记录不存在！");
        }
        return optional;
    }


    public Page findPage(Integer pageNumber, Integer pageSize,String type){
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);

        switch (type){
            case "CornerAluminum": {
                return cornerAluminumRepository.findAll(pageRequest);
            }
            case "FlatBar" : {
                return flatBarRepository.findAll(pageRequest);
            }
            case "FlowerTube" : {
                return flowerTubeRepository.findAll(pageRequest);
            }
            case "HeatSink" : {
                return heatSinkRepository.findAll(pageRequest);
            }
            case "NonstandardMaterial" : {
                return nonstandardMaterialRepository.findAll(pageRequest);
            }
            case "RoundTube" : {
                return roundTubeRepository.findAll(pageRequest);
            }
            case "SolidRod" : {
                return solidRodRepository.findAll(pageRequest);
            }
            case "SquareTube" : {
                return squareTubeRepository.findAll(pageRequest);
            }
            default:
                return mainRepository.findAll(pageRequest);
        }


    }
}
