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
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>电子物证管理</a><span>></span><a>鉴定人员操作台</a><span>></span><a>文书修改</a>
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
                    <th>委托时间</th>
                    <th>联系电话</th>
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
    <script>
	$(function(){
	   	function getOperationCol(data, type, row) {
			if(data == 4){
				var html = "";
				html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"修改\"><i class=\"fa fa-pencil-square-o\"></i></a> "; 
				return html;
			}else{
				return ""; 
			}
		}
	   	var appraisal;
	   	function getAppraisal(data, type, row){
	   		appraisal = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/appraisal/loadDataById.do", { "id" : data });
	   		return appraisal.caseSn;
		}
	   	function getCaseName(data, type, row){
	   		return appraisal.caseName;
		}
	   	function getEvidSn(data, type, row){
	   		return appraisal.evidSn;
		}
	   	function getTel(data, type, row){
	   		return appraisal.tel;
		}
	   	function getData(data, type, row) {
	   		return new Date(appraisal.entrustedDate).Format("yyyy-MM-dd hh:mm");
		}
	   	function getStatus(data, type, row) {
	   		if(data == 0 || data == 1 || data == 2 || data == 3){
	   			return "申请审批中";	
	   		}else if(data == 4){
	   			return "申请通过";
	   		}else if(data == 5){
	   			return "申请拒绝";
	   		}else if(data == 6){
	   			return "修改完成";
	   		}else if(data == 7){
	   			return "修改通过";
	   		}else if(data == 8){
	   			return "修改拒绝";
	   		}
		}
	   	
		loadGridData();
		//加载列表数据
		function loadGridData() {
			//数据列绑定
			var columns = [
				{ "mData" : "appraisalId" , "bSortable" : false , "mRender" : getAppraisal},
				{ "mData" : null , "bSortable" : false , "mRender" : getCaseName},
				{ "mData" : null , "bSortable" : false , "mRender" : getEvidSn},
				{ "mData" : null , "bSortable" : false , "mRender" : getData },
				{ "mData" : null , "bSortable" : false , "mRender" : getTel},
				{ "mData" : "status" , "bSortable" : false , "mRender" :getStatus},
				{ "mData" : "status" , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "5em" }
			];
      	
			//排序规则
			var sorting = [ [ 3 , 'desc' ] ];
    	  
			//扩展参数
			var extraParams = [{"name":"userId","value":"${sessionScope.loginUser.userId}"}];
			
			//初始化数据表
			dataTable = new BSDataTable();
			dataTable.initialize({
				"tableId" : "table2",
				"columns" : columns,
				"sorting" : sorting,
				"pageSize" : DEFAULT_PAGE_SIZE,
	            "dataSource" : "${pageContext.request.contextPath}/elecEVIDMgt/AppraisalRevise/AppraisalReviseGirdData.do",
				"extraParams" : extraParams,
				"style" : DT_FULL_NUMBERS,
				"bProcessing" : true,
				"url" : {
				}
			});
            
			//隐藏列表组件显示条数
			$('#table2_length').hide();
         }
    })
    
	function view(appraisalReviseId){
    	var url = '${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentChangeApproveSum.do?appraisalReviseId='+appraisalReviseId;
    	$(".index-iframe", window.parent.document).attr("src",url);
    }
    
    </script>
</body>
</html>