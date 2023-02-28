package com.xqy.tms.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xqy
 * @description: TODO
 * @date 2023/2/27 20:39
 */
public class JSONUtil {
    /**
     * 对象转Map
     * @param object
     * @return
     * @throws IllegalAccessException
     */
    public static Map beanToMap(Object object) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }
        return map;
    }

}
