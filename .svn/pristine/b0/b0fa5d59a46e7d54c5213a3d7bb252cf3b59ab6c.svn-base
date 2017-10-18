<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-受理人员操作台-检材交接</title>
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
			当前位置：<a>电子物证管理</a><span>></span><a>受理人员操作台</a><span>></span><a>检材交接</a>
        </p>
    </div>
    <div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-1">
    		<input type="text" id="key" />
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
    	</div>
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>检材编号</th>
                    <th>检材名称</th>
                    <th>案件名称</th>
                    <th>申请时间</th> 
                    <th>状态</th> 
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            	 
            </tbody>
        </table>
    </div>
    <script>
    var query=''; 
    
    $(function(){
    	$(".search").click(function (){ 
    		query = $('#key').val().replace(/\s+/g, "");
   		    loadGridData(); 
   	    }); 
    	loadGridData();
    });
    
	   	function handoverReturn(id){
	   		var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverReturnForm.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
	   	function handoverCollar(id){
	   		var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/handoverCollarForm.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
	  	function getOperationCol(data, type, row) {
			var html = "";
			if(row.type==1){
				html += "<a class=\"handoverReturn-btn\" onclick=\"handoverReturn('" + row.id + "');\" title=\"确认\"><i class=\"fa fa-check-square-o\"></i></a> "; //查看
			}else if(row.type==0){
				html += "<a class=\"handoverReturn-btn\" onclick=\"handoverCollar('" + row.id + "');\" title=\"确认\"><i class=\"fa fa-check-square-o\"></i></a> "; //查看
			}
			return html;
		}
	  	function getFormattedStatus(data, type, row){
	  		 if(data==0){
	  			 return "待领取";
	  		 }else if(data==1){
	  			 return "待归还";
	  		 }
	  	}
	   
    	//加载列表数据
		function loadGridData() {
			//数据列绑定
			var columns = [
				{ "mData" : "evidSn", "bSortable" : true},
				{ "mData" : "evidName", "bSortable" : true },
				{ "mData" : "caseName", "bSortable" : true },
				{ "mData" : "applicantDate", "bSortable" : true, "mRender": getFormattedDate },
				{ "mData" : "type", "bSortable" : true, "mRender": getFormattedStatus },
				{ "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "5em" }
            ];
      	
			//排序规则
			var sorting = [ [ 3 , 'desc' ] ];
    	  
			//扩展参数
			var extraParams = [{ "name" : "query", "value" : query}];
        
			//初始化数据表
			dataTable = new BSDataTable();
			dataTable.initialize({
				"tableId" : "table2",
				"columns" : columns,
				"sorting" : sorting,
				"pageSize" : DEFAULT_PAGE_SIZE,
				"dataSource" : "${ pageContext.request.contextPath }/elecEVIDMgt/evidTransition/loadListData.do",
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