package com.xqy.tms.Factory;

import com.xqy.tms.service.BaseService;
import com.xqy.tms.service.impl.CornerAluminumServiceImpl;
import com.xqy.tms.service.impl.FlaBarServiceImpl;
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

    public static Set<String> dType = new HashSet<>();
    public  Map<String, BaseService> mType = new HashMap<>();

    @Resource
    private CornerAluminumServiceImpl cornerAluminumServiceImpl;

    @Resource
    private FlaBarServiceImpl flaBarService;
    static {
        dType.add("CornerAluminum");
        dType.add("FlatBar");
        dType.add("FlowerTube");
        dType.add("HeatSink");
        dType.add("NonstandardMaterial");
        dType.add("RoundTube");
        dType.add("SolidRod");
        dType.add("SquareTube");
        dType.add("Main");
    }

    @PostConstruct
    public void init(){
        mType.put("CornerAluminum", cornerAluminumServiceImpl);
        mType.put("FlatBar",flaBarService);
    }

}
