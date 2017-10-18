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
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet">
</head>
<body style="width:100%;">
   
    <div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content" style="width:540px;">
    		<input type="text" id="key"/>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
    	</div>
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>文件编号</th>
                    <th>文件名称</th>
                    <th>上传人</th>
                    <th>上传日期</th>
                    <th>最后一次修改日期</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
               
            </tbody>
        </table>
    </div>
    <jsp:include page="/common/commonModal.jsp"></jsp:include>
  
    <input type="hidden" id="rmId" />
    <input type="hidden" id="rmName"/>
    <input type="hidden" id="rmType"/>
    <script>
    
    
    function view(id){
    	var url = '${pageContext.request.contextPath}/knowledgeMgt/knowledgeBase/fileViewer.do?id='+id;
    	$(".file-iframe", window.parent.document).attr("src",url);
    }
    
    function remove(id){
    	$.ajax({
    		url:'${pageContext.request.contextPath}/tmpDocOperationLog/removeTmpDocOperationLogFalseData.do',
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
    	
    	if( $(".file-iframe", window.parent.document).attr("data-search") ) {
    		$("#key").val($(".file-iframe", window.parent.document).attr("data-search"));	
    		searchValue = $(".file-iframe", window.parent.document).attr("data-search").replace(/\s+/g, "");
    	}
    	
    	$(".search").click(function(){
    		searchValue = $('#key').val().replace(/\s+/g, "");
    		loadGridData();
    	})
    	
    	function getOperationCol(data, type, row) {
     		var html = "<a onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
        	return html;
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
    	          { "mData" : "modifiedDate", "bSortable" : true,"mRender": getFormattedDate},
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
                "dataSource" : "${pageContext.request.contextPath}/system/assessibility/document/documentInfoGridData.do",
                "extraParams" : extraParams,
                "style" : DT_FULL_NUMBERS,
                "bProcessing" : true,
                "url" : {
              	  /* "addDataUrl" : "${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyForm.do",
      		      "editDataUrl" : "${pageContext.request.contextPath}/meetingMgt/meetingRoom/meetingRoomApplyForm.do", */
      		      "rmDataUrl" : "${pageContext.request.contextPath}/system/assessibility/document/removeDocumentInfoData.do"
    	           }
    	       });
            
             //隐藏列表组件显示条数
             $('#table2_length').hide();
         }
    	$("#table2").css("width","100%");
    })
       
    </script>
</body>
</html>