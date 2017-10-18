<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>固定资产报废申请</title>
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
    <div class="main-content" data-num="9">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content">
            	<div class="form-title">固定资产报废申请表</div>
                <div class="form-content">
			        <form class="form-horizontal">
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control" readonly required />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>型号/规格：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:model" name="model" id="model" class="form-control" readonly required />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>生产厂商：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:mfrName" name="mfrName" id="mfrName" class="form-control" readonly required />
			                </div>
			                <label class="col-sm-2 control-label">出厂编号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:sn" name="sn" id="sn" class="form-control" readonly/>
			                </div>
			            </div>
						<div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control" readonly required />
			                </div>
			                <label class="col-sm-2 control-label">接收日期：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                	<input id="receivingDate" name="receivingDate" class="form-control datetimepicker" data-bind="dateTimePicker:receivingDate" readonly/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>拟报废原因：</label>
			                <div class="col-sm-10" data-bind="with: devDiscardAppVM">
			                	<textarea rows="8" data-bind="value:reason" name="reason" id="reason" cols="" class="form-control allParam" required></textarea>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>申请人：</label>
			                <div class="col-sm-4" data-bind="with: devDiscardAppVM">
			                    <input type="text" data-bind="value:creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control" readonly required />
			                </div>
			                <label class="col-sm-2 control-label"><span class="required-fields">*</span>申请时间：</label>
			                <div class="col-sm-4" data-bind="with: devDiscardAppVM">
			                    <input data-bind="dateTimePicker:createdDate" name="createdDate" id="createdDate" class="form-control datetimepicker allParam" required />
			                </div>
			            </div>
			            <div class="form-group auditor-o">
			                <label class="col-sm-2 control-label">技术负责人意见：</label>
			                <div class="col-sm-10" data-bind="with: devDiscardAppVM">
			                	<textarea rows="8" data-bind="value: auditorOpinion" name="auditorOpinion" id="auditorOpinion" cols="" class="form-control shenheren" readonly></textarea>
			                </div>
			            </div>
			            <div class="form-group auditor-o">
			                <label class="col-sm-2 control-label">技术负责人：</label>
			                <div class="col-sm-4" data-bind="with: devDiscardAppVM">
			                    <input type="text" data-bind="value: auditorAlias" name="auditorAlias" id="auditorAlias" class="form-control shenheren" readonly/>
			                </div>
			                <label class="col-sm-2 control-label">审核时间：</label>
			                <div class="col-sm-4" data-bind="with: devDiscardAppVM">
			                	<input id="auditedDate" name="auditedDate" class="form-control datetimepicker shenheren" data-bind="dateTimePicker: auditedDate" readonly/>
			                </div>
			            </div>
			            <div class="form-group auditor-o">
			                <label class="col-sm-2 control-label">实验室主任意见：</label>
			                <div class="col-sm-10" data-bind="with: devDiscardAppVM">
			                	<textarea rows="8" data-bind="value: approverOpinion" name="approverOpinion" id="approverOpinion" cols="" class="form-control zhuren" readonly></textarea>
			                </div>
			            </div>
			            <div class="form-group auditor-o">
			                <label class="col-sm-2 control-label">实验室主任：</label>
			                <div class="col-sm-4" data-bind="with: devDiscardAppVM">
			                    <input type="text" data-bind="value: approverAlias" name="approverAlias" id="approverAlias" class="form-control zhuren" readonly/>
			                </div>
			                <label class="col-sm-2 control-label">审批时间：</label>
			                <div class="col-sm-4" data-bind="with: devDiscardAppVM">
			                	<input id="approvedDate" name="approvedDate" class="form-control datetimepicker zhuren" data-bind="dateTimePicker: approvedDate" readonly/>
			                </div>
			            </div>
			        </form>
			    </div>
                <div class="btn-content">
                    <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
                    <button class="btn btn-color1 commit" data-bind ="click : saveData"><i class="fa fa-check"></i>提交</button>
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
    	var id ="${param.id}";
        var num = $(".main-content").data("num");
        $(".left-nav li").eq(num).addClass("action");
        
        $(".left-nav li a").click(function(){
            var url = $(this).data("url");
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMgtList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
        
        
        var discardApp = loadData("${ pageContext.request.contextPath }/deviceMgt/devDiscardApp/loadDevDiscardAppbyDeviceId.do", { "deviceId" : "${param.id}" });
        var devDiscardAppDate = loadData("${ pageContext.request.contextPath }/deviceMgt/devDiscardApp/loadDevDiscardAppDate.do", { "id" : "${param.id}" });
        if(discardApp.reason != null && discardApp.reason != "" && discardApp.reason != undefined){  
    		if(discardApp.ApproverId != "" && discardApp.status == 2){ //是否已报废
				$(".shenheren").attr("readonly","readonly");
				$(".zhuren").attr("readonly","readonly");
    		}else{
    			$(".auditor-o").hide();
    		}
			$(".required-fields").hide();
        	$(".allParam").attr("readonly",true);
        	$(".commit").hide();
        	devDiscardAppDate = discardApp;
        }else{
			$(".auditor-o").hide();
		}
        var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : "${param.id}" });
        
// 		if(devDiscardAppDate.id == "" || devDiscardAppDate.id == undefined || devDiscardAppDate.id == null){
// 			 $(".shenheren").attr("readonly","readonly");
// 			 $(".zhuren").attr("readonly","readonly");
// 		}else if(devDiscardAppDate.auditorId == "" || devDiscardAppDate.auditorId == undefined || devDiscardAppDate.auditorId == null){
// 			 $(".zhuren").attr("readonly","readonly");
// 		}


        
        
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        var devDiscardAppDateVM = ko.mapping.fromJS(devDiscardAppDate);
        var userAlias = "${sessionScope.loginUser.userAlias}";
        devDiscardAppDateVM.creatorAlias = userAlias;
        
        var vm = {
        	deviceVM : deviceDateVM,
        	devDiscardAppVM : devDiscardAppDateVM
        }
        
        vm.saveData = function(){
        	$("button").attr("disabled", true);
        	bindDataToVM();
            if(validateSubmittedData()){
            	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devDiscardApp/saveDevDiscardAppDate.do", devDiscardAppDateVM) ) {  //主表保存成功
            		$(".btn-color1").attr({"disabled":"disabled"});
            		saveSuccess("${pageContext.request.contextPath}/deviceMgt/scrapApplyForm.do?id="+id);
    	    	}else{
    	    		
    	    	}
        	}else{
        		saveFailure();
        	} 
        }
        
	    function bindDataToVM(){
	    	if(devDiscardAppDate.id == "" || devDiscardAppDate.id == undefined || devDiscardAppDate.id == null){   //没有ID就是新增
	    		devDiscardAppDateVM.creatorName = "${sessionScope.loginUser.userName}";
	    		devDiscardAppDateVM.creatorId = "${sessionScope.loginUser.userId}";
	    		devDiscardAppDateVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
	    		devDiscardAppDateVM.deviceId = id;
	    		devDiscardAppDateVM.status = 1;
	    	}else{
	    	}
	    }
        
        ko.applyBindings(vm);
        
    </script>
</body>
</html>