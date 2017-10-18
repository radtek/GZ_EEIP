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
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
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
    <div class="form-title">仪器设备校准/核查/维修情况登记表</div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control space" readonly required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>型号/规格：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:model" name="model" id="model" class="form-control space" readonly required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>生产厂商：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:mfrName" name="mfrName" id="mfrName" class="form-control" readonly required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
                <div class="col-sm-4" data-bind="with: deviceVM">
                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control" readonly required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label input-choose" data-name=".project-radio"><span class="required-fields">*</span>项目：</label>
                <div class="col-sm-1 project-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radio1">
                        <label for="radio1">校准</label>
                    </div>
                </div>
                <div class="col-sm-1 project-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radio2">
                        <label for="radio2">核查</label>
                    </div>
                </div>
                <div class="col-sm-2 project-radio">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radio3">
                        <label for="radio3">维修</label>
                    </div>
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>使用经费(元)：</label>
                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
                    <input type="text" data-bind="value:cost" name="cost" id="cost" class="form-control space" readonly required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">情况说明：</label>
                <div class="col-sm-10" data-bind="with:AdjustmentSitnVM">
                	<textarea data-bind="value:situation" name="situation" id="situation" class="form-control" readonly></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">报送人：</label>
                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
                    <input data-bind="value:reporterAlias" name="reporterAlias" id="reporterAlias" type="text" class="form-control" readonly/>
                </div>
                <label class="col-sm-2 control-label">报送时间：</label>
                <div class="col-sm-4" data-bind="with: AdjustmentSitnVM">
                	<input id="createdDate" name="createdDate" class="form-control datetimepicker" data-bind="dateTimePicker:createdDate" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">验收记录：</label>
                <div class="col-sm-10" data-bind="with:AdjustmentSitnVM">
                	<textarea data-bind="value: acceptance" name="acceptance" id="acceptance" class="form-control shenheren"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">验收人：</label>
                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
                    <input type="text" data-bind="value: acceptorAlias" name="acceptorAlias" id="acceptorAlias" class="form-control shenheren" readonly/>
                </div>
                <label class="col-sm-2 control-label">验收时间：</label>
                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
                	<input id="acceptedDate" name="acceptedDate" class="form-control datetimepicker shenheren" data-bind="dateTimePicker: acceptedDate" readonly/>
                </div>
            </div>
            <div class="form-group zhuren">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>技术负责人意见：</label>
                <div class="col-sm-10" data-bind="with:AdjustmentSitnVM">
                	<textarea data-bind="value: opinion" name="opinion" id="opinion" class="form-control" required></textarea>
                </div>
            </div>
            <div class="form-group zhuren">
                <label class="col-sm-2 control-label">技术负责人：</label>
                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
                    <input type="text" data-bind="value: approverAlias" name="approverAlias" id="approverAlias" class="form-control" readonly/>
                </div>
                <label class="col-sm-2 control-label  ">审批时间：</label>
                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
                	<input id="approvedDate" name="approvedDate" class="form-control datetimepicker zhuren" data-bind="dateTimePicker: approvedDate" readonly/>
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
	    
	    var userName = "${sessionScope.loginUser.userName}";
	    var userId = "${sessionScope.loginUser.userId}";
	    var userAlias = "${sessionScope.loginUser.userAlias}";
	    var auditorOrapprover = -1;
	    var id = "${param.id}";
	    
		var AdjustmentSitnDate = loadData("${ pageContext.request.contextPath }/deviceMgt/devAdjustmentSitn/loadDeviceData.do", {"id" : "${param.id}" }); //空对象
		var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : AdjustmentSitnDate.deviceId });
        
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        var AdjustmentSitnDateVM = ko.mapping.fromJS(AdjustmentSitnDate);
        
        //判断是审核人 还是审批的人及那里
        if(AdjustmentSitnDate.acceptorId == "" || AdjustmentSitnDate.acceptorId == undefined || AdjustmentSitnDate.acceptorId == null){
			$(".zhuren").remove();
			AdjustmentSitnDateVM.acceptorAlias = userAlias;
			AdjustmentSitnDateVM.acceptedDate = new Date();
			auditorOrapprover = 0;
        }else if(AdjustmentSitnDate.approverAlias == "" || AdjustmentSitnDate.approverAlias == undefined || AdjustmentSitnDate.approverAlias == null){
			$(".shenheren").attr("readonly","readonly");
			AdjustmentSitnDateVM.approverAlias = userAlias;
			AdjustmentSitnDateVM.approvedDate = new Date();
			auditorOrapprover = 1;
        }else{
			$(".zhuren").attr("readonly","readonly");
			$(".shenheren").attr("readonly","readonly");
        }
        
        var vm = {
        	AdjustmentSitnVM : AdjustmentSitnDateVM,
        	deviceVM : deviceDateVM
        }
        
		$(function(){
			checkType();
	        ko.applyBindings(vm);
		})
        
		$(".agree").click(function(){
			$("button").attr("disabled", true);
	        if(validateSubmittedData()){
	        	if(auditorOrapprover == 0 ){ //审核
					AdjustmentSitnDateVM.acceptorAlias = userAlias;
					AdjustmentSitnDateVM.acceptorId = userId;
					AdjustmentSitnDateVM.acceptorName = userName;
					AdjustmentSitnDateVM.modifiedDate = new Date();
				}else{  //审批
					AdjustmentSitnDateVM.approverId = userId;
					AdjustmentSitnDateVM.approverName = userName;
					AdjustmentSitnDateVM.approverAlias = userAlias;
					AdjustmentSitnDateVM.modifiedDate = new Date();
					AdjustmentSitnDateVM.status = 2;
				}
	        	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devAdjustmentSitn/saveDeviceData.do", AdjustmentSitnDateVM) ) {
	        		saveSuccess("${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalList.do");
		    	}
	    	}else{
	    		saveFailure();
	    	} 
		});
	    		
        
		$(".disAgree").click(function(){
			$("button").attr("disabled", true);
	        if(validateSubmittedData()){
	        	if(auditorOrapprover == 0 ){ //主任
					AdjustmentSitnDateVM.acceptorAlias = userAlias;
					AdjustmentSitnDateVM.acceptorId = userId;
					AdjustmentSitnDateVM.acceptorName = userName;
					AdjustmentSitnDateVM.modifiedDate = new Date();
					AdjustmentSitnDateVM.status = 3;
				}else{
					AdjustmentSitnDateVM.approverId = userId;
					AdjustmentSitnDateVM.approverName = userName;
					AdjustmentSitnDateVM.approverAlias = userAlias;
					AdjustmentSitnDateVM.modifiedDate = new Date();
					AdjustmentSitnDateVM.status = 3;
				}
	        	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devAdjustmentSitn/saveDeviceData.do", AdjustmentSitnDateVM) ) {
	        		saveSuccess("${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalList.do");
		    	}
	    	}else{
	    		saveFailure();
	    	} 
		});
		
		function checkType(){
			//0：校准；1：检查；2：维修
			if(AdjustmentSitnDate.type == 0){
				$("#radio1").attr("checked","checked");
			}else if(AdjustmentSitnDate.type == 1){
				$("#radio2").attr("checked","checked");
			}else if(AdjustmentSitnDate.type == 2){
				$("#radio3").attr("checked","checked");
			}
			$("#radio1").attr("disabled", true);
			$("#radio2").attr("disabled", true);
			$("#radio3").attr("disabled", true);
		}
		
    </script>
</body>
</html>