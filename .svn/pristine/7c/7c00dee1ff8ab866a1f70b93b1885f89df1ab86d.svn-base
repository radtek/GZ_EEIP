<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-受理人员操作台-结果管理</title>
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
			当前位置：<a>电子物证管理</a><span>></span><a>受理人员操作台</a><span>></span><a>结果管理</a>
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
    <div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">通知</h4>
                </div>
                <div class="modal-body">
                    <!-- <div class="form-content">
                        <form class="form-horizontal">
                            <div class="form-group col-sm-12">
                                <label class="col-sm-2 control-label"><span class="required-fields">*</span>收信人：</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" required />
                                </div>
                            </div>
                            <div class="form-group col-sm-12">
                                <label class="col-sm-2 control-label"><span class="required-fields">*</span>内容：</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" required></textarea>
                                </div>
                            </div>
                        </form>
                    </div> -->
                    <p>已发送！</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">确定</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    <script>
    var query=''; 
    $(function(){
    	$(".search").click(function (){ 
    		query = $('#key').val().replace(/\s+/g, "");
   		    loadGridData(); 
   	    }); 
    	loadGridData();
    	
    	$(".table").on("click", ".notice-btn", function(){
    		setTimeout(function(){
    			$(".close").click();
    		},3000);
    	});
    	$(".btn-primary").click(function (){ 
    		 $.ajax({
                 type: "POST",
                 url: "${pageContext.request.contextPath}/elecEVIDMgt/appraised/sendMessage.do",
                 data: {id :currId},
                 dataType: "json",
                 success: function(data){
                	 if(data.status){
                		 alert("发送成功！");
                	 }else{
                		 alert("发送失败！");
                	 }
                 },
    	    	 error: function(data){
    	    		 alert("发送失败！");
    	    	 }
        	 }); 
    		
   	    });
    });
    
   	function outWarehouse(id){
   		var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/resultsMgtForm.do?id="+id;
    	$(".index-iframe", window.parent.document).attr("src",url);
    }

   	function getOperationCol(data, type, row) {
		var html = "";
		html+="	<a class=\"notice-btn\"  onclick=\"sendMessage('" + row.id + "'); title=\"通知委托人\" data-toggle=\"modal\" data-target=\"#myModal\"><i class=\"fa fa-envelope-o\"></i></a>";
		html+="	<a class=\"leave-btn\" onclick=\"outWarehouse('" + row.id + "');\" title=\"检材出库\"><i class=\"glyphicon glyphicon-log-out\"></i></a>";
		return html;
	}
   	 
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
			var extraParams = [{ "name" : "query", "value" : query}, { "name" : "status", "value" : 14}];
        
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