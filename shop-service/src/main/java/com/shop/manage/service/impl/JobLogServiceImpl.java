package com.shop.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import  com.github.pagehelper.PageInfo;
import  com.shop.manage.dao.JobLogDao;
import  com.shop.manage.dto.JobLogDTO;
import  com.shop.manage.service.IJobLogService;
import  com.shop.service.base.BaseServiceImpl;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

/**
* @date 20180602
* @author 张林
* @description 定时任务日志 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class JobLogServiceImpl extends BaseServiceImpl implements IJobLogService {

    @Autowired
    private JobLogDao jobLogDao;

  
	public void deleteByPk(Integer id){
	
		jobLogDao.deleteByPrimaryKey(id);
	}

    public JobLogDTO findByPk(Integer id){
    
    	return jobLogDao.selectByPrimaryKey(id);
    }
    
	
	public void insertJobLog(JobLogDTO jobLogDTO) throws Exception{
	
		jobLogDao.insertSelective(jobLogDTO);
	}
	
	public void updateJobLog(JobLogDTO jobLogDTO) throws Exception{
		
		jobLogDao.updateByPrimaryKeySelective(jobLogDTO);
	}
	
	public PageInfo<JobLogDTO> findSplitPage(JobLogDTO jobLogDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(jobLogDTO!=null){
			if(jobLogDTO.getId()!=null){
				map.put("id",jobLogDTO.getId());
			}
			if(jobLogDTO.getJobName()!=null){
				map.put("jobName",jobLogDTO.getJobName());
			}
			if(jobLogDTO.getDescription()!=null){
				map.put("description",jobLogDTO.getDescription());
			}
			if(jobLogDTO.getExcuteTime()!=null){
				map.put("excuteTime",jobLogDTO.getExcuteTime());
			}
			if(jobLogDTO.getCreateTime()!=null){
				map.put("createTime",jobLogDTO.getCreateTime());
			}
			if(jobLogDTO.getUpdateTime()!=null){
				map.put("updateTime",jobLogDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(jobLogDTO.getPageNo(), jobLogDTO.getPageSize());
		List<JobLogDTO> list = jobLogDao.findSplitPage(map);
		return new PageInfo<JobLogDTO>(list);
	}
	
}