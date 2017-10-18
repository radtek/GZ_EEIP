<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>会议申请考核</title>
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
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>普通会议</a>
        </p>
   	</div>
   	<div class="form-content">
		<form class="form-horizontal">			
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
				<label class="col-sm-2 control-label">会议室：</label>
				<div class="col-sm-4" data-bind="with:meetingAppVM">
					<input type="text" class="form-control" data-bind="value:meetingRoomName" name="meetingRoomName" readonly/>
				</div>		
				<label class="col-sm-2 control-label">参会人：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="participants" readonly/>
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
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10" data-bind="with:meetingAppVM">
					<textarea rows="8" cols="" class="form-control" data-bind="value:remarks" name="remarks" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">审批意见：</label>
				<div class="col-sm-10" data-bind="with:meetingAppVM">
					<textarea rows="8" cols=""class="form-control" data-bind="value:opinion" name="opinion"></textarea>
				</div>						
			</div>
			<!-- <div class="form-group">
				<div class="center">
					<button class="submit-btn" >√ 同意</button>
					<button class="error-btn" >× 不同意</button>
					<button class="back-btn" >< 返回</button>
				</div>
			</div> -->
		</form>
	</div>	
	<div class="btn-content">
        <button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1" data-bind="click: agree"><i class="fa fa-check"></i>同意</button>
        <button class="btn btn-color1" data-bind="click: reject"><i class="fa fa-times"></i>同意</button>
    </div>
</body>

<script type="text/javascript">

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
      
      var participants = '';
      
      for(var i=0;i<meetingAppData.participants.length;i++){
    	  participants += meetingAppData.participants[i].userAlias + ",";
      }
      
      
      $("#participants").val(participants.substring(0,participants.length-1));
      
      var vm = {
    		  meetingAppVM : meetingAppDataVM
      }
      
      vm.agree = function(){
    	  bindDataToVM();
    	  meetingAppDataVM.status = 4;
    	  if( saveData("${pageContext.request.contextPath}/meeting/meetingApp/saveMeetingAppData.do",meetingAppDataVM )){
    		  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyList.do');
    	  }
      }
      
      vm.reject = function(){
    	  bindDataToVM();
    	  meetingAppDataVM.status = 3;
    	  if( saveData("${pageContext.request.contextPath}/meeting/meetingApp/saveMeetingAppData.do",meetingAppDataVM )){
    		  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyList.do');
    	  }
      }
      
      vm.backToList = function(){
    	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyList.do');
      }

      ko.applyBindings(vm);
      
      function bindDataToVM(){
    	  meetingAppDataVM.approverName = "${sessionScope.loginUser.userName}";
    	  meetingAppDataVM.approverId = "${sessionScope.loginUser.userId}";
    	  meetingAppDataVM.approverAlias = "${sessionScope.loginUser.userAlias}";
    	  meetingAppDataVM.approvedDate = new Date();
      }
</script>
</html>