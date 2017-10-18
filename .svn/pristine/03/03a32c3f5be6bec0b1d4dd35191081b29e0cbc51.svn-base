<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>借用外部设备申请表单</title>
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
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/zyupload-1.0.0.min.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>外部设备借用</a><span>></span><a>申请表单</a>
        </p>
    </div>
    <div class="form-title">借用外部设备申请表</div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>申请人：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control space" readonly required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>申请日期：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                	<input id="createdDate" name="createdDate" class="form-control datetimepicker space" data-bind="dateTimePicker: createdDate" readonly required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: name" name="name" id="name" class="form-control space illegalCharacter" required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>型号/规格：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: identifier" name="identifier" id="identifier" class="form-control space" required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>提供单位：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: org" name="org" id="org" class="form-control space" required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>联系人：</label>
                <div class="col-sm-4" data-bind="with: devBorrowAppVM">
                    <input type="text" data-bind="value: contacts" name="contacts" id="contacts" class="form-control space" required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>借用理由：</label>
                <div class="col-sm-10" data-bind="with: devBorrowAppVM">
                	<textarea data-bind="value: reason" name="reason" id="reason" class="form-control space" required></textarea>
                </div>
            </div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1" data-bind ="click : saveData"><i class="fa fa-check"></i>提交</button>
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
	    	var url = "${pageContext.request.contextPath}/deviceMgt/externalDeviceMgtList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
	    
	    var userName = "${sessionScope.loginUser.userName}";
	    var userId = "${sessionScope.loginUser.userId}";
	    var userAlias = "${sessionScope.loginUser.userAlias}";
	    
        var uuid = loadData("${ pageContext.request.contextPath }/deviceMgt/getUUID.do", {});
        var devBorrowAppData = loadData("${ pageContext.request.contextPath }/deviceMgt/devBorrowApp/loadDevBorrowAppData.do", {"id" : " "});
        
        var devBorrowAppDataVM = ko.mapping.fromJS(devBorrowAppData);
        devBorrowAppDataVM.creatorAlias = userAlias;
        devBorrowAppDataVM.createdDate = new Date();
        var vm = {
			devBorrowAppVM : devBorrowAppDataVM	
        }
        
        ko.applyBindings(vm);
        
        vm.saveData = function(){
        	$("button").attr("disabled", true);
            if(validateSubmittedData()){
            	bindDataToVM();  //如果是新增就增加必要字段
            	if ( saveData("${ pageContext.request.contextPath }/deviceMgt/devBorrowApp/saveDevBorrowAppData.do", devBorrowAppDataVM) ) {
            		saveSuccess("${pageContext.request.contextPath}/deviceMgt/externalDeviceMgtList.do");
    	    	}else{
    	    		
    	    	}
        	}else{
        		saveFailure();
        	}
        }
        
	    function bindDataToVM(){
	    	if(devBorrowAppData.id == "" || devBorrowAppData.id == undefined || devBorrowAppData.id == null){   //没有ID就是新增
				devBorrowAppDataVM.creatorName = userName;
				devBorrowAppDataVM.creatorId = userId;
				devBorrowAppDataVM.creatorAlias = userAlias;
				devBorrowAppDataVM.createdDate = new Date();
				devBorrowAppDataVM.status = 1;
				devBorrowAppDataVM.deviceId = uuid;
	    	}else{
	    	}
	    }
	    
    </script>
</body>
</html>