<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备使用情况列表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>设备与环境管理</a><span>></span><a>设备使用情况</a>
        </p>
    </div>
    <div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-1">
    		<input type="text" id="key"/>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
    	</div>
    	<!-- <div class="button-content">
    		<button type="button" class="btn btn-color1"><i class="fa fa-plus"></i>新增</button>
    	</div> -->
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>识别号</th>
                    <th>设备名称</th>
                    <th>存放地址</th>
                    <th>最后使用时间</th> 
                    <th>创建时间</th> 
                    <th>型号</th>
                    <th>设备状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <script>
    function view(id){
    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceUseSituationViewer.do?id="+id;
    	$(".index-iframe", window.parent.document).attr("src",url);
    }
    
	$(function(){
		var searchValue = '';
		
    	$(".search").click(function (){ 
    		searchValue = $('#key').val().replace(/\s+/g, "");
    		loadGridData(); 
   	    });
    	
        $(".add-form-btn").click(function(){
        	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMgtAddForm.do";
        	$(".index-iframe", window.parent.document).attr("src",url);
        });
	   	
	   	function getOperationCol(data, type, row) {
			var html = "";
			html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
			return html;
		}
	   	
		function getReceivingStatus(data,type,row){
			if (data == 0 || data == 1) return "正常";
			if (data == 2) return "维修";
			if (data == 3) return "报废";
			return "未入库";
		}
    	
		loadGridData();
    	
		//加载列表数据
		function loadGridData() {
			//数据列绑定
			var columns = [
				{ "mData" : "identifier", "bSortable" : true},
				{ "mData" : "name", "bSortable" : true },
				{ "mData" : "location", "bSortable" : true },
				{ "mData" : "modifiedDate", "bSortable" : true, "mRender": getFormattedDate },
				{ "mData" : "createdDate", "bSortable" : false, "mRender": getFormattedDate,"bVisible" : false},
				{ "mData" : "model", "bSortable" : true },
				{ "mData" : "status", "bSortable" : true,"mRender": getReceivingStatus},
				{ "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "5em" }
            ];
      	
			//排序规则
			var sorting = [ [ 4 , 'desc' ] ];

   			//扩展参数
   			var extraParams = [{ "name" : "queryParam", "value" : searchValue }];
        
			//初始化数据表
			dataTable = new BSDataTable();
			dataTable.initialize({
				"tableId" : "table2",
				"columns" : columns,
				"sorting" : sorting,
				"pageSize" : DEFAULT_PAGE_SIZE,
				"dataSource" : "${ pageContext.request.contextPath }/deviceMgt/device/deviceGirdData.do",
				"extraParams" : extraParams,
				"style" : DT_FULL_NUMBERS,
				"bProcessing" : true,
				"url" : {
// 					"addDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
// 					"editDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
// 					"rmDataUrl" : "/eeip/meeting/meetingApp/removeMeetingAppData.do"
				}
			});
            
			//隐藏列表组件显示条数
			$('#table2_length').hide();
         }
    })
        
    </script>
</body>
</html>