<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>核查情况记录表</title>
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
                <div class="form-title">设备期间核查情况记录表-历史记录</div>
                <div class="file-upload">
                    <table class="table table-bordered" id="table2">
                        <thead>
                            <tr>
                                <th>核查日期</th>
                                <th>文件名</th>
                                <th>操作</th>
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
    	var id = "${param.id}";
    	var devDate = loadData("${pageContext.request.contextPath}/deviceMgt/device/loadDeviceData.do", { "id" : id });
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
        
        function view(devInspectionId){
        	var url = "${pageContext.request.contextPath}/deviceMgt/verificationChecklistViewer.do?devInspectionId="+devInspectionId+"&id="+id;
            $(".index-iframe", window.parent.document).attr("src",url);
        }
        
        
    	$(function(){
    	   	function getOperationCol(data, type, row) {
				var html = "";
				html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
				return html;
			}
    	   	
    	   	function fileName(data, type, row) {
    	   		return "仪器设备期间核查情况记录表"+devDate.name+"("+new Date(data).Format("yyyy-MM-dd")+")";
			}
    	   	
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : "inspectedDate", "bSortable" : false ,"mRender": getFormattedDate},
    				{ "mData" : "createdDate", "bSortable" : false , "mRender": fileName},
    				{ "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "150px" },
                ];
          	
    			//排序规则
    			var sorting = [ [ 1 , 'desc' ] ];
        	  
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
    				"dataSource" : "${pageContext.request.contextPath}/deviceMgt/devinspection/devinspectionGirdData.do",
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
    			$('#table2_length, #table2_info, #table2_paginate').hide();
             }
        })
    </script>
</body>
</html>