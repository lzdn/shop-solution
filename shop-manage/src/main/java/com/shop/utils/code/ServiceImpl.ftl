package ${package_name}.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import  com.github.pagehelper.PageInfo;
import  ${package_name}.dao.${table_name}Dao;
import  ${package_name}.dto.${table_name}DTO;
import  ${package_name}.service.I${table_name}Service;
import  com.shop.service.base.BaseServiceImpl;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

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