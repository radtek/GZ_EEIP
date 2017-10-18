<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/chosen.jquery.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-select.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-select.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/chosen.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/commonform.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>系统管理</a><span>></span><a>用户管理</a><span>></span><a class="thisPage">添加用户</a>
        </p>
    </div>
    <div class="form-content">
    	<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_ORG'] }：</label>
				<div class="col-sm-4" data-bind="with: orgVM">
					<select id="userOrg" class="chosen-select" data-bind="options: orgList, optionsValue: 'orgId', optionsText: 'orgName', value: orgId">
                    </select>
				</div>
				<label for="userName" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_USER_NAME'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input id="userName" type="text" data-bind="value: userName" name="userName" class="form-control strat userName" 
					       placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_NAME'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" 
					       maxlength="15" required />
				</div>
			</div>
			<div class="form-group">
				<label for="userAlias" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_USER_ALIAS'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="text" data-bind="value: userAlias" name="userAlias" class="form-control strat name" 
					       placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_ALIAS'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" 
					       maxlength="20" required />
				</div>
				<label for="userSex" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_USER_SEX'] }：</label>
				<div class="col-sm-4" data-bind="with: userSexVM">
					<select name="userSex" class="form-control"
						    data-bind="options: userSexList,
	                                         optionsValue: 'value',
	                		                   optionsText: 'name',
	                		                   value: userSex" required></select>
				</div>
			</div>
			<div class="form-group">
				<label for="userStatus" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_USER_STATUS'] }：</label>
				<div class="col-sm-4" data-bind="with: userStatusVM">
					<select name="userStatus" class="form-control"
						    data-bind="options: userStatusList,
	                                         optionsValue: 'value',
	                		                   optionsText: 'name',
	                		                   value: userStatus"></select>
				</div>
				<label class="col-sm-2 control-label">所属区县：</label>
				<div class="col-sm-4" data-bind="with:countyVM">
						<select id="county" class="form-control" 
						data-bind="options:countyList,
						optionsValue:'countyId',
						optionsText:'name',
						value:countyId,
						optionsCaption:'--请选择--' " ></select>
		        	</div>
					<!-- <div class="col-sm-1 div-label">
						区
					</div> -->
				
				<%-- <label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_PWD'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="password" data-bind="value: userPwd" name="userPwd" class="form-control strat" 
					       placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_PWD'] }" 
					       maxlength="20" />
				</div> --%>
			</div>
			<div class="form-group" style="display: none;">
				<label for="userType" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_USER_TYPE'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<select name="userType" class="form-control" data-bind="value: userType">
					  	<option value="0">普通会员</option>
					  	<option value="1">正式会员</option>
					</select>
				</div>
			</div>
	
	        <div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_ID_CARD'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="text" data-bind="value: userIdCard" name="userIdCard" class="form-control strat idCard" 
					       placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_ID_CARD'] }" 
					       maxlength="20" />
				</div>
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_POLICE_ID_CARD'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="text" data-bind="value: policeId" name="policeId" class="form-control strat alarm" 
					       placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_POLICE_ID_CARD'] }" 
					       maxlength="20" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_EMAIL'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="text" data-bind="value: userEmail" name="userEmail" class="form-control strat email" 
						   placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_EMAIL'] }" maxlength="18" />
				</div>
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_TEL'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="text" data-bind="value: userTelephone" name="userTelephone" class="form-control strat officePhone"
						   placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_TEL'] }" maxlength="20" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_FAX'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="text" data-bind="value: userFax" name="userFax" class="form-control strat fax" 
						   placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_FAX'] }" 
						   maxlength="20" />
				</div>
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_CELLPHONE'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="text" data-bind="value: userCellphone" name="userTelephone" class="form-control strat cellphone"
						   placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_CELLPHONE'] }" 
						   maxlength="11" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_USER_ADDR'] }：</label>
				<div class="col-sm-4" data-bind="with: userVM">
					<input type="text" data-bind="value: userAddress" name="userAddress" class="form-control strat validation"
						   placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_ADDR'] }" 
						   maxlength="40" />
				</div>
				<label for="roleId" class="col-sm-2 control-label"><span id="roleRequiredTips" class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_USER_ROLE'] }：</label>
				<div class="col-sm-4" data-bind="with: roleVM">
					<!-- <select id="userRole" name="roleId" class="form-control"
						    data-bind="options: roleList,
	                                         optionsValue: 'roleId',
	                		                   optionsText: 'roleName',
	                		                   value: roleId" required></select> -->
        			<select id="userRole" class="form-control selectpicker" multiple data-actions-box="true" 
        					data-bind="options: roleList,
									   optionsValue: 'roleId',
									   optionsText: 'roleName',
									   value: roleId" required>
					</select>
				</div>
			</div>
		</form>
		<div data-bind="with: userVM">
		  <input type="hidden" data-bind="value: userId" />
		  <input type="hidden" data-bind="value: userDetailId" />
		  <input type="hidden" data-bind="value: userStatus" />
		  <input type="hidden" data-bind="value: roleId" />
		  <input type="hidden" data-bind="value: orgId" />
		</div>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1 " data-bind="click: saveData"><i class="fa fa-check"></i>保存</button>
        <button class="btn btn-color1 reset" data-bind="click: resetData" ><i class="fa fa-undo"></i>重置</button>
    </div>

	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(function() {
			 
			  function initUserNameCtrl(userData) {
				  if ( userData != undefined 
						  && userData.userId != undefined 
						  && userData.userId != null 
						  && userData.userId != "" ) {
					  $("#userName").attr("disabled", "disabled");
				  }
			  }
			  
			  function initOrgOptionCtrl(userData) {
				  if ( userData != undefined 
						  && userData.userId != undefined 
						  && userData.userId != null 
						  && userData.userId != "" 
						  && userData.roleLabel != undefined 
						  && userData.roleLabel != "" ) {
					  var currentRoleLabel = userData.roleLabel;
					  if ( currentRoleLabel == "ROLE_ADMIN" 
							  || currentRoleLabel == "ROLE_SECONDARY_ADMIN" ) {
						  $("#userOrg").attr("readonly", "readonly");
					  }
				  }
			  }
			  
			  function initRoleSelected(userData) {
				  //set role options
				  if ( userData != undefined 
						  && userData.roleIds != undefined 
						  && userData.roleIds != null 
						  && userData.roleIds != "" ) {
				      var roleArray = new Array();
				      roleArray = userData.roleIds.split(",");
			          if (roleArray.length > 0) {
			        	  var options = $("#userRole option");
			        	  for (var j = 0; j < options.length; j++) {
			        		  for (var k = 0; k < roleArray.length; k++) {
			        			  if (options.eq(j).val() == roleArray[k]) {
			        				  options.eq(j).attr("selected", true);
						          }
			    		      }
				          }
			          }
				  }
			  }
			  
			  /*
			  function initRoleOptionCtrl(userData) {
				  if ( userData != undefined 
						  && userData.userId != undefined 
						  && userData.userId != null 
						  && userData.userId != ""
					      && userData.roleLabel != undefined 
						  && userData.roleLabel != "") {
					  var currentRoleLabel = userData.roleLabel;
					  if ( currentRoleLabel == "ROLE_ADMIN" 
							  || currentRoleLabel == "ROLE_SECONDARY_ADMIN" ) {
						  $("#userRole").attr("disabled", "disabled");
					  }
				  }
			  }*/
			  
			  function resetData4Add() {
				  try {
					  $("#userOrg").val("");
					  $('#userOrg').trigger('chosen:updated');
					  
					  $("form")[0].reset();
				  } catch(e) { console.log(e); }
			  }
			  
			  function resetData4Update() {
				  try {
					  if ( userData != null ) {
						  userDataVM.userName(userData.userName);
						  userDataVM.userAlias(userData.userAlias);
						  userDataVM.userIdCard(userData.userIdCard);
						  userDataVM.userEmail(userData.userEmail);
						  userDataVM.userTelephone(userData.userTelephone);
						  userDataVM.userFax(userData.userFax);
						  userDataVM.userCellphone(userData.userCellphone);
						  userDataVM.userAddress(userData.userAddress);
						  
						  userSexDataVM.userSex(userData.userSex);
						  userStatusDataVM.userStatus(userData.userStatus);
						  
						  $("#userOrg").val(userData.orgId);
						  $('#userOrg').trigger('chosen:updated');
						  
						  roleDataVM.roleId(userData.roleId);
					  }
				  } catch(e) { console.log(e); }
			  }
			  
			  if( "${param.userId}" != "" ){
				  $(".reset").hide();
				  $(".thisPage").text("修改用户");
			  }
			  			  
			  //USER VM
			  var userData = loadData("${pageContext.request.contextPath}/system/user/loadUserData.do", { "userId" : "${param.userId}" });
			  initUserNameCtrl(userData);
			  initOrgOptionCtrl(userData);
			  //initRoleOptionCtrl(userData);
			  var userDataVM = ko.mapping.fromJS(userData);
			  
			  //ORG VM
			  var orgData = loadData("${pageContext.request.contextPath}/system/user/orgOptionsData.do", { "userId" : "${param.userId}" });
			  var orgDataArray = new Array();
			  if ( CURRENT_ROLE_LABEL == "ROLE_ADMIN" ) orgDataArray.push({ "orgId" : "", "orgName" : "--- ${ LANG[sessionScope.loginUser.lang]['OPTION_ORG_NO_PARENT'] } ---" });
			  if ( orgData != null ) {
				  for (var i = 0; i < orgData.length; i++) orgDataArray.push(orgData[i]);
			  }
			  
			  var orgDataVM = {
					  orgList : ko.observableArray(orgDataArray),
					  orgId : ko.observable(userData.orgId)
			  };
			  
			  //ROLE VM
			  var roleData = loadData("${pageContext.request.contextPath}/system/user/roleOptionsData.do", { "userId" : "${param.userId}" });
			  var roleDataVM = {
					  roleList : ko.observableArray(roleData),
					  roleId : ko.observable(userData.roleId)
			  };
	
			  //USER STATUS VM
			  var UserStatus = function(name, val) {
				  this.name = name;
				  this.value = val;
			  };
			  
			  var userStatusDataVM = {
					  userStatusList : ko.observableArray([ new UserStatus("${ LANG[sessionScope.loginUser.lang]['OPTION_USER_STATUS01'] }", 0), new UserStatus("${ LANG[sessionScope.loginUser.lang]['OPTION_USER_STATUS02'] }", 1) ]),
					  userStatus : ko.observable(userData.userStatus)
			  };
			  
			  //USER SEX VM
			  var UserSex = function(name, val) {
				  this.name = name;
				  this.value = val;
			  };
			  
			  var userSexDataVM = {
					  userSexList : ko.observableArray([ new UserSex("${ LANG[sessionScope.loginUser.lang]['OPTION_USER_SEX01'] }", 0), new UserSex("${ LANG[sessionScope.loginUser.lang]['OPTION_USER_SEX02'] }", 1), new UserSex("${ LANG[sessionScope.loginUser.lang]['OPTION_USER_SEX03'] }", 2) ]),
					  userSex : ko.observable(userData.userSex)
			  };
			  
			  //区
			    var countyData = loadData("${ pageContext.request.contextPath }/inquest/county/getOptionsData.do",{ "cityId" : 440100 });
			    var countyDataVM = {
			    		countyList : ko.observableArray(countyData),
			    		countyId : ko.observable(userData.country)
			    }
	
			  //GENERAL VM
			  var vm = {
					  orgVM : orgDataVM,
					  roleVM : roleDataVM,
					  userStatusVM : userStatusDataVM,
					  userSexVM : userSexDataVM,
					  userVM : userDataVM,
					  countyVM : countyDataVM
			  }
			  
			  vm.saveData = function() {
				  	$("button").attr("disabled", true);
			        if ( validateSubmittedData() ) {
			        	bindDataToUserVM();
			        	if (saveData("${pageContext.request.contextPath}/system/user/saveUserData.do", userDataVM)) {
							saveSuccess("${pageContext.request.contextPath}/system/user/userList.do");
						} else {
							saveFailure("保存失败！");
						}
			        } else {
			        	saveFailure();
			        }
				  
			  }
	
			  vm.resetData = function() {
				  if ( userData.userId != undefined && userData.userId != null && userData.userId != "" ) {
					  resetData4Update(); //reset data when updating
				  } else {
					  resetData4Add(); //reset data when adding
				  }
			  }
	
			  vm.backToList = function() {
				  $(".index-iframe", window.parent.document).attr("src", "${pageContext.request.contextPath}/system/user/userList.do");
			  }
	
			  ko.applyBindings(vm);
			  initRoleSelected(userData);
	
			  function bindDataToUserVM() {
				  userDataVM.orgId = orgDataVM.orgId;
				  userDataVM.roleId = roleDataVM.roleId;
				  userDataVM.userStatus = userStatusDataVM.userStatus;
				  userDataVM.userSex = userSexDataVM.userSex;
				  userDataVM.country = countyDataVM.countyId;
				  var roleList = $("#userRole option:selected");
				  var roleIds = "";
				  if ( roleList != undefined && roleList != null && roleList.length > 0 ) {
					  for (var i = 0; i < roleList.length; i++) {
						  roleIds += roleList.eq(i).val();
						  if ( i < ( roleList.length - 1 ) ) {
							  roleIds += ",";
						  }
					  }
				  }
				  userDataVM.roleIds = roleIds;
			  }
			  
			  jQuery(".chosen-select").chosen({ 'width' : '100%', 'white-space' : 'nowrap' });
			  
			  //角色数据根据机构数据进行联动
			  $("#userOrg").change(function() {
				  var orgId = $("#userOrg option:selected").val();
				  roleDataVM.roleList.removeAll();
				  if ( orgId != null && orgId != "" ) 
					  roleData = loadData("${pageContext.request.contextPath}/system/user/roleOptionsData.do", { "orgId" : orgId, "userId" : "${param.userId}" });
				  else 
					  roleData = loadData("${pageContext.request.contextPath}/system/user/roleOptionsData.do", { "userId" : "${param.userId}" });
				  if ( roleData == undefined || roleData == null ) roleData = [];
			      roleDataVM.roleList(roleData);
			  });
		});
	</script>
</body>
</html>