package ciecc.swzf.common.util;

/**
 * @author kandigx
 * @create 2017-09-14 15:31
 */
public class RegExpUtil {

    private static Integer maxPrice = 9999;
    private static Integer minPrice = 0;
    private static Integer maxWeight = 9999;
    private static Integer minWeight = 0;

    /**
     * 简单验证字符串日期格式，yyyy-mm-dd
     * @param str
     * @return
     */
    public static boolean isDateFormatter(String str){
        if(str.matches("^\\d{4}-\\d{2}-\\d{2}$")){
            return true;
        }
        return false;
    }

    /**
     * 验证数字，且长度固定
     * @param str
     * @param i
     * @return
     */
    public static boolean isNumberLength(Object value,int i) {
        String str = value.toString();
        if(str.matches("^\\d{"+i+"}$")){
            return true;
        }
        return false;
    }

    /**
     * 验证数字，长度范围
     * @param str
     * @param min
     * @param max
     * @return
     */
    public static boolean numberLengthRange(String str,int min,int max){
        if(str.matches("^\\d{"+ min +","+ max +"}$")){
            return true;
        }
        return false;
    }

    /**
     * 重载，验证数字最大长度
     * @param str
     * @param max
     * @return
     */
    public static boolean numberLengthRange(String str,int max){
        if(str.matches("^\\d{0,"+ max +"}$")){
            return true;
        }
        return false;
    }

    /**
     * 验证正小数，最大长度和精度
     * @param str
     * @param maxLength
     * @param dec
     * @return
     */
    public static boolean isDecimalPrecision(String str,int maxLength,int dec){
        int intLength = maxLength - dec;
        if(str.matches("^[0-9]{0,"+ intLength +"}+(.[0-9]{0,"+ dec +"})?$")){
            return true;
        }
        return false;
    }

    /**
     * 验证字符串长度限制，小于i
     * @param str
     * @param i
     * @return
     */
    public static boolean strMaxLength(Object value,int i){
        String str = value.toString();
        if(ChinesePhraselength(str) > i){
            return false;
        }
        return true;
    }

    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    /**
     * 判断对象是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNull(Object value) {
        if(value == null) {
            return true;
        }
        String str = value.toString();
        try{
            if (str == null || str.trim().equals("") || str.trim().equalsIgnoreCase("null")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return true;
        }
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param String
     *            s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    public static int ChinesePhraselength(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为1,英文字符长度为0.5
     *
     * @param String
     *            s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    public static double getLength(String s) {
        double valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < s.length(); i++) {
            // 获取一个字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为1
                valueLength += 1;
            } else {
                // 其他字符长度为0.5
                valueLength += 0.5;
            }
        }
        // 进位取整
        return Math.ceil(valueLength);
    }

    /**
     * 验证不完整信息字段
     * @param field 字段名
     * @param value 值
     * @param length 长度
     * @param isStrMaxLength 是否为验证最大长度
     * @return
     */
    public static String validateRequired(String field, String value, Integer length, Boolean isStrMaxLength) {
        String errorCode = "";
        if (isNull(value)) {
            errorCode += field + ": err-01; ";
        } else {
            errorCode += validateField(field, value, length, isStrMaxLength);
        }
        return errorCode;
    }

    /**
     * 验证日期
     * @param field
     * @param value
     * @return
     */
    public static String validateDate(String field, String value){
        String errorCode = "";
        if (isNull(value)) {
            errorCode += field + ": err-01; ";
        } else {
            if (!isDateFormatter(value)) {
                errorCode += field + ": err-03; ";
            }
        }
        return errorCode;
    }

    /**
     *
     * @param field 字段名
     * @param value 值
     * @param length 长度
     * @param isStrMaxLength 是否为验证最大长度
     * @return
     */
    public static String validateField(String field, String value, Integer length, Boolean isStrMaxLength) {
        String errorCode = "";
        if(isStrMaxLength) {
            //验证最大长度
            if (!strMaxLength(value, length)) {
                errorCode += field + ": err-03; ";
            }
        } else {
            //验证固定长度
            if (!isNumberLength(value, length)) {
                errorCode += field + ": err-02; ";
            }
        }
        return errorCode;
    }

    /**
     * 验证数字
     * @param field
     * @param value
     * @param length
     * @return
     */
    public static String validateNumber(String field, Integer value, Integer length) {
        String errorCode = "";
        if(!numberLengthRange(value.toString(), length)){
            errorCode += field + ": err-02; ";
        }
        return errorCode;
    }

    /**
     * 验证重量
     * @param value
     * @param abnormalType
     * @return
     */
    public static String validateWeight(Double value, StringBuilder abnormalType) {
        return WeightOrPrice("weight", value, abnormalType);
    }

    /**
     * 验证价格
     * @param value
     * @param abnormalType
     * @return
     */
    public static String validatePrice(Double value, StringBuilder abnormalType) {
        return WeightOrPrice("price", value, abnormalType);
    }

    /**
     * 验证重量价格
     * @param field
     * @param value
     * @param abnormalType
     * @return
     */
    private static String WeightOrPrice(String field, Double value, StringBuilder abnormalType) {
        String errorCode = "";
        if (isNull(value)) {
            errorCode += field + ": err-01; ";
        } else {
            if(field.equals("weight") && (value > maxWeight || value < minWeight)) {
                abnormalType.append(",2"); //重量异常
            } else if(field.equals("price") && (value > maxPrice || value < minPrice)) {
                abnormalType.append(",3"); //价格异常
            }
            if (!isDecimalPrecision(value.toString(), 15, 2)) {
                errorCode += field + "price: err-02; ";
            }
        }
        return errorCode;
    }

}
