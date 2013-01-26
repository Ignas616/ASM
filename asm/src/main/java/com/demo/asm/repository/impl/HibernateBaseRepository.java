package com.demo.asm.repository.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.demo.asm.repository.BaseRepository;

public class HibernateBaseRepository  extends HibernateDaoSupport implements BaseRepository {

	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
		getHibernateTemplate().flush();
	}

	@Override
	public void deleteAll(Collection<?> entities) {
		getHibernateTemplate().deleteAll(entities);
		getHibernateTemplate().flush();
	}

	@Override
	public <T> T get(Class<T> clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public void save(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void saveAll(Collection<?> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	@Override
	public void merge(Object entity) {
		getHibernateTemplate().merge(entity);
		
	}

}
