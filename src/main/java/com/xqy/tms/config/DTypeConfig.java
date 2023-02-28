package com.xqy.tms.config;

import com.xqy.tms.base.BaseModel;
import com.xqy.tms.model.CornerAluminum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xqy
 * @description: TODO
 * @date 2023/2/27 20:02
 */

public class DTypeConfig {

    public static Set<String> dType = new HashSet<>();

    static {
        dType.add("CornerAluminum");
        dType.add("FlatBar");
        dType.add("FlowerTube");
        dType.add("HeatSink");
        dType.add("NonstandardMaterial");
        dType.add("RoundTube");
        dType.add("SolidRod");
        dType.add("SquareTube");
    }
}
