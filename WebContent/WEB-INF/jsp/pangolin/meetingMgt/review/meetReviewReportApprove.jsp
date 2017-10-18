<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>管理评审报告审批</title>
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
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="content">
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>管理评审会议</a>
	        </p>
    	</div>
		
		<form class="form-horizontal myform">	
			<div class="mid-title"><span>丨</span> 管理评审会议审核</div>														
			<div class="form-group">
				<label class="col-sm-2 control-label">编号：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.sn" readonly/>
				</div>
				<label class="col-sm-2 control-label">计划表编号：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.planSn" readonly/>
				</div>								
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">主持人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.emceeAlias" readonly/>
				</div>
				<label class="col-sm-2 control-label">评审日期：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:meetingMaReport.auditedDate" readonly/>
				</div>								
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">评审地点：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.location" readonly/>
				</div>						
			</div>					
			<div class="form-group">
				<label class="col-sm-2 control-label">评审目的：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.purpose" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">评审依据：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.gist" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">参加人员：</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="participants" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">评审结论及相关意见：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:meetingMaReport.conclusion" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:meetingMaReport.remarks" readonly></textarea>
				</div>						
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">编制人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.creatorAlias" readonly/>
				</div>	
				<label class="col-sm-2 control-label">日期：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:meetingMaReport.createdDate" readonly/>
				</div>						
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">批准人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:meetingMaReport.approverAlias" readonly/>
				</div>	
				<label class="col-sm-2 control-label">日期：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:meetingMaReport.approvedDate" readonly/>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">不通过原因：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:meetingMaReport.opinion"></textarea>
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
		
		var reportData = loadData("${pageContext.request.contextPath}/meeting/meetingMa/report/loadReportByAppIdData.do",{ "id" : "${param.id}" });
	    var reportDataVM = ko.mapping.fromJS(reportData);
	    
	    var participants = '';
	    
	    for(var i=0;i<reportData.participants.length;i++){
		    participants += reportData.participants[i].userAlias + ",";
		}
		    
	    $("#participants").val(participants.substring(0,participants.length-1));
	    
	    var vm = {
	    		reportVM : reportDataVM
	    }
	    
	    vm.saveData = function(){
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	vm.status = 2;
	        	if (saveData("${pageContext.request.contextPath}/meeting/meetingMa/report/saveReportData.do", reportDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/meetingMgt/review/meetReviewFileApprove.do?id=${param.id}&status=6");
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
	        	if (saveData("${pageContext.request.contextPath}/meeting/meetingMa/report/saveReportData.do", reportDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/meetingMgt/review/meetReviewFileApprove.do?id=${param.id}&status=4");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
		}
		
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/review/meetReviewFileApprove.do?id=${param.id}&status=5');
		}
		
		ko.applyBindings(vm);
		
		function bindDataVM(){
			reportDataVM.meetingMaReport.approverName = "${sessionScope.loginUser.userName}";
			reportDataVM.meetingMaReport.approverId = "${sessionScope.loginUser.userId}";
			reportDataVM.meetingMaReport.approverAlias = "${sessionScope.loginUser.userAlias}";
			reportDataVM.meetingMaReport.approvedDate = new Date();
		}
	});
	 	
	
	</script>
</body>
</html>