<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html ng-app="demoApp">
  <head>
    <title>INFO LIST</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
    <link href="<c:url value="/resources/frameworks/ionic/css/ionic.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/test/app/ionic/css/infoList.css"/>" rel="stylesheet" />
	<script src="<c:url value="/resources/frameworks/ionic/js/ionic.bundle.min.js"/>"></script>
  </head>
  <body>
    <ion-header-bar class="bar-positive-demo" align-title="center">
      <button menu-toggle="left" class="button button-icon icon ion-chevron-left back-btn" ng-controller="backCtl" on-tap="onTap()"></button>
      <h1 class="title">{{barTitle}}</h1>
    </ion-header-bar>
    <ion-content has-header="true" ng-controller="listCtrl">
      <ion-refresher pulling-text="Loading" on-refresh="doRefresh()"></ion-refresher>
      <ion-list>
        <ion-item ng-repeat="info in infoList" href="infoViewer.jsp?id={{info.id}}&label=${param.label}">{{info.title}}</ion-item>
      </ion-list>
      <ion-infinite-scroll ng-if="loadmore" on-infinite="loadMoreData()"></ion-infinite-scroll>
    </ion-content>
    <script>
	  var app = angular.module('demoApp',['ionic']).run(function($rootScope) {
		    $rootScope.barTitle = '';
	  });
	  
	  app.controller('backCtl',['$scope',function($scope) {
		  $scope.onTap=function() {
			  window.location.href = "home.jsp";
		  }
	  }]);
	  
	  app.controller('listCtrl', function($scope, $timeout, $ionicLoading, $http, $rootScope) {
		  $scope.loadmore = true;
		  $scope.infoList = [];
		  
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
			  $ionicLoading.hide();
		  }, 1000);
		  
		  // Refresh list item.
		  $scope.doRefresh = function() {
			  var girdData = [];
			  $scope.infoList = []; //clear data
			  $http.get("${pageContext.request.contextPath}/system/notification/notificationGridCacheData.do?label=${param.label}").success(function(data) {
        		  girdData = data.notificationList;
        		  if ( girdData.length == 0 ) { $scope.loadmore = false; }
            	  for ( var i = 0; i < girdData.length; i++ ) $scope.infoList.push(girdData[i]);
              }).finally(function() {
                  $scope.$broadcast('scroll.refreshComplete');
              });
			  
			  $scope.$broadcast('scroll.refreshComplete');
          };
          
          // Load more data
          $scope.loadMoreData = function() {
        	  var girdData = [];
        	  $http.get("${pageContext.request.contextPath}/system/notification/notificationGridCacheData.do?label=${param.label}").success(function(data) {
        		  girdData = data.notificationList;
        		  if ( girdData.length == 0 ) { $scope.loadmore = false; }
            	  for ( var i = 0; i < girdData.length; i++ ) $scope.infoList.push(girdData[i]);
              }).finally(function() {
            	  $scope.$broadcast('scroll.infiniteScrollComplete');
              });
        	  
        	  if ( girdData.length == 0 ) { $scope.loadmore = false; }
        	  for ( var i = 0; i < girdData.length; i++ ) $scope.infoList.push(girdData[i]);
        	  
        	  $scope.$broadcast('scroll.infiniteScrollComplete');
		  }
          
	  });
    </script>
  </body>
</html>
