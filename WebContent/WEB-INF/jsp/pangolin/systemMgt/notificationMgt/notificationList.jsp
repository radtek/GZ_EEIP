<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Notification List</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.treegrid.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.treegrid.bootstrap3.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/jquery.treegrid.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/notificationGrid.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>系统管理</a><span>></span><a>通知公告</a>
        </p>
    </div>
    <div class="operating-area has-btn-1">
    	<!-- <div class="text-content">关键字：</div>
    	<div class="input-content btn-2">
    		<input type="text" />
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2"><i class="fa fa-search"></i>查询</button>
    	</div> -->
    	<div class="button-content">
    		<button type="button" class="btn btn-color1 select_add"><i class="fa fa-plus"></i>添加消息</button>
    	</div>
    </div>
    <div class="table-content">
    	<table class="table table-striped table-hover" id="table2">
        	<thead>
            	<tr>
                  	<th>${ LANG[sessionScope.loginUser.lang]['COL_ID'] }</th>
                  	<th>${ LANG[sessionScope.loginUser.lang]['COL_NOTE_TITLE'] }</th>
                  	<th>${ LANG[sessionScope.loginUser.lang]['COL_NOTE_STATUS'] }</th>
                  	<th>${ LANG[sessionScope.loginUser.lang]['COL_CREATED_DATE'] }</th>
                  	<th>${ LANG[sessionScope.loginUser.lang]['COL_MODIFIED_DATE'] }</th>
                  	<th>${ LANG[sessionScope.loginUser.lang]['COL_OPERATION'] }</th>
                </tr>
       		</thead>
           <tbody>
           </tbody>
       	</table>
    </div>
    
    <%-- System Notice Modal --%>
    <jsp:include page="/common/commonModal.jsp"></jsp:include>
  
    <input type="hidden" id="rmNotificationId" />
    <input type="hidden" id="rmNotificationTitle"/>
    
    <script type="text/javascript">
      function setRemovedNotificationParam(notificationId, notificationTitle) {
    	  $("#rmNotificationId").val(notificationId);
	      $("#rmNotificationTitle").val(notificationTitle);
	      setSystemNoticeContent("${ LANG[sessionScope.loginUser.lang]['RM_NOTE_NOTICE'] }&nbsp;"+$("#rmNotificationTitle").val()+"&nbsp;?");
      }
    
      $(function() {
    	  $.ajax ({
    		  url: "${pageContext.request.contextPath}/system/notification/notificationTypeGridData.do",
  		      type: "POST",
  		      cache: false,
  		      async: false, 
  		      success: function(result) {
  		    	  typeData = result;
  		      }
  	      });
    	
    	  var treetd = typeData['data'];
    	  var html = "";
    	
    	  for ( var i = 0; i < treetd.length; i++ ) {
    		  html += "<tr class=\"" + treetd[i]["style"] + "\">";
    	      html += "<td style=\"cursor: pointer\" onclick=\"loadNotifications('" + treetd[i]["id"] + "'); changeStyle(this);\">" + treetd[i]["name"] + "</td>";
    	      html +="</tr>";
    	  }
    	
    	  $('.treeconnect').html(html);
    	
    	  $('.tree').treegrid();
	      var lefth = $('.user_left').height();
	      var righth = $('.user_right').height();
	      if ( lefth < righth) {
	    	  $('.user_left').height(righth);
	      }
	    
	      $('.select_add').click(function() {
	    	  $('.index-iframe' , window.parent.document ).attr("src", "${pageContext.request.contextPath}/system/notification/notificationForm.do");
	      });
   
	      loadGridData('');
        
          $('.user_left').height($(window).height()-70);   //竖线
      });
      
      function changeStyle(td) {
    	  var tdArray = $(".tree").find("td");
    	  for ( var i = 0; i < tdArray.length; i++ ) {
    		  if ( $(tdArray[i]).attr("class") != undefined 
    				  && $(tdArray[i]).attr("class") == "selected_item" ) {
    			  $(tdArray[i]).removeClass("selected_item");
    		  }
    	  }
		  $(td).addClass("selected_item");
	  }
    
      function loadNotifications(notificationId) {
    	  loadGridData(notificationId);
	  }
    
      function getFormattedNoteStatus(data, type, row) {
    	  if ( data == 0 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_NOTE_STATUS01'] }";
    	  if ( data == 1 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_NOTE_STATUS02'] }";
    	  return "";
      }
    
      //设定消息状态
      function setNotificationStatus(notificationId, status) {
    	  try {
    		  $.ajax ({
    		      url: "${pageContext.request.contextPath}/system/notification/saveNotificationDataStatus.do",
    			  type: "POST",
    			  cache: false,
    			  async: false, 
    			  data: { "notificationId" : notificationId, "status" : status },
    			  success: function (result) {
    				  dataTable.reloadData();
    			  }
    		  });
    	  } catch(e) { console.log(e); }
      }
      
      function publish(notificationId){
    	  $('.index-iframe' , window.parent.document ).attr("src", "${pageContext.request.contextPath}/system/notification/notificationPublish.do?notificationId="+notificationId);
      }
     
      
      //数据表操作列
	  function getOperationCol(data, type, row) {
    	  var html = "";
		  if ( row.status != undefined ) {
			  if ( row.status == 0 ) {
				  //html += "<a title='发布' onclick=\"setNotificationStatus('" + row.id + "', 1);\"><i class='fa fa-external-link'></i></a>"; //发布
				  html += "<a title='发布' onclick=\"publish( '" + row.id + "' );\"><i class='fa fa-external-link'></i></a>"; //发布
				  html += "<a title='修改' onclick=\"dataTable.editData({ 'notificationId' : '" + row.id + "' });\"><i class='fa fa-pencil-square-o'></i></a>"; //修改
				
			  }
			  if ( row.status == 1 ) {
				  html += "<a title='撤回' onclick=\"setNotificationStatus('" + row.id + "', 0);\"><i class='fa fa-undo'></i></a>"; //撤回
			  }
		  }
		  
          html += "<a title='删除' data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedNotificationParam('" + row.id + "', '" + row.title + "');\"><i class='fa fa-times'></i></a>"; //移除
   	      return html;
      }
      
      //加载列表数据
      function loadGridData(obj) {
    	  //数据列绑定
	      var columns = [
	          { "mData" : "id", "bSortable" : false, "bVisible" : false },
	          { "mData" : "title", "bSortable" : true},
	          { "mData" : "status", "bSortable" : true, "mRender" : getFormattedNoteStatus },
	          { "mData" : "createdDate", "bSortable" : true, "mRender": getFormattedDate },
	          { "mData" : "modifiedDate", "bSortable" : true, "mRender": getFormattedDate },
	          { "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": "9em" }
          ];
    	
	      //排序规则
          var sorting = [ [ 3, 'desc' ] ];
	  
	      //扩展参数
          var extraParams = [{ "name" : "noteTypeId", "value" : obj }];
      
          //初始化数据表
          dataTable = new BSDataTable();
          dataTable.initialize({
        	  "tableId" : "table2",
              "columns" : columns,
              "sorting" : sorting,
              "pageSize" : DEFAULT_PAGE_SIZE,
              "dataSource" : "${pageContext.request.contextPath}/system/notification/notificationGridData.do",
              "extraParams" : extraParams,
              "style" : DT_FULL_NUMBERS,
              "bProcessing" : true,
              "url" : {
            	  "addDataUrl" : "${pageContext.request.contextPath}/system/notification/notificationForm.do",
    		      "editDataUrl" : "${pageContext.request.contextPath}/system/notification/notificationForm.do",
    		      "rmDataUrl" : "${pageContext.request.contextPath}/system/notification/removeNotificationData.do"
	           }
	       });
          
           //隐藏列表组件显示条数
           $('#table2_length').hide();
       }
    
       initSystemNoticePopup(function() {
    	   dataTable.rmData({ 'notificationId' : $("#rmNotificationId").val() }, function() { dataTable.reloadData(); }, function() { dataTable.reloadData(); });
       });
    </script>
  </body>
</html>