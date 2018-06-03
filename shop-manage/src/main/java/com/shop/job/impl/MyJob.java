package com.shop.job.impl;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.job.BaseJob;
import com.shop.service.admin.IJobService;

@Component
public class MyJob extends BaseJob {

	@Autowired
	private IJobService iJobService;

	@Override
	protected String getJobKey() {
		return "MyJob";
	}

	@Override
	protected boolean run(JobExecutionContext context) throws Exception {
		iJobService.printMsg();
		return true;
	}

}
