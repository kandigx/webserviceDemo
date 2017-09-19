package test;

import java.text.DecimalFormat;

/**
 * @author kandigx
 * @create 2017-09-18 14:51
 */
public class Test {

    @org.junit.Test
    public void testBeanUtils(){
        DecimalFormat df = new DecimalFormat("##0.0000");

        System.out.println(df.format(1299536258412.3654) );
    }



}
