package demo.ws.soap_spring_cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Kang
 * @create 2017-09-06 11:25
 */
@WebService
public interface HelloService {

    String say(@WebParam(name = "name") String name);
}
