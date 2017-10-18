<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>核查情况记录表查看表单</title>
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
	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
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
    <div class="main-content" data-num="2">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content">
            	<div class="form-title">设备期间核查情况记录表</div>
                <div class="form-content">
                    <form class="form-horizontal">
				        <div class="form-group">
			                <label class="col-sm-2 control-label">设备识别号：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:identifier" name="identifier" id="identifier" class="form-control" readonly />
			                </div>
			                <label class="col-sm-2 control-label">设备名称：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:name" name="name" id="name" class="form-control" readonly />
			                </div>
			            </div>
				        <div class="form-group">
			                <label class="col-sm-2 control-label">型号/规格：</label>
			                <div class="col-sm-4" data-bind="with: deviceVM">
			                    <input type="text" data-bind="value:model" name="model" id="model" class="form-control" readonly />
			                </div>
			                <label class="col-sm-2 control-label">工作状态：</label>
                            <div class="col-sm-4">
                                <input id="workstatus" type="text" class="form-control" readonly />
                            </div>
			            </div>
				        <div class="form-group">
				            <label class="col-sm-2 control-label">核查日期：</label>
			                <div class="col-sm-4" data-bind="with: devInspectionVM">
			                	<input id="checkingDate" name="checkingDate" class="form-control datetimepicker" data-bind="dateTimePicker:inspectedDate" readonly />
			                </div>
			                <label class="col-sm-2 control-label">核查周期：</label>
				            <div class="col-sm-4" data-bind="with: devInspectionVM">
				                <input type="text" data-bind="value:cycle" name="cycle" id="cycle" class="form-control" readonly />
				            </div>
				        </div>
				        <div class="form-group">
				            <label class="col-sm-2 control-label">下次核查日期：</label>
			                <div class="col-sm-4" data-bind="with: devInspectionVM">
			                	<input id="checkingDate" name="checkingDate" class="form-control datetimepicker" data-bind="dateTimePicker:nextInspectedDate" readonly />
			                </div>
			                <label class="col-sm-2 control-label">本次核查结果：</label>
                            <div class="col-sm-2">
                                <div class="rdio rdio-primary">
                                    <input type="radio" name="radio1" value="" id="radio1">
                                    <label for="radio1">正常</label>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <div class="rdio rdio-primary">
                                    <input type="radio" name="radio1" value="" id="radio2">
                                    <label for="radio2">不正常</label>
                                </div>
                            </div>
				        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">核查人：</label>
                            <div class="col-sm-4" data-bind="with: devInspectionVM">
                                <input type="text" data-bind="value:inspectorAlias" name="inspectorAlias" id="inspectorAlias" class="form-control" readonly/>
                            </div>
                        </div>
				        <div class="form-group">
				            <label class="col-sm-2 control-label">备注：</label>
				            <div class="col-sm-10" data-bind="with: devInspectionVM">
				                <textarea rows="8" data-bind="value:remarks" name="remarks" id="remarks" cols="" class="form-control" readonly></textarea>
				            </div>
				        </div>
                    </form>
                </div>
                <div class="table-title">期间核查项目及参数</div>
                <div class="file-upload">
                    <table class="table table-bordered" id="table2">
                        <thead>
                            <tr>
                                <th>核查项目</th>
                                <th>标准参数</th>
                                <th>核查参数</th>
                                <th>单项核查结果</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                <div class="btn-content">
                    <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
                    <!-- <button class="btn btn-color1"><i class="fa fa-check"></i>提交</button> -->
                </div>
            </div>
        </div>
    </div>
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
    	var devInspectionId = "${param.devInspectionId}";
    
        var num = $(".main-content").data("num");
        $(".left-nav li").eq(num).addClass("action");
        
        $(".left-nav li a").click(function(){
            var url = $(this).data("url");
            $(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/verificationChecklist.do";
	    	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
        
        var devInspectionDate = loadData("${pageContext.request.contextPath}/deviceMgt/devinspection/loadById.do", { "id" : devInspectionId });
        var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : id });
        
        var workstatus = devInspectionDate.status;//工作状态
        if(workstatus == 0){
        	$("#workstatus").val("正常");
        }else{
        	$("#workstatus").val("异常");
        }
        var resultStatus = devInspectionDate.result;//核查结果
        if(resultStatus == 0){  //正常
        	$("#radio1").attr("checked",true);
        }else{//不正常
        	$("#radio2").attr("checked",true);
        }
       	$("#radio1").attr("disabled","disabled");
       	$("#radio2").attr("disabled","disabled");
        
        
        var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        var devInspectionDateVM = ko.mapping.fromJS(devInspectionDate);
        
        var vm = {
        	devInspectionVM : devInspectionDateVM,
        	deviceVM : deviceDateVM
        }
        
        ko.applyBindings(vm);
        
        
    	$(function(){
    		
    		function getResult(data, type, row){
    			if(data == 1){
    				return "异常";
    			}else{
    				return "正常";
    			}
    		}
    		
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : "item" , "bSortable" : true },
    				{ "mData" : "standardParam", "bSortable" : true},
    				{ "mData" : "inspectingParam", "bSortable" : true},
    				{ "mData" : "result", "bSortable" : true , "mRender": getResult},
    				{ "mData" : "createdDate", "bSortable" : false,"bVisible" : false }
                ];
          	
    			//排序规则
    			var sorting = [ [ 4 , 'desc' ] ];
        	  
    			//扩展参数
    			var extraParams = [ {
    				"name" : "devId",
    				"value" : id
    			}, {
    				"name" : "devInspectionId",
    				"value" : devInspectionId
    			} ];
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : DEFAULT_PAGE_SIZE,
    				"dataSource" : "${pageContext.request.contextPath}/deviceMgt/devInspectionParam/DevInspectionParamGirdData.do",
    				"extraParams" : extraParams,
    				"style" : DT_FULL_NUMBERS,
    				"bProcessing" : true,
    				"url" : {
//     					"addDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//     					"editDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//     					"rmDataUrl" : "/eeip/meeting/meetingApp/removeMeetingAppData.do"
    				}
    			});
                
    			//隐藏列表组件显示条数  --  数量   和 分页
    			$('#table2_length').hide();
    			$('#table2_paginate').hide();
    			$('#table2_info').hide();
             }
        })
        
    </script>
</body>
</html>