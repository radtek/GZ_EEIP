<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>管理评审计划列表</title>
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
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>计划</a><span>></span><a>管理评审计划</a>
        </p>
   	</div>
    <div class="operating-area has-btn-1">
    	<!-- <div class="text-content">关键字：</div>
    	<div class="input-content btn-2">
    		<input type="text" id="key"/>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
    	</div> -->
    	<sys:auth grant="REVIEW_PLAN_APP_ADD" username="${sessionScope.loginUser.userName}">
    	<div class="button-content">
    		<button type="button" class="btn btn-color1 add-form-btn"><i class="fa fa-plus"></i>新增</button>
    	</div>
    	</sys:auth>
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>年度</th>
                    <th>主题</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
              
            </tbody>
        </table>
    </div>
    <jsp:include page="/common/commonModal.jsp"></jsp:include>
  
    <input type="hidden" id="rmId" />
    <input type="hidden" id="rmTitle"/>
      
    <script>
        var displayEditBtn = false;
	    function view(id){
		    $('.index-iframe' , window.parent.document ).attr('src', '${pageContext.request.contextPath}/meetingMgt/managementReviewPlan/managementReviewPlanViewer.do?id='+id);
		}
	    
	    function modify(id){
		    $('.index-iframe' , window.parent.document ).attr('src', '${pageContext.request.contextPath}/meetingMgt/managementReviewPlan/managementReviewPlanForm.do?id='+id);
		}
	    
	    function remove(id){
	    	$.ajax({
	    		url:'${pageContext.request.contextPath}/meeting/removeAnnualPlanAppData.do',
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
	    	
	    	$('.add-form-btn').click(function() {
	  	        $('.index-iframe' , window.parent.document ).attr('src', '${pageContext.request.contextPath}/meetingMgt/managementReviewPlan/managementReviewPlanForm.do');
	        });
	    	
	    	$(".search").click(function(){
	    		searchValue = $('#key').val().replace(/\s+/g, "");
	    		loadGridData(); 
	    	})
	    	
	    	function getOperationCol(data, type, row) {
	     		var html = "";
	     		if(displayEditBtn){
	     	    html += "<a onclick=\"modify('" + row.id + "');\" title=\"修改\"><i class=\"fa fa-edit\"></i></a> "; //修改
	     		}
	     		html += "<a class=\"viewer-btn\" onclick=\"view('" + row.id + "');\" title=\"查看\"><i class=\"fa fa-search\"></i></a> "; //查看
	     		html += "<a title='删除' data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedAnnualParam('" + row.id + "', '" + row.title + "');\"><i class='fa fa-times'></i></a>";
	     		return html;
	        }
	    	
	    	function getFormatStatus(data,type,row){
	         	if (data == 0) return "草稿";
	         	if (data == 1) return "待审批";
	         	if (data == 2) return "通过";
	         	if (data == 3) return "拒绝";
	          	return "";
	         }
	    	
	    	loadGridData();
	    	
	    	//加载列表数据
	        function loadGridData() {
	      	  //数据列绑定
	    	      var columns = [
	                  { "mData" : "year", "bSortable" : true },
	    	          { "mData" : "title", "bSortable" : true },
	    	          { "mData" : "createdDate", "bSortable" : true, "mRender": getFormattedDate },
	    	          /* { "mData" : "status", "bSortable" : true, "mRender":  getFormatStatus},*/
	    	          { "mData" : "modifiedDate", "bSortable" : true, "mRender": getFormattedDate }, 
	    	          { "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "9em" }
	            ];
	      	
	    	      //排序规则
	            var sorting = [ [ 2, 'desc' ] ];
	    	  
	              //扩展参数
	            var extraParams = [{'name':'key','value':searchValue}];
	        
	            //初始化数据表
	            dataTable = new BSDataTable();
	            dataTable.initialize({
	          	  "tableId" : "table2",
	                "columns" : columns,
	                "sorting" : sorting,
	                "pageSize" : DEFAULT_PAGE_SIZE,
	                "dataSource" : "${pageContext.request.contextPath}/meeting/mgtRvwPlanAppGirdData.do",
	                "extraParams" : extraParams,
	                "style" : DT_FULL_NUMBERS,
	                "bProcessing" : true,
	                "url" : {
	              	  /* "addDataUrl" : "${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyForm.do",
	      		      "editDataUrl" : "${pageContext.request.contextPath}/meetingMgt/generalMeet/meetingApplyForm.do", */
	      		      "rmDataUrl" : "${pageContext.request.contextPath}/meeting/removeMgtRvwPlanAppData.do"
	    	           }
	    	       });
	            
	             //隐藏列表组件显示条数
	             $('#table2_length').hide();
	         }
	    })
	    
	     function setRemovedAnnualParam(id, title) {
	      	  $("#rmId").val(id);
	  	      $("#rmTitle").val(title);
	  	      setSystemNoticeContent("是否确认删除&nbsp;"+$("#rmTitle").val()+"&nbsp;?");
	     }
	        
	    initSystemNoticePopup(function() {
	      	  dataTable.rmData({ 'id' : $("#rmId").val() }, function() { dataTable.reloadData(); }, function() { dataTable.reloadData(); });
	    });
    </script>
    <sys:auth grant="REVIEW_PLAN_APP_EDIT" username="${sessionScope.loginUser.userName}">
	    <script type="text/javascript">
	    	displayEditBtn = true;
	    </script>
    </sys:auth>
</body>
</html>