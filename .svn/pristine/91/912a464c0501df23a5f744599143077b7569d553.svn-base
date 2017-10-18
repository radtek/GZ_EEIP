<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>取证及流程管理-检材交接记录-查看</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>取证及流程管理</a><span>></span><a>检材交接记录</a><span>></span><a>查看</a>
        </p>
    </div>
	<div class="form-title">检材流转记录表</div>
	<div class="form-content">
	   	<form class="form-horizontal">
	   		<div class="form-group">
				<label class="col-sm-2 control-label">检材名称：</label>
				<div class="col-sm-4" data-bind="with: appraisalVM">
					<input type="text" data-bind="value: evidName" name="evidName" id="evidName" class="form-control" readonly/>
				</div>	
				<label class="col-sm-2 control-label">唯一性编号：</label>
				<div class="col-sm-4" data-bind="with: appraisalVM">
					<input type="text" data-bind="value: evidSn" name="evidSn" id="evidSn" class="form-control" readonly/>
				</div>				
			</div>			
			<div class="form-group">
				<label class="col-sm-2 control-label">接收人：</label>
				<div class="col-sm-4" data-bind="with: evidenceVM">
					<input type="text" data-bind="value: creatorAlias" name="creatorAlias" id="creatorAlias" class="form-control" readonly/>
				</div>	
				<label class="col-sm-2 control-label">接收时间：</label>
				<div class="col-sm-4" data-bind="with: evidenceVM">
                	<input id="createdDate" name="createdDate" class="form-control datetimepicker" data-bind="dateTimePicker: createdDate" readonly/>
                </div>		
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">存放地点：</label>
				<div class="col-sm-10" data-bind="with: evidenceVM">
					<input type="text" data-bind="value: location" name="location" id="location" class="form-control" readonly/>
				</div>	
			</div>		
	   	</form>
	</div>
	<div class="file-upload">
	    <table class="table table-bordered devTelFile" id="table2">
	        <thead>
	            <tr>
	                <th>时间</th>
	                <th>交接人1</th>
	                <th>交接人2</th>
	                <th>备注(检验/发还)</th>
	            </tr>
	        </thead>
	        <tbody>
<!-- 				<tr>
					<td>2016-12-12</td>
					<td>张三</td>
					<td>李四</td>
					<td>检验</td>
				</tr> -->
	        </tbody>
	    </table>
	</div>
	<div class="btn-content">
	    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
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
		$(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/evidenceMgt/handoverRecord/handoverRecordList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
		var appraisalId = "${param.id}";
		
		var evidenceData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/evidence/getDataByAppraisalId.do", { "appraisalId" : appraisalId });
		var appraisalData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/loadDataById.do", { "id" : appraisalId });
		
		var evidenceDataVM = ko.mapping.fromJS(evidenceData);
		var appraisalDataVM = ko.mapping.fromJS(appraisalData);
		
        var vm = {
           		evidenceVM : evidenceDataVM,
           		appraisalVM : appraisalDataVM,
   		}
        
		ko.applyBindings(vm);
        
    	$(function(){
    	   	function getOperationCol(data, type, row) {
				var html = "";
				html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
				return html;
			}
    	   	function getType(data, type, row){
    	   		if(data == 0){
    	   			return "领用";
    	   		}else{
    	   			return "归还";
    	   		}
    	   	}
        	function getDate(data,type,row){
        		return new Date(data).Format("yyyy-MM-dd");
        	}
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
				//数据列绑定
				var columns = [
					{ "mData" : "createdDate" , "bSortable" : false , "mRender" : getDate},
					{ "mData" : "applicantAlias" , "bSortable" : false },
					{ "mData" : "operatorAlias" , "bSortable" : false },
					{ "mData" : "type" , "bSortable" : false , "mRender" : getType},
	            ];
          	
    			//排序规则
    			var sorting = [ [ 0 , 'desc' ] ];
        	  
    			//扩展参数
    			var extraParams = [
					{	"name" : "appraisalId",
						"value" : appraisalId } 
				];
            
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : 50,
    				"dataSource" : "${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/evidTransitionGirdData.do",
    				"extraParams" : extraParams,
    				"style" : DT_FULL_NUMBERS,
    				"bProcessing" : true,
    				"url" : {
    				}
    			});
    			//隐藏列表组件显示条数
    			$('#table2_length, #table2_paginate,#table2_info').hide();
             }
        })
	</script>
</body>
</html>