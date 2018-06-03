package com.shop.dao.admin;

import java.util.Map;

import com.github.pagehelper.Page;
import com.shop.domain.admin.Job;

public interface JobDao {

	Page<Job> findPage(Map<String,Object> map);
}
