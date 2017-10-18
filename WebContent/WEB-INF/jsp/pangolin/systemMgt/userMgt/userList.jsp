<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
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
    
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/jquery.treegrid.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/userGrid.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
  	<div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>系统管理</a><span>></span><a>用户管理</a>
        </p>
    </div>
    <div class="operating-area">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-2">
    		<input type="text" id="search_content"/>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2" id="search_btn"><i class="fa fa-search"></i>查询</button>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color1 select_add"><i class="fa fa-plus"></i>添加用户</button>
    	</div>
    </div>
    <div class="panel panel-default">
      <%-- <div class="panel-heading"> 
	    <button type="button" class="btn btn-info select_add">${ LANG[sessionScope.loginUser.lang]['ADD_USER_DATA'] }</button>
	    <div class="headerRight">
	       <div class="select_search">
             <input id="search_content" type="text" placeholder="${ LANG[sessionScope.loginUser.lang]['SEARCH_USER_REMINDER'] }">
             <span id="search_btn" class="glyphicon glyphicon-search search_icon"></span>
           </div>
	    </div>
      </div> --%>
      
      <!-- Organization Tree -->
      <div class="user_left">
        <table class="tree">
          <tbody class="treeconnect">
          </tbody>
        </table>
      </div>
      
      <!-- User List -->
      <div class="user_right">
        <table class="table table-striped table-hover" id="table2">
          <thead>
            <tr>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_ID'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_USER_NAME'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_USER_ALIAS'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_USER_STATUS'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_CREATED_DATE'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_MODIFIED_DATE'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_OPERATION'] }</th>
            </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
      </div>
      <div class="clear"></div>
    </div>
    
    <%-- System Notice Modal --%>
    <jsp:include page="/common/commonModal.jsp"></jsp:include>
  
    <input type="hidden" id="rmUserId" />
    <input type="hidden" id="rmUserName"/>
    
    <script type="text/javascript">
      var chosenOrgId = "";  
    
      $(function() {    	  
    	  //Searching data
    	  $("#search_btn").click(function(){
        	  loadGridData(chosenOrgId, $("#search_content").val().replace(/\s+/g, ""));
    	  });
    	  
    	  $("#search_content").keyup(function(){
    		  if ( event.keyCode == 13 ) {
    			  loadGridData(chosenOrgId, $("#search_content").val().replace(/\s+/g, ""));
    	      }
    	  });
    	  
    	  $.ajax ({
    		  url: "${pageContext.request.contextPath}/system/user/orgTreeGridData.do",
  		      type: "POST",
  		      cache: false,
  		      async: false, 
  		      success: function(result) {
  		    	  orgData = result;
  		      }
  	      });
    	
    	  var treetd = orgData['data'];
    	  var html = "";
    	
    	  for ( var i = 0; i < treetd.length; i++ ) {
    		  html += "<tr class=\"" + treetd[i]["style"] + "\">";
    		  if ( treetd[i]["shortName"] != undefined && treetd[i]["shortName"] != "" ) {
    			  html += "<td style=\"cursor: pointer\" onclick=\"loadUsers('" + treetd[i]["id"] + "'); changeStyle(this);\">" + treetd[i]["shortName"] + "</td>";
    		  } else {
    			  html += "<td style=\"cursor: pointer\" onclick=\"loadUsers('" + treetd[i]["id"] + "'); changeStyle(this);\">" + treetd[i]["name"] + "</td>";
    		  }
    	      html +="</tr>";
    	  }
    	
    	  $('.treeconnect').html(html);
    	
    	  $('.tree').treegrid();
	      /* var lefth = $('.user_left').height();
	      var righth = $('.user_right').height();
	      if ( lefth < righth) { $('.user_left').height(righth); } */
	    
	      $('.select_add').click(function() {
	    	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/system/user/userForm.do');
	      });
   
	      loadGridData('', '');
        
          //$('.user_left').height($(window).height()-70);   //竖线
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
      
      function loadUsers(orgId) {
    	  chosenOrgId = orgId;
    	  loadGridData(orgId, '');
	  }
    
      function getFormattedUserName(data, type, row) {
    	  if ( row.userRegStatus == 0 ) return "<span class=\"fa fa-lightbulb-o new_tips\"></span>&nbsp;&nbsp;" + data;
    	  return data;
      }
      
      function getFormattedUserStatus(data, type, row) {
    	  if ( data == 0 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_USER_STATUS01'] }";
    	  if ( data == 1 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_USER_STATUS02'] }";
    	  return "";
      }
    
      //数据表操作列
	  function getOperationCol(data, type, row) {
    	  var html = "";
		  html += "<a title='修改' onclick=\"dataTable.editData({ 'userId' : '" + row.userId + "' });\"><i class='fa fa-pencil-square-o'></i></a>";
		  if ( !(row.userName.indexOf("admin") != -1) ) {
			  html += "<a title='删除' data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedUserParam('" + row.userId + "', '" + row.userName + "');\"><i class='fa fa-times'></i></a>";
		  }
   	      return html;
      }
    
      //加载列表数据
      function loadGridData(orgId, condition) {
    	  //数据列绑定
	      var columns = [
	          { "mData" : "userId", "bSortable" : false, "bVisible" : false },
	          { "mData" : "userName", "bSortable" : true, "mRender" : getFormattedUserName },
	          { "mData" : "userAlias", "bSortable" : true },
	          { "mData" : "userStatus", "bSortable" : true, "mRender" : getFormattedUserStatus },
	          { "mData" : "createdDate", "bSortable" : true, "mRender": getFormattedDate },
	          { "mData" : "modifiedDate", "bSortable" : true, "mRender": getFormattedDate },
	          { "mData" : null , "bSortable" : false,  "mRender": getOperationCol, "sWidth": 80}
          ];
    	
	      //排序规则
          var sorting = [ [ 1, 'asc' ] ];
	  
	      //扩展参数
          var extraParams = [{ "name" : "orgId", "value" : orgId }, { "name" : "condition", "value" : condition }];
      
          //初始化数据表
          dataTable = new BSDataTable();
          dataTable.initialize({
            "tableId" : "table2",
            "columns" : columns,
            "sorting" : sorting,
            "pageSize" : DEFAULT_PAGE_SIZE,
            "dataSource" : "${pageContext.request.contextPath}/system/user/userGridData.do",
            "extraParams" : extraParams,
            "style" : DT_FULL_NUMBERS,
            "bProcessing" : true,
            "url" : {
        	    "addDataUrl" : "${pageContext.request.contextPath}/system/user/userForm.do",
    		    "editDataUrl" : "${pageContext.request.contextPath}/system/user/userForm.do",
    		    "rmDataUrl" : "${pageContext.request.contextPath}/system/user/removeUserData.do"
	        }
	      });
    
          //隐藏列表组件显示条数
          $('#table2_length').hide();
      }
    
      function setRemovedUserParam(userId, userName) {
    	  $("#rmUserId").val(userId);
	      $("#rmUserName").val(userName);
	      setSystemNoticeContent("${ LANG[sessionScope.loginUser.lang]['RM_USER_NOTICE'] }&nbsp;"+$("#rmUserName").val()+"&nbsp;?");
      }
      
      initSystemNoticePopup(function() {
    	  dataTable.rmData({ 'userId' : $("#rmUserId").val() }, function() { dataTable.reloadData(); }, function() { dataTable.reloadData(); });
      });
    </script>
  </body>
</html>