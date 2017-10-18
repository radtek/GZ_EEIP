<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>内部审核检查表参看</title>
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
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a><span>></span><a>查看</a><span>></span><a>内部审核检查表</a><span>></span><a>查看</a>
        </p>
   	</div>
	<div class="form-content">		
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
			<!-- <div class="form-group">
				<label class="col-sm-2 control-label">审核日期：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-bind="dateTimePicker:auditedDate" readonly/>
				</div>					
			</div>	 -->								
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>审核设计要素</th>
						<th>审核内容</th>
						<th>审核方法</th>
						<th class="th-border">
							<p>审核结果</p>
							<p class="border-p">
								<span>符合Y</span>
								<span>观察Y’</span>
								<span>不符合N</span>
								<span class="no-border">不适用N/A</span>
							</p>
						</th>
						<th>结果说明</th>
						
					</tr>
				</thead>
				<tbody class="handleData">
					
				</tbody>
			</table>	
			<!-- <div class="form-group">
				<label class="col-sm-2 control-label">审核意见：</label>
				<div class="col-sm-10" >
					<textarea rows="8" cols="" class="form-control" data-bind="value:auditorOpinion" readonly></textarea>
				</div>						
			</div> -->
			<!-- <div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div> -->			
		</form>
	</div>	
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
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
		   
			
			vm.backToList = function(){//返回
				$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalInspectList.do?id=${param.appId}&status=${param.status}');
			}
			
			ko.applyBindings(vm);
			
			var radioRowNum = 0;
			var items = loadData("${pageContext.request.contextPath}/meeting/meetingIa/inspection/item/getItemsByInspectionIdData.do",{ "id" : "${param.id}" });
			if(items.length > 0){
				var html = '';
				for(var i=0;i<items.length;i++){
					radioRowNum++;
					var radioName = "result"+radioRowNum;	
					var num0='',num1='',num2 = '',num3 ='';
					if(items[i]['result']=="0"){
						num0 = "checked=true";
					}else if(items[i]['result']=="1"){
						num1 = "checked=true";
					}else if(items[i]['result']=="2"){
						num2 = "checked=true";
					}else{
						num3 = "checked=true";
					}
					html += '<tr>'
						+'<td><input type="text" data-id="'+items[i]['id']+'" value="'+items[i]['element']+'" readonly/></td>'
						+'<td><input type="text" value="'+items[i]['content']+'" readonly/></td>'	
						+'<td><input type="text" value="'+items[i]['method']+'" readonly/></td>'
						+'<td class="td-checks"><span><input type="radio" name='+radioName+' value="0" '+num0+' disabled/></span>'
						+'<span><input type="radio" name='+radioName+' value="1" '+num1+' disabled/></span>'
						+'<span><input type="radio" name='+radioName+' value="2" '+num2+' disabled/></span>'
						+'<span class="no-border"><input type="radio" name='+radioName+' value="3" '+num3+' disabled/></span></td>'	
						+'<td><input type="text" value="'+items[i]['explanation']+'" readonly/></td>'
						
						+'</tr>'	
				}
				$(".handleData").append(html);
			}
					
		})			
		
	</script>
</body>
</html>