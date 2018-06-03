package com.shop.service.impl.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.dao.admin.JobDao;
import com.shop.dao.admin.JobLogDao;
import com.shop.domain.admin.Job;
import com.shop.domain.admin.JobLog;
import com.shop.dto.admin.JobDTO;
import com.shop.service.admin.IJobService;

@Service("iJobService")
public class JobServiceImpl implements IJobService {

	@Autowired
	private JobDao jobDao;

	@Autowired
	private JobLogDao jobLogDao;

	@Override
	 @Transactional(value = "manageTransactionManager")
	public void addLog(JobLog log) {
		jobLogDao.insertSelective(log);
	}

	@Override
	public void printMsg() {
		System.out.println("Hello");
	}

	@Override
	public PageInfo<Job> findAll(JobDTO job) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (job != null) {
			if (StringUtils.isNotEmpty(job.getJOB_NAME())) {
				map.put("JOB_NAME", job.getJOB_NAME());
			}
		}
		PageHelper.startPage(job.getPageNo(), job.getPageSize());
		Page<Job> page = jobDao.findPage(map);
		return page.toPageInfo();
	}
}