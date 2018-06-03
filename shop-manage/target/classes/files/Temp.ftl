package ${package_name};

import com.shop.common.BaseEntity;

import java.util.Date;


/**
* @date ${date}
* @author ${author}
* @description${table_annotation}
*/
public class ${table_name} extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ${table_name}(){
	
	}
<#if model_column?exists>
<#list model_column as model>
    <#if (model.columnType = 'int' || model.columnType = 'Integer')>
    <#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>
	private Integer ${model.changeColumnName?uncap_first};
	</#if>
	<#if (model.columnType = 'bigint' || model.columnType = 'decimal' || model.columnType = 'bigint')>
	<#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>
	private Long ${model.changeColumnName?uncap_first};
	</#if>
	<#if (model.columnType = 'double')>
	<#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>
	private Double ${model.changeColumnName?uncap_first};
	</#if>
    <#if (model.columnType = 'datetime' || model.columnType = 'date' )>
    <#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>
	private Date ${model.changeColumnName?uncap_first};
	</#if>
	<#if (model.columnType = 'tinyint' )>
	<#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>
	private Byte ${model.changeColumnName?uncap_first};
	</#if>
	<#if (model.columnType = 'longblob'|| model.columnType = 'blob'  )>
	<#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>	
	private byte[] ${model.changeColumnName?uncap_first};
	</#if>
	<#if (model.columnType = 'smallint' )>
	<#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>
	private Short ${model.changeColumnName?uncap_first};
	</#if>
	<#if (model.columnType = 'float' )>
	<#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>
	private Float ${model.changeColumnName?uncap_first};
	</#if>
    <#if (model.columnType = 'varchar' || model.columnType = 'text' || model.columnType = 'longtext' || model.columnType = 'char' || model.columnType = 'enum' )>
    <#if (model.columnComment)??>
	/**
    *${model.columnComment!}
    */
    </#if>	
	private String ${model.changeColumnName?uncap_first};
	</#if>
</#list>	
</#if>
<#if model_column?exists>
<#list model_column as model>
    <#if (model.columnType = 'int' || model.columnType = 'Integer')>
    public Integer get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Integer ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
	<#if (model.columnType = 'bigint' || model.columnType = 'decimal' || model.columnType = 'bigint')>
	public Long get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Long ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
	<#if (model.columnType = 'double')>
	public Double get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Double ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
    <#if (model.columnType = 'datetime' || model.columnType = 'date' )>
    public Date get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
	<#if (model.columnType = 'tinyint' )>
	public Byte get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Byte ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
	<#if (model.columnType = 'longblob'|| model.columnType = 'blob'  )>
	public byte[] get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(byte[] ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
	<#if (model.columnType = 'smallint' )>
	public Short get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Short ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
	
	<#if (model.columnType = 'float' )>
	public Float get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Float ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
    
    <#if (model.columnType = 'varchar' || model.columnType = 'text' || model.columnType = 'longtext' || model.columnType = 'char' || model.columnType = 'enum' )>
    public String get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
	</#if>
</#list>	
</#if>
}