<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>综合鉴定信息列表</title>
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
			当前位置：<a>电子物证管理</a><span>></span><a>综合鉴定信息</a>
        </p>      
    </div>
	<div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-1">
    		<input type="text" id ="key"/>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
    	</div>   	
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>案件编号</th>
                    <th>案件名称</th>
                    <th>检材编号</th>
                    <th>检材名称</th>
                    <th>委托单位</th>  
                    <th>委托时间</th>  
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
              
            </tbody>
        </table>
    </div>
    <script>
    var query = '';
     
   	function operation(id){
   		var url = "${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/timelineViewer.do?id="+id;
    	$(".index-iframe", window.parent.document).attr("src",url);
    }
   	function downLoad(id){
   		var url = "${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/appraisalDocDownLoad.do?id="+id;
    	$(".index-iframe", window.parent.document).attr("src",url);
    }
   	

   	function getOperationCol(data, type, row) {
		var html = "";
		html+="<a class=\"viewer-btn\" onclick=\"operation('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a>";
		html+="<a class=\"viewer-btn\" onclick=\"downLoad('" + row.id + "');\" title=\"下载文书\"><i class=\"fa fa-download\"></i></a>";
		return html;
	}
   	
	$(function(){
		$(".search").click(function (){ 
    		query = $('#key').val().replace(/\s+/g, "");
   		    loadGridData(); 
   	    });  
		loadGridData(); 
    });
    //加载列表数据
	function loadGridData() {
			//数据列绑定
			var columns = [
				{ "mData" : "caseSn", "bSortable" : true},
				{ "mData" : "caseName", "bSortable" : true },
				{ "mData" : "evidSn", "bSortable" : true },
				{ "mData" : "evidName", "bSortable" : true },
				{ "mData" : "orgName", "bSortable" : true },
				{ "mData" : "entrustedDate", "bSortable" : true, "mRender": getFormattedDate },
				{ "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "7em" }
            ];
      	
			//排序规则
			var sorting = [ [ 5 , 'desc' ] ];
    	  
			//扩展参数
			var extraParams = [{ "name" : "query", "value" : query}];
        
			//初始化数据表
			dataTable = new BSDataTable();
			dataTable.initialize({
				"tableId" : "table2",
				"columns" : columns,
				"sorting" : sorting,
				"pageSize" : DEFAULT_PAGE_SIZE,
				"dataSource" : "${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/loadAllListData.do",
				"extraParams" : extraParams,
				"style" : DT_FULL_NUMBERS,
				"bProcessing" : true,
				"url" : { }
			});
            
			//隐藏列表组件显示条数
			$('#table2_length').hide();
         }
    
    
    
    
    
    
    </script>
</body>
</html>