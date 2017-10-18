<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html ng-app="demoApp">
  <head>
    <title>System Login</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
    <link href="<c:url value="/resources/frameworks/ionic/css/ionic.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/test/app/ionic/css/login.css"/>" rel="stylesheet" />
	<script src="<c:url value="/resources/frameworks/ionic/js/ionic.bundle.min.js"/>"></script>
  </head>
  <body>
    <ion-header-bar class="bar-positive-demo" align-title="center">
      <h1 class="title">用戶登錄</h1>
    </ion-header-bar>
    <ion-content has-header="true" ng-controller="loginCtl">
      <form action="${pageContext.request.contextPath}/signin.action" method="post">
        <%-- LOGO --%>
        <div class="system-logo">
          <img src="${pageContext.request.contextPath}/test/app/ionic/images/logo.png" />
        </div>
        <%-- FORM ITEMS --%>
        <div class="list list-inset">
          <label class="item item-input">
            <input type="text" name="username" placeholder="手提電話">
          </label>
          <label class="item item-input">
            <input type="password" name="password" placeholder="用戶密碼">
          </label>
        </div>
        <div class="padding">
          <button type="submit" class="button button-block button-positive login-btn">登錄</button>
        </div>
        <div class="padding">
          <span class="left" ng-controller="regCtl" on-tap="onTap()">用戶註冊</span>
          <span class="right" ng-controller="resetPwdCtl" on-tap="onTap()" ng-if="false">忘記密碼</span>
        </div>
        
        <%-- Navigator type, 1 is navigator of cellphone --%>
        <input type="hidden" name="navigatorType" value="1"/>
        <input type="hidden" name="rememberMe" id="rememberMe" value="1"/>
      </form>
    </ion-content>
    <script>
	  var app = angular.module('demoApp',['ionic']);
	  
	  app.controller('regCtl',['$scope',function($scope) {
		  $scope.onTap=function() {
			  window.location.href = "register.jsp";
		  }
	  }]);
	  
	  app.controller('resetPwdCtl',['$scope',function($scope) {
		  $scope.onTap=function() {
			  window.location.href = "resetPwd.jsp";
		  }
	  }]);
	  
	  app.controller('loginCtl',function($scope, $ionicPopup) {
		  var opCode= "${param.action}";
		  
		  if ( opCode != "" ) {
			  var text = "";
			  if ( opCode == "user_disabled" ) text = "用戶帳號已禁用";
			  if ( opCode == "user_info_error" ) text = "登錄用戶數據有誤";
			  if ( opCode == "invalid_license" ) text = "系統許可證書已過期";
			  
			  $ionicPopup.show({
		          title: '系統提示',
		          subTitle: text,
		             scope: $scope,
		             buttons: [{ 
		            	 text: '確認',
		            	 type: 'button-light'
		             }]
		      });
		  }
      });
    </script>
  </body>
</html>
