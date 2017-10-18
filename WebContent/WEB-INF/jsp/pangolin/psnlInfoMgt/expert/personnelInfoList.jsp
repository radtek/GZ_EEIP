<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>人员信息管理列表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<%-- <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script> --%>
  	
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
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>人员信息管理</a><span>></span><a>专家库</a>
        </p>      
    </div>
	<div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-2">
    		<input type="text" id="key"/>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
    	</div>
    	<sys:auth grant="APPRAISER_LIB_ADD" username="${sessionScope.loginUser.userName}">
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
                    <th>警衔</th>
                    <th>警察证号</th>
                    <th>从事专业</th>
                    <th>技术职务</th>                   
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
    	
    	$(".add-form-btn").click(function(){
	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelRegisterForm.do?userBasicInfoId=&status=0');
	    }); 
    	$(".search").click(function (){ 
    		searchValue = $('#key').val().replace(/\s+/g, "");
   		    loadGridData(); 
   	    }); 
    	 
    	loadGridData();
    });
    
    function view(id){
    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoView.do?userBasicInfoId='+id+'&status=1');
    };
    
    function edit(id){
    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelRegisterForm.do?userBasicInfoId='+id+'&status=0');
    };
    
    function getOperationCol(data, type, row){
    	var html = "";  
    	html += "<a onclick=\"edit('" + row.id + "');\" title=\"修改\"><i class=\"fa fa-edit\"></i></a> "; //修改
    	html += "<a onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
		return html; 	
    };
    function getSex(data, type, row){
    	if(data==0){
    		return '男';
    	}else if(data==1){
    		return '女';
    	} 
    };
    //加载列表数据
    function loadGridData() {
  	  //数据列绑定
	      var columns = [
	          { "mData" : "name", "bSortable" : true  },
	          { "mData" : "policeRank", "bSortable" : true},
	          { "mData" : "policeId", "bSortable" : true },
	          { "mData" : "major", "bSortable" : true },
	          { "mData" : "techPost", "bSortable" : true },
	          { "mData" : null , "bSortable" : true,  "mRender": getOperationCol, "sWidth": "7em" }
        ];
  	
	      //排序规则
        var sorting = [ [ 4, 'desc' ] ];
	  
	      //扩展参数
        var extraParams = [{ "name" : "queryParam", "value" : searchValue}];
    
        //初始化数据表
        dataTable = new BSDataTable();
        dataTable.initialize({
      	  "tableId" : "table2",
            "columns" : columns,
            "sorting" : sorting,
            "pageSize" : DEFAULT_PAGE_SIZE,
            "dataSource" : "${pageContext.request.contextPath}/psnlInfo/userBasicInfo/userBasicInfoListData.do",
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