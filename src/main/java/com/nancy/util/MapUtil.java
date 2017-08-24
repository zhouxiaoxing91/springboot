package com.nancy.util;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.util.*;

/**
 * ${Descriptions}
 * Created by zhoujifeng on 2017/7/12.
 */
public class MapUtil {
    private static Logger log = LoggerFactory.getLogger(MapUtil.class);

    public static Object convertMap(Class type, Map<String, Object> map) throws Exception {
        Object obj = null;
        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            Map<String,Object> tempMap = toReplaceKeyLow(map);
             obj = type.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for(int i = 0; i < propertyDescriptors.length; ++i) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName().toLowerCase();
                if(tempMap.containsKey(propertyName)) {
                    Object value = tempMap.get(propertyName);
                    Object[] args = null;
                    if( value instanceof BigDecimal){
                        args = new Object[]{((BigDecimal) value).doubleValue()};
                    } else {
                        args = new Object[]{value};
                    }
                    descriptor.getWriteMethod().invoke(obj, args);
                }
            }
        } catch (Exception e){
            log.error("transfer map to bean failed" ,e);
            throw new Exception("transfer map to bean failed");
        }


        return obj;
    }

    public static Map<String, Object> toReplaceKeyLow(Map<String, Object> map) {
        Map re_map = new HashMap();
        if(re_map != null) {
            Iterator var2 = map.entrySet().iterator();

            while(var2.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var2.next();
                re_map.put(underlineToCamel((String)entry.getKey()), map.get(entry.getKey()));
            }

            map.clear();
        }

        return re_map;
    }
    private static String underlineToCamel(String key){
        return key.replaceAll("_","");
    }




    /**
     * 将 List<Map>对象转化为List<JavaBean>
     * @param listMap
     * @param T
     * @param <T>
     * @return
     * @throws Exception
     */

    public static <T> List<T> convertListMap2ListBean(List<Map<String, Object>> listMap, Class<T> T)
            throws Exception
    {
        List<T> beanList = new ArrayList<>();
        if (listMap != null && !listMap.isEmpty())
        {
            for (int i = 0, n = listMap.size(); i < n; i++)
            {
                Map<String, Object> map = listMap.get(i);
                T bean = convertMap2Bean(map, T);
                beanList.add(bean);
            }
            return beanList;
        }
        return beanList;
    }

    /**
     * 将 Map对象转化为JavaBean
     * @param map
     * @param T
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T convertMap2Bean(Map<String, Object> map, Class<T> T)
            throws Exception
    {
        if (map == null || map.size() == 0)
        {
            return null;
        }
        //获取map中所有的key值，全部更新成大写，添加到keys集合中,与mybatis中驼峰命名匹配
        Object mvalue = null;
        Map<String, Object> newMap = new HashMap<>();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while(it.hasNext()){
            String key = it.next().getKey();
            mvalue = map.get(key);
            if (key.indexOf("_") != -1)
            {
                key = key.replaceAll("_", "");
            }
            newMap.put(key.toUpperCase(Locale.US), mvalue);
        }

        BeanInfo beanInfo = Introspector.getBeanInfo(T);
        T bean = T.newInstance();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0, n = propertyDescriptors.length; i < n; i++)
        {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            String upperPropertyName = propertyName.toUpperCase();

            if (newMap.keySet().contains(upperPropertyName))
            {
                Object value = newMap.get(upperPropertyName);
                //这个方法不会报参数类型不匹配的错误。
                BeanUtils.copyProperty(bean, propertyName, value);
            }
        }
        return bean;
    }



}
