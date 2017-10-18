<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html ng-app="demoApp">
  <head>
    <title>RESET PWD FAILURE</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
    <link href="<c:url value="/resources/frameworks/ionic/css/ionic.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/test/app/ionic/css/infoViewer.css"/>" rel="stylesheet" />
	<script src="<c:url value="/resources/frameworks/ionic/js/ionic.bundle.min.js"/>"></script>
  </head>
  <body>
    <ion-header-bar class="bar-positive-demo" align-title="center">
      <h1 class="title">系統資訊</h1>
    </ion-header-bar>
    <ion-content has-header="true" padding="true">
      <div style="text-align: center; width: 100%;">
        <img src="${pageContext.request.contextPath}/test/app/ionic/images/failure.png" style="width: 100px; height: 100px; margin-top: 50px;"/><br><br>
        <span style="font-size: 20px;">重置失敗</span><br><br><br><br>
        <button class="button button-block button-positive done-btn" ng-controller="doneCtrl" on-tap="onTap()">確認</button>
      </div>
    </ion-content>
    <script>
      var app = angular.module('demoApp',['ionic']);
	  
	  app.controller('doneCtrl', function($scope) {
		  $scope.onTap = function() {
			  window.location.href = "home.jsp";
          };
	  });
    </script>
  </body>
</html>