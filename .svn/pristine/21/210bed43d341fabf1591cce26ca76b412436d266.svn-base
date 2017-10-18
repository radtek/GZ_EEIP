<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备校准维修情况申请表单</title>
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
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备管理</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="main-content" data-num="6">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content">
            	<div class="form-title">仪器设备校准/核查/维修情况登记表</div>
                <div class="form-content">
			        <form class="form-horizontal">
			            <div class="form-group">
			                <label class="col-sm-2 control-label">设备名称：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control" readonly />
			                </div>
			                <label class="col-sm-2 control-label">型号/规格：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:model" name="model" id="model" class="form-control" readonly />
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">生产厂商：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:mfrName" name="mfrName" id="mfrName" class="form-control" readonly/>
			                </div>
			                <label class="col-sm-2 control-label">设备识别号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control" readonly/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">项目：</label>
			                <div class="col-sm-1">
                                <div class="rdio rdio-primary">
                                    <input type="radio" name="radio" value="" id="radio1">
                                    <label for="radio1">校准</label>
                                </div>
                            </div>
                            <div class="col-sm-1">
                                <div class="rdio rdio-primary">
                                    <input type="radio" name="radio" value="" id="radio2">
                                    <label for="radio2">核查</label>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <div class="rdio rdio-primary">
                                    <input type="radio" name="radio" value="" id="radio3">
                                    <label for="radio3">维修</label>
                                </div>
                            </div>
                            <label class="col-sm-2 control-label">使用经费(元)：</label>
			                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
			                    <input type="text" data-bind="value:cost" name="cost" id="cost" class="form-control" readonly/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">情况说明：</label>
			                <div class="col-sm-10" data-bind="with:AdjustmentSitnVM">
			                	<textarea rows="8" data-bind="value:situation" name="situation" id="situation" cols="" class="form-control" readonly></textarea>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">报送人：</label>
			                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
			                    <input data-bind="value:reporterAlias" name="reporterAlias" id="reporterAlias" type="text" class="form-control" readonly/>
			                </div>
			                <label class="col-sm-2 control-label">报送时间：</label>
			                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
			                	<input id="createdDate" name="createdDate" class="form-control" data-bind="dateTimePicker: createdDate" readonly/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">验收记录：</label>
			                <div class="col-sm-10" data-bind="with:AdjustmentSitnVM">
			                	<textarea rows="8" data-bind="value: acceptance" name="acceptance" id="acceptance" cols="" class="form-control" readonly></textarea>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">验收人：</label>
			                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
			                    <input type="text" data-bind="value: acceptorAlias" name="acceptorAlias" id="acceptorAlias" class="form-control" readonly/>
			                </div>
			                <label class="col-sm-2 control-label">验收时间：</label>
			                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
			                	<input id="acceptedDate" name="acceptedDate" class="form-control" data-bind="dateTimePicker: acceptedDate" readonly/>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">技术负责人意见：</label>
			                <div class="col-sm-10" data-bind="with:AdjustmentSitnVM">
			                	<textarea rows="8" data-bind="value: opinion" name="opinion" id="opinion" cols="" class="form-control" readonly></textarea>
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label">技术负责人：</label>
			                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
			                    <input type="text" data-bind="value: approverAlias" name="approverAlias" id="approverAlias" class="form-control" readonly/>
			                </div>
			                <label class="col-sm-2 control-label">审批时间：</label>
			                <div class="col-sm-4" data-bind="with:AdjustmentSitnVM">
			                    <input data-bind="dateTimePicker: approvedDate" name="approvedDate" id="approvedDate" class="form-control" readonly/>
			                </div>
			            </div>
			        </form>
			    </div>
                <div class="btn-content">
                    <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
                    <!-- <button class="btn btn-color1" data-bind ="click : saveData"><i class="fa fa-check"></i>提交</button> -->
                </div>
            </div>
        </div>
    </div>
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
		var id ="${param.id}";
		var AdjId ="${param.AdjId}";
		var userName = "${sessionScope.loginUser.userName}";
		var userId = "${sessionScope.loginUser.userId}";
		var userAlias = "${sessionScope.loginUser.userAlias}";
		
		
        var num = $(".main-content").data("num");
        $(".left-nav li").eq(num).addClass("action");
        
        $(".left-nav li a").click(function(){
            var url = $(this).data("url");
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/maintenanceSituationViewer.do";
	    	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
        
        
		var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : "${param.id}" });
		var AdjustmentSitnDate = loadData("${ pageContext.request.contextPath }/deviceMgt/devAdjustmentSitn/loadDeviceData.do", {"id" : "${param.AdjId}" }); //空对象
        
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        var AdjustmentSitnDateVM = ko.mapping.fromJS(AdjustmentSitnDate);
        
        var vm = {
        	deviceVM : deviceDateVM,
        	AdjustmentSitnVM : AdjustmentSitnDateVM
        }
        
        
        ko.applyBindings(vm);
        
        checkType();
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