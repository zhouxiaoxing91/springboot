package com.shenma.util;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

public class MapUtils {
    public static String getString(Map<String, Object> param, String key) {
        if (param != null && param.get(key) != null) {
            return String.valueOf(param.get(key));
        }
        return "";
    }

    public static String getStr(Map<String, Object> param, String key) {
        if (param != null) {
            return String.valueOf(param.get(key));
        }
        return "";
    }

    /**
     * Map key 排序
     * @param map
     * @return
     */
    public static Map<String, String> order(Map<String, String> map) {
        HashMap<String, String> tempMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(
                map.entrySet());

        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i < infoIds.size(); i++) {
            Map.Entry<String, String> item = infoIds.get(i);
            tempMap.put(item.getKey(), item.getValue());
        }
        return tempMap;
    }

    /**
     * 转换对象为map
     * @param object
     * @param ignore
     * @return
     */
    public static Map<String, Object> objectToMap(Object object, String... ignore) {
        Map<String, Object> tempMap = new LinkedHashMap<String, Object>();
        for (Field f : object.getClass().getDeclaredFields()) {
            if (!f.isAccessible()) {
                f.setAccessible(true);
            }
            boolean ig = false;
            if (ignore != null && ignore.length > 0) {
                for (String i : ignore) {
                    if (i.equals(f.getName())) {
                        ig = true;
                        break;
                    }
                }
            }
            if (ig) {
                continue;
            } else {
                Object o = null;
                try {
                    o = f.get(object);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                tempMap.put(f.getName(), o == null ? "" : o.toString());
            }
        }
        return tempMap;
    }

    /**
     * url 参数串连
     * @param map
     * @param keyLower
     * @param valueUrlencode
     * @return
     */
    public static String mapJoin(Map<String, String> map, boolean keyLower, boolean valueUrlencode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : map.keySet()) {
            if (map.get(key) != null && !"".equals(map.get(key))) {
                try {
                    String temp = (key.endsWith("_") && key.length() > 1) ? key.substring(0,
                            key.length() - 1) : key;
                    stringBuilder
                            .append(keyLower ? temp.toLowerCase() : temp)
                            .append("=")
                            .append(
                                    valueUrlencode ? URLEncoder.encode(map.get(key), "utf-8").replace("+",
                                            "%20") : map.get(key)).append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    /**
     * 简单 xml 转换为 Map
     * @param xml
     * @return
     */
    public static Map<String, String> xmlToMap(String xml) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document document = documentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getChildNodes();
            Map<String, String> map = new LinkedHashMap<String, String>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element e = (Element) nodeList.item(i);
                map.put(e.getNodeName(), e.getNodeValue());
            }
            return map;
        } catch (DOMException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[] getQueryParam(Object... args) {
        List<Object> list = new ArrayList<Object>();
        if (args == null || args.length <= 0) {
            return new Object[0];
        }
        for (Object obj : args) {
            list.add(obj);
        }
        return list.toArray();
    }

    public static Integer getStringInteger(Map<String, Object> map, String key) {
        String value = map.get(key).toString();
        if (value == null) {
            return 0;
        }

        return Integer.parseInt(value);
    }

    public static Integer getInteger(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value == null) {
            return 0;
        }
        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).intValue();
        }
        if (value instanceof Double) {
            Double doubleValue = (Double) value;
            return doubleValue.intValue();
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Long) {
            Long longValue = (Long) value;
            return longValue.intValue();
        }
        if (value instanceof String && ((String) value).indexOf(".") <= -1) {
            return Integer.parseInt(String.valueOf(value));
        }
        return 0;
    }

    public static Double getDouble(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value == null) {
            return 0.0;
        }
        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).doubleValue();
        }
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Integer) {
            return ((Integer) value).doubleValue();
        }
        return 0.0;
    }

    /**
     * 把map的value由String 转为 Object
     * @param map
     * @return
     */
    public static Map<String, Object> switchMap(Map<String, String> map) {

        Map<String, Object> result = new HashMap<String, Object>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            result.put(entry.getKey(), (Object) entry.getValue());
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    public static Object convertMap(Class type, Map<String, Object> map)
            throws IntrospectionException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        Object obj = type.newInstance();

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {

                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    /**
     * 对象转成map
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> beanToMap(Object obj) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return params;
    }
}
