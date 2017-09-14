package ciecc.swzf.common.interceptor;

import ciecc.swzf.common.security.Signature;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class InCallback implements CallbackHandler {

    @Qualifier("signature")
    @Autowired
    private Signature signature;

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];

        String clientUsername = callback.getIdentifier();
        System.out.println("-----------------------------" + clientUsername);
        System.out.println("-----------------------------" + signature);
        callback.setPassword("Hfzx7bx5B7GqQALUnRao3B612QNq0pAP");
//        String serverPassword = signature.getUserMap().get(clientUsername);
//        if (serverPassword != null) {
//            callback.setPassword(serverPassword);
//        }
    }
}
