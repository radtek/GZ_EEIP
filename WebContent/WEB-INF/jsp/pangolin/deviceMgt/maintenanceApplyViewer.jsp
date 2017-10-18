<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>校准维修申请</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>  	
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script> 
	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
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
    <div class="main-content" data-num="8">
        <jsp:include page="/common/deviceMgtLeftNav.jsp"></jsp:include>
        <div class="right-form">
            <div class="right-content">
            	<div class="form-title">仪器设备核查/校准/维修申请单</div>
                <div class="file-upload">
                    <table class="table table-bordered" id="table2">
                        <thead>
                            <tr>
			                    <th>设备名称</th>
			                    <th>型号/规格</th>
			                    <th>设备识别号</th>
			                    <th>申请项目</th>
			                    <th>申请时间</th>
			                    <th>审批人</th>
			                    <th>操作</th>
			                </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                <div class="btn-content">
                    <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
                    <button class="btn btn-color1 add-form-btn"><i class="fa fa-plus"></i>申请</button>
                </div>
            </div>
        </div>
    </div>
    <script>
    	var id = "${param.id}";
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
        
        $(".add-form-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/maintenanceApplyForm.do";
	    	$(".index-iframe", window.parent.document).attr("src",url+"?id="+id);
	    });
        
        function view(id){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/requisitionViewer.do?id="+id;
	    	$(".index-iframe", window.parent.document).attr("src",url);
        }
        function sitn(id){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/maintenanceSituationForm.do?id="+id;
	    	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
    	$(function(){
    		var deviceDateSource = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : id });
			
    		loadGridData();
    		
    	   	function getOperationCol(data, type, row) {
    	   		if(data == "" || data == undefined || data == null){
    				var html = "";
    				html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
    				return html;
    	   		}else{
    				var html = "";
    				html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
    				html += "<a class=\"operating-btn\" onclick=\"sitn('" + row.id + "');\" title=\"设备登记填写\"><i class=\"fa fa-pencil-square-o\"></i></a> "; //查看
    				return html;
    	   		}
    	   		
			}
    	   	
    	   	function getName(data, type, row){
    	   		return deviceDateSource.name;
    	   	}
    	   	function getModel(data, type, row){
    	   		return deviceDateSource.model;
    	   	}
    	   	function getIdentifier(data, type, row){
    	   		return deviceDateSource.identifier;
    	   	}
    	   	function getType(data, type, row){
    	   		if(data == 0){
    	   			return "校准";
    	   		}else if(data == 1){
    	   			return "检查";
    	   		}else if(data == 2){
    	   			return "维修";
    	   		}else{
    	   			return "校准";
    	   		}
    	   	}
    		//加载列表数据
    		function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : null , "bSortable" : false, "mRender": getName },
    				{ "mData" : null , "bSortable" : false, "mRender": getModel },
    				{ "mData" : null ,  "bSortable" : false, "mRender": getIdentifier },
    				{ "mData" : "type" ,  "bSortable" : false, "mRender": getType},
    				{ "mData" : "createdDate", "bSortable" : false, "mRender": getFormattedDate},
    				{ "mData" : "approverAlias" , "bSortable" : false },
    				{ "mData" : "approverAlias" , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "6em" }
                ];
          	
    			//排序规则
    			var sorting = [ [ 4 , 'desc' ] ];
        	  
    			//扩展参数
    			var extraParams = [ {
    				"name" : "devId",
    				"value" : id
    			} ];
            
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : DEFAULT_PAGE_SIZE,
    				"dataSource" : "${ pageContext.request.contextPath }/deviceMgt/devAdjApp/DevAdjAppGirdData.do",
    				"extraParams" : extraParams,
    				"style" : DT_FULL_NUMBERS,
    				"bProcessing" : true,
    				"url" : {
//     					"addDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//     					"editDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
//     					"rmDataUrl" : "/eeip/meeting/meetingApp/removeMeetingAppData.do"
    				}
    			});
                
    			//隐藏列表组件显示条数
    			$('#table2_length').hide();
    			$('#table2_paginate').hide();
    			$('#table2_info').hide();
             }
        })
        
    </script>
</body>
</html>