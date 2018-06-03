package ${package_name}.controller.${package_last_name};

import java.util.Map;
import java.util.HashMap;
import com.shop.web.BaseController;
import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import ${package_name}.service.${package_last_name}.I${table_name}Service;
import ${package_name}.dto.${package_last_name}.${table_name}DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @date ${date}
* @author ${author}
* @description ${table_annotation}控制层
* @gitHub:${gitHub}
*/
@Controller
@RequestMapping(value = "${table_name?uncap_first}")
public class ${table_name}Controller extends BaseController {

    @Autowired
    private I${table_name}Service ${table_name?uncap_first}Service;


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletResponse response, Model model,${table_name}DTO ${table_name?uncap_first}DTO) {
		PageInfo<${table_name}DTO> splitPage = ${table_name?uncap_first}Service.findSplitPage(${table_name?uncap_first}DTO);
		model.addAttribute("splitPage", splitPage);
		model.addAttribute("${table_name?uncap_first}DTO", ${table_name?uncap_first}DTO);
		return "admin/${table_name?uncap_first}/main";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request, ${table_name}DTO ${table_name?uncap_first}DTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		${table_name?uncap_first}Service.insert${table_name}(${table_name?uncap_first}DTO);
		map.put("success",true);
		return map;
	}

}