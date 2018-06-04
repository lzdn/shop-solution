package com.shop.service.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.JobLog;
import com.shop.dto.admin.JobLogDTO;
import com.shop.service.IBaseService;

/**
* @date 20180602
* @author 张林
* @description 定时任务日志 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IJobLogService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除JobLog
    */
	void deleteByPk(Integer id);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询JobLog
    */
    JobLog findByPk(Integer id);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增JobLog
    */
    void insertJobLog(JobLogDTO jobLogDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改JobLog
    */
    void updateJobLog(JobLogDTO jobLogDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页JobLog
    */
	PageInfo<JobLog> findSplitPage(JobLogDTO jobLogDTO);
	
	/**
	* @date 20180602
	* @author 张林
    * 描述：查询全部JobLog
    */
	List<JobLog> findAll(JobLogDTO jobLogDTO);
}