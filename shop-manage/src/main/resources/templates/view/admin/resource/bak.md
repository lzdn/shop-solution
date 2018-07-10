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
                    
                    	function callbackTree(obj){
		$("#parentId").val(obj.id);
		$("#parentIdSelect").val(obj.name);
	}
                    
                    	function openResource(){
		/*
		var path = "${basePath}/resource/tree";
		parent.layer.open({
		    type: 2,
		    title: '资源列表',
		    shadeClose: true,
		    shade: 0.8,
		    maxmin: false, //开启最大化最小化按钮
		    area: ['300px', '35%'],
		    content: path, //iframe的url
		    cancel: function(index){
		    }, 
		    success: function (layero, index) {
		    	systemshop.initFrame({layFrame:layero,frameId:"${basePath}/module/main"});
	        }
		});
		*/
	}
	
	
	
	function onClick(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("resourceTree"),
		nodes = zTree.getSelectedNodes(),
		v = "", id = "";
		
		nodes.sort(function compare(a,b){return a.id-b.id;});
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
			id += nodes[i].id + ",";
		}
		
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		if (id.length > 0 ) id = id.substring(0, id.length-1);
		
		var data ={"name":v,"id":id};
		alert(data);
		//var data ={"name":v,"id":id};
		//var iframeId = $('#iframeId').val();
		//parent.window.frames[iframeId].contentWindow.callbackTree(data);
		//parent.layer.closeAll();
	}	
	
		var zNodes = new Array();
    	var jsonstr = {};
    	<#if (resourceTree)??&&resourceTree?size gt 0>
    	<#list resourceTree as tree>
    		jsonstr = systemshop.toJson('${tree!}');
    		zNodes.push(jsonstr);
    	</#list>
    	</#if>
    	
    		$(document).ready(function(){
        		$.fn.zTree.init($("#resourceTree"), setting, zNodes);
        	});