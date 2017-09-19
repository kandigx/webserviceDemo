package ciecc.swzf.common.dao;

import ciecc.swzf.common.entity.User;

/**
 * @author kandigx
 * @create 2017-09-19 9:48
 */
public interface UserDao extends BaseDao<User> {

    User getByUserCode(String userCode);

}
