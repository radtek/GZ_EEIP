<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定文书修改通知委托人</title>
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
			<div class="mid-title"><span>丨</span> 通知</div>															
			<div class="form-group">
				<label class="col-sm-4 control-label"><span class="required-fields">*</span>收信人：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" required/>
				</div>																
			</div>
			<div class="form-group">												
				<label class="col-sm-4 control-label"><span class="required-fields">*</span>内容：</label>
				<div class="col-sm-4" >
					<textarea type="text" class="form-control" required></textarea>
				</div>								
			</div>
			<div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: saveData" class="submit-btn">√ 确定</button>
					<button type="button" data-bind="click: backToList" class="back-btn">< 取消</button>
				</div>
			</div>
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
		$(".back-btn").click(function(){
	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentList.do');
	    })		
	    $(".submit-btn").click(function(){
			if(validateSubmittedData()){
				
			}else{
				saveFailure();
			}
		})
	</script>
</body>
</html>