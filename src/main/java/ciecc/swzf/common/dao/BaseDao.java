package ciecc.swzf.common.dao;

import java.util.List;

/**
 * @author kandigx
 * @create 2017-09-13 10:19
 */
public interface BaseDao<T> {

    void save(T t);

    void update(T t);

    void remove(String id);

    T get(String id);

    List<T> list(String hql, Object... args);

}
