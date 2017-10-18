<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Role Form</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/chosen.jquery.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/Isempty.js" />"></script>
    <script src="<c:url value="/resources/javascript/jsMap.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/commonform.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/chosen.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/Isempty.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>系统管理</a><span>></span><a>角色管理</a><span>></span><a class="thisPage">添加角色</a>
        </p>
    </div>
    <div class="form-content">
    	<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_ROLE_GROUP'] }：</label>
				<div class="col-sm-4" data-bind="with: orgVM">
					<select id="roleOrg" 
					        class="chosen-select"
						    data-bind="options: orgList, 
						               optionsValue: 'orgId', 
						               optionsText: 'orgName', 
						               value: orgId"></select>
				</div>
				<label for="roleName" class="col-sm-2 control-label"><span class=required-fields>*</span>${ LANG[sessionScope.loginUser.lang]['COL_ROLE_NAME'] }：</label>
				<div class="col-sm-4" data-bind="with: roleVM">
				    <input type="text" 
				           data-bind="value: roleName" 
				           name="roleName" 
				           class="form-control illegalCharacter" 
				           placeholder="${ LANG[sessionScope.loginUser.lang]['COL_ROLE_NAME'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" 
				           maxlength="10" required />
				</div>
			</div>
			<div class="form-group">
				<label for="roleLabel" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_ROLE_LABEL'] }：</label>
				<div class="col-sm-4" data-bind="with: roleVM">
				    <input type="text" 
				           data-bind="value: roleLabel" 
				           name="roleLabel" 
				           class="form-control roleIdentification" 
				           placeholder="${ LANG[sessionScope.loginUser.lang]['COL_ROLE_LABEL'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" 
				           maxlength="20" required />
				</div>
				<label for="roleStatus" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_ROLE_STATUS'] }：</label>
				<div class="col-sm-4" data-bind="with: roleStatusVM">
					<select name="roleStatus" 
					        class="form-control"
						    data-bind="options: roleStatusList,
	                                         optionsValue: 'value',
	                		                   optionsText: 'name',
	                		                   value: roleStatus" required></select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_ROLE_DESC'] }：</label>
				<div class="col-sm-10" data-bind="with: roleVM">
					<textarea class="form-control illegalCharacter" 
					          data-bind="value: roleDesc" 
					          name="roleDesc" 
					          placeholder="${ LANG[sessionScope.loginUser.lang]['COL_ROLE_DESC'] }" 
					          rows="8" maxlength="99"></textarea>
				</div>
				<div class="clear"></div>
			</div>
			<div data-bind="with: roleVM">
				<input type="hidden" name="roleId" data-bind="value: roleId" />
				<input type="hidden" name="orgId" data-bind="value: orgId" />
				<input type="hidden" name="orgName" data-bind="value: orgName" />
			</div>
		</form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1 " data-bind="click: saveData"><i class="fa fa-check"></i>保存</button>
        <button class="btn btn-color1 reset" data-bind="click: resetData"><i class="fa fa-undo"></i>重置</button>
    </div>
    


	<%-- <div class="panel panel-default">
		<div class="panel-heading">
			<p class="headPosition">
				${ LANG[sessionScope.loginUser.lang]['CURRENT_LOCATION'] }：<a href="${pageContext.request.contextPath}/homepage.do">${ LANG[sessionScope.loginUser.lang]['MODULE_PLATFORM_MGT'] }</a>
				<i>/</i><a href="${pageContext.request.contextPath}/system/role/roleList.do">${ LANG[sessionScope.loginUser.lang]['MODULE_FUNC_AUTH_MGT'] }</a>
				<i>/</i>${ LANG[sessionScope.loginUser.lang]['ADD_ROLE_DATA'] }
			</p>
		</div>
		<div class="panel-body panel-body-nopadding">
			
		</div>
	</div> --%>
	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
    
    <script type="text/javascript">
      $(function() {
    	  function resetData4Add() {
			  try {
				  $("#roleOrg").val("");
				  $('#roleOrg').trigger('chosen:updated');
				  
				  $("form")[0].reset();
			  } catch(e) { console.log(e); }
		  }
		  
		  function resetData4Update() {
			  try {				  
				  if ( roleData != null ) {
					  roleDataVM.roleName(roleData.roleName);
					  roleDataVM.roleLabel(roleData.roleLabel);
					  roleDataVM.roleStatus(roleData.roleStatus);
					  roleDataVM.roleDesc(roleData.roleDesc);
					  
					  $("#roleOrg").val(roleData.orgId);
					  $('#roleOrg').trigger('chosen:updated');
					  
					  orgDataVM.orgId(roleData.orgId);
				  }
			  } catch(e) { console.log(e); }
		  }
		  
		  if( "${param.roleId}" != "" ){
			  $(".reset").hide();
			  $(".thisPage").text("修改角色");
		  }
    	  
    	  //ROLE VM
	      var roleData = loadData("${pageContext.request.contextPath}/system/role/loadRoleData.do", { "roleId" : "${param.roleId}" });
	      var roleDataVM = ko.mapping.fromJS(roleData);
	      
	      //ORG VM
          var orgData = loadData("${pageContext.request.contextPath}/system/org/orgOptionsData.do", { });
          var orgDataArray = new Array();
          orgDataArray.push({ "orgId" : "", "orgName" : "--- ${ LANG[sessionScope.loginUser.lang]['OPTION_ROLE_NO_ORG'] } ---" });
	      if ( orgData != null ) {
	    	  for (var i = 0; i < orgData.length; i++) orgDataArray.push(orgData[i]);
	      }
	  
	      var orgDataVM = {
	    		  orgList : ko.observableArray(orgDataArray),
			      orgId : ko.observable(roleData.orgId)
	      };
	  
	      orgMap = new Map();
	      if ( orgData != undefined && orgData != null ) {
	    	  for ( var i = 0; i < orgData.length; i++ ) {
	    		  orgMap.put(orgData[i].orgId, orgData[i].orgName);
		      }
	      }
	      
	      //ROLE STATUS VM
	      var RoleStatus = function(name, val) {
	    	  this.name = name;
		      this.value = val;
	      };
		
	      var roleStatusDataVM = {
	    		  roleStatusList : ko.observableArray([ new RoleStatus("${ LANG[sessionScope.loginUser.lang]['OPTION_ROLE_STATUS01'] }", 0), new RoleStatus("${ LANG[sessionScope.loginUser.lang]['OPTION_ROLE_STATUS02'] }", 1) ]),
			      roleStatus : ko.observable(roleData.roleStatus)
	      };
	  
	      //GENERAL VM
	      var vm = {
	    		  orgVM : orgDataVM,
	              roleVM : roleDataVM,
	              roleStatusVM : roleStatusDataVM
          }
	  
	      function getOrgName(id) {
	    	  return orgMap.get(id);
	      }
	  
	      function bindDataToRoleVM() {
	    	  roleDataVM.orgId = orgDataVM.orgId;
		      roleDataVM.orgName = getOrgName(orgDataVM.orgId());
		      roleDataVM.roleStatus = roleStatusDataVM.roleStatus;
	      }
	  
          vm.saveData = function() {
        	  $("button").attr("disabled", true);
        	  if ( validateSubmittedData() ) {
           		  bindDataToRoleVM();
           	      if ( saveData("${pageContext.request.contextPath}/system/role/saveRoleData.do", roleDataVM) ) {
           	    	saveSuccess("${pageContext.request.contextPath}/system/role/roleList.do");
           	      } else{
           	    	saveFailure();
           	      }
       	      } else {
       	    	  saveFailure();
       	      }
          }
      
          vm.resetData = function() {       	  
        	  if ( roleData.roleId != undefined && roleData.roleId != null && roleData.roleId != "" ) {
				  resetData4Update(); //reset data when updating
			  } else {
				  resetData4Add(); //reset data when adding
			  }
          }
      
          vm.backToList = function() {
        	  $(".index-iframe", window.parent.document ).attr("src", "${pageContext.request.contextPath}/system/role/roleList.do");
          }
      
          ko.applyBindings(vm);
      
          jQuery(".chosen-select").chosen({'width':'100%','white-space':'nowrap'});
      });
    </script>
</body>
</html>