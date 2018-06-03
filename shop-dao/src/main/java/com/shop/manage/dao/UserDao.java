package com.shop.manage.dao;
import com.shop.dao.base.BaseDao;
import com.shop.manage.domain.User;
import com.shop.manage.dto.UserDTO;
import java.util.List;
import java.util.Map;

/**
* @date 20180602
* @author 张林
* @description 用户数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface UserDao extends BaseDao {

	int deleteByPrimaryKey(Integer userId);
	
	UserDTO selectByPrimaryKey(Integer userId);

	int insertSelective(User record);

	int updateByPrimaryKeySelective(User record);

	List<UserDTO> findSplitPage(Map<String, Object> map); 
	
}