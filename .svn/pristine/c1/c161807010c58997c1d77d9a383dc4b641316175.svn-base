<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>System Log List</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>系统管理</a><span>></span><a>日志管理</a>
        </p>
    </div>
    <div class="operating-area">
    	<ul class="log-content">
    		<li><a data-url="${pageContext.request.contextPath}/system/log/accessLogList.do">访问日志</a></li>
    		<li><a data-url="${pageContext.request.contextPath}/system/log/operationLogList.do">操作日志</a></li>
    		<li><a class="action" data-url="${pageContext.request.contextPath}/system/log/sysLogList.do">系统日志</a></li>
    	</ul>
    	<div class="button-content">
    		<button type="button" class="btn btn-color1 add-form-btn" data-toggle="modal" data-target="#sysNoticePopup"><i class="fa fa-times"></i>删除所有</button>
    	</div>
    </div>
    <div class="table-content">
        <table class="table table-striped table-hover" id="table2">
          	<thead>
	            <tr>
	              	<th>ID</th>
              		<th>${ LANG[sessionScope.loginUser.lang]['COL_SYSTEM_LOG_TYPE'] }</th>
              		<th>${ LANG[sessionScope.loginUser.lang]['COL_SYSTEM_LOG_MODULE'] }</th>
              		<th>${ LANG[sessionScope.loginUser.lang]['COL_SYSTEM_LOG_DATE'] }</th>
              		<th>${ LANG[sessionScope.loginUser.lang]['COL_SYSTEM_LOG_CONTENT'] }</th>
              		<th>${ LANG[sessionScope.loginUser.lang]['COL_SYSTEM_LOG_OPERATOR_NAME'] }</th>
              		<th>${ LANG[sessionScope.loginUser.lang]['COL_SYSTEM_LOG_OPERATOR_ALIAS'] }</th>
              		<th>${ LANG[sessionScope.loginUser.lang]['COL_SYSTEM_LOG_IP_ADDR'] }</th>
              		<th>${ LANG[sessionScope.loginUser.lang]['COL_OPERATION'] }</th>
	            </tr>
          	</thead>
          	<tbody>
          	</tbody>
        </table>
    </div>
    <%-- System Notice Modal --%>
    <jsp:include page="/common/commonModal.jsp"></jsp:include>
    <input type="hidden" id="rmId" />
    
    <script type="text/javascript">
    $(function() {
    	/* var menu = $('.dropdown-menu li');
        menu.click(function() {
	    var url = $(this).attr('data-addres');
	      $('.index-iframe' , window.parent.document ).attr('src', url);
        }); */
        
        $(".log-content a").click(function(){
      		var url = $(this).data("url");
      	  	$('.index-iframe' , window.parent.document ).attr('src', url);
        });
        
        function getFormattedLogType(data, type, row) {
        	if ( data == 0 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_SYSTEM_LOG_TYPE01'] }";
        	if ( data == 1 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_SYSTEM_LOG_TYPE02'] }";
        	if ( data == 2 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_SYSTEM_LOG_TYPE03'] }";
        	return "";
        }
        
        function getOperationCol(data, type, row) {
      		var html = "";
      		html += "<a title='删除' data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedOrgParam('" + row.logId + "');\"><i class='fa fa-times'></i></a>"; //删除
         	return html;
          }
      
        loadGridData();
      
        //加载列表数据
        function loadGridData() {
        	//数据列绑定
    	    var columns = [     	       
    	      { "mData" : "logId", "bSortable" : false, "bVisible" : false },  	      
              { "mData" : "logType", "bSortable" : true, "mRender" : getFormattedLogType },
              { "mData" : "moduleName", "bSortable" : true },
    	      { "mData" : "eventDate", "bSortable" : true, "mRender": getFormattedDate },
    	      { "mData" : "logEvent", "bSortable" : false },
    	      { "mData" : "userName", "bSortable" : true},
              { "mData" : "userAlias", "bSortable" : true},
    	      { "mData" : "userIPAddress", "bSortable" : true},
	          { "mData" : null, "bSortable" : true ,"mRender" : getOperationCol, "sWidth":"4em" }
            ];
        	
    	    //排序规则
            var sorting = [ [ 2, 'desc' ] ];
    	  
    	    //扩展参数
            var extraParams = [];
            var url = '';
          
            //初始化数据表
            dataTable = new BSDataTable();
            dataTable.initialize({
              "tableId" : "table2",
              "columns" : columns,
              "sorting" : sorting,
              "pageSize" : DEFAULT_PAGE_SIZE,
              "dataSource" : "${pageContext.request.contextPath}/system/log/sysLogGridData.do",
              "extraParams" : extraParams,
              "style" : DT_FULL_NUMBERS,
              "bProcessing" : true,
              "url" : {
                "addDataUrl" : url
    	      }
    	    });  
        
            //隐藏列表组件显示条数
            $('#table2_length').hide();
        }
     });
    
    function setRemovedOrgParam(id){
  	  $("#rmId").val(id);
  	  setSystemNoticeContent("是否删除访问日志&nbsp;?");
    }
    
    initSystemNoticePopup(function() {
    	  if($("#rmId").val() == null || $("#rmId").val() == "" || $("#rmId").val() == "undefined"){
    		  $.ajax ({
        		  url: "${pageContext.request.contextPath}/system/log/removeAllLogData.do",
    			  type: "POST",
    			  cache: false,
    			  async: false, 
    			  data: { "logType" : 2 },
    			  success: function (result) {
    				  dataTable.reloadData();
    			  }
    		  }); 
    		  
    	  }else{
    		  $.ajax({
        		  url:'${pageContext.request.contextPath}/system/log/removeLogData.do',
        		  type:'post',
        		  data:{"id":$("#rmId").val(),"logType":2},
        		  datatype:'json',
        		  success:function(data){
        			  window.location.href="${pageContext.request.contextPath}/system/log/sysLogList.do";
        		  }
        	  }); 
    	  }
    	  
      });
    
     setSystemNoticeContent("${ LANG[sessionScope.loginUser.lang]['RM_SYSTEM_LOG_NOTICE'] }&nbsp;?");
    </script>
</body>
</html>