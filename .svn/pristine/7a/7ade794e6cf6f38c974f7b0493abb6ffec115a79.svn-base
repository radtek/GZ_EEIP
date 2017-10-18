<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>条形码</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
   	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/jquery-barcode.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<style type="text/css">
  		.bar-code-img{margin:0 auto;}
  		.bar-code-text{font-size: 12px;text-align: center;font-weight: bold;}
  		.hide-btn{display:none;}
  	</style>
</head>
<body>
    <div class="bar-code-content" style="margin-top:9px;">
		<div class="bcTarget bar-code-img"></div> 
		<div class="bar-code-text"></div>
	</div>
	<button class="hide-btn print-page" onclick="window.print()"></button>
	<script type="text/javascript">
		var value = window.location.search.substr(7);
		$(".bcTarget").empty().barcode(value, "code128",{barWidth:1, barHeight:25,showHRI:false});
		$(".bcTarget").siblings(".bar-code-text").html(value);
	</script>
</body>
</html>