package com.shop.service.admin;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.Job;
import com.shop.domain.admin.JobLog;
import com.shop.dto.admin.JobDTO;
 

public interface IJobService {

	void printMsg();

	void addLog(JobLog log);

	PageInfo<Job> findAll(JobDTO job);

}
