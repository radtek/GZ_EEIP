<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Organization List</title>
    <meta charset="utf-8">
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.treegrid.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.treegrid.bootstrap3.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/jquery.treegrid.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/assets2.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-list.css" />" rel="stylesheet" />
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
			当前位置：<a>系统管理</a><span>></span><a>组织架构</a>
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
    		<button type="button" class="btn btn-color1 select_add"><i class="fa fa-plus"></i>添加机构</button>
    	</div>
    </div>
    <div class="table-content">
        <table class="tree table table-striped table-hover" id="table2">
            <thead>
                <tr>
                    <th>${ LANG[sessionScope.loginUser.lang]['COL_ORG_NAME'] }</th>
            		<th>${ LANG[sessionScope.loginUser.lang]['COL_ORG_TYPE'] }</th>
            		<th>${ LANG[sessionScope.loginUser.lang]['COL_ORG_SN'] }</th>
            		<th>${ LANG[sessionScope.loginUser.lang]['COL_CREATED_DATE'] }</th>
            		<th>${ LANG[sessionScope.loginUser.lang]['COL_MODIFIED_DATE'] }</th>
            		<th>${ LANG[sessionScope.loginUser.lang]['COL_OPERATION'] }</th>
                </tr>
            </thead>
            <tbody class="treeconnect">
            </tbody>
        </table>
    </div>
    
  	<%-- System Notice Modal --%>
  	<jsp:include page="/common/commonModal.jsp"></jsp:include>
  
  	<input type="hidden" id="rmOrgId" />
  	<input type="hidden" id="rmOrgName"/>
  
  	<script type="text/javascript">
	    function editOrg(id) {
	    	$('.index-iframe' , window.parent.document ).attr("src", "${pageContext.request.contextPath}/system/org/orgForm.do?orgId=" + id);
	    }
	  
	    function setRemovedOrgParam(orgId, orgName) {
	    	$("#rmOrgId").val(orgId);
		    $("#rmOrgName").val(orgName);
		    setSystemNoticeContent("${ LANG[sessionScope.loginUser.lang]['RM_ORG_NOTICE'] }&nbsp;"+$("#rmOrgName").val()+"&nbsp;?");
	    }
	  
	    function removeOrg(id) {
	    	if ( id != null && id != "" ) {
	    		$.ajax ({
	    			url: "${pageContext.request.contextPath}/system/org/removeOrgData.do",
				    type: "POST",
				    cache: false,
				    async: false, 
				    data: { "orgId" : id },
				    success: function (result) {
				    	window.location.reload();
				    }
			    });
		    }
	    }
	    
	    function getFormattedOrgType(data) {
	    	if ( data == 0 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_ORG_TYPE01'] }";
	  	    if ( data == 1 ) return "${ LANG[sessionScope.loginUser.lang]['OPTION_ORG_TYPE02'] }";
	  	    return "";
	    }
	  	    $(function() {
	    	$.ajax ({
	    		url: "${pageContext.request.contextPath}/system/org/orgGridData.do",
			    type: "POST",
			    cache: false,
			    async: false, 
			    success: function (result) {
			    	orgData = result;
			    }
		    });
		  
		    var treetd = orgData['data'];
		    var html = "";
		  
		    for ( var i = 0; i < treetd.length; i++ ) {
		    	html += "<tr class=\"" + treetd[i]["style"] + "\">";
			    html += "<td>" + treetd[i]["name"] + "</td>";
			    html += "<td>" + getFormattedOrgType(treetd[i]["type"]) + "</td>";
			    html += "<td>" + treetd[i]["sn"] + "</td>";
			    html += "<td>" + treetd[i]["createdDateStr"] + "</td>";
			    html += "<td>" + treetd[i]["modifiedDateStr"] + "</td>";
			    html += "<td>";
			    html += "<a class=\"modifyBtn\" title='修改' onclick=\"editOrg('"+treetd[i]["id"]+"')\"><i class='fa fa-pencil-square-o'></i></a>";
			    //html += "&nbsp;&nbsp;&nbsp;&nbsp;";
			    html += "<a class=\"deleteBtn\" title='删除' data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedOrgParam('"+treetd[i]["id"]+"', '"+treetd[i]["name"]+"');\"><i class='fa fa-times'></i></a>";
			    html += "</td>";
		    }
		  
		    $('.treeconnect').html(html);
		    $('.tree').treegrid();
		  
		    $('.select_add').click(function() {
		    	$('.index-iframe' , window.parent.document ).attr("src", "${pageContext.request.contextPath}/system/org/orgForm.do");
		    });
	    });
	  
	    initSystemNoticePopup(function() { removeOrg($("#rmOrgId").val()); });
  	</script>
</body>
</html>