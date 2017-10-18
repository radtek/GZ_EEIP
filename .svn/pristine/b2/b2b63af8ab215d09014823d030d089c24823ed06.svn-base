<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<c:if test="${ not empty sessionScope.loginUser }">
  <c:redirect url="/"></c:redirect>
</c:if>
<c:set var="lang" value="zh_CN" scope="page"></c:set>
<!DOCTYPE html>
<html>
  <head>
    <title>广州市公安局电子数据检验鉴定管理系统</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/javascript/common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/icheck/icheck.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.download.js" />"></script>
    <script src="<c:url value="/resources/javascript/login/signin.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/signin.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/icheck/skins/all.css" />" rel="stylesheet" />
    <!-- <script type="text/javascript">
		function refresh(){
	    	if( location.href.indexOf("?reload=true") < 0 ){
	    		location.href += "?reload=true";
	       	}else{
	       		clearTimeout(time);
	       	}
	    }  
		var time = setTimeout("refresh()",100); 
	</script> -->
</head>
<body class="signinBg">
  	<div class="login-content">
  		<div class="logo-img">
  			<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/loginLogo.png" />
  		</div>
  		<div class="system-name">
  			<p>广州市公安局</p>
  			<p>电子数据检验鉴定管理系统</p>
  		</div>
  		<div class="login-section">
	  		<form id="signinForm" action="signin.action" method="post">
	  			<div class="input-content">
	  				<span>帐号：</span><input type="text" class="username user" name="username" />
	  			</div>
	  			<div class="input-content">
	  				<span>密码：</span><input type="password" class="password" name="password" />
	  			</div>
	  			<div class="operating-area">
	  				<div class="remember">
	  					<div class="ckbox ckbox-primary">
	                        <input type="checkbox" value="" id="checkboxPrimary" checked="checked" class="rememberMe" />
	                        <label for="checkboxPrimary">记住密码</label>
	                	</div>
	  				</div>
	  				<div class="forget">
	  					<span class="forget-password-btn" data-toggle="modal" data-target="#sysNoticeModal">忘记密码？</span>
	  				</div>
	  			</div>
	  			<div class="login-btn">
	  				<button type="button" class="btn denglu"><i class="fa fa-unlock-alt"></i>登录</button>
	  				<input type="hidden" class="tishiBtn" data-toggle="modal" data-target="#sysNoticeModal" />
	  			</div>
	  			<%-- Navigator type, 0 is navigator of pc --%>
			    <input type="hidden" name="navigatorType" value="0"/>
			    <input type="hidden" name="rememberMe" id="rememberMe" value="0"/>
	  		</form>
  		</div>
  	</div>
  	
  	<%-- System Notice Modal --%>
  	<div class="modal fade" id="sysNoticeModal" tabindex="-1" role="dialog">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span class="modal-custom-close" aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title modal-custom-title" id="myModalLabel">${ LANG[pageScope.lang]['SYSTEM_NOTICE_TITLE'] }</h4>
	      </div>
	        
	      <div class="modal-body">
	        <p class="markedWords"></p>
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">${ LANG[pageScope.lang]['BTN_CONFIRM'] }</button>
	      </div>
	    </div>
	  </div>
	</div>
  	<div class="bgDiv hideDiv"></div>
    <div class="textDiv hideDiv">请自行将浏览器浏览模式手动切换成极速模式，否则无法对页面进行任何操作。</div>
  	<script type="text/javascript">
	  	//浏览器浏览模式判断
		if(window.navigator.userAgent.indexOf('AppleWebKit') != -1) {
			$(".hideDiv").hide();
		}else{
			$(".hideDiv").show();
		}
	  	$(function() {
	  		submitEvent = true;
	  		
	  		$(".applyBtn").click(function(){
	  			applyLicense("${pageContext.request.contextPath}/licence/apply.do", 
	  					"${pageContext.request.contextPath}/licence/download.do");
	  		});
	  		
	  		$(".forget-password-btn").click(function(){
	  			$(".markedWords").html("请联系管理员！");
	  		});
	  		
	  		$(".verificationBtn").click(function(){
	  			var result = activateLicense("${pageContext.request.contextPath}/licence/activate.do");
	  			if ( result.status ) {
	  				clearRegCode();
	  				$(".tishiBtn").click();
	  				$(".markedWords").html("&nbsp;&nbsp;&nbsp;&nbsp;${ LANG[pageScope.lang]['LEGAL_LICENSE_WARNING'] }&nbsp;" + result.expDate);
	  			} else {
	  				$(".tishiBtn").click();
	  				$(".markedWords").html("&nbsp;&nbsp;&nbsp;&nbsp;${ LANG[pageScope.lang]['ILLEGAL_LICENSE_WARNING'] }&nbsp;!");
	  			}
	  		});
	  		
	  		$(".switchBtn").click(function(){
	  			var id = $(this).attr("name");
	  			
	  			if ( id.indexOf("signinForm") != -1 ) submitEvent = true;
	  			if ( id.indexOf("registrationApplication") != -1 ) submitEvent = false;
	  			if ( id.indexOf("registrationCodeVerification") != -1 ) submitEvent = false;
	  			
	  			$(id).siblings().hide();
	  			$(id).show();
	  		});
	  		
	  		/* $('.rememberMe').iCheck({
				labelHover : false, 
				cursor : true, 
				checkboxClass : 'icheckbox_square-blue', 
				radioClass : 'iradio_square-blue', 
				increaseArea : '20%'
		    }); */
	  		
	  		$('.rememberMe').on('ifChecked', function(event) {
				$("#rememberMe").val("1");
	        });
			
			$('.rememberMe').on('ifUnchecked', function(event) {
				$("#rememberMe").val("0");
	        });
	  		
	  		$(".denglu").click(function() {
	  			var valueU = $(".username").val().replace(/\s+/g,"");	  			  		  
		  		var valueP = $(".password").val().replace(/\s+/g,"");		  			
	  	        if ( $(".user").val() == "" ) {
	  				$(".markedWords").html("&nbsp;&nbsp;&nbsp;&nbsp;${ LANG[pageScope.lang]['USERNAME_REQUIRED_WARNING'] }&nbsp;!");
		  	        $(".tishiBtn").click();
		  	    } else if ( $(".password").val() == "" ) {
		  	    	$(".markedWords").html("&nbsp;&nbsp;&nbsp;&nbsp;${ LANG[pageScope.lang]['USERPWD_REQUIRED_WARNING'] }&nbsp;!");
		  	       	$(".tishiBtn").click();
		  	    } else if(!valueU){
		  	    	$(".markedWords").html("用户名不能为空!");
		  	        $(".tishiBtn").click();
		  	    } else if(!valueP){
		  	    	$(".markedWords").html("密码不能为空!");
		  	        $(".tishiBtn").click();    
		  	    } else {
		  	    	$("form").submit();
		  	    }
		    });
	  		
		  	document.onkeydown = function(e) {
		  		var ev = document.all ? window.event : e;
		  		if ( submitEvent ) {
		  			if ( ev.keyCode == 13 ) {
			  			$(".denglu").click();
			  		}
		  		}
		  	 }
		  	  	
		  	 function centerModals() {
		  		 $('#sysNoticeModal').each(function(i) {
		  			 var $clone = $(this).clone().css('display', 'block').appendTo('body'); var top = Math.round(($clone.height() - $clone.find('.modal-content').height()) / 2);
		  	         top = top > 0 ? top : 0;
		  	         $clone.remove();
		  	         $(this).find('.modal-content').css("margin-top", top);
		  	     });
		  	 }
		  	
		  	 $('#sysNoticeModal').on('show.bs.modal', centerModals);
		  	  
		  	 var urlName = window.location.search.substr(8);
		     if ( urlName == "user_info_error" ) {
		    	 $(".tishiBtn").click();
		  	     $(".markedWords").html("&nbsp;&nbsp;&nbsp;&nbsp;${ LANG[pageScope.lang]['USER_INFO_ERROR_WARNING'] }&nbsp;!");
		  	 }
		  	    
		  	 if ( urlName == "user_disabled" ) {
		  		 $(".tishiBtn").click();
		  	     $(".markedWords").html("&nbsp;&nbsp;&nbsp;&nbsp;${ LANG[pageScope.lang]['USER_DISABLE_WARNING'] }&nbsp;!");
		  	 }
		  	  
		  	 if ( urlName == "invalid_license" ) {
		  		 $(".tishiBtn").click();
		  	     $(".markedWords").html("&nbsp;&nbsp;&nbsp;&nbsp;${ LANG[pageScope.lang]['INVALID_LICENSE'] }&nbsp;!");
		  	 }	  	 	  		  	
		  	 
		});
  	</script>
</body>
</html>