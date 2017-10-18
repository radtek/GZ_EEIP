<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备维护申请审批列表</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>  	
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script> 
	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
   	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" /></head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>设备与环境管理</a><span>></span><a>设备维护申请审批</a>
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
                    <th>识别号</th>
                    <th>设备名称</th>
                    <th>存放地址</th>
                    <th>申请事项</th>
                    <th>申请时间</th>
                    <th>型号</th>
                    <th>审核状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <script>
        /* $(".table").on("click", ".viewer-btn", function(){
        	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalViewer.do";
        	$(".index-iframe", window.parent.document).attr("src",url);
        }); */
        
        function registerBtn(id){
        	var url = "${pageContext.request.contextPath}/deviceMgt/registerForm.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
        function planBtn(id){
        	var url = "${pageContext.request.contextPath}/deviceMgt/planForm.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
        function requisitionBtn(id){
        	var url = "${pageContext.request.contextPath}/deviceMgt/requisitionForm.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
        function scrappedBtn(id){
        	var url = "${pageContext.request.contextPath}/deviceMgt/scrappedForm.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
        function registerView(id){
        	var url = "${pageContext.request.contextPath}/deviceMgt/registerViewer.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
        function planView(id){
        	var url = "${pageContext.request.contextPath}/deviceMgt/planViewer.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
        function requisitionView(id){
        	var url = "${pageContext.request.contextPath}/deviceMgt/requisitionViewer.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
        function scrappedView(id){
        	var url = "${pageContext.request.contextPath}/deviceMgt/scrappedViewer.do?id="+id;
        	$(".index-iframe", window.parent.document).attr("src",url);
        }
        
    	$(function(){
    		var deviceData;
			var searchValue = '';
			
	    	$(".search").click(function (){ 
	    		searchValue = $('#key').val().replace(/\s+/g, "");
	    		loadGridData(); 
	   	    });
	    	
    		function getNumber(data, type, row){
    			deviceData = loadData("${ pageContext.request.contextPath }/deviceMgt/device/loadDeviceData.do", { "id" : data });
    			return deviceData.identifier;
    		}
    		
    	   	function getName(data, type, row) {
    	   		return deviceData.name;
			}
    	   	function getLocation(data, type, row) {
    	   		return deviceData.location;
			}
    	   	function getFinishedDate(data, type, row) {
    	   		if(data == "" || data == undefined || data == null){
    	   			return "";
    	   		}else{
        	   		return new Date(data).Format("yyyy-MM-dd hh:mm");
    	   		}
			}
    	   	function getType(data, type, row){
    	   		if(data == 1){
    	   			return "设备维修情况登记";
    	   		}else if(data == 2){
    	   			return "核查校准计划";
    	   		}else if(data == 3){
    	   			return "核查维修申请单";
    	   		}else{
    	   			return "固定资产报废";
    	   		}
    	   	}
    	   	function getModel(data, type, row){
    	   		return deviceData.model;
    	   	}
    	   	function getStatus(data, type, row){
    	   		if(data == 0){
    	   			return "草稿";
    	   		}else if(data == 1){
    	   			return "待审核";
    	   		}else if(data == 2){
    	   			return "同意";
    	   		}else if(data == 3){
    	   			return "拒绝";
    	   		}
    	   	}
    	   	
    	   	function getOperationCol(data, type, row) {
    			var html = "";
    			if(row.type == 1){	//"设备维修情况登记";
        	   		if(row.status == 1){
        				html += "<a onclick=\"registerBtn('" + row.otherId + "');\" title=\"审批\"><i class=\"fa fa-check-square-o\"></i></a> "; //查看
//         				html += "<a onclick=\"registerView('" + row.otherId + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
//         	   		}else{
//         	   			html += "<a onclick=\"registerView('" + row.otherId + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
            	   	}
    			}else if(row.type == 2){	//"核查校准计划";
        	   		if(row.status == 1){
        				html += "<a onclick=\"planBtn('" + row.otherId + "');\" title=\"审批\"><i class=\"fa fa-check-square-o\"></i></a> "; //查看
//         				html += "<a onclick=\"planView('" + row.otherId + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
//         	   		}else{
//         	   			html += "<a onclick=\"planView('" + row.otherId + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
            	   	}
    			}else if(row.type == 3){	//"核查维修申请单";
        	   		if(row.status == 1){
        				html += "<a onclick=\"requisitionBtn('" + row.otherId + "');\" title=\"审批\"><i class=\"fa fa-check-square-o\"></i></a> "; //查看
//         				html += "<a onclick=\"requisitionView('" + row.otherId + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
//         	   		}else{
//         	   			html += "<a onclick=\"requisitionView('" + row.otherId + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
            	   	}
    			}else if(row.type == 4){	//"固定资产报废";
        	   		if(row.status == 1){
        				html += "<a onclick=\"scrappedBtn('" + row.otherId + "');\" title=\"审批\"><i class=\"fa fa-check-square-o\"></i></a> "; //查看
//         				html += "<a onclick=\"scrappedView('" + row.otherId + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
//         	   		}else{
//         	   			html += "<a onclick=\"scrappedView('" + row.otherId + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
            	   	}
    			}
    			return html;
    		}
    	   	
    		loadGridData();
        	
    		//加载列表数据
    		function loadGridData() {
    			//数据列绑定
    			var columns = [
    				{ "mData" : "deviceId", "bSortable" : true ,"mRender": getNumber},
    				{ "mData" : null, "bSortable" : true,"mRender": getName},
    				{ "mData" : null, "bSortable" : true,"mRender": getLocation},
    				{ "mData" : "type", "bSortable" : true,"mRender": getType},
    				{ "mData" : "date", "bSortable" : true ,"mRender": getFinishedDate},
    				{ "mData" : null, "bSortable" : true,"mRender": getModel},
    				{ "mData" : "status", "bSortable" : true,"mRender": getStatus },
    				{ "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "4em" }
                ];
          	
    			//排序规则
    			var sorting = [ [ 6 , 'desc' ] ];

	   			//扩展参数
	   			var extraParams = [{ "name" : "queryParam", "value" : searchValue }];
	   			
    			//初始化数据表
    			dataTable = new BSDataTable();
    			dataTable.initialize({
    				"tableId" : "table2",
    				"columns" : columns,
    				"sorting" : sorting,
    				"pageSize" : DEFAULT_PAGE_SIZE,
    				"dataSource" : "${pageContext.request.contextPath}/deviceMgt/device/approveListData.do",
    				"extraParams" : extraParams,
    				"style" : DT_FULL_NUMBERS,
    				"bProcessing" : true,
    				"url" : {
    				}
    			});
                
    			//隐藏列表组件显示条数  --  数量   和 分页
    			$('#table2_length').hide();
             }
        })
        
        
        
    </script>
</body>
</html>