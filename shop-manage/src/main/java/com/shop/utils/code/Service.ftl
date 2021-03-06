package ${package_name}.service.${package_last_name};

import java.util.List;
import com.shop.service.IBaseService;
import com.github.pagehelper.PageInfo;
import ${package_name}.domain.${package_last_name}.${table_name};
import ${package_name}.dto.${package_last_name}.${table_name}DTO;


/**
* @date ${date}
* @author ${author}
* @description ${table_annotation} 服务接口
* @gitHub:${gitHub}
*/
public interface I${table_name}Service extends IBaseService {

    
    <#if (primarykeysTypes)??>
    /**
    * @date ${date}
	* @author ${author}
    * 描述：根据主键删除${table_name}
    */
	void deleteByPk(${primarykeysTypes!});
    /**
    * @date ${date}
	* @author ${author}
    * 描述：根据主键查询${table_name}
    */
    ${table_name} findByPk(${primarykeysTypes!});
	</#if>

	/**
	* @date ${date}
	* @author ${author}
    * 描述：新增${table_name}
    */
    void insert${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception;

	/**
	* @date ${date}
	* @author ${author}
    * 描述：修改${table_name}
    */
    void update${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception;

	/**
	* @date ${date}
	* @author ${author}
    * 描述：分页${table_name}
    */
	PageInfo<${table_name}> findSplitPage(${table_name}DTO ${table_name?uncap_first}DTO);
	
	/**
	* @date ${date}
	* @author ${author}
    * 描述：查询全部${table_name}
    */
	List<${table_name}> findAll(${table_name}DTO ${table_name?uncap_first}DTO);
}