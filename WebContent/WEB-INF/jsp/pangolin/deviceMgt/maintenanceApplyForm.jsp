<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>校准维修申请申请表单</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备管理</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="main-content" data-num="8">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content">
            	<div class="form-title">仪器设备核查/校准/维修申请单</div>
                <div class="form-content">
			        <form class="form-horizontal">
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control serialNumber" readonly required />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control validation" readonly required />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>生产厂商：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:mfrName" name="mfrName" id="mfrName" class="form-control validation" readonly required />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>规格/型号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:model" name="model" id="model" class="form-control specifications" readonly required />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label input-choose" data-name=".project-radio"><span class="required-fields">*</span>申请项目：</label>
			                <div class="col-sm-1 project-radio">
                                <div class="rdio rdio-primary">
                                    <input type="radio" name="radio" value="" id="radio1">
                                    <label for="radio1">检定</label>
                                </div>
                            </div>
                            <div class="col-sm-1 project-radio">
                                <div class="rdio rdio-primary">
                                    <input type="radio" name="radio" value="" id="radio2">
                                    <label for="radio2">校准</label>
                                </div>
                            </div>
                            <div class="col-sm-2 project-radio">
                                <div class="rdio rdio-primary">
                                    <input type="radio" name="radio" value="" id="radio3">
                                    <label for="radio3">维修</label>
                                </div>
                            </div>
                            <label class="col-sm-2 control-label"><span class="required-fields">*</span>经费预算(元)：</label>
			                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
			                    <input type="text" data-bind="value: budget" name="budget" id="budget" class="form-control money" required />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">详细说明：</label>
			                <div class="col-sm-10" data-bind="with: DevAdjAppVM">
			                	<textarea data-bind="value: details" name="details" id="details" class="form-control"></textarea>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>申请人：</label>
			                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
			                    <input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control name" readonly required />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>申请时间：</label>
			                <div class="col-sm-4" data-bind="with: DevAdjAppVM">
			                	<input id="createdDate" name="createdDate" class="form-control datetimepicker" data-bind="dateTimePicker:createdDate" readonly required />
			                </div>
			            </div>
			            <div class="form-group shenheren">
			                <label class="col-sm-2 control-label">审核人意见：</label>
			                <div class="col-sm-10">
			                	<textarea class="form-control "></textarea>
			                </div>
			            </div>
			            <div class="form-group shenheren">
			                <label class="col-sm-2 control-label">审核人：</label>
			                <div class="col-sm-4">
			                    <input type="text" class="form-control  name" />
			                </div>
			                <label class="col-sm-2 control-label">审核时间：</label>
			                <div class="col-sm-4">
			                    <input type="text" class="form-control datetimepicker shenheren" />
			                </div>
			            </div>
			            <div class="form-group zhuren">
			                <label class="col-sm-2 control-label">实验室主任意见：</label>
			                <div class="col-sm-10">
			                	<textarea rows="8" cols="" class="form-control "></textarea>
			                </div>
			            </div>
			            <div class="form-group zhuren">
			                <label class="col-sm-2 control-label">实验室主任：</label>
			                <div class="col-sm-4">
			                    <input type="text" class="form-control  name" />
			                </div>
			                <label class="col-sm-2 control-label">审批时间：</label>
			                <div class="col-sm-4">
			                    <input type="text" class="form-control datetimepicker zhuren" />
			                </div>
			            </div>
			        </form>
			    </div>
                <div class="btn-content">
                    <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
                    <button class="btn btn-color1" data-bind ="click : saveData"><i class="fa fa-check"></i>提交</button>
                </div>
            </div>
        </div>
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
    
    	var id = "${param.id}";
        var num = $(".main-content").data("num");
        $(".left-nav li").eq(num).addClass("action");
        
        $(".left-nav li a").click(function(){
            var url = $(this).data("url");
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/maintenanceApplyViewer.do";
	    	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
        
	    //项目（0：校准；1：检查；2：维修），即登记类型	
	    $("#radio1").click(function(){
	    	DevAdjAppDataVM.type = 0;
	    })
	    $("#radio2").click(function(){
	    	DevAdjAppDataVM.type = 1;
	    })
	    $("#radio3").click(function(){
	    	DevAdjAppDataVM.type = 2;
	    })
        
        
        var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : "${param.id}" });
		var DevAdjAppData = loadData("${ pageContext.request.contextPath }/deviceMgt/devAdjApp/loadDevAdjAppData.do", { "id" : " " });
		
        var DevAdjAppDataVM = ko.mapping.fromJS(DevAdjAppData);
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
		DevAdjAppDataVM.createdDate = new Date();
        
		var DevAdjAppId = DevAdjAppData.id;
		var auditedDateSource = DevAdjAppData.auditedDate;	//审核时间	
		
		if(DevAdjAppId == "" || DevAdjAppId == undefined || DevAdjAppId == null){  //审核人
			$(".shenheren").hide();
			$(".zhuren").hide();
        	DevAdjAppDataVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
		}else if(auditedDateSource == "" || auditedDateSource == undefined || auditedDateSource == null){
			 $(".zhuren").hide();
		}
		
        
        var vm = {
			deviceVM : deviceDateVM,
			DevAdjAppVM : DevAdjAppDataVM
        }
        
        vm.saveData = function(){
        	$("button").attr("disabled", true);
            if(validateSubmittedData()){
            	bindDataToVM();  //如果是新增就增加必要字段
            	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devAdjApp/saveDevAdjAppData.do", DevAdjAppDataVM) ) {  //主表保存成功
            		$(".btn-color1").attr({"disabled":"disabled"});
            		saveSuccess("${pageContext.request.contextPath}/deviceMgt/maintenanceApplyViewer.do?id="+id);
    	    	}else{
    	    		
    	    	}
        	}else{
        		saveFailure();
        	}
        }
        
	    function bindDataToVM(){
	    	if(DevAdjAppData.id == "" || DevAdjAppData.id == undefined || DevAdjAppData.id == null){   //没有ID就是新增
	    		DevAdjAppDataVM.creatorName = "${sessionScope.loginUser.userName}";
	    		DevAdjAppDataVM.creatorId = "${sessionScope.loginUser.userId}";
	    		DevAdjAppDataVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    		DevAdjAppDataVM.status = 1;
	    		DevAdjAppDataVM.deviceId = id;
	    		DevAdjAppDataVM.createdDate = new Date();
	    	}else{
	    	}
	    }

        ko.applyBindings(vm);
    </script>
</body>
</html>