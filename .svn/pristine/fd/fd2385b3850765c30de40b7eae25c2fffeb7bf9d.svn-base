<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-受理人员操作台-检材入库</title>
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
			当前位置：<a>电子物证管理</a><span>></span><a>受理人员操作台</a><span>></span><a>检材入库</a>
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
                    <th>委托单位</th>
                    <th>委托时间</th> 
                    <th>联系电话</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            	<!-- <tr>
            		<td>A44010501911002015110035</td>
            		<td>非法买卖枪支弹药</td>
            		<td>广州市公安局刑事警察支队三大队</td>
            		<td>2016-4-18</td>
            		<td>83112754</td>
            		<td>待入库</td>
            		<td><a class="operating-btn" title="入库"><i class="glyphicon glyphicon-log-in"></i></a></td>
            	</tr> -->
            </tbody>
        </table>
    </div>
    <script>
	  /*   $(".table").on("click", ".operating-btn", function(){
			var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingForm.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
		}); */
    
	   	/* function view(id){
	   		var url = "${pageContext.request.contextPath}/deviceMgt/deviceRegisterViewer.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
 */	   	
	   	var query=''; 
 
		 $(function(){
		 	$(".search").click(function (){ 
		 		query = $('#key').val().replace(/\s+/g, "");
				    loadGridData(); 
			    }); 
		 	loadGridData();
		 });
		 
 
 
	   	function warehousing(id){
	   		var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingForm.do?id="+id;
	    	$(".index-iframe", window.parent.document).attr("src",url); 
        }

	   	function getOperationCol(data, type, row) {
			var html = "";
			html+="<a class=\"operating-btn\" onclick=\"warehousing('" + row.id + "');\" title=\"入库\"><i class=\"glyphicon glyphicon-log-in\"></i></a>";
			return html;
		} 
        
         //加载列表数据
    	function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : "caseSn", "bSortable" : true},
    				{ "mData" : "caseName", "bSortable" : true },
    				{ "mData" : "orgName", "bSortable" : true },
    				{ "mData" : "entrustedDate", "bSortable" : true, "mRender": getFormattedDate },
    				{ "mData" : "tel", "bSortable" : false},
    				{ "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "5em" }
                ];
          	
    			//排序规则
    			var sorting = [ [ 3 , 'desc' ] ];
        	  
    			//扩展参数
    			var extraParams = [{ "name" : "query", "value" : query}, { "name" : "status", "value" : 4}];
            
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : DEFAULT_PAGE_SIZE,
    				"dataSource" : "${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/LoadListData.do",
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