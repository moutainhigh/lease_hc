package hc.lease.common.util;

import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ListUtil {

    public static List<Long> typeChange(Collection<?> e) {
        if (e != null && !e.isEmpty()) {
            List<Long> list = new ArrayList<Long>();
            for (Object object : e) {
                if (object != null) {
                    list.add(Long.parseLong(object.toString()));
                }
            }
            return list;
        }
        return null;
    }

    /**
     * 空值 则返回 空List数组
     *
     * @param obj
     * @return
     */
    public static Object objectIsNullToList(Object obj) {
        obj = obj == null || obj == "" ? new ArrayList<Object>() : obj;
        return obj;
    }

    /**
     * 空值 则返回 空Map
     *
     * @param obj
     * @return
     */
    public static Object objectIsNullToMap(Object obj) {
        obj = obj == null || obj == "" ? new HashMap<String, Object>() : obj;
        return obj;
    }

    /**
     * 将一个 JavaBean 对象转化为一个 Map
     *
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的 Map 对象
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map<String, Object> convertBean(Object bean) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        if (bean != null) {
            Class type = bean.getClass();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        if ("realityEndDate".equals(propertyName)) {
                            Date result_date = (Date) readMethod.invoke(bean, new Object[0]);
                            //returnMap.put(propertyName, DateUtils.formatDateTime(result_date));
                        } else {
                            returnMap.put(propertyName, result);
                        }
                    }
                /*
                else {
					returnMap.put(propertyName, "");
				}
				*/
                }
            }
        }
        return returnMap;
    }

    /**
     * 处理图片路径
     *
     * @param str
     * @param accessUrl
     * @return
     */
    public static String dealImgUrl(String str, String accessUrl) {
        if (StringUtils.isNotBlank(str)) {
            str = accessUrl + str;
        }
        return str;
    }

    public static List<String> stringToList(String obj) {
        List<String> orderNumberList = new ArrayList<String>();
        if (StringUtils.isNotBlank(obj)) {
            if (obj.contains(",")) {
                String[] objStr = obj.split(",");
                for (int i = 0; i < objStr.length; i++) {
                    String str = objStr[i];
                    orderNumberList.add(str);
                }
            } else {
                orderNumberList.add(obj);
            }
        }
        return orderNumberList;
    }

    /**
     * 删除ArrayList中重复元素，保持顺序
     *
     * @param list
     */
    public static List removeDuplicateWithOrder(List list) {
        if (list != null) {
            if (list.size() > 0) {
                Set set = new HashSet();
                List newList = new ArrayList();
                for (Iterator iter = list.iterator(); iter.hasNext(); ) {
                    Object element = iter.next();
                    if (set.add(element))
                        newList.add(element);
                }
                list.clear();
                list.addAll(newList);
            }
        }

        System.out.println(" removeDuplicateWithOrder = list=== " + list);
        return list;
    }


    /**
     * 判断 字符是否 包含在 List里
     *
     * @param list
     * @param item
     * @return
     */
    public static Boolean containsList(List list, String item) {
        if (list != null) {
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    Long id = (Long) list.get(i);
                    if (item.equals(id.toString())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * list 截取固定条数
     * @param list
     * @param skip
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> List<T> getSubListPage(List<T> list, int skip, int pageSize) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int startIndex = skip * pageSize;
        int endIndex = (skip + 1) * pageSize;
        if (startIndex > endIndex || startIndex > list.size()) {
            return null;
        }
        if (endIndex > list.size()) {
            endIndex = list.size();
        }
        return list.subList(startIndex, endIndex);
    }



}
