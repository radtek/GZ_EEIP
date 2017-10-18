<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Notification Form</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/chosen.jquery.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/ckeditor/ckeditor.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/Isempty.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/timer.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/icheck/icheck.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-select.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>    
    
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/Isempty.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/chosen.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/icheck/skins/all.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/commonform.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/spinner.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-select.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/noteForm.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
    <!--[if lt IE 9]>
    <script src="<c:url value="/resources/frameworks/pangolin/js/selectivizr.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/respond.min.js" />" type="text/javascript"></script>
    <![endif]-->
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>系统管理</a><span>></span><a>通知公告</a><span>></span><a>新增</a>
        </p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
	      	<div class="form-group">
		        <label class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_NOTE_TITLE'] }：</label>
		        <div class="col-sm-10" data-bind="with: notificationVM">
				  <input type="text" name="title" data-bind="value: title" class="form-control illegalCharacter" 
				         placeholder="${ LANG[sessionScope.loginUser.lang]['COL_NOTE_TITLE'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" 
				         maxlength="80" required />
		        </div>
	      	</div>
		  	<div class="form-group">
			    <label class="col-sm-2 control-label"><span class="required-fields">*</span>${ LANG[sessionScope.loginUser.lang]['COL_NOTE_TYPE'] }：</label>
		        <div class="col-sm-4" data-bind="with: typeVM">
		        	<select id="notificationTypeId" class="form-control"
				                  data-bind="options: typeList, 
				                             optionsValue: 'id', 
				                             optionsText: 'name', 
				                             value: typeId" required>
				    </select>
		        </div>
	      	</div>
	      	<div class="form-group">
		        <label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_PUBLISH_SCOPE'] }：</label>
		        <div class="col-sm-4" style="display:none">
				  <div class="navbar" role="navigation" data-bind="with: orgVM">
				    <div class="navbar-form" role="search">
				      <div class="form-group">
				        <select id="org" 
				                class="selectpicker" 
				                multiple data-live-search="true" 
				                data-actions-box="true"
				          		data-bind="options: orgList, optionsValue: 'orgSN', optionsText: 'orgName', value: orgSN">
				        </select>
				      </div>
				    </div>
				  </div>
				</div>
				
				<div class="col-sm-4">
				  <div class="navbar" role="navigation" data-bind="with: roleVM">
				    <div class="navbar-form" role="search">
				      <div class="form-group">
				        <select id="role" 
				                class="selectpicker" 
				                multiple data-live-search="true" 
				                data-actions-box="true"
				          		data-bind="options: roleList, optionsValue: 'roleLabel', optionsText: 'roleName', value: roleLabel">
				        </select>
				      </div>
				    </div>
				  </div>  
		        </div>
	      	</div>
				 
		  	<div class="form-group date-ctrl-excursion" data-bind="with: notificationVM">
			    <label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_PUBLISH_DATE'] }：</label>
		        <div class="col-sm-8">
		        	<div class="col-sm-2">
		        		<select id="publishedYear" class="form-control width80" name="publishedYear"></select>
		        		<span class="yearText spanText">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_PUBLISH_YEAR'] }</span>
		        	</div>
		        	
				  	<div class="col-sm-2">
				  		<select id="publishedMonth" class="form-control width80" name="publishedMonth"></select>
				  		<span class="monthText spanText">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_PUBLISH_MONTH'] }</span>
				  	</div>
				  	
				  	<div class="col-sm-2">
					  	<select id="publishedDay" class="form-control width80" name="publishedDay">
			          		<option value="" >-</option>
			          	</select>
			          	<span class="dayText spanText">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_PUBLISH_DAY'] }</span>
				  	</div>
				  	
				  	<div class="col-sm-2">
					  	<div id="publishedHour" class="spin">
				          	<input type="text" name="publishedHour" class="spinner" data-min="0" data-max="23" value="0"/>
						  	<span class="spinnerup"></span>
						  	<span class="spinnerdown"></span>
					  	</div>
					  	<div style="position: absolute; left:127px; top: 10px;">hr</div>
				  	</div>
				  	
				  	<div class="col-sm-1 timeText">&nbsp;:&nbsp;</div>
				  	
				  	<div class="col-sm-2">
					  	<div id="publishedMin" class="spin">
				            <input type="text" name="publishedMin" class="spinner" data-min="0" data-max="59" value="0"/>
						    <span class="spinnerup"></span>
						    <span class="spinnerdown"></span>
					 	</div>
					 	<div style="position: absolute; left:127px; top: 10px;">min</div>
				  	</div>
		        </div>
		        
		        <div class="col-sm-2 inputBtn">
			        <div id="publishingMethodDiv">
					   <input id="publishingMethod" type="checkbox"/>
					   <span style="width: 5px;">&nbsp;&nbsp;${ LANG[sessionScope.loginUser.lang]['COL_NOTE_AUTO_PUBLISH'] }&nbsp;&nbsp;</span>
					 </div>
		        </div>
	      	</div>
				 
		  	<div class="form-group date-ctrl-excursion" data-bind="with: notificationVM">
			    <label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_EXPIRED_DATE'] }：</label>
		        <div class="col-sm-8">
		        	<div class="col-sm-2">
		        		<select id="expiredYear" class="form-control width80" name="expiredYear"></select>
		        		<span class="yearText spanText">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_PUBLISH_YEAR'] }</span>
		        	</div>
		        	
		        	<div class="col-sm-2">
		        		<select id="expiredMonth" class="form-control width80" name="expiredMonth"></select>
		        		<span class="monthText spanText">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_PUBLISH_MONTH'] }</span>
		        	</div>
		        	
		        	<div class="col-sm-2">
			        	<select id="expiredDay" class="form-control width80" name="expiredDay">
			          		<option value="" >-</option>
			          	</select>
			          	<span class="dayText spanText">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_PUBLISH_DAY'] }</span>
		        	</div>
		        	
		        	<div class="col-sm-2">
			        	<div id="expiredHour" class="spin">
				            <input type="text" name="expiredHour" class="spinner" data-min="0" data-max="23" value="0"/>
						    <span class="spinnerup"></span>
						    <span class="spinnerdown"></span>
					  	</div>
					  	<div style="position: absolute; left:127px; top: 8px;">hr</div>
		        	</div>
		        	
		        	<div class="col-sm-1 timeText">&nbsp;:&nbsp;</div>
		        	
		        	<div class="col-sm-2">
			        	<div id="expiredMin" class="spin">
				            <input type="text" name="expiredMin" class="spinner" data-min="0" data-max="59" value="0"/>
						    <span class="spinnerup"></span>
						    <span class="spinnerdown"></span>
					  	</div>
					  	<div style="position: absolute; left:127px; top: 8px;">min</div>
		        	</div>
		        </div>
		        
		        <div class="col-sm-2 inputBtn">
			        <div id="timelinessDivDiv">
					   <input id="timeliness" type="checkbox"/>
					   <span style="width: 5px;">&nbsp;&nbsp;${ LANG[sessionScope.loginUser.lang]['COL_NOTE_NEVER_INVALID'] }&nbsp;&nbsp;</span>
					</div>
		        </div>
	      	</div>
	      	<%-- <div class="form-group">
			    <label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_NOTE_EXPIRED_DATE'] }：</label>
		        <div class="col-sm-4">
			        <input type="text" class="form-control" id="datetimepicker" />
		        </div>
	      	</div> --%>
	      	<div class="form-group formTextarea" data-bind="with: notificationVM">
	        	<textarea id="noteContent" data-bind="value: content" name="noteContent"></textarea>
		  	</div>
	      	<div data-bind="with: notificationVM">
	      	  <input id="images" type="hidden" data-bind="value: notificationImages" />
	      	</div>
		</form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1 " data-bind="click: saveData"><i class="fa fa-check"></i>保存</button>
        <button class="btn btn-color1 reset" data-bind="click: resetData"><i class="fa fa-undo"></i>重置</button>
    </div>
    
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
  
    <script src="<c:url value="/resources/frameworks/pangolin/js/spinner.js" />"></script>
  
    <script type="text/javascript">
	 	// 链接判断
	    var url = window.location.href;
	    if( url.indexOf("notificationId=") != -1 ){
	      $(".crumbs-text").html("当前位置：<a>系统管理</a><span>></span><a>通知公告</a><span>></span><a>修改</a>");
	    }
    
      	var ORG_RANGE_TEXT = "${ LANG[sessionScope.loginUser.lang]['OPTION_NOTE_ORG_RANGE'] }"; //机构范围选择
      	var ROLE_RANGE_TEXT = "${ LANG[sessionScope.loginUser.lang]['OPTION_NOTE_ROLE_RANGE'] }"; //角色范围选择
      
      Array.prototype.contains = function ( needle ) {
        for (i in this) {
          if (this[i] == needle) return true;
        }
        return false;
      }
      
      function initCKEditorCtrl() {
    	  CKEDITOR.config.language = "${ LANG[sessionScope.loginUser.lang]['CKEDITOR_LANG'] }";
    	  CKEDITOR.config.toolbar = "Full";
    	  CKEDITOR.config.height = 200;
	      CKEDITOR.config.width = "auto";
	      CKEDITOR.config.filebrowserImageUploadUrl = "${pageContext.request.contextPath}/system/notification/uploadNotePhotoData.do";
	      CKEDITOR.replace("noteContent");
      }
  
      function enablePublishedDateCtrl() {
    	  $("#publishedYear,#publishedMonth,#publishedDay").removeAttr("disabled");
	      $("#publishedHour,#publishedMin").children().removeAttr("disabled");
      }
  
      function disablePublishedDateCtrl() {
    	  $("#publishedYear,#publishedMonth,#publishedDay").attr("disabled","disabled");
	      $("#publishedHour,#publishedMin").children().attr("disabled","disabled");
      }
  
      function enableExpiredDateCtrl() {
    	  $("#expiredYear,#expiredMonth,#expiredDay").removeAttr("disabled");
	      $("#expiredHour,#expiredMin").children().removeAttr("disabled");
      }
  
      function disableExpiredDateCtrl() {
    	  $("#expiredYear,#expiredMonth,#expiredDay").attr("disabled","disabled");
	      $("#expiredHour,#expiredMin").children().attr("disabled","disabled");
      }
      
      function initIssueRange() {
    	  $("button").each(function(){
    		  if ( $(this).attr("data-id") == "org" ) {
    			  if ( $("#org option:selected").length == 0 ) {
    				  $(this).children("span.pull-left")[0].innerHTML = ORG_RANGE_TEXT;
			      }
		      }
		      
    		  if ( $(this).attr("data-id") == "role" ) {
    			  if ( $("#role option:selected").length == 0 ) {
    				  $(this).children("span.pull-left")[0].innerHTML = ROLE_RANGE_TEXT;
			      }
		      }
	      });
      }
  
      function initPublishedDateCtrl() {
    	  //initialize data of selectors
	      loadYearSelector($("#publishedYear"), getCurrentYear());
	      loadMonthSelector($("#publishedMonth"), getCurrentMonth());
	      loadDaySelector($("#publishedYear").val(), $("#publishedMonth").val(), $("#publishedDay"), getCurrentDay());
	  
	      $("#publishedYear,#publishedMonth,#publishedDay,#publishedHour,#publishedMin,#publishingMethodDiv").css("float", "left");
	      $(".yearText,.monthText,.dayText,.timeText,.spacingDiv").css("float", "left");
	  
	      //initialize checkbox
	      $("#publishingMethod").iCheck({
	    	  checkboxClass: "icheckbox_square-blue",
	          radioClass: "iradio_square-blue",
	          increaseArea: "20%"
	      });
	  
	      $("#publishingMethod").on("ifChecked", function(event) {
	    	  enablePublishedDateCtrl();
	      });
	  
	      $("#publishingMethod").on("ifUnchecked", function(event) {
	    	  disablePublishedDateCtrl();
	      });
	  
	      //disable published date controller
	      disablePublishedDateCtrl();
	  
	      //initialize method 'Change' of selectors
	      $("#publishedYear,#publishedMonth").change(function() {
	    	  loadDaySelector($("#publishedYear").val(), $("#publishedMonth").val(), $("#publishedDay"));
	      });
      }
  
      function initExpiredDateCtrl() {
    	  //initialize data of selectors
          loadYearSelector($("#expiredYear"), getCurrentYear());
	      loadMonthSelector($("#expiredMonth"), getCurrentMonth());
	      loadDaySelector($("#expiredYear").val(), $("#expiredMonth").val(), $("#expiredDay"), getCurrentDay());
	  
	      $("#expiredYear,#expiredMonth,#expiredDay,#expiredHour,#expiredMin,#timelinessDiv").css("float", "left");
	  
	      //initialize checkbox
	      $("#timeliness").iCheck({
	    	  checkboxClass: "icheckbox_square-blue",
	          radioClass: "iradio_square-blue",
	          increaseArea: "20%"
	      });
	  
	      $("#timeliness").on("ifChecked", function(event) {
	    	  disableExpiredDateCtrl();
	      });
	  
	      $("#timeliness").on("ifUnchecked", function(event) {
	    	  enableExpiredDateCtrl();
	      });
	
	      //disable expired date controller
	      $("#timeliness").iCheck("check");
      }
  
      function getIssueRange() {
    	  var orgList = $("#org option:selected");
	      var orgRange = "\"orgRange\" : \"";
	      if ( orgList != undefined && orgList != null && orgList.length > 0 ) {
	    	  for (var i = 0; i < orgList.length; i++) {
	    		  if ( i == ( orgList.length - 1 ) ) orgRange += orgList.eq(i).val() + "\"";
	    		  else { orgRange += orgList.eq(i).val() + ","; }
		      }
	      } else {
	    	  orgRange += "\"";
	      }
	  
	      var roleList = $("#role option:selected");
	      var roleRange = "\"roleRange\" : \"";
	      if ( roleList != undefined && roleList != null && roleList.length > 0 ) {
	    	  for (var i = 0; i < roleList.length; i++) {
	    		  if ( i == ( roleList.length - 1 ) ) roleRange += roleList.eq(i).val() + "\"";
			      else { roleRange += roleList.eq(i).val() + ","; }
		      }
	      } else {
	    	  roleRange += "\"";
	      }
	  
	      var issueRangeJson = "[{" + orgRange + "," + roleRange + "}]";
	      return issueRangeJson;
      }
  
      function prefixInteger(num, length) {
    	  return (Array(length).join('0') + num).slice(-length);
      }
      
      function convertToDate(year, month, day, hour, min) {
    	  var yearStr = prefixInteger(parseInt(year.val()), 4) + "";
	      var monthStr = prefixInteger(parseInt(month.val()), 2) + "";
	      var dayStr = prefixInteger(parseInt(day.val()), 2) + "";
	      var hourStr = prefixInteger(parseInt(hour.children().val()), 2) + "";
	      var minStr = prefixInteger(parseInt(min.children().val()), 2) + "";
	  
	      var dateStr = yearStr + "-" + monthStr + "-" + dayStr + " " + hourStr + ":" + minStr;
	      dateStr = dateStr.replace(/-/g,"/");
          var date = Date.parse(dateStr);
          return date;
      }
  
      function loadDataToDateCtrl(date, year, month, day, hour, min) {
	      var dateObj = new Date(getFormattedDate(date).replace(/-/, "/"));
	      var yearStr = dateObj.getFullYear() + "";
	      var monthStr = (dateObj.getMonth() + 1) + "";
	      var dayStr = dateObj.getDate() + "";
	      var hourStr = dateObj.getHours() + "";
	      var minStr = dateObj.getMinutes() + "";
	  
	      year.val(yearStr);
	      month.val(monthStr);
	      day.val(dayStr);
	      hour.children().val(hourStr);
	      min.children().val(minStr);
      }
  
      function loadIssueRange(issueRange) {
    	  try {
    		  var range = eval(issueRange);
		      for (var i = 0; i < range.length; i ++) {
		    	  //set org options
			      var orgArray = new Array();
		    	  orgArray = range[i].orgRange.split(",");
			      if (orgArray.length > 0) {
			    	  var options = $("#org option");
				      for (var j = 0; j < options.length; j++) {
				    	  for (var k = 0; k < orgArray.length; k++) {
				    		  if (options.eq(j).val() == orgArray[k]) {
				    			  options.eq(j).attr("selected", true);
						      }
					      }
				      }
		          }
			  
			      //set role options
			      var roleArray = new Array();
			      roleArray = range[i].roleRange.split(",");
		          if (roleArray.length > 0) {
		        	  var options = $("#role option");
		        	  for (var j = 0; j < options.length; j++) {
		        		  for (var k = 0; k < roleArray.length; k++) {
		        			  if (options.eq(j).val() == roleArray[k]) {
		        				  options.eq(j).attr("selected", true);
					          }
		    		      }
			          }
		          }
		      }
	      } catch(e) { console.log(e); }
      }
  
      function loadNotification(noteData) {
    	  if ( noteData != undefined && noteData != null 
    			  && noteData.id != undefined && noteData.id != null ) {
    		  if (noteData.publishedDate != null) {
    			  loadDataToDateCtrl(noteData.publishedDate, $("#publishedYear"), $("#publishedMonth"), $("#publishedDay"), $("#publishedHour"), $("#publishedMin"));
		      }
		      if (noteData.expiredDate != null) {
		    	  loadDataToDateCtrl(noteData.expiredDate, $("#expiredYear"), $("#expiredMonth"), $("#expiredDay"), $("#expiredHour"), $("#expiredMin"));
		      }
		      
		      if (!noteData.timeliness) {
		    	  $("#timeliness").iCheck("check");
		      } else {
		    	  $("#timeliness").iCheck("uncheck");
		      }
		  
		      if (noteData.method == 0) {
		    	  $('#publishingMethod').iCheck('check');
		      } else {
		    	  $('#publishingMethod').iCheck('uncheck');
		      }
		  
		      if (noteData.issueRange != null && noteData.issueRange.length > 0) {
		    	  loadIssueRange(noteData.issueRange);
		      }
	      }
      }
      
      $(function() {	
    	  /* $(".filter-option.pull-left").html("全体人员"); */
    	  
    	  
    	  if( "${param.notificationId}" != "" ){
			  $(".reset").hide();
		  }
    	  /* $('#datetimepicker').datetimepicker({
    		  format: 'YYYY-MM-DD  hh:mm',
    		  language: 'zh-CN',
    	  }); */
    	  
	      initCKEditorCtrl();
	      initPublishedDateCtrl();
	      initExpiredDateCtrl();
	  
	      //create notification module
	      var noteData = loadData("${pageContext.request.contextPath}/system/notification/loadNotificationData.do", {"notificationId" : "${param.notificationId}"});
	      var noteDataVM = ko.mapping.fromJS(noteData);
	  
	      //create notification type module
	      var typeData = loadData("${pageContext.request.contextPath}/system/notification/notificationTypeOptionsData.do", {  });
	      var typeDataVM = {
	    		  typeList : ko.observableArray(typeData),
			      typeId : ko.observable(noteData.notificationTypeId)
	      };
	  
	      //create org module
	      var orgData = loadData("${pageContext.request.contextPath}/system/org/orgOptionsData.do", {  });
	      var orgDataVM = {
	    		  orgList : ko.observableArray(orgData),
			      orgSN : ko.observable("")
	      };
	  
	      //create role module
	      var roleData = loadData("${pageContext.request.contextPath}/system/role/roleOptionsData.do", {  });
	      var roleDataVM = {
	    		  roleList : ko.observableArray(roleData),
			      roleLabel : ko.observable("")
	      };
	  
	      //create general module
	      var vm = {
	    		  typeVM: typeDataVM,
			      orgVM: orgDataVM,
			      roleVM: roleDataVM,
			      notificationVM: noteDataVM
	      };
	  
	      function bindNotificationData() {
	    	  var publishedDate = convertToDate($("#publishedYear"), $("#publishedMonth"), $("#publishedDay"), 
	    			                            $("#publishedHour"), $("#publishedMin")); //set publishing date
              var expiredDate = convertToDate($("#expiredYear"), $("#expiredMonth"), $("#expiredDay"), 
            		                          $("#expiredHour"), $("#expiredMin")); //set expired date
		  
              //set type of notification
		      if ($("#notificationTypeId option:selected").text().length > 0) {
		    	  noteDataVM.notificationTypeId = $("#notificationTypeId option:selected").val();
		      }
		  
		      //set issue range of notification
		      noteDataVM.issueRange = getIssueRange();
		  
		      //set publishing method of notification
		      if ($('#publishingMethod').prop("checked")) {
		    	  noteDataVM.method = 0; //automatic publishing
			      noteDataVM.publishedDate = publishedDate;
		    	  
		    	  if ( !$("#timeliness").prop("checked") ) {
		    		  if( publishedDate >= expiredDate ) {
				    	  saveFailure("${ LANG[sessionScope.loginUser.lang]['NOTE_ILLEGAL_DATE_NOTICE'] }");
					      return false;
				      }
		    	  }
		      } else {
		    	  noteDataVM.method = 1; //manual publishing
		      }
		  
		      //set timeliness of notification
		      if ($("#timeliness").prop("checked")) {
		    	  noteDataVM.timeliness = false;
		      } else {
		    	  noteDataVM.timeliness = true;
			      noteDataVM.expiredDate = expiredDate;
		      }
		  
		      //set content of notification
		      noteDataVM.content = CKEDITOR.instances.noteContent.getData();
		      
		      //set images of notification
		      noteDataVM.notificationImages = $("#images").val();
		      
		      return true;
	      }
	      
	      function clearOrgAndRoleOptions() {
	    	  $("button").each(function(){
	    		  if ( $(this).attr("data-id") == "org" || $(this).attr("data-id") == "role" ) {
	    			  var buttons = $(this).parent().find("button");
	    			  for( var i = 0; i < buttons.length; i++ ) {
	    				  if ( $(buttons[i]).attr("class") 
	    						  == "actions-btn bs-deselect-all btn btn-default" ) {
	    					  $(buttons[i]).click();
	    				  }
	    			  }
			      }
		      });
	      }
	      
	      function resetData4Add() {
			  try {
				  $("form")[0].reset();
				  
				  clearOrgAndRoleOptions();
				  initIssueRange();
				  
				  CKEDITOR.instances.noteContent.setData("");
				  noteDataVM.content("");
			  } catch(e) { console.log(e); }
		  }
	      
		  function resetData4Update() {
			  try {
				  if ( noteData != null ) {
					  //reset title of notification
					  noteDataVM.title(noteData.title);
					  
					  //reset type of notification
					  typeDataVM.typeId(noteData.notificationTypeId);
					  
					  //reset content of ckeditor
					  CKEDITOR.instances.noteContent.setData(noteData.content);
					  
					  //reset published date and expired date
					  if (noteData.publishedDate != null) {
						  loadDataToDateCtrl(noteData.publishedDate, $("#publishedYear"), $("#publishedMonth"), $("#publishedDay"), $("#publishedHour"), $("#publishedMin"));
		              }
		              if (noteData.expiredDate != null) {
		            	  loadDataToDateCtrl(noteData.expiredDate, $("#expiredYear"), $("#expiredMonth"), $("#expiredDay"), $("#expiredHour"), $("#expiredMin"));
		              }
		      
		              if (!noteData.timeliness) {
		            	  $("#timeliness").iCheck("check");
		              } else {
		            	  $("#timeliness").iCheck("uncheck");
		              }
		  
		              if (noteData.method == 0) {
		            	  $('#publishingMethod').iCheck('check');
		              } else {
		            	  $('#publishingMethod').iCheck('uncheck');
		              }
					  
		              //reset org and role options
					  clearOrgAndRoleOptions(); //clear org and role options
					  
					  var orgOptionIndex = new Array();
					  var roleOptionIndex = new Array();
					  var range = eval(noteData.issueRange);
				      
					  for (var i = 0; i < range.length; i ++) {
				    	  //reset org options
					      var orgArray = new Array();
				    	  orgArray = range[i].orgRange.split(",");
					      if (orgArray.length > 0) {
					    	  var options = $("#org option");
						      for (var j = 0; j < options.length; j++) {
						    	  for (var k = 0; k < orgArray.length; k++) {
						    		  if (options.eq(j).val() == orgArray[k]) {
						    			  orgOptionIndex.push(j);
								      }
							      }
						      }
				          }
					  
					      //reset role options
					      var roleArray = new Array();
					      roleArray = range[i].roleRange.split(",");
				          if (roleArray.length > 0) {
				        	  var options = $("#role option");
				        	  for (var j = 0; j < options.length; j++) {
				        		  for (var k = 0; k < roleArray.length; k++) {
				        			  if (options.eq(j).val() == roleArray[k]) {
				        				  roleOptionIndex.push(j);
							          }
				    		      }
					          }
				          }
				      }
				      			  
					  $("button").each(function(){
						  if ( $(this).attr("data-id") == "org" ) {
							  var uls = $(this).parent().find("ul");
							  for( var i = 0; i < uls.length; i++ ) {
								  if ( $(uls[i]).attr("class") == "dropdown-menu inner" ) {
									  var ul = $(uls[i]);
									  var lis = ul.children("li");
									  for ( var j = 0; j < lis.length; j++ ) {
										  if (orgOptionIndex.contains(j)) {
											  $($(lis[j]).children("a")[0]).click();
										  }
									  }
		    				      }
		    			      }
				          }
						  if ( $(this).attr("data-id") == "role" ) {
							  var uls = $(this).parent().find("ul");
							  for( var i = 0; i < uls.length; i++ ) {
								  if ( $(uls[i]).attr("class") == "dropdown-menu inner" ) {
									  var ul = $(uls[i]);
									  var lis = ul.children("li");
									  for ( var j = 0; j < lis.length; j++ ) {
										  if (roleOptionIndex.contains(j)) {
											  $($(lis[j]).children("a")[0]).click();
										  }
									  }
		    				      }
		    			      }
				          }
			          });
				  }
			  } catch(e) { console.log(e); }
		  }
	  
          vm.saveData = function() {
        	  $("button").attr("disabled", true);
        	  if( validateSubmittedData() ) {
          		  if( bindNotificationData() ) {
              		  if (saveData("${pageContext.request.contextPath}/system/notification/saveNotificationData.do", noteDataVM)) {
              			  saveSuccess("${pageContext.request.contextPath}/system/notification/notificationList.do");
                  	  } else {
                  		saveFailure();
                  	  }
              	  }
          	  } else {
          		saveFailure();
          	  }
          }
	  
          vm.resetData = function() {
        	  if ( noteData.id != undefined && noteData.id != null && noteData.id != "" ) {
				  resetData4Update(); //reset data when updating
			  } else {
				  resetData4Add(); //reset data when adding
			  }
          }
      
          vm.backToList = function() {
        	  $(".index-iframe", window.parent.document ).attr("src", "${pageContext.request.contextPath}/system/notification/notificationList.do");
          }
      
          ko.applyBindings(vm);
      
          loadNotification(noteData); //load notification data
	        
          jQuery(".chosen-select").chosen({'width':'100%','white-space':'nowrap'});
      });
      
      //initialize text of issue range after page loading
      window.onload = function() {
    	  initIssueRange();
      }
  </script>
</body>
</html>