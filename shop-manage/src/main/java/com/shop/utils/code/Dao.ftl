package ${package_name}.dao;
import com.shop.dao.base.BaseDao;
import ${package_name}.domain.${table_name};
import ${package_name}.dto.${table_name}DTO;
import java.util.List;
import java.util.Map;

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

	int insertSelective(${table_name} record);

	int updateByPrimaryKeySelective(${table_name} record);

	List<${table_name}DTO> findSplitPage(Map<String, Object> map); 
	
}