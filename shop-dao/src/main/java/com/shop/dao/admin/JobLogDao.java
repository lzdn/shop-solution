package com.shop.dao.admin;

import java.util.Map;
import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.JobLog;
import com.shop.dto.admin.JobLogDTO;


/**
* @date 20180602
* @author 张林
* @description 定时任务日志数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface JobLogDao extends BaseDao {

	int deleteByPrimaryKey(Integer id);
	
	JobLogDTO selectByPrimaryKey(Integer id);

	int insertSelective(JobLog jobLog);

	int updateByPrimaryKeySelective(JobLog jobLog);

	List<JobLogDTO> findSplitPage(Map<String, Object> map); 
	
}