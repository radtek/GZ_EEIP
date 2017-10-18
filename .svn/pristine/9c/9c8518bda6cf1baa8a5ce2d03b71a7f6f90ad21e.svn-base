<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>取证及流程管理-在库检材</title>
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
			当前位置：<a>取证及流程管理</a><span>></span><a>在库检材</a>
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
                    <th>案件编号</th>
                    <th>案件名称</th>
                    <th>检材编号</th>
                    <th>委托时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
<!--             	<tr>
            		<td>A44010501911002015110035</td>
            		<td>非法买卖枪支弹药</td>
            		<td>10501911002015110035</td>
            		<td>2016-4-18</td>
            		<td>在库</td>
            		<td><a class="viewer-btn" title="查看"><i class="fa fa-search"></i></a></td>
            	</tr> -->
            </tbody>
        </table>
    </div>
    <script>
	   	function view(id){
    		var url = "${pageContext.request.contextPath}/evidenceMgt/inTheLibrary/inTheLibraryViewer.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
		$(function(){
			var searchValue = '';
	    	$(".search").click(function (){ 
	    		searchValue = $('#key').val().replace(/\s+/g, "");
	    		loadGridData(); 
	   	    });
			
		   	function getOperationCol(data, type, row) {
				var html = "";
				html += "<a class=\"modify-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a>"; //修改
				return html;
		   	}
		   	
		   	function getData(data, type, row){
		   		return new Date(data).Format("yyyy-MM-dd hh:mm");
		   	}
		   	function getStatus(data, type, row){
		   		return "在库";
		   	}
		   	
			loadGridData();
	    	
			//加载列表数据
			function loadGridData() {
				//数据列绑定
				var columns = [
					{ "mData" : "caseSn" , "bSortable" : false },
					{ "mData" : "caseName" , "bSortable" : false },
					{ "mData" : "evidSn" , "bSortable" : false },
					{ "mData" : "entrustedDate" , "bSortable" : false , "mRender" : getData},
					{ "mData" : null , "bSortable" : false , "mRender" : getStatus},
					{ "mData" : null , "bSortable" : false , "mRender" : getOperationCol, "sWidth": "5em" }
	            ];
	      	
				//排序规则
				var sorting = [ [ 3 , 'desc' ] ];
	    	  
	   			//扩展参数
	   			var extraParams = [{ "name" : "queryParam", "value" : searchValue }];
	   			
				//初始化数据表
				dataTable = new BSDataTable();
				dataTable.initialize({
					"tableId" : "table2",
					"columns" : columns,
					"sorting" : sorting,
					"pageSize" : DEFAULT_PAGE_SIZE,
					"dataSource" : "${pageContext.request.contextPath}/elecEVIDMgt/appraisal/appraisalGirdData.do",
					"extraParams" : extraParams,
					"style" : DT_FULL_NUMBERS,
					"bProcessing" : true,
					"url" : {
					}
				});
	            
				//隐藏列表组件显示条数  --  数量   和 分页
				$('#table2_length').hide();
	         }
	    })
    </script>
</body>
</html>