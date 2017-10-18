<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>内部审核报告申请</title>
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
				<label class="col-sm-2 control-label">编号：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" data-bind="value:year" name="year" readonly/>
				</div>	
				<div class="col-sm-1" style="height:34px;line-height:34px;">
					年/第					
				</div>
				<div class="col-sm-2">
					<input type="text" class="form-control" data-bind="value:time" name="time" readonly/>
				</div>	
				<div class="col-sm-1" style="height:34px;line-height:34px;">
					次
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">审核范围：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:scope" name="scope" readonly/>
				</div>	
				<label class="col-sm-2 control-label">审核开始日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="dateTimePicker:startDate" readonly/>
				</div>							
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">审核目的：</label>
				<div class="col-sm-4">
					<div class="checkbox" data-bind="checked:purpose">
						<label>
							<input type="checkbox" value="0"> 例行审核
						</label>
						<label style="margin-left:40px;">
							<input type="checkbox" value="1"> 特殊审核
						</label>
					</div>		
				</div>
				<label class="col-sm-2 control-label">审核结束日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="dateTimePicker:endDate" readonly/>
				</div>					
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">审核依据：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:gist" name="gist" readonly/>
				</div>	
				<label class="col-sm-2 control-label">上次审核完成日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="dateTimePicker:lastFinishedDate" readonly/>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">审核概述：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:overview" name="overview" readonly></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">审核中的不符合项描述：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:incongruentItem" name="incongruentItem" readonly></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">审核问题分析：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:problemAnalysis" name="problemAnalysis" readonly></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">总体评价：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:overallEval" name="overallEval" readonly></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">不符合项的整改：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:amendment" name="amendment" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">报告编制人：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:creatorAlias" name="creatorAlias" readonly/>
				</div>	
				<label class="col-sm-2 control-label">编制日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="dateTimePicker:createdDate" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">质量负责人签署对内审结果的批准意见：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:opinion" name="opinion"></textarea>
				</div>						
			</div>
			<div class="form-group">
				<div class="center">
					<button class="submit-btn"  data-bind="click: saveData">√ 同意</button>
					<button class="error-btn"  data-bind="click: refuseData">× 不同意</button>
					<button class="back-btn"  data-bind="click: backToList">< 返回</button>
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
		 
		var reportData = loadData("${pageContext.request.contextPath}/meeting/meetingIa/report/loadReportByAppIdData.do",{ "id" : "${param.id}" });
	    var vm = ko.mapping.fromJS(reportData);
	    
	    vm.saveData = function(){
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	vm.status = 2;
	        	if (saveData("${pageContext.request.contextPath}/meeting/meetingIa/report/saveReportData.do", vm)) {
					saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalFileAudit.do?id=${param.id}");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
		}
	    
	    vm.refuseData = function(){
	    	$("button").attr("disabled", true);
	    	if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	vm.status = 3;
	        	if (saveData("${pageContext.request.contextPath}/meeting/meetingIa/report/saveReportData.do", vm)) {
					saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalFileAudit.do?id=${param.id}&status=4");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
	    }
		
	    vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalFileAudit.do?id=${param.id}');
		}
		
		ko.applyBindings(vm);
		
		//数据绑定
		function bindDataVM(){
			 vm.approverName = "${sessionScope.loginUser.userName}";
		     vm.approverId = "${sessionScope.loginUser.userId}";
		     vm.approverAlias = "${sessionScope.loginUser.userAlias}";
		}
	 });
	 		
	</script>
</body>
</html>