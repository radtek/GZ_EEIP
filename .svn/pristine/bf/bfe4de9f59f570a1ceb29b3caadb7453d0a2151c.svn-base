<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>广州市公安局电子数据检验鉴定管理系统</title>
  	<meta charset="utf-8">
  	<meta http-equiv="x-ua-compatible" content="IE=8" >
   	<meta name="renderer" content="ie-stand" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.sparkline.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script> 
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
  	<%@ include file = "/common/scripts.jsp"%>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form2.css" />" rel="stylesheet" />
	<script type="text/javascript">
	</script>
</head>
<body>
	<h2 class="video-title">广州市公安局电子数据检验鉴定管理系统鉴定视频</h2>
	<div class="video-content">
	</div>
    
    <div class="bgDiv hideDiv"></div>
    <div class="textDiv hideDiv">请自行将浏览器浏览模式手动切换成兼容模式，否则无法观看视频。</div>
    
	<script>
	 if(window.navigator.userAgent.indexOf('AppleWebKit') != -1) {
		$(".hideDiv").show();
	}else{
		$(".hideDiv").hide();
	}
	 
	$(function(){
		var appraisalData =  loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{"id":"${param.id}"});
		var videoPath = appraisalData.videoPath;
		var videoHtml = '';
		if(videoPath!=null || videoPath!=''){
			videoHtml+='<object id="MediaPlayer" classid="CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95" standby="Loading Windows Media Player components..." type="application/x-oleobject" width="500" height="500"> '
			+'<PARAM id="filename" name="filename" value="'+videoPath+'"> </object>';
		}
		$(".video-content").append(videoHtml); 
	}) 
	</script>
</body>
</html>