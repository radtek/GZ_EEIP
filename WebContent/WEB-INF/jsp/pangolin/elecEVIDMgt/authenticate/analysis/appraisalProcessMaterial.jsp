<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定过程领材</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />	
</head>
<body>
	<div class="content">
		<div class="location">
			<span>当前位置：电子物证管理 > 鉴定人员操作台  </span>			
		</div>
		
		<form class="form-horizontal myform">
			<div class="mid-title"><span>丨</span> 鉴定分配</div>													
			<div class="form-group">
				<label class="col-sm-2 control-label">分配人：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>
				<label class="col-sm-2 control-label">分配时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>								
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">鉴定师：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>											
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">预计开始时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>
				<label class="col-sm-2 control-label">截止时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>								
			</div>	
		   <div class="mid-title"><span>丨</span> 检材领用</div>
		   	<div class="form-group">
				<label class="col-sm-2 control-label">领用人：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">领用时间：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>							
			</div>
			<div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: saveData" class="submit-btn">√ 提交</button>
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div>
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
	
	</script>
</body>
</html>