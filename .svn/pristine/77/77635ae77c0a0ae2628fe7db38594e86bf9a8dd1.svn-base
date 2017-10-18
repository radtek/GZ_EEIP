<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备维护申请审批-查看</title>
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
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备维护申请审批</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="form-title">仪器设备核查/校准/维修申请单</div>
    <div class="form-content">
        <form class="form-horizontal">
             <div class="form-group">
                 <label class="col-sm-2 control-label">填表人：</label>
                 <div class="col-sm-4" data-bind="with: DevAdjPlanVM">
                     <input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control" readonly/>
                 </div>
                 <label class="col-sm-2 control-label">填表时间：</label>
                 <div class="col-sm-4" data-bind="with: DevAdjPlanVM">
        			<input id="createdDate" name="createdDate" class="form-control" data-bind="dateTimePicker:createdDate" readonly/>
                 </div>
             </div>
             <div class="form-group">
                 <label class="col-sm-2 control-label">技术负责人：</label>
                 <div class="col-sm-4" data-bind="with: DevAdjPlanVM">
                     <input type="text" data-bind="value: approverAlias" name="approverAlias" id="approverAlias" class="form-control" readonly/>
                 </div>
                 <label class="col-sm-2 control-label">审批时间：</label>
                 <div class="col-sm-4" data-bind="with: DevAdjPlanVM">
        			<input id="approvedDate" name="approvedDate" class="form-control" data-bind="dateTimePicker:approvedDate" readonly/>
                 </div>
             </div>
        </form>
    </div>
    <div class="file-upload">
        <table class="table table-bordered" id="table2">
            <thead>
                <tr>
                    <th>序号</th>
                    <th><span class="required-fields">*</span>设备名称</th>
                    <th><span class="required-fields">*</span>型号/规格</th>
                    <th><span class="required-fields">*</span>设备识别号</th>
                    <th>核查/校准方式</th>
                    <th>核查时间</th>
                    <th>责任人</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <!-- <button class="btn btn-color1"><i class="fa fa-check"></i>同意</button>
        <button class="btn btn-color1"><i class="fa fa-times"></i>不同意</button> -->
    </div>
    <script type="text/javascript">
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
		
	    var DevAdjPlanData = loadData("${ pageContext.request.contextPath }/deviceMgt/devAdjPlan/loadDevAdjPlanData.do", { "id" : "${param.id}" });
	    var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : DevAdjPlanData.deviceId });
		
        var DevAdjPlanDataVM = ko.mapping.fromJS(DevAdjPlanData);
		var deviceDateVM = ko.mapping.fromJS(deviceDateSource);
        
        var vm = {
			deviceVM : deviceDateVM,
			DevAdjPlanVM : DevAdjPlanDataVM,
        }

        ko.applyBindings(vm);
        
    	$(function(){
    		function getName(){
    			return deviceDateSource.name;
    		}
    		function getType(){
    			return deviceDateSource.model;
    		}
    		function getIdf(){
    			return deviceDateSource.identifier;
    		}
    		
    	   	function getDate(data, type, row) {
    	   		return new Date(data).Format("yyyy-MM-dd");
			}
    	   	
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : null , "bSortable" : true ,"mRender": getName},
    				{ "mData" : null , "bSortable" : true ,"mRender": getType},
    				{ "mData" : null , "bSortable" : true ,"mRender": getIdf},
    				{ "mData" : "method", "bSortable" : true},
    				{ "mData" : "inspectedDate", "bSortable" : true,"mRender": getDate},
    				{ "mData" : "principalAlias", "bSortable" : true },
    				{ "mData" : "createdDate", "bSortable" : false,"bVisible" : false }
                ];
          	
    			//排序规则
    			var sorting = [ [ 6 , 'desc' ] ];
        	  
    			//扩展参数
    			var extraParams = [ {
    				"name" : "devId",
    				"value" : deviceDateSource.id
    			},{
    				"name" : "devAdjPlanId",
    				"value" : DevAdjPlanData.id
    			}  ];
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : DEFAULT_PAGE_SIZE,
    				"dataSource" : "${pageContext.request.contextPath}/deviceMgt/devAdjPlanItem/DevAdjPlanItemGirdData.do",
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