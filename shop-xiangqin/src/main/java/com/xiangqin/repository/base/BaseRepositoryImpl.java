package com.xiangqin.repository.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements BaseRepository<T, ID> {

	private final EntityManager entityManager;

	// 父类没有不带参数的构造方法，这里手动构造父类
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listBySQL(String sql, Object... args) {
		Query query = entityManager.createNativeQuery(sql);
		if(args!=null) {
			int i = 0;
			for (Object object : args) {
				query.setParameter(i++, object);
			}
		}
		List<Object[]> result = query.getResultList();
		return result;
	}

}