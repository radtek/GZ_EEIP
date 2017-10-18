<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>实时计划审批</title>
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
     <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/knowledgeMgt/fileMgt-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 	
</head>
<body>
	<div class="content">
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>会议管理</a><span>></span><a>计划</a><span>></span><a>内审实施计划</a>
	        </p>
    	</div>
		
		<form class="form-horizontal myform">														
			<div class="form-group">
				<label class="col-sm-2 control-label">内审目的：</label>
				<div class="col-sm-10" data-bind="with:implPlanVM">
					<input type="text" class="form-control" data-bind="value:purpose" readonly/>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">内审范围：</label>
				<div class="col-sm-10" data-bind="with:implPlanVM">
					<input type="text" class="form-control" data-bind="value:scope" readonly/>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">审核依据：</label>
				<div class="col-sm-10" data-bind="with:implPlanVM">
					<input type="text" class="form-control" data-bind="value:gist" readonly/>
				</div>						
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">内审组组长：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="leader" readonly/>
				</div>	
				<label class="col-sm-2 control-label">首次会议时间：</label>
				<div class="col-sm-4" data-bind="with:implPlanVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:firstDate" readonly/>
				</div>						
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">审核员：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" id="auditor" readonly></textarea>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">首次会议参加人员：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" id="first" readonly></textarea>
				</div>						
			</div>	
			<table class="table table-bordered" data-bind="with:implVM">
			   <thead>
					<tr>
					   <th>时间</th>
					   <th>受审核岗位</th>
					   <th>责任人</th>
					   <th>审核员</th>
					   <th>审核内容(要素）</th>
					</tr>
			   </thead>
			   <tbody class="handleData" data-bind="foreach:implPlans">
			        <tr>
			           <td><input type="text" data-bind="dateTimePicker:auditedDate" readonly/></td>
			           <td><input type="text" data-bind="value:auditedPost" readonly/></td>
			           <td><input type="text" data-bind="value:principalAlias" readonly/></td>
			           <td><input type="text" data-bind="value:auditorAlias" readonly/></td>
			           <td><input type="text" data-bind="value:content" readonly/></td>
			        </tr>
			   </tbody>
			</table>								
			<div class="form-group">
				<label class="col-sm-2 control-label">末次会议时间：</label>
				<div class="col-sm-4" data-bind="with:implPlanVM">
					<input type="text" class="form-control" data-bind="dateTimePicker:lastDate" readonly/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">末次会议参加人员：</label>
				<div class="col-sm-10">
					<textarea rows="8" cols="" class="form-control" id="last" readonly></textarea>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">审核意见：</label>
				<div class="col-sm-10" data-bind="with:implPlanVM">
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
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
	<script>
							
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
	
	var implPlanData = loadData("${pageContext.request.contextPath}/meeting/loadImplPlanAppData.do",{ "id" : "${param.id}" });
    var implPlanDataVM = ko.mapping.fromJS(implPlanData);
    
    var implDataVM = {
    	implPlans : ko.observableArray(implPlanData.implPlans)
    }
    
    var iaParticipants = implPlanData.iaParticipants;
    var participants = implPlanData.participants; //参加人员
    var firstParticipants = ''; //首次参加人员
    var lastParticipants = ''; //末次参加人员
    var auditors = ''; // 审核员
    if( participants.length > 0 ){
    	for(var i=0;i< participants.length;i++){
    		if( participants[i].type == 0 ){
    			firstParticipants += participants[i]['userAlias'] + ',';
    		}else if( participants[i].type == 1 ){
    			lastParticipants += participants[i]['userAlias'] + ',';
    		}
    	}
    }
    

    var leaderAlias = '';
    if( iaParticipants.length > 0 ){
    	for(var i=0;i< iaParticipants.length;i++){
    		if( iaParticipants[i].userType == 0 ){
    			leaderAlias = iaParticipants[i]['userAlias'];
    		}else if(iaParticipants[i].userType == 1){
    			auditors += iaParticipants[i]['userAlias'] + ',';;
    		}
    	}
    }
    
    $("#leader").val(leaderAlias);
    $("#first").val(firstParticipants.substring(0,firstParticipants.length-1));
    $("#last").val(lastParticipants.substring(0,lastParticipants.length-1));
    $("#auditor").val(auditors.substring(0,auditors.length-1));
    
    var vm = {
    		implPlanVM : implPlanDataVM,
    		implVM : implDataVM
    }
    
    
    vm.saveData = function(){
    	$("button").attr("disabled", true);
        if ( validateSubmittedData() ) {
        	bindDataVM();
        	implPlanDataVM.status = 2;
        	if (saveData("${pageContext.request.contextPath}/meeting/saveImplPlanAppData.do",implPlanDataVM)) {
				saveSuccess("${pageContext.request.contextPath}/meetingMgt/annualPlan/realtimePlanList.do");
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
        	implPlanDataVM.status = 3;
        	if (saveData("${pageContext.request.contextPath}/meeting/saveImplPlanAppData.do",implPlanDataVM)) {
				saveSuccess("${pageContext.request.contextPath}/meetingMgt/annualPlan/realtimePlanList.do");
			} else {
				saveFailure();
			}
        } else {
        	saveFailure();
        }
	}
	
    vm.backToList = function(){//返回
		$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/annualPlan/realtimePlanList.do');
	}
	
	ko.applyBindings(vm);

	function bindDataVM(){
		implPlanDataVM.approverName = "${sessionScope.loginUser.userName}";
		implPlanDataVM.approverId = "${sessionScope.loginUser.userId}";
		implPlanDataVM.approverAlias = "${sessionScope.loginUser.userAlias}";
		implPlanDataVM.approvedDate = new Date();
	}
		
		
					
	</script>
</body>
</html>