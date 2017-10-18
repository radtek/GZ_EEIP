<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Notification View</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/ckeditor/ckeditor.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/chosen.jquery.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>    
    
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
    <!--[if lt IE 9]>
    <script src="<c:url value="/resources/frameworks/pangolin/js/selectivizr.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/respond.min.js" />" type="text/javascript"></script>
    <![endif]-->
    <style>
    	.cke_top.cke_reset_all, .cke_bottom.cke_reset_all{
    		display:none;
    	}
    </style>
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>系统管理</a><span>></span><a>通知公告</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
	      	<div class="form-group">
		        <label class="col-sm-2 control-label">发布人：</label>
		        <div class="col-sm-4">
				  	<input type="text" class="form-control creatorAlias" readonly />
		        </div>
		        <label class="col-sm-2 control-label">发布时间：</label>
		        <div class="col-sm-4">
				  	<input type="text" class="form-control publishedDate" readonly />
		        </div>
	      	</div>
		  	<div class="form-group">
			    <label class="col-sm-2 control-label">发布内容：</label>
		        <div class="col-sm-10">
		        	<textarea id="noteContent" name="noteContent" class="form-control content" readonly></textarea>
		        </div>
	      	</div>		
		</form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
    <script src="<c:url value="/resources/frameworks/pangolin/js/spinner.js" />"></script>
  
    <script type="text/javascript">
    $(function(){
    	$(".back-btn").click(function(){
    		var url = "${pageContext.request.contextPath}/system/notification/notificationList.do";
    		$(".index-iframe", window.parent.document).attr("src",url);
    	});
    	
    	CKEDITOR.replace("noteContent");
    	
    	var noteData = loadData("${pageContext.request.contextPath}/system/notification/loadNotificationData.do", {"notificationId" : "${param.notificationId}"});
    	$(".publishedDate").val(new Date(noteData.publishedDate).Format("yyyy-MM-dd hh:mm"));
    	$(".creatorAlias").val(noteData.creatorAlias);
    	$(".content").val(noteData.content);
    	
    	
    })
  	</script>
</body>
</html>