<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Organization Form</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/chosen.jquery.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-datetimepicker.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/icheck/icheck.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/switcher/bootstrap-switch.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
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
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>系统管理</a><span>></span><a>组织架构</a><span>></span><a>添加架构</a>
        </p>
    </div>
    <div class="form-content">
    	<form class="form-horizontal">
			<div id="parentOrg" class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_PARENT_ORG'] }</label>
				<div class="col-sm-4" data-bind="with: parentOrgVM">
					<select id="parentOrgSelector" class="chosen-select" data-bind="options: parentOrgList, optionsValue: 'orgId', optionsText: 'orgName', value: parentOrgId">
    		        </select>
				</div>
				<label for="orgName" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_ORG_NAME'] }</label>
				<div class="col-sm-4" data-bind="with: orgVM">
					<input type="text" data-bind="value: orgName" name="orgName" class="form-control illegalCharacter" maxlength="40" placeholder="${ LANG[sessionScope.loginUser.lang]['COL_ORG_NAME'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_ORG_SHORT_NAME'] }</label>
				<div class="col-sm-4" data-bind="with: orgVM">
					<input type="text" data-bind="value: orgShortName" name="orgShortName" class="form-control illegalCharacter" maxlength="6" placeholder="${ LANG[sessionScope.loginUser.lang]['COL_ORG_SHORT_NAME'] }" />
				</div>
				<label for="orgSN" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_ORG_SN'] }</label>
				<div class="col-sm-4" data-bind="with: orgVM">
					<input type="text" data-bind="value: orgSN" name="orgSN" id = "orgSN" class="form-control" readonly="readonly" placeholder="${ LANG[sessionScope.loginUser.lang]['COL_ORG_SN'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" required />
				</div>
			</div>
			<div class="form-group">
				<label for="orgType" class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_ORG_TYPE'] }</label>
				<div class="col-sm-4" data-bind="with: orgTypeVM">
					<select name="orgType" class="form-control" data-bind="options: orgTypeList, optionsValue: 'value', optionsText: 'name', value: orgType" required>
                 	</select>
				</div>
				 
			</div>
			<%--
			<div class="form-group">
				<label class="col-sm-2 control-label">机构管理员</label>
				<div class="col-sm-4">
					<input id="orgAdminSwitcher" type="checkbox" />
				</div>
			</div>
			--%>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_ORG_DESC'] }</label>
				<div class="col-sm-10" data-bind="with: orgVM">
					<textarea class="form-control illegalCharacter" data-bind="value: orgDesc" name="orgDesc" maxlength="90" placeholder="${ LANG[sessionScope.loginUser.lang]['COL_ORG_DESC'] }">
					</textarea>
				</div>
			</div>
		</form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>${ LANG[sessionScope.loginUser.lang]['BTN_BACK'] }</button>
        <button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>${ LANG[sessionScope.loginUser.lang]['BTN_SAVE_DATA'] }</button>
        <button class="btn btn-color1 reset" data-bind="click: resetData"><i class="fa fa-undo"></i>${ LANG[sessionScope.loginUser.lang]['BTN_RESET_DATA'] }</button>
    </div>
    
    <div data-bind="with: orgVM">
      <input type="hidden" name="orgId" data-bind="value: orgId" />
      <input type="hidden" name="parentOrgId" data-bind="value: parentOrgId" />
	  <input type="hidden" name="orgAdminStatus" data-bind="value: orgAdminStatus" />
    </div>
  
  <jsp:include page="/common/alertMessages.jsp"></jsp:include>
  
  <script type="text/javascript">
    <%-- 
    function setSwitcherStatus(orgData) {
    	if (orgData != undefined && orgData.orgAdminStatus != undefined) {
    		$("#orgAdminSwitcher").bootstrapSwitch("state", orgData.orgAdminStatus);
		}
	}
    --%>
    
    $(function() {
    	
    	  
    	// 链接判断
    	var url = window.location.href;
    	if( url.indexOf("orgId=") != -1 ){
    	  $(".crumbs-text").html("当前位置：<a>系统管理</a><span>></span><a>组织架构</a><span>></span><a>修改架构</a>");
    	}
    	
    	$('.datetimepicker').datetimepicker({
		    format: 'YYYY-MM-DD  HH:mm',
		});
		$(".datetimepicker-before").on("dp.change",function (e) {
	        $('.datetimepicker-after').data("DateTimePicker").minDate(e.date);
	    });
	    $(".datetimepicker-after").on("dp.change",function (e) {
	        $('.datetimepicker-before').data("DateTimePicker").maxDate(e.date);
	    });
    	
    	<%--
    	adminSwitcherStatus = false;
    	
    	$("#orgAdminSwitcher").bootstrapSwitch({
    		size : "small",
    		onSwitchChange : function(event, state) {
    			event.preventDefault();
    			adminSwitcherStatus = state;
			}
		});
    	--%>
    	
    	function resetData4Add() {
			  try {
				  $("form")[0].reset();
				  if ( orgData != null ) {
					  $("#orgSN").val(orgData.orgSN);
				  }
				  $("#parentOrgSelector").val("");
				  $('#parentOrgSelector').trigger('chosen:updated');
			  } catch(e) { console.log(e); }
		}
    	
    	function resetData4Update() {
			  try {
				  if ( orgData != null ) {
					  orgDataVm.orgName(orgData.orgName);
					  orgDataVm.orgShortName(orgData.orgShortName);
					  orgDataVm.orgDesc(orgData.orgDesc);
					  
					  orgDataVm.parentOrgId( ( (orgData.parentOrgId == null) ? "" : (orgData.parentOrgId) ) );
					  $("#parentOrgSelector").val( ( (orgData.parentOrgId == null) ? "" : (orgData.parentOrgId) ) );
					  $('#parentOrgSelector').trigger('chosen:updated');
					  
					  parentOrgDataVM.parentOrgId( ( (orgData.parentOrgId == null) ? "" : (orgData.parentOrgId) ) );
				  }
			  } catch(e) { console.log(e); }
		}

    	//ORG VM
    	var orgData = loadData("${pageContext.request.contextPath}/system/org/loadOrgData.do", { "orgId" : "${param.orgId}" });
		var orgDataVm = ko.mapping.fromJS(orgData);
		

		<%-- setSwitcherStatus(orgData); --%>

		//PARENT ORG VM
		var parentOrgData = loadData("${pageContext.request.contextPath}/system/org/orgOptionsData.do", { "orgId" : "${param.orgId}" });
		var parentOrgDataArray = new Array();
		parentOrgDataArray.push({ "orgId" : "", "orgName" : "--- ${ LANG[sessionScope.loginUser.lang]['OPTION_ORG_NO_PARENT'] } ---" });
		
		if ( parentOrgData != undefined && parentOrgData != null ) {
			for (var i = 0; i < parentOrgData.length; i++) {
				parentOrgDataArray.push(parentOrgData[i]);
			}
		}

		var parentOrgDataVM = {
				parentOrgList : ko.observableArray(parentOrgDataArray),
				parentOrgId : ko.observable(orgData.parentOrgId)
		};
		
		//ORG TYPE VM
		var OrgType = function(name, val) {
			this.name = name;
			this.value = val;
		};
		
		var orgTypeDataVM = {
				orgTypeList : ko.observableArray([ new OrgType("${ LANG[sessionScope.loginUser.lang]['OPTION_ORG_TYPE01'] }", 0), new OrgType("${ LANG[sessionScope.loginUser.lang]['OPTION_ORG_TYPE02'] }", 1) ]),
				orgType : ko.observable(orgData.orgType)
		};
		
		//ORG STATUS VM
		var OrgStatus = function(name, val) {
			this.name = name;
			this.value = val;
		};
		
		var orgStatusDataVM = {
				orgStatusList : ko.observableArray([ new OrgStatus("${ LANG[sessionScope.loginUser.lang]['OPTION_ORG_STATUS01'] }", 0), new OrgStatus("${ LANG[sessionScope.loginUser.lang]['OPTION_ORG_STATUS02'] }", 1) ]),
				orgStatus : ko.observable(orgData.orgStatus)
		};
		
		//VERSION VM
		var versionData = loadData("${pageContext.request.contextPath}/system/assessibility/version/versionOptionsData.do", {  });
		var versionDataVM = {
				versionList : ko.observableArray(versionData),
				versionId : ko.observable(orgData.versionId)
		};

		//GENERAL VM
		var vm = {
				parentOrgVM : parentOrgDataVM,
				orgTypeVM : orgTypeDataVM,
				orgStatusVM : orgStatusDataVM,
				versionVM : versionDataVM,
				orgVM : orgDataVm
		}

		vm.saveData = function() {
			$("button").attr("disabled", true);
			if ( validateSubmittedData() ) {
				bindDataToOrgVM();
				if (saveData("${pageContext.request.contextPath}/system/org/saveOrgData.do", orgDataVm)) {
					saveSuccess("${pageContext.request.contextPath}/system/org/orgList.do");
				} else {
					saveFailure();
				}
			} else {
	        	saveFailure();
	        }
		}

		vm.resetData = function() {
			if ( orgData.orgId != undefined  && orgData.orgId != null && orgData.orgId != "" ) {
				  resetData4Update(); //reset data when updating
			} else {
				resetData4Add(); //reset data when adding
			}
		}

		vm.backToList = function() {
			$(".index-iframe", window.parent.document).attr("src", "${pageContext.request.contextPath}/system/org/orgList.do");
		}
		
		ko.applyBindings(vm);

		function bindDataToOrgVM() {
			orgDataVm.parentOrgId = parentOrgDataVM.parentOrgId;
			orgDataVm.versionId = versionDataVM.versionId;
			orgDataVm.orgType = orgTypeDataVM.orgType;
			orgDataVm.orgStatus = orgStatusDataVM.orgStatus;
			<%-- orgDataVm.orgAdminStatus(adminSwitcherStatus); --%>
		}
		
		jQuery(".chosen-select").chosen({'width' : '100%', 'white-space' : 'nowrap' });
		
	});
  </script>	
</body>
</html>