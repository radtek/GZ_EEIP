<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>User Password Form</title>
    <meta charset="utf-8"/>
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" /> 
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>    
    <script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>   
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet">    
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <!--[if lt IE 9]>
    <script src="<c:url value="/resources/frameworks/pangolin/js/selectivizr.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/respond.min.js" />" type="text/javascript"></script>
    <![endif]-->    
  </head>
  <style>
      h4 { 
  	    font-size:16px;
  	  }
  	  
  	  .form-group {
	    height: 60px;
	    line-height: 40px;
	    padding: 10px 0;
	    margin-bottom:0;
      }
      
      .form-control {
        height:40px;
      }
  	  
  	  .juyou { 
  	    text-align:right;
  	  }
  	  
  	  .wk { 
  	    display:none; 
  	    color:red;
  	  }
	  
	  .modal-content {
	    border:none;
	    border-radius: 0px;
	    -webkit-box-shadow: 0 3px 9px rgba(0,0,0,0);
	    box-shadow: 0 3px 9px rgba(0,0,0,0);
	  }
	  
	  .btnWidth {
	    padding-left: 35px;
	    padding-right: 35px;
	    height:35px;
	  }
	  
	  .promptDiv {
	    	display: none;
	    	position: fixed;
	    	top: 0;
	    	left: 0;
	    	width: 100%;
	    	margin-left: 0;
		}
  </style>
  <body>
    <form>
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h4 class="modal-title" id="myModalLabel"><span class="fa fa-user title-icon"></span>&nbsp;&nbsp;密码修改</h4>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <div class="col-xs-3 juyou" >原密码</div>
        	<div class="col-xs-7" >
        	  <input type="password" class="form-control"  data-bind="value: originalPassword" placeholder="用户原密码" required></input>
        	</div>
        	<div class="col-xs-2 wk" ></div>
          </div>
          <div class="form-group">
            <div class="col-xs-3 juyou">新密码</div>
        	<div class="col-xs-7">
        	  <input type="password" class="form-control newPassword" data-bind="value: newPassword" placeholder="用户新密码" required></input>
        	</div>
        	<div class="col-xs-2 wk" ></div>
          </div>
          <div class="form-group">
            <div class="col-xs-3 juyou">确认新密码</div>
        	<div class="col-xs-7">
        	  <input type="password" class="form-control confirmPassword" data-bind="value: confirmPassword" placeholder="确认新密码" required></input>
        	</div>
        	<div class="col-xs-2 wk" ></div>
          </div>
        </div>
        
        <div class="modal-footer">
          <button type="button" class="btn btn-default btnWidth" data-dismiss="modal" data-bind="click:closeDiv">关闭</button>
         
     	  <button type="button" class="btn btn-primary btnWidth" data-bind="click: saveData" data-toggle="modal" data-target="#sysNoticePopup">保存</button>
     	  
     	  <input type="hidden" name="userId" data-bind="value: userId" />
        </div>
      </div>
    </form>
    
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
  </body>
  <script type="text/javascript">
  $(function() {
	  var data = {
		     "originalPassword" : "", 
		     "newPassword" : "",
		     "confirmPassword" : "",
		     "userId" : "${sessionScope.loginUser.userId}"
	  };
	  
      var vm = ko.mapping.fromJS(data);
 
      vm.saveData =function() {
    	  if ( validateSubmittedData() ) {
    		  var newPwd=$(".newPassword").val();
    		  var confirmPwd=$(".confirmPassword").val(); 
    		  if(newPwd!=confirmPwd){
    			  //alert("密码不一致"); 
    			  saveFailure("两次输入的新密码不一致。");
    			  return false;
    		  }
    		  if ( saveData("${pageContext.request.contextPath}/system/user/resetUserPwdData.do", vm) ) {
    			/*   window.parent.notlock(); */
    			  //alert("修改成功！请重新登录！");
    			  saveFailure("修改成功！请重新登录！");
    			  setTimeout(function(){
    				  window.parent.location.href = "${pageContext.request.contextPath}/signout.action";
    				},2000); 
    			  
    			 // window.location.href = "${pageContext.request.contextPath}/login.jsp";
    			  //location.reload();
    		  }else{
    			  //alert("密码错误，修改失败!");
    			  saveFailure("密码错误，修改失败!");
    		  }
    	  }else{
    		  saveFailure("表单没填写完。");
    	  }
      }
      
      $(".close").click(function() {
    	  window.parent.notlock();
      });
    
      vm.closeDiv = function(){
    	  window.parent.notlock();
      }
      
      ko.applyBindings(vm);
      
  });
  </script>
</html>