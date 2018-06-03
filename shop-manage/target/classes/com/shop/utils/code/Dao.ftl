package ${package_name}.dao.${package_last_name};

import java.util.Map;
import java.util.List;
import com.shop.dao.BaseDao;
import ${package_name}.domain.${package_last_name}.${table_name};
import ${package_name}.dto.${package_last_name}.${table_name}DTO;


/**
* @date ${date}
* @author ${author}
* @description ${table_annotation}数据持久层
* @gitHub:${gitHub}
*/
public interface ${table_name}Dao extends BaseDao {

	<#if (primarykeysTypes)??>
	int deleteByPrimaryKey(${primarykeysTypes!});
	
	${table_name}DTO selectByPrimaryKey(${primarykeysTypes!});
	</#if>

	int insertSelective(${table_name} ${table_name?uncap_first});

	int updateByPrimaryKeySelective(${table_name} ${table_name?uncap_first});

	List<${table_name}DTO> findSplitPage(Map<String, Object> map); 
	
}