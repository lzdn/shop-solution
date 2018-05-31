package com.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.manage.TestMapper;
import com.shop.dao.product.Test2Mapper;
import com.shop.domain.manage.Test;
import com.shop.domain.product.Test2;
import com.shop.service.ITest;

@Service
public class TestImpl implements ITest {

	@Autowired
	private TestMapper testMapper;

	@Autowired
	private Test2Mapper test2Mapper;

	@Override
	public void addTest(Test record) {

		testMapper.insertSelective(record);

	}

	@Override
	@Transactional(value = "productTransactionManager")
	public void addTest2(Test2 record) {
		test2Mapper.insertSelective(record);
		int  a = 1/0;
	}

}
