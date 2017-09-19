package ciecc.swzf.common.dao.impl;

import ciecc.swzf.common.dao.UserDao;
import ciecc.swzf.common.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kandigx
 * @create 2017-09-19 9:49
 */
@Component
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User getByUserCode(String userCode) {
        String hql = "from User where usercode = ? ";
        List<User> list = list(hql, userCode);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
