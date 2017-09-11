package demo.ws.soap_spring_cxf_wss4j;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * @author Kang
 * @create 2017-09-06 14:34
 */
@Component
public class ServerPasswordCallback implements CallbackHandler {

    @Autowired
    private SignatureUser user;

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

        WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];

        String clientUsername = callback.getIdentifier();
        String serverPassword = user.getUserMap().get(clientUsername);
        if (serverPassword != null) {
            callback.setPassword(serverPassword);
        }

    }
}
