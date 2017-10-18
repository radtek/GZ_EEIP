<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>User Profile Form</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/font-awesome.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/userProfile.css" />" rel="stylesheet" />
    <!--[if lt IE 9]>
    <script src="<c:url value="/resources/frameworks/pangolin/js/selectivizr.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/respond.min.js" />" type="text/javascript"></script>
    <![endif]-->
    <style>
	  	.promptDiv {
	    	display: none;
	    	position: fixed;
	    	top: 0;
	    	left: 0;
	    	width: 100%;
	    	margin-left: 0;
		}
  	</style>
  </head>
  
  <body>
  <form>
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         <h4 class="modal-title" id="myModalLabel"><span class="fa fa-user"></span>&nbsp;&nbsp;${ LANG[sessionScope.loginUser.lang]['USER_PROFILE'] }</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
          <label class="col-xs-3 juyou input-item">${ LANG[sessionScope.loginUser.lang]['COL_USER_ALIAS'] }</label>
	      <div class="col-xs-7">
		    <input type="text" 
		           name="userName" 
		           data-bind="value:userAlias" 
		           class="form-control form_text_height illegalCharacter" 
		           placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_ALIAS'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" 
		           required />
	      </div>
        </div>
        <div class="form-group">
          <label class="col-xs-3 juyou input-item">${ LANG[sessionScope.loginUser.lang]['COL_USER_EMAIL'] }</label>
	      <div class="col-xs-7">
		    <input type="email" 
		           name="userEmail" 
		           data-bind="value:userEmail" 
		           class="form-control form_text_height email" 
		           placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_EMAIL'] }" />
	      </div>
        </div>
        <div class="form-group">
          <label class="col-xs-3 juyou input-item">${ LANG[sessionScope.loginUser.lang]['COL_USER_TEL'] }</label>
	      <div class="col-xs-7">
	        <input type="text" 
	               name="userTelephone" 
	               data-bind="value:userTelephone" 
	               class="form-control form_text_height officePhone" 
	               placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_TEL'] }" />
	      </div>
        </div>
        <div class="form-group">
	      <label class="col-xs-3 juyou input-item">${ LANG[sessionScope.loginUser.lang]['COL_USER_FAX'] }</label>
	      <div class="col-xs-7">
	        <input type="text" 
	               name="userFax" 
	               data-bind="value:userFax" 
	               class="form-control form_text_height fax" 
	               placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_FAX'] }" />
	      </div>
        </div>
        <div class="form-group">
	      <label class="col-xs-3 juyou input-item">${ LANG[sessionScope.loginUser.lang]['COL_USER_CELLPHONE'] }</label>
	      <div class="col-xs-7">
	        <input type="text" 
	               name="userCellphone" 
	               data-bind="value:userCellphone" 
	               class="form-control form_text_height cellphone" 
	               placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_CELLPHONE'] }" />
	      </div>
        </div>
        <div class="form-group">
	      <label class="col-xs-3 juyou input-item">${ LANG[sessionScope.loginUser.lang]['COL_USER_ADDR'] }</label>
	      <div class="col-xs-7">
	        <input type="text" 
	               name="userAddress" 
	               data-bind="value:userAddress" 
	               class="form-control form_text_height illegalCharacter" 
	               placeholder="${ LANG[sessionScope.loginUser.lang]['COL_USER_ADDR'] }" />
	      </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" 
                class="btn btn-default btnWidth" 
                data-bind="click: closeDiv"  
                data-dismiss="modal">${ LANG[sessionScope.loginUser.lang]['BTN_CLOSE'] }</button>
      
        <button type="button" 
                class="btn btn-primary btnWidth" 
                data-bind="click: saveData">${ LANG[sessionScope.loginUser.lang]['BTN_SAVE_DATA'] }</button>
        
        <input type="hidden" name="userId" data-bind="value:userId" />
      </div>
    </div>
  </form>
  
  <jsp:include page="/common/alertMessages.jsp"></jsp:include>
  
  <script type="text/javascript">
  $(function() {
	  var data = loadData("${pageContext.request.contextPath}/system/user/loadUserData.do", { "userId" : "${sessionScope.loginUser.userId}" });
      var vm = ko.mapping.fromJS(data);
 
      vm.saveData =function() {
    	  if ( validateSubmittedData() ) {
    		  if ( saveData("${pageContext.request.contextPath}/system/user/saveUserProfileData.do", vm)) {
    			  window.parent.notlock2();
        	  }
    	  }
      }
      
      $(".close").click(function(){
    	  window.parent.notlock2();
      });
    
      vm.closeDiv = function(){
    	  window.parent.notlock2();
      }
      
      ko.applyBindings(vm);
  })
  </script>
</body>
</html>