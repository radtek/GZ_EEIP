<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>业务考核</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>	 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />  
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	        	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>新增</a><span>></span><a>业务考核</a><span>></span><a>新增</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<!-- <div class="mid-footer">业务考核记录</div> -->
		<form class="form-horizontal myform">
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>姓名：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control name" data-bind="value: name" readonly required/>
				</div>
			
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>部门：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control dept" data-bind="value:dept" readonly required/>
				</div>										
			</div>							
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>技术职称：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control validation" data-bind="value: title" required/>
				</div>	
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>考试类别：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control validation" data-bind="value: type" required/>
				</div>							
			</div>			
			<div class="form-group">							
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>考核形式：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control validation" data-bind="value: form" required/>
				</div>
				
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>考核时间：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control datetimepicker"  data-bind="dateTimePicker: examDate"  required/>
				</div>			
			</div>					
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>考试内容：</label>
				<div class="col-sm-10">
					<textarea class="form-control" data-bind="value: content" required></textarea>
				</div>						
			</div>	
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>考核结果：</label>
				<div class="col-sm-10">
					<textarea class="form-control"  data-bind="value: result"  required></textarea>
				</div>						
			</div>	
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>考核意见：</label>
				<div class="col-sm-10">
					<textarea class="form-control" data-bind="value: opinion" required></textarea>
				</div>						
			</div>	
			
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<textarea class="form-control"  data-bind="value: remarks"></textarea>
				</div>						
			</div>	
			
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>技术负责人：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control name"  data-bind="value: techPrincipal" required />
				</div>	
				<label class="col-sm-2 control-label"  ><span class="required-fields">*</span>填表时间：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker: signatureDate" readonly required />
				</div>		
			</div>				
			
		</form>
	</div>
	<div class="btn-content">
        <button type="button" data-bind="click: backToList"  class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button type="button" data-bind="click: saveData"  class="btn btn-color1"><i class="fa fa-check"></i>提交</button>
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>	
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
	<script>
		$(function(){
			// 链接判断
			var url = window.location.href;
			if( "${param.userBasicInfoId}" && "${param.id}" ){
			  $(".crumbs-text").html("当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>修改</a><span>></span><a>业务考核</a><span>></span><a>修改</a>");
			}else if( "${param.userBasicInfoId}" ){
			  $(".crumbs-text").html("当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>修改</a><span>></span><a>业务考核</a><span>></span><a>新增</a>");
			}
			
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
		
		 	var data = loadData("${pageContext.request.contextPath}/psnlInfo/userEvaluation/getUserEvaluationByIdData.do",{ "id" : "${param.id}" });
		    var userData = loadData("${pageContext.request.contextPath}/psnlInfo/userBasicInfo/getUserBasicInfoByIdData.do",{ "id" : "${param.userBasicInfoId}" });
 			data.name=userData.name;
 			data.dept=userData.dept;
		    var vm = ko.mapping.fromJS(data);
		   vm.signatureDate = new Date();
		    
		    
		    vm.saveData = function(){
		    	$("button").attr("disabled", true);
		        if ( validateSubmittedData() ) {
		        	bindDataVM();
		        	if (saveData("${pageContext.request.contextPath}/psnlInfo/userEvaluation/saveUserEvaluationData.do", vm)) {
						saveSuccess("${pageContext.request.contextPath}/psnlInfo/expert/businessAssessmentList.do?userBasicInfoId="+"${param.userBasicInfoId}"+"&type=examine&status=0");
					}
		        } else {
		        	saveFailure();
		        }  
			} 
			
			vm.backToList = function(){//返回
				$(".index-iframe", window.parent.document).attr("src","${pageContext.request.contextPath}/psnlInfo/expert/businessAssessmentList.do?type=examine&userBasicInfoId=${param.userBasicInfoId}&status="+${param.status});
			}
			
			ko.applyBindings(vm);
			
			function bindDataVM(){ 
		    	vm.creatorId="${sessionScope.loginUser.userId}";
		    	vm.creatorName="${sessionScope.loginUser.userName}";
		    	vm.creatorAlias="${sessionScope.loginUser.userAlias}";
		    	vm.userBasicInfoId="${param.userBasicInfoId}";
			}
			
		}); 
	</script>
</body>
</html>