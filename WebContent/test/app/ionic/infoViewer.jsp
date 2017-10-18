<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html ng-app="demoApp">
  <head>
    <title>INFO CONTENT VIEWER</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
    <link href="<c:url value="/resources/frameworks/ionic/css/ionic.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/test/app/ionic/css/infoViewer.css"/>" rel="stylesheet" />
	<script src="<c:url value="/resources/frameworks/ionic/js/ionic.bundle.min.js"/>"></script>
  </head>
  <body>
    <ion-header-bar class="bar-positive-demo" align-title="center">
      <button menu-toggle="left" class="button button-icon icon ion-chevron-left back-btn" ng-controller="backCtl" on-tap="onTap()"></button>
      <h1 class="title">{{barTitle}}</h1>
    </ion-header-bar>
    <ion-content has-header="true" scroll="true" overflow-scroll="true" ng-controller="contentCtrl">
      <div id="noteContent"></div>
    </ion-content>
    <script>
	  var app = angular.module('demoApp',['ionic']).run(function($rootScope) {
		    $rootScope.barTitle = 'Content Viewer';
	  });
	  
	  app.controller('backCtl',['$scope',function($scope) {
		  $scope.onTap=function() {
			  window.location.href = "infoList.jsp?label=${param.label}";
		  }
	  }]);
	  
	  app.controller('contentCtrl', function($scope, $timeout, $ionicLoading, $http, $rootScope) {
		  
		// Set bar title
		  $http.get("${pageContext.request.contextPath}/system/notification/loadNotificationTypeCacheData.do?label=${param.label}").success(function(data) {
			  $rootScope.barTitle = data.entity.name;
          }).finally(function() {
        	  
          });
		  
		  // Setup the loader
		  $ionicLoading.show({
			  content: 'Loading',
		      animation: 'fade-in',
		      showBackdrop: true,
		      maxWidth: 200,
		      showDelay: 0
		  });
		  
		  // Set a timeout to clear loader, however you would actually call the $ionicLoading.hide(); method whenever everything is ready or loaded.
		  $timeout(function () {
			  $http.get("${pageContext.request.contextPath}/system/notification/notificationContentCacheData.do?id=${param.id}").success(function(data) {
				  document.getElementById("noteContent").innerHTML = data.content;
              }).finally(function() {
            	  $ionicLoading.hide();
              });
		  }, 1000);
		  
		});
    </script>
  </body>
</html>
