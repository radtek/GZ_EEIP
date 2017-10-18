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
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a><span>></span><a>文件上传</a><span>></span><a>内部审核报告</a>
        </p>
   	</div>
	<div class="form-content">	
		<form class="form-horizontal">					
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>编号：</label>
				<div class="col-sm-2">
					<input type="number" class="form-control" data-bind="value:year" required/>
				</div>	
				<div class="col-sm-1 div-label">年/第	</div>
				<div class="col-sm-2">
					<input type="number" class="form-control" data-bind="value:time" required/>
				</div>	
				<div class="col-sm-1 div-label">次</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>审核范围：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:scope" required/>
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>审核开始日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:startDate" id="startDate" required/>
				</div>							
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label input-choose" data-name=".audit-purpose-radio"><span class="required-fields">*</span>审核目的：</label>
				<div class="col-sm-2 audit-purpose-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="purpose" value="0" id="purpose1" data-bind="checked:purpose" />
                        <label for="purpose1">例行审核</label>
                    </div>
                </div>
                <div class="col-sm-2 audit-purpose-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="purpose" value="1" id="purpose2" data-bind="checked:purpose" />
                        <label for="purpose2">特殊审核</label>
                    </div>
                </div>
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>审核结束日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:endDate" id="endDate" required />
				</div>					
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>审核依据：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:gist" required/>
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>上次审核完成日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:lastFinishedDate" id="lastFinishedDate" required/>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>审核概述：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:overview"  required></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">审核中的不符合项描述：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:incongruentItem"></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">审核问题分析：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:problemAnalysis"></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>总体评价：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:overallEval" required></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">不符合项的整改：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value:amendment"></textarea>
				</div>						
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>质量负责人签署对内审结果的批准意见：</label>
				<div class="col-sm-10">
					<textarea class="form-control" data-bind="value:opinion" required></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>报告编制人：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:creatorAlias" required />
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>编制日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:createdDate" required />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>质量负责人：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:approverAlias" required />
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>审核日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:approvedDate" required />
				</div>						
			</div> 
		</form>
	</div>
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
       	<button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
   	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script>
		$(function(){
			$('.datetimepicker').datetimepicker({
			    format: 'YYYY-MM-DD  HH:mm',
			});
			
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
		    reportData.purpose += ""; // 将purpose转换成字符串（knockoutjs中radio的值只能是字符串）
			var vm = ko.mapping.fromJS(reportData);
		    
		    vm.saveData = function(){
		    	$("button").attr("disabled", true);
		    	if(compareDate($("#lastFinishedDate").val(),$("#startDate").val())){
					$("button").attr("disabled", false);
		  			promptContent("系统提示：开始时间需大于上次审核时间");
		  			$("#startDate").addClass("error");
		  			$(".alert").addClass("alert-danger").removeClass("alert-success");
		  			$(".promptDiv").slideDown();
		  		}else if(compareDate($("#startDate").val(),$("#endDate").val())){
					$("button").attr("disabled", false);
		  			promptContent("系统提示：结束时间需大于开始时间");
		  			$("#endDate").addClass("error");
		  			$(".alert").addClass("alert-danger").removeClass("alert-success");
		  			$(".promptDiv").slideDown();
		  		}else if ( validateSubmittedData() ) {
		        	bindDataVM();
		        	if (saveData("${pageContext.request.contextPath}/meeting/meetingIa/report/saveReportData.do", vm)) {
						saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalFileUpload.do?id=${param.id}");
					} else {
						saveFailure();
					}
		        } else {
		        	saveFailure();
		        }
			}
			
			vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalFileUpload.do?id=${param.id}');
			}
			
			ko.applyBindings(vm);
			
		   function bindDataVM(){
			   vm.meetingAppId = "${param.id}";
			   vm.status = 1;
			   vm.creatorName = "${sessionScope.loginUser.userName}";
		       vm.creatorId = "${sessionScope.loginUser.userId}";
		       vm.creatorAlias = "${sessionScope.loginUser.userAlias}";
		   }
		}); 
	
		//比较两个时间的大小，当date1>=date2时，返回ture
		function compareDate(obj1, obj2) {
			var date1 = new Date(obj1);
			var date2 = new Date(obj2);
			if (date1.getTime() >= date2.getTime()) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>