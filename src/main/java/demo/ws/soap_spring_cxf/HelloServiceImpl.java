package demo.ws.soap_spring_cxf;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author Kang
 * @create 2017-09-06 11:26
 */
@WebService
@Component
public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
