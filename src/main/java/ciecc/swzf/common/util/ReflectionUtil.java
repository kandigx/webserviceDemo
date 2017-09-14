package ciecc.swzf.common.util;

import ciecc.swzf.common.exception.IncompleteException;

import javax.persistence.Column;
import java.lang.reflect.Field;

/**
 * 反射相关的util
 *
 * @author kandigx
 * @create 2017-09-14 17:12
 */
public class ReflectionUtil {

    /**
     * 对象属性约束验证，根据 @Column 注解判断是否为空和最大长度
     * @param obj
     * @param clazz
     * @return
     */
    public static String DOConstraint(Object obj, Class clazz){
        String msg = "数据符合对接标准！";
        //获取属性域数组
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //private 修饰的属性可访问
            field.setAccessible(true);
            //获取属性上的 @Column 注解
            Column column = field.getAnnotation(Column.class);
            //属性是否可为空
            Boolean nullable = column.nullable();
            //得到此属性的类型
            String type = field.getType().toString();

            try {
                //获取属性值
                Object value = field.get(obj);
                if (!nullable && value == null) {
                    msg = "数据不完整！" + clazz.getName() + " 中的 " + field.getName() + " 字段不能为空！";
                    throw new IncompleteException(msg);
                }
                // 字符类型 或 Double 类型，验证长度
                if (("String".equals(type) || "Double".equals(type))
                        && !RegExpUtil.strMaxLength(value,column.length())) {
                    msg = "数据字段长度超出标准范围！" + clazz.getName() + " 中的 " + field.getName()
                            + " 长度超出范围！最大长度：" + column.length() + " ,实际长度："
                            + RegExpUtil.ChinesePhraselength(value.toString());
                    throw new IndexOutOfBoundsException(msg);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IncompleteException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            } finally {
                return msg;
            }

        }
        return msg;
    }

    /**
     * 单个属性的约束判断
     * @param name
     * @param value
     * @return
     */
    public static String attributeConstraint(String name, Object value){
        //todo
        return null;
    }

}
