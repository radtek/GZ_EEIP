<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>内部审核文件审批</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="content">
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a>
	        </p>
    	</div>
		
		<form class="form-horizontal myform">
															
			<div class="form-group">
				<label class="col-sm-2 control-label">会议主题：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:subject" name="subject" readonly/>
				</div>	
				<label class="col-sm-2 control-label">会议目的：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:purpose" name="purpose" readonly/>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">参会人员：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" id="participants" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内审组长：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内审员：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" id="iaParticipants" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">开始时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:startDate" name="startDate" readonly/>
				</div>
				<label class="col-sm-2 control-label">结束时间：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:endDate" name="endDate" readonly/>
				</div>					
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">会议室：</label>
				<div class="col-sm-10" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:meetingRoomName" name="meetingRoomName" readonly/>
				</div>						
			</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">会议文件：</label>
			<div class="upload-file">
				<div class="item">
					<input type="text"  readonly/> <!-- 会议签到表 -->
					<button type="button" class="upload" id="SignIn"><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/upload.png"> 审批</button>
				</div>
				<div class="item">
					<input type="text" readonly/><!-- 会议记录表 -->
					<button type="button" class="upload" id="record"><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/upload.png"> 审批</button>
				</div>
				<div class="item">
					<input type="text" readonly/><!-- 内部审核报告 -->
					<button type="button" class="upload" id="report"><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/upload.png"> 审批</button>
				</div>
				<div class="item">
					<input type="text" readonly/><!-- 不符合项报告 -->
					<button type="button" class="upload" id="iiReport"><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/upload.png"> 查看</button>
				</div>
				<div class="item">
					<input type="text" readonly/><!-- 内部审核检查表-->
					<button type="button" class="upload" id="inspection"><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/expert/upload.png"> 审批</button>
				</div>
			</div>
			</div>
			
			<div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: saveData" class="submit-btn">√ 提交</button>
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div>
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>

	
	
	$(function(){	
		//时间控件数据绑定-----------开始
		ko.bindingHandlers.dateTimePicker = {
			init : function(element, valueAccessor, allBindingsAccessor) {
				//initialize datepicker with some optional options
				var options = allBindingsAccessor().dateTimePickerOptions || {};
				$(element).datetimepicker(options);
				
				//when a user changes the date, update the view model
				ko.utils.registerEventHandler(element, "dp.change",
						function(event) {
							var value = valueAccessor();
							if (ko.isObservable(value)) {
								if (event.date != null
										&& !(event.date instanceof Date)) {
									value(event.date.toDate());
								} else {
									value(event.date);
								}
							}
						});
				
				ko.utils.domNodeDisposal.addDisposeCallback(element,
						function() {
							var picker = $(element).data("DateTimePicker");
							if (picker) {
								picker.destroy();
							}
						});
			},
			update : function(element, valueAccessor, allBindings, viewModel, bindingContext) {
				var picker = $(element).data("DateTimePicker");
				//when the view model is updated, update the widget
				if (picker) {
					var koDate = ko.utils.unwrapObservable(valueAccessor());
					//in case return from server datetime i am get in this form for example /Date(93989393)/ then fomat this
					koDate = (typeof (koDate) !== 'object') ? new Date(
							parseFloat(koDate)) : koDate;
					picker.date(koDate);
				}
			}
		};
		//时间控件数据绑定-----------结束 
		
	  var meetingAppData = loadData("${pageContext.request.contextPath}/meeting/meetingApp/loadMeetingAppData.do", { "id" : "${param.id}"});
      var meetingAppDataVM = ko.mapping.fromJS(meetingAppData);
      
      var meetingRoomData = loadData("${pageContext.request.contextPath}/meeting/meetingRoom/emptyMeetingRoomData.do",{});
      var meetingRoomDataVM = {
    		  roomList:ko.observableArray(meetingRoomData),
    		  roomId:ko.observable(meetingAppData.meetingRoomId)
      }
      
      var participants = '';
      var iaParticipants = '';
      
	  for(var i=0;i<meetingAppData.participants.length;i++){
	      participants += meetingAppData.participants[i].userAlias + ",";
	  }
	  
	  for(var i=0;i<meetingAppData.iaParticipants.length;i++){
		  if( meetingAppData.iaParticipants[i].userType == 1 ){
			  iaParticipants += meetingAppData.iaParticipants[i].userAlias + ",";
		  }
	      
	  }
	  
	  $("#participants").val(participants.substring(0,participants.length-1));
	  $("#iaParticipants").val(iaParticipants.substring(0,iaParticipants.length-1));
      
      var vm = {
    		  meetingAppVM : meetingAppDataVM,
    		  meetingRoomVM : meetingRoomDataVM
      }
		
	    vm.saveData = function(){ 
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataToVM();
	        	if( saveData("${pageContext.request.contextPath}/meeting/meetingApp/saveMeetingAppData.do",meetingAppDataVM )){
   	    		    saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do");
   	    	    }else{
   	    	    	$("button").attr("disabled", false);
   	    		    saveFailure();
   	    	    }
	        } else {
	        	$("button").attr("disabled", false);
	        	saveFailure();
	        }
		}
		
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditList.do');
		}
		
		ko.applyBindings(vm);
		
		//内部审核报告
		$("#report").click(function(){
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/internalReportApprove.do?id=${param.id}'); 
			
		});
		
		//不符合项报告
		$("#iiReport").click(function(){
			$('.index-iframe' , window.parent.document ).attr('src', '${pageContext.request.contextPath}/meetingMgt/internalAudit/inconformityReportList.do?id=${param.id}&status=1');
		});
		
		//内部审核检查
		$("#inspection").click(function(){
			$('.index-iframe' , window.parent.document ).attr('src', '${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.id}&status=1');
		});
		
		function bindDataToVM(){
			if("${param.status}" != ""){
				meetingAppDataVM.staus = 4;
			}else{
				meetingAppDataVM.status = 6;
			}
		}
		
	}); 
	
	 	
		
	</script>
</body>
</html>