<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>来访人员查看</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>人员信息管理</a><span>></span><a>来访人员管理</a><span>></span><a>查看</a>
        </p>
   	</div>
	<div class="form-content">	
		<form class="form-horizontal">									
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名：</label>
				<div class="col-sm-4">
					<input data-bind="value: name" type="text" class="form-control" readonly/>
				</div>
				<label class="col-sm-2 control-label">单位：</label>
				<div class="col-sm-4">
					<input data-bind="value: org" type="text" class="form-control" readonly/>
				</div>	
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">证件类型：</label>
				<div class="col-sm-4">
				    <select  id="certType"  class="form-control" disabled>
                       <option value="0">警官证</option>
                       <option value="1">身份证</option>
                   	</select> 
				</div>
				<label class="col-sm-2 control-label">性别：</label>
				<div class="col-sm-4">
				    <select  id="sex"  class="form-control" disabled>
                       <option value="0">男</option>
                       <option value="1">女</option>
                   	</select> 
				</div>								
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">证件号码：</label>
				<div class="col-sm-4">
					<input data-bind="value: certNo" type="text" class="form-control" readonly/>
				</div>
				<label class="col-sm-2 control-label">来访时间：</label>
				<div class="col-sm-4">
					<input id="visitDate" class="form-control datetimepicker" data-bind="dateTimePicker:visitDate" readonly>
				</div>								
			</div>					
			<div class="form-group">
				<label class="col-sm-2 control-label">离开时间：</label>
				<div class="col-sm-4">
					<input id="leavingDate" class="form-control datetimepicker" data-bind="dateTimePicker:leavingDate" readonly>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">来访事由：</label>
				<div class="col-sm-10">
					<textarea data-bind="value:reason" class="form-control" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10">
					<textarea data-bind="value:remarks"  class="form-control" readonly></textarea>
				</div>						
			</div>						
		</form>
	</div>	
	<div class="btn-content">
        <button type="button" data-bind="click: backToList"  class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>     
    </div>	
	<script type="text/javascript">
	  	$(function() {
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
		  
		  var data = loadData("${pageContext.request.contextPath}/psnlInfo/visitor/getVisitorByIdData.do", { "id" : "${param.id}" });
	      var vm = ko.mapping.fromJS(data); 
	       $("#sex").val(data.sex);
	       $("#certType").val(data.certType);
	      $('input').click(function() { 
	    	  $(this).css('border','1px solid #ccc');
	      });
	      vm.backToList = function(){
	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/visitor/visitorInfoList.do');
	      }
	      ko.applyBindings(vm); 
	   }) 
  	</script>
</body>
</html>