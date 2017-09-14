package ciecc.swzf.common.interceptor;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * @author kandigx
 * @create 2017-09-13 10:24
 */
@Component
public class OutCallback implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
        callback.setPassword("Hfzx7bx5B7GqQALUnRao3B612QNq0pAP"); //
    }
}
