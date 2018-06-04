<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package_name}.dao.${package_last_name}.${table_name}Dao">
  <resultMap id="BaseResultMap" type="${package_name}.domain.${package_last_name}.${table_name}">
  <#if (primaryKeys)??&&primaryKeys?size gt 0>
  <#list primaryKeys as primaryKey >
  	<id column="${primaryKey.columnName}" jdbcType="${primaryKey.columnType}" property="${primaryKey.changeColumnName}" />
  </#list>
  </#if>
  <#if (columnKeys)??&&columnKeys?size gt 0>
  <#list columnKeys as columnKey >
  	<result column="${columnKey.columnName}" jdbcType="${columnKey.columnType}" property="${columnKey.changeColumnName}" />
  </#list>
  </#if>
  </resultMap>
  <sql id="Base_Column_List">
   ${primarykeysTypes}
  </sql>
  <select id="selectByPrimaryKey" parameterType="Map" resultMap="BaseResultMap">
    select 
    <include refid="Base_Column_List" />
    from ${table_fix}${table_name_small}
   <where>  
  <#if (primaryKeys)??&&primaryKeys?size gt 0>
  <#list primaryKeys as primaryKey >
  	and ${primaryKey.columnName} = <#noparse>#</#noparse>{${primaryKey.changeColumnName},jdbcType=${primaryKey.columnType}}
  </#list>
  </#if>
  </where>
  </select>
  <delete id="deleteByPrimaryKey" parameterType="Map">
    delete from ${table_fix}${table_name_small}
    <where>  
  <#if (primaryKeys)??&&primaryKeys?size gt 0>
  <#list primaryKeys as primaryKey >
  	and ${primaryKey.columnName} = <#noparse>#</#noparse>{${primaryKey.changeColumnName},jdbcType=${primaryKey.columnType}}
  </#list>
  </#if>
  </where>
  </delete>
  
  <insert id="insertSelective" parameterType="${package_name}.domain.${package_last_name}.${table_name}">
    insert into ${table_fix}${table_name_small}
    <trim prefix="(" suffix=")" suffixOverrides=",">
	  <#if (primaryKeys)??&&primaryKeys?size gt 0>
	  <#list primaryKeys as primaryKey >
	  <if test="${primaryKey.changeColumnName} != null">
        ${primaryKey.columnName},
      </if>
	  </#list>
	  </#if>
	<#if (columnKeys)??&&columnKeys?size gt 0>
  	<#list columnKeys as columnKey >
  	  <if test="${columnKey.changeColumnName} != null">
  		${columnKey.columnName},
  	  </if>
  	</#list>
  	</#if>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides=",">
      <#if (primaryKeys)??&&primaryKeys?size gt 0>
	  <#list primaryKeys as primaryKey >
	  <if test="${primaryKey.changeColumnName} != null">
		<#noparse>#</#noparse>{${primaryKey.changeColumnName},jdbcType=${primaryKey.columnType}},
      </if>
	  </#list>
	  </#if>
  	  <#if (columnKeys)??&&columnKeys?size gt 0>
	  <#list columnKeys as columnKey >
	  <if test="${columnKey.changeColumnName} != null">
		<#noparse>#</#noparse>{${columnKey.changeColumnName},jdbcType=${columnKey.columnType}},
      </if>
	  </#list>
	  </#if>
    </trim>
  </insert>
  
  <update id="updateByPrimaryKeySelective" parameterType="${package_name}.domain.${package_last_name}.${table_name}">
    update ${table_fix}${table_name_small}
    <set>
      <#if (columnKeys)??&&columnKeys?size gt 0>
	  <#list columnKeys as columnKey >
	  <if test="${columnKey.changeColumnName} != null">
		${columnKey.columnName} = <#noparse>#</#noparse>{${columnKey.changeColumnName},jdbcType=${columnKey.columnType}},
      </if>
	  </#list>
	  </#if>
    </set>
   <where>  
  <#if (primaryKeys)??&&primaryKeys?size gt 0>
  <#list primaryKeys as primaryKey >
  	and ${primaryKey.columnName} = <#noparse>#</#noparse>{${primaryKey.changeColumnName},jdbcType=${primaryKey.columnType}}
  </#list>
  </#if>
  </where>
  </update>
  
  <select id="findSplitPage" parameterType="Map" resultMap="BaseResultMap">
    select <include refid="Base_Column_List" /> from ${table_fix}${table_name_small}
    <where>  
       <#if (columnKeys)??&&columnKeys?size gt 0>
	  <#list columnKeys as columnKey >
	  <if test="${columnKey.changeColumnName} != null">
		and ${columnKey.columnName} = <#noparse>#</#noparse>{${columnKey.changeColumnName},jdbcType=${columnKey.columnType}}
      </if>
	  </#list>
	  </#if>
	  <#if (primaryKeys)??&&primaryKeys?size gt 0>
	  <#list primaryKeys as primaryKey >
	  <if test="${primaryKey.changeColumnName} != null">
	  	and ${primaryKey.columnName} = <#noparse>#</#noparse>{${primaryKey.changeColumnName},jdbcType=${primaryKey.columnType}}
	  </if>
	  </#list>
	  </#if>
  </where>
  </select>
  
  <select id="findAll" parameterType="Map" resultMap="BaseResultMap">
    select <include refid="Base_Column_List" /> from ${table_fix}${table_name_small}
    <where>  
       <#if (columnKeys)??&&columnKeys?size gt 0>
	  <#list columnKeys as columnKey >
	  <if test="${columnKey.changeColumnName} != null">
		and ${columnKey.columnName} = <#noparse>#</#noparse>{${columnKey.changeColumnName},jdbcType=${columnKey.columnType}}
      </if>
	  </#list>
	  </#if>
	  <#if (primaryKeys)??&&primaryKeys?size gt 0>
	  <#list primaryKeys as primaryKey >
	  <if test="${primaryKey.changeColumnName} != null">
	  	and ${primaryKey.columnName} = <#noparse>#</#noparse>{${primaryKey.changeColumnName},jdbcType=${primaryKey.columnType}}
	  </if>
	  </#list>
	  </#if>
  </where>
  </select>
  
</mapper>