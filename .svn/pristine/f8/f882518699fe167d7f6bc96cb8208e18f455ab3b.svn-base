<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>业务考核列表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
        	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>新增</a><span>></span><a>业务考核</a>
        </p>      
    </div>
    <div class="content">
    	<jsp:include page="/common/personNav.jsp"></jsp:include>
    </div>	
	<div class="operating-area has-btn-1">
    	<div class="button-content">
    		<button type="button" class="btn btn-color1 add-form-btn"><i class="fa fa-plus"></i>新增</button>
    	</div>
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>姓名</th>
                    <th>部门</th>
                    <th>技术职称</th>
                    <th>考试类别</th>                
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <script>
		var searchValue = '';
		
	    $(function(){
	    	// 链接判断
			var url = window.location.href;
			if( "${param.userBasicInfoId}" ){
			  $(".crumbs-text").html("当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>修改</a><span>></span><a>业务考核</a>");
			}
	    	
	    	if (  "${param.status}" == 1 ) {
	    		$('.add-form-btn').hide();
	    	}
	    	
	    	
	    	$(".add-form-btn").click(function(){
		    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/businessAssessment.do?type=examine&status='+${param.status}+'&userBasicInfoId=${param.userBasicInfoId}');
		    }); 
	    	$(".search").click(function (){ 
	    		searchValue = $('#key').val().replace(/\s+/g, "");
	   		    loadGridData(); 
	   	    }); 
	    	 
	    	loadGridData();
	    });
	    
	    function view(id){
	    	$('.index-iframe' , window.parent.document ).attr('src',
	    	'${pageContext.request.contextPath}/psnlInfo/expert/businessAssessmentView.do?id='+id+'&type=examine&status=${param.status}&userBasicInfoId=${param.userBasicInfoId}');
	    };
	    
	    function edit(id){
	    	$('.index-iframe' , window.parent.document ).attr('src',
	    	'${pageContext.request.contextPath}/psnlInfo/expert/businessAssessment.do?id='+id+'&type=examine&status=${param.status}&userBasicInfoId=${param.userBasicInfoId}');
	    };
	    
	    function getOperationCol(data, type, row){
	    	var html = "";  
	    	if (  "${param.status}" == 0 ) {
	    		html += "<a class=\"viewer-btn\" onclick=\"edit('" + row.id + "');\" title=\"修改\"><i class=\"fa fa-edit\"></i></a> "; //修改
	    	}
	    	html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
			return html; 	
	    };
	   
	    //加载列表数据
	    function loadGridData() {
	  	  //数据列绑定
		      var columns = [
		          { "mData" : "name", "bSortable" : true  },
		          { "mData" : "dept", "bSortable" : true },
		          { "mData" : "title", "bSortable" : true },
		          { "mData" : "type", "bSortable" : true },
		          { "mData" : null , "bSortable" : true,  "mRender": getOperationCol }
	        ];
	  	
		      //排序规则
	        var sorting = [ [ 1, 'desc' ] ];
		  
		      //扩展参数
	        var extraParams = [{ "name" : "userBasicInfoId", "value" : "${param.userBasicInfoId}"}];
	    
	        //初始化数据表
	        dataTable = new BSDataTable();
	        dataTable.initialize({
	      	  "tableId" : "table2",
	            "columns" : columns,
	            "sorting" : sorting,
	            "pageSize" : DEFAULT_PAGE_SIZE,
	            "dataSource" : "${pageContext.request.contextPath}/psnlInfo/userEvaluation/getUserEvaluationByUserIdGirdData.do",
	            "extraParams" : extraParams,
	            "style" : DT_FULL_NUMBERS,
	            "bProcessing" : true,
	            "url" : {}
		       });
	        
	         //隐藏列表组件显示条数
	         $('#table2_length').hide();
	     }
    </script>
</body>
</html>