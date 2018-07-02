package com.xiangqin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangqin.domain.Concern;
import com.xiangqin.repository.ConcernRepository;
import com.xiangqin.service.ConcernService;

@Service
public class ConcernServiceImpl implements ConcernService {

	@Autowired
	private ConcernRepository concernRepository;

	@Override
	public Integer save(Concern c) {
		concernRepository.save(c);
		return c.getId();
	}

	@Override
	public List<Concern> findByOwnerId(Integer ownerId) {
		String sql = "select t.* from t_concern t where t.owner_id=?";
		List<Object[]> list = concernRepository.listBySQL(sql, new Object[] {ownerId});
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
		return null;
	}

}
