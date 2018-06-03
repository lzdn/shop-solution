package com.shop.service.impl.admin;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.shop.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.dao.admin.JobLogDao;
import com.shop.dto.admin.JobLogDTO;
import com.shop.service.admin.IJobLogService;



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

    @Transactional(value = "manageTransactionManager")
	public void deleteByPk(Integer id){
	
		jobLogDao.deleteByPrimaryKey(id);
	}

    public JobLogDTO findByPk(Integer id){
    
    	return jobLogDao.selectByPrimaryKey(id);
    }
    
    @Transactional(value = "manageTransactionManager")
	public void insertJobLog(JobLogDTO jobLogDTO) throws Exception{
	
		jobLogDao.insertSelective(jobLogDTO);
	}
	
    @Transactional(value = "manageTransactionManager")
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