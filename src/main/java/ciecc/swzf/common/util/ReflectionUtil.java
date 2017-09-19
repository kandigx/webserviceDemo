package ciecc.swzf.common.util;

import ciecc.swzf.common.constant.PromptMessageConsts;
import ciecc.swzf.common.entity.ErrorMsgVO;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射相关的util
 *
 * @author kandigx
 * @create 2017-09-14 17:12
 */
public class ReflectionUtil {

    //格式化
    private static DecimalFormat df = new DecimalFormat("##0.0000");

    /**
     * 对象属性约束验证，根据 @Column 注解判断是否为空及其最大长度约束
     * @param clazz
     * @param obj
     * @return
     */
    public static List<ErrorMsgVO> DOColumnConstraint(Class clazz, Object obj) throws IllegalAccessException{
        List<ErrorMsgVO> columnConstraintErrorList = new ArrayList<>();

        //获取属性域数组
        Field[] fields = clazz.getDeclaredFields();

        //属性是否可为空
        Boolean nullable = true;
        int maxLength = 4000;
        int precision = 0; //Double 类型总长度
        int scale = 0; //精度

        for (Field field : fields) {
            //private 修饰的属性可访问
            field.setAccessible(true);

            //字段上是否有 @Column 注解
            boolean fieldHasAnno = field.isAnnotationPresent(Column.class);
            if (fieldHasAnno) {
                //获取属性上的 @Column 注解
                Column colAnno = field.getAnnotation(Column.class);
                nullable = colAnno.nullable();
                maxLength = colAnno.length();
                precision = colAnno.precision();
                scale = colAnno.scale();

                //得到此属性的类型
                String type = field.getType().getName();

                //获取属性值
                Object value = field.get(obj);
                if (!nullable && value == null) {
                    columnConstraintErrorList.add(new ErrorMsgVO(PromptMessageConsts.ERROR_CODE_INCOMPLETED,
                            PromptMessageConsts.ERROR_DESCR_INCOMPLETED,field.getName() + " 字段不能为空！"));
                }
                // 字符类型 或 Double 类型，验证长度
                if (value != null){
                    if ("java.lang.String".equals(type) && !RegExpUtil.strMaxLength(value, maxLength)) {
                        columnConstraintErrorList.add(new ErrorMsgVO(PromptMessageConsts.ERROR_CODE_LENGTH_OUT_OF_RANGE,
                                PromptMessageConsts.ERROR_DESCR_LENGTH_OUT_OF_RANGE,
                                field.getName() + " 长度超出范围！最大长度：" + maxLength + " ,实际长度："
                                + RegExpUtil.ChinesePhraselength(value.toString())));

                    } else if ("java.lang.Double".equals(type)
                            && !RegExpUtil.isDecimalPrecision(df.format(value),precision,scale)){
                        columnConstraintErrorList.add(new ErrorMsgVO(PromptMessageConsts.ERROR_CODE_LENGTH_OUT_OF_RANGE,
                                PromptMessageConsts.ERROR_DESCR_LENGTH_OUT_OF_RANGE,
                                field.getName() + " 长度超出范围！最大长度：" + precision + " ,精度: "
                                        + scale + " ,实际值：" + df.format(value)));
                    }
                }
            }

        }
        return columnConstraintErrorList;
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
