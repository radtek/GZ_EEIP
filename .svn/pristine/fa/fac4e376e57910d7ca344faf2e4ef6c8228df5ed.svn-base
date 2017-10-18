<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html ng-app="demoApp">
  <head>
    <title>Register</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
    <link href="<c:url value="/resources/frameworks/ionic/css/ionic.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/test/app/ionic/css/register.css"/>" rel="stylesheet" />
	<script src="<c:url value="/resources/frameworks/ionic/js/ionic.bundle.min.js"/>"></script>
	<style type="text/css">
	  .required-item {
	    font-size: 14px;
	    color: red;
	    margin-left: 4px;
	  }
	</style>
  </head>
  <body>
    <ion-header-bar class="bar-positive-demo" align-title="center">
      <button menu-toggle="left" class="button button-icon icon ion-chevron-left back-btn" ng-controller="backCtl" on-tap="onTap()"></button>
      <h1 class="title">用戶註冊</h1>
    </ion-header-bar>
    <ion-content has-header="true" ng-controller="regCtl">
      <form name="regForm" ng-submit="submitForm(regForm.$valid)" novalidate>
      <div class="list list-inset">
        <label class="item item-input">
          <div class="input-label">用戶帳號<span class="required-item">*</span></div>
          <input type="text" placeholder="手提電話" ng-model="userName" required/>
        </label>
        <label class="item item-input">
          <div class="input-label">用戶姓名<span class="required-item">*</span></div>
          <input type="text" placeholder="中文姓名" ng-model="userAlias" required/>
        </label>
        <div class="item item-input item-select">
          <div class="input-label">用戶性別<span class="required-item">*</span></div>
          <select ng-model="userSex" required>
            <option value="0">男</option>
            <option value="1">女</option>
          </select>
        </div>
        <label class="item item-input" ng-if="false">
          <div class="input-label">身份證<span class="required-item">*</span></div>
          <input type="text" placeholder="身份證" ng-model="userIdCard" required/>
        </label>
        <label class="item item-input">
          <div class="input-label">電子郵件</div>
          <input type="text" placeholder="電子郵件" ng-model="userEmail" />
        </label>
        <label class="item item-input" ng-if="false">
          <div class="input-label">手提電話</div>
          <input type="text" placeholder="手提電話" ng-model="userCellphone" />
        </label>
        <div class="item item-input item-select" ng-controller="orgCtl">
          <div class="input-label">所屬地區<span class="required-item">*</span></div>
          <select id="orgOtions">
            <option ng-repeat="org in orgList" value="{{org.orgId}}">{{org.orgName}}</option>
          </select>
        </div>
        <label class="item item-input">
          <div class="input-label">帳號密碼<span class="required-item">*</span></div>
          <input type="password" placeholder="用戶密碼" ng-model="userPwd" required/>
        </label>
        <label class="item item-input">
          <div class="input-label">確認密碼<span class="required-item">*</span></div>
          <input type="password" placeholder="確認密碼" ng-model="userConfirmPwd" required/>
        </label>
      </div>
      <div class="padding">
        <button type="submit" class="button button-block button-positive reg-btn">註冊</button>
      </div>
      </form>
    </ion-content>
    <script>
	  var app = angular.module('demoApp',['ionic']);
	  
	  app.controller('backCtl',['$scope',function($scope){
		  $scope.onTap=function() {
			  window.location.href = "login.jsp";
		  }
	  }]);
	  
	  app.controller('regCtl',function($scope, $http, $ionicPopup) {
		  $scope.userSex = "0";
          
          $scope.submitForm = function(isValid) {
              // check to make sure the form is completely valid
              if (isValid) {
            	  if ( $scope.userPwd != $scope.userConfirmPwd ) {
            		  $ionicPopup.show({
        		          title: '系統提示',
        		          subTitle: "兩次填入的密碼必須一致",
        		             scope: $scope,
        		             buttons: [{ 
        		            	 text: '確認',
        		            	 type: 'button-light'
        		             }]
        		      });
            	  } else {
            		  $http.post('${pageContext.request.contextPath}/registerUserData.do', {
    					  userName : $scope.userName,
    					  userAlias : $scope.userAlias,
    					  userSex : $scope.userSex,
    					  //userIdCard : $scope.userIdCard,
    					  userEmail : $scope.userEmail,
    					  //userCellphone : $scope.userCellphone,
    					  userCellphone : $scope.userName,
    					  userPwd : $scope.userPwd,
    					  userConfirmPwd : $scope.userConfirmPwd,
    					  orgId : document.getElementById("orgOtions").value
    			      }).success(function(data) {
    			    	  if ( data.status ) {
    			    		  window.location.href = "regSuccess.jsp";
    			    	  } else {
    			    		  window.location.href = "regFailure.jsp";
    			    	  }
    			      });
            	  }
              } else {
            	  var text = "";
            	  if ( $scope.userName == undefined || $scope.userName == "" ) text = "用戶帳號必須填寫";
            	  else if ( $scope.userAlias == undefined || $scope.userAlias == "" ) text = "用戶姓名必須填寫";
            	  else if ( $scope.userSex == undefined || $scope.userSex == "" ) text = "用戶性別必須選擇";
            	  else if ( $scope.userIdCard == undefined || $scope.userIdCard == "" ) text = "身份證必須填寫";
            	  else if ( $scope.userPwd == undefined || $scope.userPwd == "" ) text = "帳號密碼必須填寫";
            	  else if ( $scope.userConfirmPwd == undefined || $scope.userConfirmPwd == "" ) text = "確認密碼必須填寫";
            	  
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
          };
      });
	  
	  app.controller('orgCtl',function($scope, $http) {
		  var orgData = [];
		  $scope.orgList = [];
		  
		  $http.get("${pageContext.request.contextPath}/orgOptionsData.do").success(function(data) {
			  orgData = data.entity;
        	  for ( var i = 0; i < orgData.length; i++ ) $scope.orgList.push(orgData[i]);
          });
      });
    </script>
  </body>
</html>
