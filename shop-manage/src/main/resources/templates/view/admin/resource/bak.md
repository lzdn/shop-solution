    <div class="form-group">
                        <label class="col-sm-3 control-label">资源类型：<span id="typeError"></span></label>
                        <div class="col-sm-8">
                     	    <#if (resourceDto.parentId)??&&resourceDto.parentId == 0>
                     	    	<input type="hidden" name="type" value="1">菜单
                     	    <#else>
                     	    	<#if (parentResource)??&&parentResource.level == 1>
                     	    		<input type="hidden" name="type" value="1">菜单
                     	    	<#elseif (parentResource)??&&parentResource.level == 2>
                     	    		<input type="hidden" name="type" value="1">菜单
                     	    	<#elseif (parentResource)??&&parentResource.level == 3>
                     	    		<input type="hidden" name="type" value="2">功能
                     	    	</#if>	
                     	    </#if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">资源级别：<span id="levelError"></span></label>
                        <div class="col-sm-8">
                     	    <#if (resourceDto.parentId)??&&resourceDto.parentId == 0>
                     	    	<input type="hidden" name="level" value="1">一级（菜单）
                     	    <#else>
                     	    	<#if (parentResource)??&&parentResource.level == 1>
                     	    		<input type="hidden" name="level" value="2">二级（菜单）
                     	    	<#elseif (parentResource)??&&parentResource.level == 2>
                     	    		<input type="hidden" name="level" value="3">三级（菜单）
                     	    	<#elseif (parentResource)??&&parentResource.level == 3>
                     	    		<input type="hidden" name="level" value="4">四级功能
                     	    	</#if>	
                     	    </#if>
                        </div>
                    </div>