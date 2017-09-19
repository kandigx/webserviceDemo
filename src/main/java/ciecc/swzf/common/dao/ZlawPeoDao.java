package ciecc.swzf.common.dao;

import ciecc.swzf.common.entity.ZlawPeo;

import java.util.List;
import java.util.Map;

/**
 * @author kandigx
 * @create 2017-09-19 10:51
 */
public interface ZlawPeoDao extends BaseDao<ZlawPeo> {

    Map<String,ZlawPeo> getZlawPeoMapByNameList(String areaCode, List<String > nameList);

    ZlawPeo listByAreaCodeAndName(String areaCode, String name);

}
