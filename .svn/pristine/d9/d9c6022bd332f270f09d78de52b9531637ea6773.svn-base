<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Version Form</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/chosen.jquery.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/icheck/icheck.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/switcher/bootstrap-switch.min.js" />"></script>
    <script src="<c:url value="/resources/javascript/jsMap.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script> 
    <script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/Isempty.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/chosen.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/icheck/skins/all.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/js/switcher/bootstrap-switch.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/formStyle.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet">
    <style type="text/css">
      #col1, #col2, #col3 {
        float: left;
        margin: 10px 100px 10px 0px;
      }
    </style>
  </head>
  <body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<p class="headPosition">
				${ LANG[sessionScope.loginUser.lang]['CURRENT_LOCATION'] }：<a href="${pageContext.request.contextPath}/homepage.do">${ LANG[sessionScope.loginUser.lang]['MODULE_PLATFORM_MGT'] }</a>
				<i>/</i><a href="${pageContext.request.contextPath}/system/assessibility/version/versionList.do">${ LANG[sessionScope.loginUser.lang]['MODULE_FUNC_VER_MGT'] }</a>
				<i>/</i>${ LANG[sessionScope.loginUser.lang]['ADD_VER_DATA'] }
			</p>
		</div>
		<div class="panel-body panel-body-nopadding">
			<form class="form-horizontal form-bordered">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label"><span class="errors">*</span>${ LANG[sessionScope.loginUser.lang]['COL_VER_NAME'] }</label>
					<div class="col-sm-8" data-bind="with: versionVM">
						<input type="type" 
						       data-bind="value: name" 
						       name="name" 
						       class="form-control illegalCharacter" 
						       placeholder="${ LANG[sessionScope.loginUser.lang]['COL_VER_NAME'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" 
						       maxlength="40" 
						       required></input>
					</div>
				</div>
				
				<div class="form-group">
					<label for="versionStatus" class="col-sm-2 control-label"><span class="errors">*</span>${ LANG[sessionScope.loginUser.lang]['COL_VER_STATUS'] }</label>
					<div class="col-sm-8" data-bind="with: versionStatusVM">
						<select name="versionStatus" 
						        class="form-control"
							    data-bind="options: versionStatusList,
                                           optionsValue: 'value',
                  		                   optionsText: 'name',
                  		                   value: versionStatus" required></select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_VER_FUNS'] }</label>
					<div id="moduleDiv" class="col-sm-8">
					  <div id="col1"></div>
					  <div id="col2"></div>
					  <div id="col3"></div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_VER_DESC'] }</label>
					<div class="col-sm-8" data-bind="with: versionVM">
						<textarea class="form-control illegalCharacter"
							      data-bind="value: description" 
							      name="description" 
							      placeholder="${ LANG[sessionScope.loginUser.lang]['COL_VER_DESC'] }"
							      rows="3" maxlength="90"></textarea>
					</div>
					<div class="clear"></div>
				</div>

				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-3 btnCenter">
						<button class="btn btn-primary btnWidth"
							    data-bind="click: saveData" 
							    type="button">${ LANG[sessionScope.loginUser.lang]['BTN_SAVE_DATA'] }</button>
					</div>
					<div class="col-sm-2 btnCenter" id="reset">
						<button class="btn btn-default btnWidth"
							    data-bind="click: resetData" 
							    type="button">${ LANG[sessionScope.loginUser.lang]['BTN_RESET_DATA'] }</button>
					</div>
					<div class="col-sm-2 btnCenter">
						<button class="btn btn-default btnWidth"
							    data-bind="click: backToList" 
							    type="button">${ LANG[sessionScope.loginUser.lang]['BTN_BACK'] }</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>

    <div data-bind="with: versionVM">
      <input type="hidden" name="id" data-bind="value: id" />
    </div>
  </form>
  <script type="text/javascript">
    var moduleMap = new Map(); //模块信息全集
    var moduleLabelMap = new Map(); //选中的模块标识集合
    var moduleNamesMap = new Map(); //选中的模块名称集合
    
    //加载模块信息全集
    function loadModuleMap(moduleData) {
    	if ( moduleData != undefined && moduleData != null ) {
    		for ( var i = 0; i < moduleData.length; i ++ ) {
    			moduleMap.put(moduleData[i].authorityTypeLabel, moduleData[i].authorityTypeName);
    		}
    	}
    }
    
    //根据标识获取模块名称
    function getModuleName(label) {
    	if ( moduleMap.containsKey(label) ) {
    		return moduleMap.get(label);
    	}
    	return "";
    }
    
    //加入版本功能模块
    function addModule(label) {
    	if ( !moduleLabelMap.containsKey(label) 
    			&& !moduleNamesMap.containsKey(label) ) {
    		moduleLabelMap.put(label, label);
    		moduleNamesMap.put(label, getModuleName(label));
    	}
    }
    
    //移除版本功能模块
    function removeModule(label) {
    	if ( moduleLabelMap.containsKey(label) 
    			&& moduleNamesMap.containsKey(label) ) {
    		moduleLabelMap.remove(label);
    		moduleNamesMap.remove(label);
    	}
    }
    
    //获取所选功能模块标识
    function getModuleLabels() {
    	var modules = "";
    	var keys = moduleLabelMap.keys();
    	if ( keys != null ) {
    		var keyQty = keys.length;
    		for ( var i = 0; i < keyQty; i ++ ) {
    			if ( i != (keyQty - 1) ) modules += keys[i] + ",";
    			else modules += keys[i];
    		}
    	}
    	return modules;
    }
    
    //获取所选功能模块名称
    function getModuleNames() {
    	var modules = "";
    	var values = moduleNamesMap.values();
    	if ( values != null ) {
    		var valQty = values.length;
    		for ( var i = 0; i < valQty; i ++ ) {
    			if ( i != (valQty - 1) ) modules += values[i] + ",";
    			else modules += values[i];
    		}
    	}
    	return modules;
    }
    
    //加载版本功能模块（更新时使用）
    function loadModules(modules) {
    	if ( modules != null && modules != "" ) {
    		var moduleArray = modules.split(",");
        	for ( var i = 0; i < moduleArray.length; i++ ) {
        		addModule(moduleArray[i]);
        		$("#" + moduleArray[i]).iCheck('check');
        	}
    	}
    }
    
    //在指定列对象追加CHECKBOX对象
    function appendCheckboxItem(obj, label, name) {
    	var html = "";
		html += "<div><input type='checkbox' class='moduleItem' id='" + label + "' />";
		html += "&nbsp;&nbsp;&nbsp;<label style='cursor: pointer;' for='" + label + "'>" + name + "</label></div>";
		obj.append(html);
		html = "";
    }
    
    //渲染模块功能选项
    function renderModuleOptions(moduleData) {
    	if ( moduleData != undefined && moduleData != null ) {
    		loadModuleMap(moduleData); //加载模块信息全集
    		
    		//Column 1
			for ( var i = 0; i < moduleData.length; i ++ ) {
				appendCheckboxItem($("#col1"), moduleData[i].authorityTypeLabel, moduleData[i].authorityTypeName);
				i = i + 2;
			}
			
			//Column 2
			for ( var i = 1; i < moduleData.length; i ++ ) {
				appendCheckboxItem($("#col2"), moduleData[i].authorityTypeLabel, moduleData[i].authorityTypeName);
				i = i + 2;
			}
			
			//Column 3
			for ( var i = 2; i < moduleData.length; i ++ ) {
				appendCheckboxItem($("#col3"), moduleData[i].authorityTypeLabel, moduleData[i].authorityTypeName);
				i = i + 2;
			}
		}
    }
    
    $(function() {
    	
    	if("${param.id}" != null && "${param.id}" != "" && "${param.id}" != "undefined"){
   		    $("#reset").hide();
   	    }
    	
    	//VERSION VM
    	var versionData = loadData("${pageContext.request.contextPath}/system/assessibility/version/loadVersionData.do", { "id" : "${param.id}" });
		var versionDataVm = ko.mapping.fromJS(versionData);
		
		//VERSION STATUS VM
		var VersionStatus = function(name, val) {
			this.name = name;
			this.value = val;
		};
		
		var versionStatusDataVM = {
				versionStatusList : ko.observableArray([ new VersionStatus("禁用", 0), new VersionStatus("启用", 1) ]),
				versionStatus : ko.observable(versionData.status)
		};
		
		//MODULE OPTIONS
		var moduleData = loadData("${pageContext.request.contextPath}/system/assessibility/version/moduleOptionsData.do", {  });
		renderModuleOptions(moduleData);
		
		$('.moduleItem').iCheck({
			labelHover : false, 
			cursor : true, 
			checkboxClass : 'icheckbox_square-blue', 
			radioClass : 'iradio_square-blue', 
			increaseArea : '20%'
	    });
		
		loadModules(versionData.moduleLabels);
		
		$('.moduleItem').on('ifChecked', function(event) {
			addModule($(this).attr("id"));
        });
		
		$('.moduleItem').on('ifUnchecked', function(event) {
			removeModule($(this).attr("id"));
        });

		//GENERAL VM
		var vm = {
				versionStatusVM : versionStatusDataVM,
				versionVM : versionDataVm
		}

		vm.saveData = function() {
			if ( validateSubmittedData() ) {
				bindDataToVersionVM();
				if (saveData("${pageContext.request.contextPath}/system/assessibility/version/saveVersionData.do", versionDataVm)) {
					saveSuccess("${pageContext.request.contextPath}/system/assessibility/version/versionList.do");
				} else {
					saveFailure();
				}
			} else {
				saveFailure();
			}
		}

		vm.resetData = function() {
			$("form")[0].reset();
		}

		vm.backToList = function() {
			$(".iframes", window.parent.document).attr("src", "${pageContext.request.contextPath}/system/assessibility/version/versionList.do");
		}
		
		ko.applyBindings(vm);

		function bindDataToVersionVM() {
			versionDataVm.status = versionStatusDataVM.versionStatus;
			versionDataVm.moduleLabels(getModuleLabels());
			versionDataVm.moduleNames(getModuleNames());
		}
	});
  </script>	
</body>
</html>