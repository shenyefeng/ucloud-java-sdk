package cn.ucloud.sdk.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.ucloud.sdk.vo.UcloudInVo;

public class VoUtils {

    /**
     * InVo to TreeMap in order to change the parameters' sequence
     * @param vo
     * @return
     */
    public static TreeMap<String, Object> genMap(UcloudInVo vo) {
        TreeMap<String, Object> map = new TreeMap<String, Object>();
        genMap(vo, vo.getClass(), map);
        return map;
    }

    /**
     * Recursion method to get all fields in object
     * @param object
     * @param clazz
     * @param map
     */
    private static void genMap(Object object, Class<?> clazz, TreeMap<String, Object> map) {
        // get super class
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            // if super class not null, call herself
            genMap(object, superclass, map);
        }

        String key;
        Object value;
        for (Field field : clazz.getDeclaredFields()) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            key = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            // if field contains "_", replace it with "."
            if(key.indexOf("_") > -1) {
                key = key.replaceAll("_", ".");
            }
            value = getValue(object, field.getName());
            if (value != null) {
                map.put(key, value);
            }
        }
    }

    /**
     * Reflection method
     * @param obj
     * @param column
     * @return
     */
    private static Object getValue(Object obj, String column) {
        Object res = null;
        String method = "get" + getMethodName(column);
        try {
            Method getter = obj.getClass().getMethod(method);
            res = getter.invoke(obj);
        } catch (Exception e) {
            LogUtils.exception(VoUtils.class, e);
        }

        return res;
    }
    
    /**
     * Reflection method
     * @param column
     * @return
     */
    private static String getMethodName(String column) {
        String methodName;
        if(column.length() > 2 && column.substring(1, 2).toUpperCase().equals(column.substring(1, 2))) {
            methodName = column;
        } else {
            methodName = column.substring(0, 1).toUpperCase() + column.substring(1);
        }
        
        return methodName;
    }
    
    /**
     * Build out vo
     * @param str
     * @param type
     * @return
     */
    public static <T> T buildOutVo(String str, Class<T> type) {
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>)JsonUtils.fromJSON(str);
        Map<String, Object> resMap = new HashMap<String, Object>();
        changeMapKey(resMap, map);
        String resStr = JsonUtils.toJSON(resMap);
        return JsonUtils.fromJSON(resStr, type);
    }
    
    /**
     * Change the key's first letter to upper case
     * @param resMap
     * @param map
     */
    @SuppressWarnings("unchecked")
    private static void changeMapKey(Map<String, Object> resMap, Map<String, Object> map) {
        Map<String, Object> resMapTmp;
        List<Object> list;
        for(String key : map.keySet()) {
            if(map.get(key) instanceof Map) {
                resMapTmp = new HashMap<String, Object>();
                changeMapKey(resMapTmp, (Map<String, Object>)map.get(key));
                resMap.put(key.substring(0, 1).toLowerCase() + key.substring(1), resMapTmp);
            } else if(map.get(key) instanceof List) {
                list = new ArrayList<Object>();
                for(Object tmp : (List<Object>)map.get(key)) {
                    if(tmp instanceof Map) {
                        resMapTmp = new HashMap<String, Object>();
                        changeMapKey(resMapTmp, (Map<String, Object>)tmp);
                        list.add(resMapTmp);
                    } else {
                        list.add(tmp);
                    }
                }
                resMap.put(key.substring(0, 1).toLowerCase() + key.substring(1), list);
            } else {
                resMap.put(key.substring(0, 1).toLowerCase() + key.substring(1), map.get(key));
            }
        }
    }
}
