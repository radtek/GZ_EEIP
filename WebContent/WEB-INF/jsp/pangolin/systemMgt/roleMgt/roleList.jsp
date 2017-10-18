<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Role List</title>
    <meta charset="utf-8">
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
    <link href="<c:url value="/resources/frameworks/pangolin/css/roleGrid.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>系统管理</a><span>></span><a>角色管理</a>
        </p>
    </div>
   <%--  <div class="operating-area has-btn-1">
    	<div class="text-content">关键字：</div>
    	<div class="input-content btn-2">
    		<input type="text" />
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color2"><i class="fa fa-search"></i>查询</button>
    	</div>
    	<div class="button-content">
    		<button type="button" class="btn btn-color1 select_add"><i class="fa fa-plus"></i>添加角色</button>
    	</div>
    </div> --%>


    <div class="panel panel-default">
      	<!-- Organization Tree -->
      	<div class="user_left">
	        <table class="tree">
	          	<tbody class="treeconnect">
	          	</tbody>
	        </table>
      	</div>
      
      	<!-- Role List -->
     	<div class="panel-body user_right">
			<table class="table table-striped table-hover" id="table2">
	          	<thead>
	            	<tr>
	              		<th>${ LANG[sessionScope.loginUser.lang]['COL_ID'] }</th>
	              		<th>${ LANG[sessionScope.loginUser.lang]['COL_ROLE_GROUP'] }</th>
	              		<th>${ LANG[sessionScope.loginUser.lang]['COL_ROLE_NAME'] }</th>
	              		<th>${ LANG[sessionScope.loginUser.lang]['COL_ROLE_LABEL'] }</th>
	              		<th>${ LANG[sessionScope.loginUser.lang]['COL_CREATED_DATE'] }</th>
	              		<th>${ LANG[sessionScope.loginUser.lang]['COL_MODIFIED_DATE'] }</th>
	              		<th>${ LANG[sessionScope.loginUser.lang]['COL_ROLE_DESC'] }</th>
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
  
    <input type="hidden" id="rmRoleId" />
    <input type="hidden" id="rmRoleName"/>
    
    <script type="text/javascript">
      function setRemovedRoleParam(roleId, roleName) {
    	  $("#rmRoleId").val(roleId);
	      $("#rmRoleName").val(roleName);
	      setSystemNoticeContent("${ LANG[sessionScope.loginUser.lang]['RM_ROLE_NOTICE'] }&nbsp;"+$("#rmRoleName").val()+"&nbsp;?");
      }
    
      $(function() {
    	  $.ajax ({
    		  url: "${pageContext.request.contextPath}/system/role/orgTreeGridData.do",
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
    			  html += "<td style=\"cursor: pointer\" onclick=\"loadRoles('" + treetd[i]["id"] + "'); changeStyle(this);\">" + treetd[i]["shortName"] + "</td>";
    		  } else {
    			  html += "<td style=\"cursor: pointer\" onclick=\"loadRoles('" + treetd[i]["id"] + "'); changeStyle(this);\">" + treetd[i]["name"] + "</td>";
    		  }
    	      html +="</tr>";
    	  }
    	
    	  $('.treeconnect').html(html);
    	
    	  $('.tree').treegrid();
	      /* var lefth = $('.user_left').height();
	      var righth = $('.user_right').height();
	      if ( lefth < righth) {
	    	  $('.user_left').height(righth);
	      } */
	    
	      $('.select_add').click(function() {
	    	  $('.index-iframe' , window.parent.document ).attr("src", "${pageContext.request.contextPath}/system/role/roleForm.do");
	      });
   
	      loadGridData(""); //加载所有角色数据
        
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
    
      //加载角色数据
      function loadRoles(orgId) {
    	  loadGridData(orgId);
	  }
    
      //设置权限
      function setAuth(roleId) {
    	  $(".index-iframe" , window.parent.document).attr("src", "${pageContext.request.contextPath}/system/auth/authList.do?roleId=" + roleId);
      }
    
      //角色类别名称
      function getFormattedOrgName(data, type, row) {
    	  if ( data == "" || data == null ) return "-";
    	  else return data;
    	  return "";
      }
    
      //数据表操作列
	  function getOperationCol(data, type, row) {
    	  var html = "";
		  html += "<a title='权限' onclick=\"setAuth('" + row.roleId + "');\"><i class='fa fa-lock'></i></a>"; //设置权限
		  html += "<a title='修改' onclick=\"dataTable.editData({ 'roleId' : '" + row.roleId + "' });\"><i class='fa fa-pencil-square-o'></i></a>"; //修改
          html += "<a title='删除' data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedRoleParam('" + row.roleId + "', '" + row.roleName + "');\"><i class='fa fa-times'></i></a>"; //移除
   	      return html;
      }
    
      //加载列表数据
      function loadGridData(obj) {
    	  //数据列绑定
	      var columns = [
	          { "mData" : "roleId", "bSortable" : false, "bVisible" : false },
	          { "mData" : "orgName", "bSortable" : true, "mRender": getFormattedOrgName, "bVisible" : false },
    	      { "mData" : "roleName", "bSortable" : true },
    	      { "mData" : "roleLabel", "bSortable" : true, "bVisible" : false },
    	      { "mData" : "createdDate", "bSortable" : true, "mRender": getFormattedDate },
    	      { "mData" : "modifiedDate", "bSortable" : true,  "mRender": getFormattedDate },
    	      { "mData" : "roleDesc", "bSortable" : false },
    	      { "mData" : null , "bSortable" : false,  "mRender": getOperationCol ,"sWidth": "9em"}
          ];
    	
	      //排序规则
          var sorting = [ [ 2, "asc" ] ];
	  
	      //扩展参数
          var extraParams = [{"name":"orgId","value":obj}];
      
          //初始化数据表
          dataTable = new BSDataTable();
          dataTable.initialize({
              "tableId" : "table2",
              "columns" : columns,
              "sorting" : sorting,
              "pageSize" : DEFAULT_PAGE_SIZE,
              "dataSource" : "${pageContext.request.contextPath}/system/role/roleGridData.do",
              "extraParams" : extraParams,
              "style" : DT_FULL_NUMBERS,
              "bProcessing" : true,
              "url" : {
        	      "addDataUrl" : "${pageContext.request.contextPath}/system/role/roleForm.do",
    		      "editDataUrl" : "${pageContext.request.contextPath}/system/role/roleForm.do",
    		      "rmDataUrl" : "${pageContext.request.contextPath}/system/role/removeRoleData.do"
	          }
	      });
        
          //隐藏列表组件显示条数
          $('#table2_length').hide();
      }
    
      initSystemNoticePopup(function() {
    	  dataTable.rmData({ 'roleId' : $("#rmRoleId").val() }, function() { dataTable.reloadData(); }, function() { dataTable.reloadData(); });
      });
    </script>
</body>
</html>