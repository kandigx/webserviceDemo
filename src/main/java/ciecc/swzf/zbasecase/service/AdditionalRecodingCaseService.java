package ciecc.swzf.zbasecase.service;

import ciecc.swzf.common.entity.CaseDTO;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author kandigx
 * @create 2017-09-13 16:39
 */
@WebService
public interface AdditionalRecodingCaseService {

    String transferZBaseCase(@WebParam(name = "baseCase") CaseDTO baseCase);

}
