<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>内部审核检查表录入</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />  
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />
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
				<label class="col-sm-2 control-label">被审岗位：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:auditedPost" readonly/>
				</div>	
				<label class="col-sm-2 control-label">内审员：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="value:auditorAlias" readonly/>
				</div>						
			</div>							
			<div class="record-list">
				<div class="item head">
					<div class="inspect-info1 info-height">审核设计要素</div>
					<div class="inspect-info2 info-height">审核内容</div>
					<div class="inspect-info3 info-height">审核方法</div>
					<div class="inspect-infos info-height">
						<p class="up">审核结果</p>
						<p class="down">
							<span>符合Y</span>
							<span>观察Y</span>
							<span>不符合N</span>
							<span class="last">不适用N/A</span>
						</p>
					</div>
					<div class="inspect-info8 info-height">结果说明</div>
				</div>
				<div class="info-group">
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">审核意见：</label>
				<div class="col-sm-10" >
					<textarea rows="8" cols="" class="form-control" data-bind="value:auditorOpinion" ></textarea>
				</div>						
			</div>
			<div class="form-group">
				<div class="center">
				    <button class="submit-btn"  data-bind="click: saveData">√ 同意</button>
					<button class="error-btn"  data-bind="click: refuseData">× 不同意</button>
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div>			
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
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
			
			var data = loadData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/loadInspectionData.do",{ "id" : "${param.id}" });
		    var vm = ko.mapping.fromJS(data);
		    vm.saveData = function(){
		    	if ( validateSubmittedData() ) {
		        	vm.auditedDate = new Date();
		        	vm.status = 2;
		        	if(saveData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/saveInspectionData.do",vm)){
						saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.appId}&status=1");
					}else{
						saveFailure();
					}
		        } else {
		        	saveFailure();
		        }
				
			}
		    
		    vm.refuseData = function(){
		    	if ( validateSubmittedData() ) {
		        	vm.auditedDate = new Date();
		        	vm.status = 3;
		        	if(saveData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/saveInspectionData.do",vm)){
						saveSuccess("${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.appId}&status=1&statusResult=4");
					}else{
						saveFailure();
					}
		        } else {
		        	saveFailure();
		        }
				
			}
		   
			
			vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.appId}&status=1');
			}
			
			ko.applyBindings(vm);
			
			var items = loadData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/item/getItemsByInspectionIdData.do",{ "id" : "${param.id}" });
			if(items.length > 0){
				var html = '';
				for(var i=0;i<items.length;i++){
					html += '<div class="item col-white">'
						+'<div class="inspect-info1">'
						+'<input type="text" data-id="'+items[i]['id']+'"  value="'+items[i]['element']+'"/>'
						+'</div>'
						+'<div class="inspect-info2">'
						+'<input type="text"  value="'+items[i]['content']+'"/>'
						+'</div>'
						+'<div class="inspect-info3">'
						+'<input type="text"  value="'+items[i]['method']+'"/>'
						+'</div>'	
						+'<div class="inspect-info4">'
						+'<input type="text"  value=""/>'
						+'</div>'
						+'<div class="inspect-info5">'
						+'<input type="text" " value=""/>'
						+'</div>'
						+'<div class="inspect-info6">'
						+'<input type="text"  value=""/>'
						+'</div>'
						+'<div class="inspect-info7">'
						+'<input type="text"  value=""/>'
						+'</div>'
						+'<div class="inspect-info8">'
						+'<input type="text"  value="'+items[i]['explanation']+'"/>'
						+'</div>'
						+'</div>'
				}
				$(".record-list .info-group").append(html);
			}
					
		})			
		
	</script>
</body>
</html>