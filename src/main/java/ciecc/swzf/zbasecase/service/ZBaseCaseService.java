package ciecc.swzf.zbasecase.service;

import ciecc.swzf.common.entity.ZBaseCaseDO;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author kandigx
 * @create 2017-09-13 16:39
 */
@WebService
public interface ZBaseCaseService {

    String transferZBaseCase(@WebParam(name = "baseCase") ZBaseCaseDO baseCase);

}
