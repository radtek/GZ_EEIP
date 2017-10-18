<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html ng-app="demoApp">
  <head>
    <title>RESET PWD</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
    <link href="<c:url value="/resources/frameworks/ionic/css/ionic.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/test/app/ionic/css/setpwd.css"/>" rel="stylesheet" />
	<script src="<c:url value="/resources/frameworks/ionic/js/ionic.bundle.min.js"/>"></script>
  </head>
  <body>
    <ion-header-bar class="bar-positive-demo" align-title="center">
      <button menu-toggle="left" class="button button-icon icon ion-chevron-left back-btn" ng-controller="backCtl" on-tap="onTap()"></button>
      <h1 class="title">密碼設定</h1>
    </ion-header-bar>
    <ion-content has-header="true" ng-controller="pwdCtl">
      <div class="list list-inset">
        <label class="item item-input">
          <div class="input-label">用戶帳號</div>${sessionScope.loginUser.userName}
        </label>
        <label class="item item-input">
          <div class="input-label">用戶原密碼</div>
          <input type="password" placeholder="用戶原密碼" ng-model="originalPwd" />
        </label>
        <label class="item item-input">
          <div class="input-label">用戶新密碼</div>
          <input type="password" placeholder="用戶新密碼" ng-model="newPwd" />
        </label>
        <label class="item item-input">
          <div class="input-label">確認新密碼</div>
          <input type="password" placeholder="確認新密碼" ng-model="confirmPwd" />
        </label>
      </div>
      <div class="padding">
        <button class="button button-block button-calm" on-tap="onTap()">重置</button>
      </div>
    </ion-content>
    <script>
	  var app = angular.module('demoApp',['ionic']);
	  
	  app.controller('backCtl',['$scope',function($scope) {
		  $scope.onTap=function() {
			  window.location.href = "home.jsp";
		  }
	  }]);
	  
	  app.controller('pwdCtl',function($scope, $http) {
		  $scope.onTap = function() {
			  $http.post('${pageContext.request.contextPath}/system/user/resetUserPwdData.do', {
				  userId : "${sessionScope.loginUser.userId}",
				  originalPassword : $scope.originalPwd,
				  newPassword : $scope.newPwd,
				  confirmPassword : $scope.confirmPwd
		      }).success(function(data) {
		    	  if ( data.status ) {
		    		  window.location.href = "resetPwdSuccess.jsp";
		    	  } else {
		    		  window.location.href = "resetPwdFailure.jsp";
		    	  }
		      });
          };
      });
    </script>
  </body>
</html>