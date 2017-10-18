<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备维护申请审批-审批</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备维护申请审批</a><span>></span><a>审批</a>
        </p>
    </div>
    <div class="form-title">仪器设备核查/校准/维修申请单</div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control" readonly required/>
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control" readonly required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>制造厂商：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:mfrName" name="mfrName" id="mfrName" class="form-control" readonly required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>规格/型号：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:model" name="model" id="model" class="form-control" readonly required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">申请项目：</label>
                <div class="col-sm-1">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio" value="" id="radio1">
                        <label for="radio1">检定</label>
                    </div>
                </div>
                <div class="col-sm-1">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio" value="" id="radio2">
                        <label for="radio2">校准</label>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio" value="" id="radio3">
                        <label for="radio3">维修</label>
                    </div>
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>经费预算(元)：</label>
                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
                    <input type="text" data-bind="value: budget" name="budget" id="budget" class="form-control" readonly required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">详细说明：</label>
                <div class="col-sm-10" data-bind="with: DevAdjAppVM">
                	<textarea rows="8" data-bind="value: details" name="details" id="details" cols="" class="form-control" readonly></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>申请人：</label>
                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
                    <input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control" readonly required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>申请时间：</label>
                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
                	<input id="createdDate" name="createdDate" class="form-control datetimepicker" data-bind="dateTimePicker:createdDate" readonly required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>审核人意见：</label>
                <div class="col-sm-10" data-bind="with: DevAdjAppVM">
                	<textarea data-bind="value: auditorOpinion" name="auditorOpinion" id="auditorOpinion" class="form-control shenheren" required></textarea>
                </div>
            </div>
            <div class="form-group shenheren">
                <label class="col-sm-2 control-label">审核人：</label>
                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
                    <input type="text" data-bind="value: auditorAlias" name="auditorAlias" id="auditorAlias" class="form-control " readonly/>
                </div>
                <label class="col-sm-2 control-label">审核时间：</label>
                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
                	<input id="auditedDate" name="auditedDate" class="form-control datetimepicker" data-bind="dateTimePicker: auditedDate" readonly/>
                </div>
            </div>
            <div class="form-group zhuren">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>实验室主任意见：</label>
                <div class="col-sm-10" data-bind="with: DevAdjAppVM">
                	<textarea data-bind="value: approverOpinion" name="approverOpinion" id="approverOpinion" class="form-control" required></textarea>
                </div>
            </div>
            <div class="form-group zhuren">
                <label class="col-sm-2 control-label">实验室主任：</label>
                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
                    <input type="text" data-bind="value: approverAlias" name="approverAlias" id="approverAlias" class="form-control" readonly/>
                </div>
                <label class="col-sm-2 control-label">审批时间：</label>
                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
                	<input id="approvedDate" name="approvedDate" class="form-control zhuren datetimepicker" data-bind="dateTimePicker: approvedDate" readonly/>
                </div>
            </div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1 agree"><i class="fa fa-check"></i>同意</button>
        <button class="btn btn-color1 disAgree"><i class="fa fa-times"></i>不同意</button>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script type="text/javascript">
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
	    $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
	    
		var auditorOrapprover = -1;
        var userId = "${sessionScope.loginUser.userId}";
        var userAlias = "${sessionScope.loginUser.userAlias}";
        var userName = "${sessionScope.loginUser.userName}";
		var DevAdjAppData = loadData("${ pageContext.request.contextPath }/deviceMgt/devAdjApp/loadDevAdjAppData.do", { "id" : "${param.id}" });
        var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : DevAdjAppData.deviceId });
		
		var DevAdjAppId = DevAdjAppData.id;
		var auditedDateSource = DevAdjAppData.auditedDate;	//审核时间		

		var DevAdjAppDataVM = ko.mapping.fromJS(DevAdjAppData);
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        
        if(DevAdjAppData.auditorAlias == "" || DevAdjAppData.auditorAlias == undefined || DevAdjAppData.auditorAlias == null){
			$(".zhuren").remove();
			DevAdjAppDataVM.auditorAlias = userAlias;
			DevAdjAppDataVM.auditedDate = new Date();
			auditorOrapprover = 0;
        }else if(DevAdjAppData.approverAlias == "" || DevAdjAppData.approverAlias == undefined || DevAdjAppData.approverAlias == null){
        	$(".shenheren").attr("readonly","readonly");
        	DevAdjAppDataVM.approverAlias = userAlias;
			DevAdjAppDataVM.approvedDate = new Date();
			auditorOrapprover = 1;
        }else{
			$(".zhuren").attr("readonly","readonly");
			$(".shenheren").attr("readonly","readonly");
        }

        
        var vm = {
			deviceVM : deviceDateVM,
			DevAdjAppVM : DevAdjAppDataVM
        }
        
        ko.applyBindings(vm);
        
        
		$(".agree").click(function(){
			$("button").attr("disabled", true);
	        if(validateSubmittedData()){
	        	if(auditorOrapprover == 0 ){ //审核
					DevAdjAppDataVM.auditorAlias = userAlias;
					DevAdjAppDataVM.auditorId = userId;
					DevAdjAppDataVM.auditorName = userName;
				}else{  //审批
					DevAdjAppDataVM.approverId = userId;
					DevAdjAppDataVM.approverName = userName;
					DevAdjAppDataVM.approverAlias = userAlias;
					DevAdjAppDataVM.status = 2;
				}
	        	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devAdjApp/saveDevAdjAppData.do", DevAdjAppDataVM) ) {
	        		saveSuccess("${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalList.do");
		    	}else{
		    		
		    	}
	    	}else{
	    		saveFailure();
	    	} 
		});
	    		
        
		$(".disAgree").click(function(){
			$("button").attr("disabled", true);
	        if(validateSubmittedData()){
	        	if(auditorOrapprover == 0 ){ //主任
					DevAdjAppDataVM.auditorAlias = userAlias;
					DevAdjAppDataVM.auditorId = userId;
					DevAdjAppDataVM.auditorName = userName;
					DevAdjAppDataVM.status = 3;
				}else{
					DevAdjAppDataVM.approverId = userId;
					DevAdjAppDataVM.approverName = userName;
					DevAdjAppDataVM.approverAlias = userAlias;
					DevAdjAppDataVM.status = 3;
				}
	        	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devAdjApp/saveDevAdjAppData.do", DevAdjAppDataVM) ) {
	        		saveSuccess("${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalList.do");
		    	}else{
		    		saveFailure();
		    	}
	    	}else{
	    		saveFailure();
	    	} 
		});

		checkType();
		function checkType(){
			//0：校准；1：检查；2：维修
			if(DevAdjAppData.type == 0){
				$("#radio1").attr("checked","checked");
			}else if(DevAdjAppData.type == 1){
				$("#radio2").attr("checked","checked");
			}else if(DevAdjAppData.type == 2){
				$("#radio3").attr("checked","checked");
			}
			$("#radio1").attr("disabled", true);
			$("#radio2").attr("disabled", true);
			$("#radio3").attr("disabled", true);
		}
    </script>
</body>
</html>