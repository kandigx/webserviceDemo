package demo.ws.soap_spring_cxf_wss4j;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Kang
 * @create 2017-09-11 15:49
 */
@Component
public class SignatureUser {

    private Map<String, String> userMap;

    public Map<String, String> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, String> userMap) {
        this.userMap = userMap;
    }
}
