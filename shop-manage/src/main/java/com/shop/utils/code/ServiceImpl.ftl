package ${package_name}.service.impl.${package_last_name};

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.shop.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ${package_name}.dao.${package_last_name}.${table_name}Dao;
import ${package_name}.dto.${package_last_name}.${table_name}DTO;
import ${package_name}.service.${package_last_name}.I${table_name}Service;



/**
* @date ${date}
* @author ${author}
* @description ${table_annotation} 服务接口实现
* @gitHub:${gitHub}
*/
@Service
public class ${table_name}ServiceImpl extends BaseServiceImpl implements I${table_name}Service {

    @Autowired
    private ${table_name}Dao ${table_name?uncap_first}Dao;

	<#if (primarykeysTypes)??>
  
	public void deleteByPk(${primarykeysTypes!}){
	
		${table_name?uncap_first}Dao.deleteByPrimaryKey(${variableKeys!});
	}

    public ${table_name}DTO findByPk(${primarykeysTypes!}){
    
    	return ${table_name?uncap_first}Dao.selectByPrimaryKey(${variableKeys!});
    }
    
	</#if>
	
	public void insert${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception{
	
		${table_name?uncap_first}Dao.insertSelective(${table_name?uncap_first}DTO);
	}
	
	public void update${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception{
		
		${table_name?uncap_first}Dao.updateByPrimaryKeySelective(${table_name?uncap_first}DTO);
	}
	
	public PageInfo<${table_name}DTO> findSplitPage(${table_name}DTO ${table_name?uncap_first}DTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(${table_name?uncap_first}DTO!=null){
		<#if (columnKeys)??&&columnKeys?size gt 0 >
		<#list columnKeys as columnKey>
			if(${table_name?uncap_first}DTO.get${columnKey.changeColumnName}()!=null){
				map.put("${columnKey.changeColumnName?uncap_first}",${table_name?uncap_first}DTO.get${columnKey.changeColumnName}());
			}
		</#list>
		</#if>
		}
		PageHelper.startPage(${table_name?uncap_first}DTO.getPageNo(), ${table_name?uncap_first}DTO.getPageSize());
		List<${table_name}DTO> list = ${table_name?uncap_first}Dao.findSplitPage(map);
		return new PageInfo<${table_name}DTO>(list);
	}
	
}