package ciecc.swzf.common.dao.impl;

import ciecc.swzf.common.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;

/**
 * @author kandigx
 * @create 2017-09-13 10:20
 */
@Repository
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory){
       super.setSessionFactory(sessionFactory);
    }

    private Class<T> clazz;

    public Class<T> getClazz() {
        if (clazz == null) {
            clazz = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clazz;
    }

    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    public void remove(String id) {
        this.getHibernateTemplate().delete(get(id));
    }

    public T get(String id) {
        return this.getHibernateTemplate().get(getClazz(),id);
    }
}
