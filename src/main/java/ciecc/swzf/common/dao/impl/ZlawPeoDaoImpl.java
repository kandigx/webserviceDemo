package ciecc.swzf.common.dao.impl;

import ciecc.swzf.common.dao.ZlawPeoDao;
import ciecc.swzf.common.entity.ZlawPeo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kandigx
 * @create 2017-09-19 10:52
 */
@Component
public class ZlawPeoDaoImpl extends BaseDaoImpl<ZlawPeo> implements ZlawPeoDao {

    /**
     * 根据 areaCode 及执法员名称列表获取执法员id列表
     * @param areaCode
     * @param nameList
     * @return Map<name,id>
     */
    public Map<String,ZlawPeo> getZlawPeoMapByNameList(String areaCode, List<String > nameList){
        Map<String, ZlawPeo> map = new HashMap<>();
        for (String name : nameList) {
            ZlawPeo person = listByAreaCodeAndName(areaCode,name.trim());
            map.put(name,person);
        }
        return map;
    }

    public ZlawPeo listByAreaCodeAndName(String areaCode, String name) {
        String hql = "from ZlawPeo where areaCode = ? and name = ? and isDel = 0 " +
                "and workNature = 2 and isJob = 0 and sysAudStatus = 2 ";
            List<ZlawPeo> list = list(hql, areaCode, name);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
