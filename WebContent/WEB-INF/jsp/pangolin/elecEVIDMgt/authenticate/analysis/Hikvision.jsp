<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hikvision</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
	<meta http-equiv="Expires" content="0" />
	<meta http-equiv="x-ua-compatible" content="IE=8" >
  	<meta name="renderer" content="ie-comp" />
	<script src="<c:url value="/resources/frameworks/Hikvision/js/jquery-1.7.1.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/Hikvision/js/webVideoCtrl.js" />"></script>
	<script src="<c:url value="/resources/frameworks/Hikvision/js/monitor.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
	<style type="text/css">
		body{width:auto;margin:0;}
		.plugin{width:100%;height:auto;text-align: center;}
		.plugin embed{width:710px !important;height:400px !important;}
		.btn-content{border-top:1px dashed #333;padding:20px 0 0 0;margin-top:20px;}
		.prompt-box{position: fixed;top: 150px;left: 50%;background-color: rgba(0,0,0,0.5);width: 300px;
		    min-height: 50px;line-height: 24px;border-radius: 4px;text-align: center;color: #fff;
		    margin-top: -25px;margin-left: -150px;padding: 10px 15px;
		}
	</style>
</head>
<body>
    <div id="divPlugin" class="plugin"></div>
    <div class="btn-content">
    	<button class="btn btn-color1 start-btn" onClick="startRecord()"><i class="fa fa-play"></i>开始录制</button>
    	<button class="btn btn-color1 stop-btn" onClick="stopRecord()" disabled><i class="fa fa-stop"></i>停止录制</button>
    </div>
    
    <!-- <br>---------------------------------------------<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="Start" onClick="startRecord()"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="Stop" onClick="stopRecord()"/> -->
    
    <script>
    	$(".start-btn").click(function(){
    		$(this).attr("disabled", true);
    		$(".stop-btn").attr("disabled", false);
    		$("#video", window.parent.document).attr("disabled",true);
    	});
		$(".stop-btn").click(function(){
			$(this).attr("disabled", true);
    		$(".start-btn").attr("disabled", false);
    		$("#video", window.parent.document).attr("disabled",false);
    	});
		
		/* function startSuccessfully(){
			alert("成功开始记录！");
		}
		
		function failedRecord(){
			alert("记录失败！");
		}
		
		function stopSuccessfully(){
			alert("成功停止记录！");
		}
		
		function failedStop(){
			alert("停止失败！");
		}
		
		function chromeNot(){
			alert("浏览器不支持NPAPI！");
		}
		
		function webComponentsKit(){
			alert("请先安装插件'WebComponentsKit.exe'!");
		} */
    </script>
</body>
</html>
