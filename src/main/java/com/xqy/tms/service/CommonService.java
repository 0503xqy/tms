package com.xqy.tms.service;

import com.xqy.tms.base.BaseException;
import com.xqy.tms.config.DTypeConfig;
import com.xqy.tms.dto.Result;
import com.xqy.tms.mapper.*;
import com.xqy.tms.model.*;
import com.xqy.tms.utils.JSONUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;


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




    public void saveOrUpdateCornerAluminum(Map map,String type) throws InvocationTargetException, IllegalAccessException {
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
            case "solidRod" : {
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


    public Optional findById(Long id,String type) throws IllegalAccessException {
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
        }
        if (Optional.empty().equals(optional)){
            throw new BaseException(403,"记录不存在！");
        }
        return optional;
    }
    
}
