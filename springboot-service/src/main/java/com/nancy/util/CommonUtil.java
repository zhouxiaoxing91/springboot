package com.nancy.util;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by guangfeng.zhou on 2017/7/13.
 */
public class CommonUtil {
    /**
     * @description: 判定任意对象是否为空
     * @param: obj
     * @return: boolean
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null)
            return true;
        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    /**
     * @description: 拼凑SQL in 字符
     * @param: str
     * @return: String
     */
    public static String toInSql(String[] str) {
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < str.length; x++) {
            sb.append("'");
            sb.append(str[x].replaceAll(",", ""));
            sb.append("',");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * map 转换 javabean
     *
     * @param map
     * @param T
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws IntrospectionException
     * @throws InstantiationException
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> T) throws
                                                                      IllegalAccessException,
                                                                      IllegalArgumentException,
                                                                      InvocationTargetException,
                                                                      IntrospectionException,
                                                                      InstantiationException {
        if ( map.isEmpty()||map==null )
            return null;
        Map<String, Object> mapTemp = new HashMap<>();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            Object value = map.get(key);
            key = key.toUpperCase(Locale.US).replaceAll("_", "");
            mapTemp.put(key, value);
        }

        T bean = T.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(T);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            String keyUpperCase = key.toUpperCase(Locale.US);
            if (mapTemp.containsKey(keyUpperCase)) {
                Object value = mapTemp.get(keyUpperCase);
                //                Method setter = property.getWriteMethod();
                //                setter.invoke(bean, value);
                BeanUtils.copyProperty(bean, key, value); // 包含类型转换
            }
        }
        return bean;
    }

    /**
     * javabean 转换 map
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws IntrospectionException
     */
    public static Map<String, Object> bean2Map(Object obj) throws
                                                           IllegalAccessException,
                                                           IllegalArgumentException,
                                                           InvocationTargetException,
                                                           IntrospectionException,
                                                           InstantiationException {

        if (obj == null)
            return null;
        Map<String, Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if ( !key.equals("class") ) { //  过滤class属性
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                map.put(key, value);
            }
        }
        return map;
    }

    /**
     * 将 List<Map>对象转化为List<javaBean>
     *
     * @param listMap
     * @param T
     * @return
     * @throws Exception
     */
    public static <T> List<T> convertListMap2ListBean(List<Map<String, Object>> listMap, Class<T> T) throws Exception {
        List<T> listBean = new ArrayList<>();
        if ( listMap!=null && !listMap.isEmpty() ) {
            for (int i=0, n=listMap.size(); i < n; i++) {
                Map<String, Object> map = listMap.get(i);
                T bean = map2Bean(map, T);
                listBean.add(bean);
            }
            return listBean;
        }
        return listBean;
    }

    /**
     *  将list中javabean转换为指定类型 javabean
     *
     * @param list
     * @param T
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @return list
     */
    public static <T> List<T> convertList2ListType(List list, Class<T> T) throws
                                                                          InvocationTargetException,
                                                                          InstantiationException,
                                                                          IllegalAccessException {
        List listBean = new ArrayList<>();
        for (int x=0,length=list.size(); x<length; x++) {
            Object dst = T.newInstance();
            BeanUtils.copyProperties(dst, list.get(x));
            listBean.add(dst);
        }
        return listBean;
    }

}
