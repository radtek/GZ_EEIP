<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>年度计划审核</title>
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
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>会议管理</a><span>></span><a>计划</a><span>></span><a>内审年度计划</a>
	        </p>
    	</div>
		<form class="form-horizontal myform">
															
			<div class="form-group">
				<label class="col-sm-2 control-label">年度：</label>
				<div class="col-sm-10" data-bind="with:planAppVM">
					<input type="text" class="form-control" id="year" data-bind="value:year" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10" data-bind="with:planAppVM">
					<textarea rows="8" cols="" class="form-control" data-bind="value:remarks" readonly></textarea>
				</div>						
			</div>						
			 <div class="table-content" data-bind="with:planVM">
		        <table class="table table-bordered">
		            <thead>
		                <tr>		                 
		                    <th class="th-slash">
		                    	<div class="slash"></div>	                    		                    	
		                    	<span class="left">部门</span>
	                    		<span class="right">月份</span>
		                    </th>
		                    <th>涉及要素</th>
		                    <th>1</th>
		                    <th>2</th>
		                    <th>3</th>
		                    <th>4</th>
		                    <th>5</th>
		                    <th>6</th>
		                    <th>7</th>
		                    <th>8</th>
		                    <th>9</th>
		                    <th>10</th>
		                    <th>11</th>
		                    <th>12</th>	
		                    <th style="display: none"></th>	                    
		                </tr>
		            </thead>
		            <tbody class="enter-td" data-bind="foreach:plans">
		                <tr>
							<td><output type="text" data-bind="value:dept" readonly></output></td>
							<td><output type="text" data-bind="value:element" readonly></output></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:jan" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:feb" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:mar" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:apr" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:may" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:jun" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:jul" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:aug" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:sep" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:oct" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:nov" disabled/></td>
							<td class="width-td"><input type="checkbox" data-bind="checked:dec" disabled/></td>
							<td class="width-td" style="display: none"><input type="value" data-bind="text:id"/></td>
						</tr>  
		            </tbody>
		        </table> 
		    </div> 
			
			<div class="form-group">
				<label class="col-sm-2 control-label">编制人：</label>
				<div class="col-sm-4" data-bind="with:planAppVM">
					<input type="text" class="form-control" data-bind="value:creatorAlias" readonly/>
				</div>	
				<label class="col-sm-2 control-label">编制时间：</label>
				<div class="col-sm-4" data-bind="with:planAppVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:createdDate" readonly/>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">意见：</label>
				<div class="col-sm-10" data-bind="with:planAppVM">
					<textarea rows="8" cols="" class="form-control" data-bind="value:opinion"></textarea>
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
		
		
		
		var planAppData = loadData("${ pageContext.request.contextPath }/meeting/loadAnnualPlanAppData.do",{ "id" : "${param.id}" });
	    var planAppDataVM = ko.mapping.fromJS(planAppData);
	    
	    var planDataVM = {
	    		plans : ko.observableArray(planAppData.annualPlans)
	    }
	    
	    var vm = {
	    		planAppVM : planAppDataVM,
	    		planVM : planDataVM
	    }
	    
	    vm.saveData = function(){
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	planAppDataVM.status = 2;
	        	if (saveData("${pageContext.request.contextPath}/meeting/saveAnnualPlanAppData.do", planAppDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/meetingMgt/annualPlan/annualPlanList.do");
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
		        	planAppDataVM.status = 3;
		        	if (saveData("${pageContext.request.contextPath}/meeting/saveAnnualPlanAppData.do", planAppDataVM)) {
						saveSuccess("${pageContext.request.contextPath}/meetingMgt/annualPlan/annualPlanList.do");
					} else {
						saveFailure();
					}
		        } else {
		        	saveFailure();
		        }
 		} 
		
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/annualPlan/annualPlanList.do');
		}
		
		ko.applyBindings(vm);
		//数据绑定
		function bindDataVM(){
			
			planAppDataVM.approverName = "${sessionScope.loginUser.userName}";
			planAppDataVM.approverId = "${sessionScope.loginUser.userId}";
			planAppDataVM.approverAlias = "${sessionScope.loginUser.userAlias}";
			planAppDataVM.approvedDate = new Date();
		}
	});
	</script>
</body>
</html>