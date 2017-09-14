package ciecc.swzf.common.exception;

/**
 * 指标项错误，不在制定范围之内
 *
 * @author kandigx
 * @create 2017-09-14 17:51
 */
public class IndexOutOfBoundsException extends Exception {

    public IndexOutOfBoundsException(String message) {
        super(message);
    }
}
