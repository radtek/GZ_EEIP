<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>业务能力确认及授权详情页</title>
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
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>查看</a><span>></span><a>业务能力确认及授权</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<form class="form-horizontal myform">
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  data-bind="value: name" readonly/>
				</div>
				<label class="col-sm-2 control-label">部门：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value: dept" readonly/>
				</div>									
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">确认时间：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="dateTimePicker: confirmedDate" readonly/>
				</div>						
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">确认内容：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value: content" readonly></textarea>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">确认结果：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value: result" readonly></textarea>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">确认人：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value: confirmPerson" readonly/>
				</div>
				<label class="col-sm-2 control-label">确认时间：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="dateTimePicker: confirmedDate" readonly />
				</div>
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">授权意见：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value: opinion" readonly></textarea>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">实验室主任：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value: labDirector" readonly/>
				</div>
				<label class="col-sm-2 control-label">授权时间：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="dateTimePicker: authorizationDate" readonly />
				</div>
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" data-bind="value: remarks" readonly></textarea>
				</div>						
			</div>				
		</form>
	</div>
	<div class="btn-content">
        <button type="button" data-bind="click: backToList"  class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>	
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
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
			
		 	var data = loadData("${pageContext.request.contextPath}/psnlInfo/userAuthorization/getUserAuthorizationByUserIdData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
		 	var userData = loadData("${pageContext.request.contextPath}/psnlInfo/userBasicInfo/getUserBasicInfoByIdData.do",{ "id" : "${param.userBasicInfoId}" });
		 	data.name=userData.name;
			data.dept=userData.dept;
		 	var vm = ko.mapping.fromJS(data);
		   
			
			vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
			}
			
			ko.applyBindings(vm);
		});
	</script>
</body>
</html>