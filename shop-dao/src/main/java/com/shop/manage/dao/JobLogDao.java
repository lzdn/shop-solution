package com.shop.manage.dao;
import com.shop.dao.base.BaseDao;
import com.shop.manage.domain.JobLog;
import com.shop.manage.dto.JobLogDTO;
import java.util.List;
import java.util.Map;

/**
* @date 20180602
* @author 张林
* @description 定时任务日志数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface JobLogDao extends BaseDao {

	int deleteByPrimaryKey(Integer id);
	
	JobLogDTO selectByPrimaryKey(Integer id);

	int insertSelective(JobLog record);

	int updateByPrimaryKeySelective(JobLog record);

	List<JobLogDTO> findSplitPage(Map<String, Object> map); 
	
}