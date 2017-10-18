<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html ng-app="demoApp">
  <head>
    <title>FILE VIEWER</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
    <link href="<c:url value="/resources/frameworks/ionic/css/ionic.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/test/app/ionic/css/fileViewer.css"/>" rel="stylesheet" />
	<script src="<c:url value="/resources/frameworks/ionic/js/ionic.bundle.min.js"/>"></script>
  </head>
  <body>
    <ion-header-bar class="bar-positive-demo" align-title="center">
      <button menu-toggle="left" class="button button-icon icon ion-chevron-left back-btn" ng-controller="backCtl" on-tap="onTap()"></button>
      <h1 class="title">勞聯報</h1>
    </ion-header-bar>
    <ion-content has-header="true" scroll="true" overflow-scroll="true">
      <iframe src="${pageContext.request.contextPath}/test/app/ionic/previewPDF.jsp?id=${param.id}" 
                   style="width: 100%; height: 800px; border: 0px;"></iframe>
    </ion-content>
    <script>
	  var app = angular.module('demoApp',['ionic']);
	  
	  app.controller('backCtl',['$scope',function($scope){
		  $scope.onTap=function() {
			  window.location.href = "home.jsp";
		  }
	  }]);
    </script>
  </body>
</html>
