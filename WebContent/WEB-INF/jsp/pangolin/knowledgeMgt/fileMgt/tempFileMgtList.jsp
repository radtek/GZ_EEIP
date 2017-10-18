<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>知识管理列表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
     <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
     <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>知识管理</a><span>></span><a>知识文件审批</a>
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
    		<button type="button" class="btn btn-color1 add-form-btn"><i class="fa fa-plus"></i>新增</button>
    	</div> -->
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>文件编号</th>
                    <th>文件名称</th>
                    <th>上传人</th>
                    <th>上传日期</th>
                    <!-- <th>最后一次修改日期</th> -->
                    <th>状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
               
            </tbody>
        </table>
    </div>
    <jsp:include page="/common/commonModal.jsp"></jsp:include>
  
    <input type="hidden" id="rmId" />
    <input type="hidden" id="rmCaseName"/>
    <script>
	    function modify(id){
	    	var url = "${pageContext.request.contextPath}/knowledgeMgt/fileMgt/fileMgtAddForm.do?id="+id;
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    }
	    
	    function edit(id){
	    	var url = "${pageContext.request.contextPath}/knowledgeMgt/fileMgt/fileMgtApprovalForm.do?id="+id+"&status=0";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    }
	    
	    function remove(id){
	    	$.ajax({
	    		url:'${pageContext.request.contextPath}/tmpDocOperationLog/removeTmpDocOperationLogData.do',
	    	    type:'post',
	    	    datatype:'json',
	    	    data:{'id':id},
	    	    success:function(){
	    	    	dataTable.reloadData();
	    	    }
	    	})
	    }
	    
	    
	    $(function(){
	    	
	    	var searchValue = '';
	    	
	    	$(".add-form-btn").click(function(){
	        	var url = "${pageContext.request.contextPath}/knowledgeMgt/fileMgt/fileMgtAddForm.do";
	        	$(".index-iframe", window.parent.document).attr("src",url);
	        });
	    	
	    	$(".search").click(function(){
	    		searchValue = $('#key').val().replace(/\s+/g, "");
	    		loadGridData();
	    	})
	    	
	    	
	    	function getOperationCol(data, type, row) {
	     		var html = "";
	     		
	     		html += "<a onclick=\"edit('" + row.id + "');\" title=\"审核\"><i class=\"fa fa-check-square-o\"></i></a> "; //审核
	     		
	     		//html += "<a class=\"viewer-btn\" onclick=\"modify('" + row.id + "');\" title=\"修改\"><i class=\"fa fa-search\"></i></a> "; //修改
	     		/* html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看 */
	        	//html += "<a class=\"viewer-btn\" onclick=\"remove('" + row.id + "');\" title=\"删除\"><i class=\"fa fa-times\"></i></a> "; //删除
	     		return html;
	        }
	    	
	    	function getFormatStatus(data, type, row){
	    		if( data == -1 ) return "正式";
	    		if( data == 0 ) return "草稿";
	    		if( data == 1 ) return "待审核";
	    		if( data == 2 ) return "同意";
	    		if( data == 3 ) return "拒绝";
	    		return "";
	    	}
	    	
	    	loadGridData();
	    	
	    	//加载列表数据
	        function loadGridData() {
	      	  //数据列绑定
	    	      var columns = [
	    	          { "mData" : "sn", "bSortable" : true},
	    	          { "mData" : "name", "bSortable" : true},
	    	          { "mData" : "creatorAlias", "bSortable" : true },
	    	          { "mData" : "createdDate", "bSortable" : true,"mRender": getFormattedDate },
	    	         // { "mData" : "modifiedDate", "bSortable" : true,"mRender": getFormattedDate},
	    	          { "mData" : "status", "bSortable" : true,"mRender": getFormatStatus},
	    	          { "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "5em" }
	            ];
	      	
	    	      //排序规则
	            var sorting = [ [ 3, 'desc' ] ];
	    	  
	    	      //扩展参数
	            var extraParams = [{'name':'key','value':searchValue}];
	        
	            //初始化数据表
	            dataTable = new BSDataTable();
	            dataTable.initialize({
	          	  "tableId" : "table2",
	                "columns" : columns,
	                "sorting" : sorting,
	                "pageSize" : DEFAULT_PAGE_SIZE,
	                "dataSource" : "${pageContext.request.contextPath}/tmpDocOperationLog/tmpDocOperationLogGirdData.do",
	                "extraParams" : extraParams,
	                "style" : DT_FULL_NUMBERS,
	                "bProcessing" : true,
	                "url" : {
	              	  /* "addDataUrl" : "${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyForm.do",
	      		      "editDataUrl" : "${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyForm.do",
	      		      "rmDataUrl" : "${pageContext.request.contextPath}/meeting/meetingRoom/removeMeetingRoomFalseData.do" */
	    	           }
	    	       });
	            
	             //隐藏列表组件显示条数
	             $('#table2_length').hide();
	         }
	    })
    </script>
</body>
</html>