package com.shop.manage.service;

import com.github.pagehelper.PageInfo;
import com.shop.service.base.IBaseService;
import com.shop.manage.dto.JobLogDTO;

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
    JobLogDTO findByPk(Integer id);

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
	PageInfo<JobLogDTO> findSplitPage(JobLogDTO jobLogDTO);
}