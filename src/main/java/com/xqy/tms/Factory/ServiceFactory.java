package com.xqy.tms.Factory;

import com.xqy.tms.mapper.MainRepository;
import com.xqy.tms.service.BaseService;
import com.xqy.tms.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xqy
 * @description: TODO
 * @date 2023/2/27 20:02
 */

@Component
public class ServiceFactory {
    
    public  Map<String, BaseService> mType = new HashMap<>();

    @Resource
    private CornerAluminumServiceImpl cornerAluminumService;

    @Resource
    private FlaBarServiceImpl flaBarService;
    
    @Resource
    private FlowerTubeServiceImpl flowerTubeService;
    
    @Resource
    private HeatSinkServiceImpl heatSinkService;
    
    @Resource
    private NonstandardMaterialServiceImpl nonstandardMaterialService;
    
    @Resource
    private RoundTubeServiceImpl roundTubeService;
    
    @Resource
    private SolidRodServiceImpl solidRodService;
    
    @Resource
    private  SquareTubeServiceImpl squareTubeService;
    
    @Resource
    private MainServiceImpl mainService;
    
    @PostConstruct
    public void init(){
        mType.put("CornerAluminum", cornerAluminumService);
        mType.put("FlatBar",flaBarService);
        mType.put("FlowerTube",flowerTubeService);
        mType.put("HeatSink",heatSinkService);
        mType.put("NonstandardMaterial",nonstandardMaterialService);
        mType.put("RoundTube",roundTubeService);
        mType.put("SolidRod",solidRodService);
        mType.put("SquareTube",squareTubeService);
        mType.put("Main",mainService);
    }

}
