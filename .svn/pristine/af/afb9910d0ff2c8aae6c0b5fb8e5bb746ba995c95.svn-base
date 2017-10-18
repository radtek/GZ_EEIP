<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>来访人员列表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet">
</head>
<body>
    <div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>人员</a><span>></span><a>来访人员管理</a><span>></span><a>列表</a>
	        </p>
    	</div>
    <div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-2">
    		<input type="text" id="key" />
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
    	</div>
    	<sys:auth grant="VISITOR_MGT_ADD" username="${sessionScope.loginUser.userName}">
	    	<div class="button-content">
	    		<button type="button" class="btn btn-color1 add-form-btn"><i class="fa fa-plus"></i>新增</button>
	    	</div>
    	</sys:auth>
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>单位</th>
                    <th>事由</th>
                    <th>来访时间</th>                   
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
    <script>
    
    var searchValue = '';
    
    $(function (){ 
    	 $(".add-form-btn").click(function(){
    	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/visitor/visitorRegisterForm.do');
    	 });
    	 
    	 $(".search").click(function (){ 
     		searchValue = $('#key').val().replace(/\s+/g, "");
    		    loadGridData(); 
    	 });
    	 
    	 loadGridData(); 
    });
    function view(id){
    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/visitor/visitorInfoView.do?id='+id);
    }
    
    function edit(id){
    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/visitor/visitorRegisterForm.do?id='+id);
    }
    
    function getOperationCol(data, type, row){
    	var html = "";  
    	html += "<a class=\"viewer-btn\" onclick=\"edit('" + row.id + "');\" title=\"修改\"><i class=\"fa fa-edit\"></i></a> "; //修改
    	html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
    	html += "<a title='删除' data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedVisitorParam('" + row.id + "', '" + row.name + "');\"><i class='fa fa-times'></i></a>";
		return html; 	
    }
    
    
    function getFormattedSex(data, type, row){
    	if(data==0){
    		return '男';
    	}else if(data==1){
    		return '女';
    	} 
    }
    
    //加载列表数据
    function loadGridData() {
  	  //数据列绑定
	      var columns = [
	          { "mData" : "name", "bSortable" : true },
	          { "mData" : "sex", "bSortable" : true,"mRender" : getFormattedSex},
	          { "mData" : "org", "bSortable" : true },
	          { "mData" : "reason", "bSortable" : true },
	          { "mData" : "createdDate", "bSortable" : true, "mRender": getFormattedDate },
	          { "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "9em" }
        ];
  	
	      //排序规则
        var sorting = [ [ 4, 'desc' ] ];
	  
	      //扩展参数
        var extraParams = [{"name":"queryParam","value":searchValue}];
    
        //初始化数据表
        dataTable = new BSDataTable();
        dataTable.initialize({
      	  "tableId" : "table2",
            "columns" : columns,
            "sorting" : sorting,
            "pageSize" : DEFAULT_PAGE_SIZE,
            "dataSource" : "${pageContext.request.contextPath}/psnlInfo/visitor/visitorListData.do",
            "extraParams" : extraParams,
            "style" : DT_FULL_NUMBERS,
            "bProcessing" : true,
            "url" : { 
            	"rmDataUrl" : "${pageContext.request.contextPath}/psnlInfo/visitor/removeVisitorData.do"
            }
	       });
        
         //隐藏列表组件显示条数
         $('#table2_length').hide();
     }
    
    function setRemovedVisitorParam(id, name) {
    	  $("#rmId").val(id);
	      $("#rmName").val(name);
	      setSystemNoticeContent("是否确认删除来访人员&nbsp;"+$("#rmName").val()+"&nbsp;?");
    }
      
    initSystemNoticePopup(function() {
    	   dataTable.rmData({ 'id' : $("#rmId").val() }, function() { dataTable.reloadData(); }, function() { dataTable.reloadData(); });
    });
    </script>
</body>
</html>