<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>文书列表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>文书修改申请</a>
        </p>      
    </div>
	<div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-1">
    		<input type="text" />
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2"><i class="fa fa-search"></i>查询</button>
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
                    <th>状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
<!--                 <tr>
                    <td>A44010501911002045110035</td>
                    <td>thinkPad笔记本电脑1</td>
                    <td>10501911002045110035</td>
                    <td>2016-4-18</td>
                    <td>12345678900</td>
                    <td>已办结</td>
                    <td><a class="apply-btn" title="申请"><i class="fa fa-check-square-o"></i></a></td>
                </tr>
                <tr>
                    <td>A44010501651002015110035</td>
                    <td>thinkPad笔记本电脑2</td>
                    <td>10501911002045110035</td>
                    <td>2016-4-18</td>
                    <td>12345678900</td>
                    <td>修改文书</td>
                    <td><a class="modify-btn" title="修改"><i class="fa fa-pencil-square-o"></i></a></td>
                </tr> -->
            </tbody>
        </table>
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    $(".modify-btn").click(function(){
    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentChangeApproveSum.do');
    })
	
	$(function(){
		var creatorId = "${sessionScope.loginUser.userId}";
	   	function getOperationCol(data, type, row) {
			var html = "";
			html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"申请\"><i class=\"fa fa-plus\"></i></a> "; //查看
			return html;
		}
	   	function getData(data, type, row) {
	   		return new Date(data).Format("yyyy-MM-dd hh:mm");
		}
	   	function getStatus(data, type, row) {
	   		return "结果反馈";
		}
	   	
		loadGridData();
		//加载列表数据
		function loadGridData() {
			//数据列绑定
			var columns = [
				{ "mData" : "caseSn" , "bSortable" : false},
				{ "mData" : "caseName" , "bSortable" : true },
				{ "mData" : "evidSn" , "bSortable" : true },
				{ "mData" : "evidName", "bSortable" : true },
				{ "mData" : "orgName", "bSortable" : true },
				{ "mData" : "entrustedDate" , "bSortable" : true, "mRender" : getData },
				{ "mData" : "status" , "bSortable" : true , "mRender" : getStatus},
				{ "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "5em" }
			];
      	
			//排序规则
			var sorting = [ [ 5 , 'desc' ] ];
    	  
			//扩展参数
			var extraParams = [{"name":"userId","value":"${sessionScope.loginUser.userId}"}];
			
			//初始化数据表
			dataTable = new BSDataTable();
			dataTable.initialize({
				"tableId" : "table2",
				"columns" : columns,
				"sorting" : sorting,
				"pageSize" : DEFAULT_PAGE_SIZE,
	            "dataSource" : "${pageContext.request.contextPath}/elecEVIDMgt/appraised/appraisedGirdData.do",
				"extraParams" : extraParams,
				"style" : DT_FULL_NUMBERS,
				"bProcessing" : true,
				"url" : {
// 					"addDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
// 					"editDataUrl" : "/eeip/meetingMgt/generalMeet/meetingApplyForm.do",
// 					"rmDataUrl" : "/eeip/meeting/meetingApp/removeMeetingAppData.do"
				}
			});
            
			//隐藏列表组件显示条数
			$('#table2_length').hide();
         }
    })
    
    function view(appraisalId){
    	var AppraisalRevise = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalRevise/loadAppraisalReviseByAppraisalId.do", { "appraisalId" : appraisalId });
    	if(AppraisalRevise.creatorId == "" || AppraisalRevise.creatorId == undefined || AppraisalRevise.creatorId == null){
	    	var url = '${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentChangeApply.do?appraisalId='+appraisalId;
	    	$(".index-iframe", window.parent.document).attr("src",url);
    	}else{
			promptContent("文书修改已经申请");
		 	$(".alert").removeClass("alert-success").addClass("alert-danger");
 			$(".promptDiv").slideDown();
 		    setTimeout(function(){
 				$(".promptDiv").slideUp();
 		    },1500);
    	}
    }
    
    </script>
</body>
</html>