<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>个人不符合项报告录入</title>
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
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />  
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
</head>
<body>		
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a><span>></span><a>查看</a><span>></span><a>不符合项报告</a><span>></span><a>录入</a>
        </p>
   	</div>
   	<div class="form-content">
		<form class="form-horizontal">						
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>被审岗位：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:auditedPost" required />
				</div>	
				<label class="col-sm-2 control-label">责任人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:principalAlias" readonly/>
				</div>							
			</div>								
			<div class="form-group">
				<label class="col-sm-2 control-label">审核依据文件：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:gist"/>
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">不符合事实陈述：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:statement"></textarea>
					<div style="margin-top:15px;">上述事实构成不符合项，与</div>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:provisions"/>
					<div style="margin-top:15px;">规定不符。</div>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">责任人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:principalAlias" readonly/>
				</div>		
				<label class="col-sm-2 control-label">时间：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:stmtAuditedDate" />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>严重性评价：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<select class="form-control" data-bind="value:evaluation" required>
					   <option value="0">严重不符合</option>
					   <option value="1">一般不符合</option>
					   <option value="2">轻微不符合</option>
					</select>
				</div>						
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">质量或技术负责人：</label>
				<div class="col-sm-4" data-bind="with:userVM">
					<select id="userId" class="form-control" data-bind="options:userList,optionsValue:'userId',optionsText:'userAlias',value:userId,optionsCaption:'--请选择--',event:{change:changeUser}">
					</select>
					
				</div>			
				<label class="col-sm-2 control-label">时间：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:approvedDate" />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">被审核方确认意见：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:confOpinion"></textarea>
				</div>						
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">责任人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:principalAlias" readonly/>
				</div>		
				<label class="col-sm-2 control-label">时间：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:confReportedDate" />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">拟采取纠正措施及完成时间：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:adjOpinion"></textarea>
				</div>						
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">责任人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:principalAlias" readonly/>
				</div>		
				<label class="col-sm-2 control-label">时间：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:adjReportedDate" />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">内审员：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:auditorAlias" />
				</div>		
				<label class="col-sm-2 control-label">时间：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:adjAuditedDate" />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">纠正措施完成情况：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:sitnOpinion"></textarea>
				</div>						
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">责任人：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:principalAlias" readonly/>
				</div>		
				<label class="col-sm-2 control-label">时间：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:sitnReportedDate" />
				</div>						
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">纠正措施验证情况：</label>
				<div class="col-sm-10" data-bind="with:reportVM">
					<textarea class="form-control" data-bind="value:verOpinion"></textarea>
				</div>						
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">内审员：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control" data-bind="value:auditorAlias" />
				</div>		
				<label class="col-sm-2 control-label">时间：</label>
				<div class="col-sm-4" data-bind="with:reportVM">
					<input type="text" class="form-control datetimepicker" data-bind="dateTimePicker:verAuditedDate" />
				</div>						
			</div>
			<!-- <div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: saveData" class="submit-btn">√ 提交</button>
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div> -->
		</form>
	</div>	
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
       	<button class="btn btn-color1" data-bind="click: saveData"><i class="fa fa-check"></i>提交</button>
   	</div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
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
		
	 	var data = loadData("${pageContext.request.contextPath}/meeting/meetingIi/report/loadReportData.do",{ "id" : "${param.id}" });
	    var reportDataVM = ko.mapping.fromJS(data);
	    
	    var userData = loadData("${pageContext.request.contextPath}/system/user/getAllUserData.do",{});
		var userDataVM = {
				userList : ko.observableArray(userData),
				userId : ko.observable(data.approverId)
		}
	    
		var vm = {
	    		reportVM : reportDataVM,
	    		userVM : userDataVM
	    }
	    
	    vm.saveData = function(){
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataToVM();
	        	if (saveData("${pageContext.request.contextPath}/meeting/meetingIi/report/saveReportData.do", reportDataVM)) {
					saveSuccess("meetingMgt/internalAudit/inconformityReportList.do?id=${param.appId}");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
		} 
	    
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/inconformityReportList.do?id=${param.appId}&status=0');
		}
		
		ko.applyBindings(vm);
		
		function bindDataToVM(){
			/* reportDataVM.auditorName = "${sessionScope.loginUser.userName}";
			reportDataVM.auditorId = "${sessionScope.loginUser.userId}";
			reportDataVM.auditorAlias = "${sessionScope.loginUser.userAlias}"; */
		}
		
		function changeUser(){
			var index = $('#userId option:selected').index();
			reportDataVM.approverName = userData[index-1]['userName'];
			reportDataVM.approverAlias = userData[index-1]['userAlias'];
			reportDataVM.approverId = $('#userId').val();
		}
		

	</script>
</body>
</html>