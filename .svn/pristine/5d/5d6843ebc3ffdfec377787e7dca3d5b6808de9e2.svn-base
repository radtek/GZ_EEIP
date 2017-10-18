<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="org.pangolin.eeip.common.Const" %>
<%@ page import="org.pangolin.eeip.common.CurrentUser" %>
<%@ page import="org.pangolin.eeip.util.SpringUtil" %>
<%@ page import="org.pangolin.eeip.entity.User" %>
<%@ page import="org.pangolin.eeip.entity.Document" %>
<%@ page import="org.pangolin.eeip.entity.Advertisement" %>
<%@ page import="org.pangolin.eeip.service.DocumentService" %>
<%@ page import="org.pangolin.eeip.service.AdvertisementService" %>
<%@ page import="org.pangolin.eeip.service.UserService" %>
<%!
public String getCookie(HttpServletRequest request) {
	try {
		Cookie[] cookies = request.getCookies();
		if ( cookies != null ) {
			for ( Cookie cookie : cookies ) {
				if ( cookie.getName().trim().equals(Const.LOGIN_USER_SESSION_NAME) ) {
					return cookie.getValue();
				}
			}
		}
	} catch(Exception ex) { ex.printStackTrace(); }
	return null;
}
%>
<%
String docId = "";
SpringUtil springUtil = new SpringUtil();

if ( session.getAttribute(Const.LOGIN_USER_SESSION_NAME) == null ) {
	String userName = getCookie(request);
	if ( userName != null && !userName.trim().equals("") ) {
		UserService userService = (UserService) springUtil.getBean("userService");
		User user = userService.getUserByName(userName);
		if ( user != null ) {
			CurrentUser currentUser = userService.getCurrentUser(user);
			session.setAttribute(Const.LOGIN_USER_SESSION_NAME, currentUser);
		}
	} else response.sendRedirect(request.getContextPath() + "/test/app/ionic/login.jsp");
}

DocumentService documentService = (DocumentService) springUtil.getBean("documentService");
List<Document> docList = documentService.getDocuments();
if ( docList != null && docList.size() > 0 ) docId = docList.get(0).getId();

AdvertisementService advertisementService = (AdvertisementService) springUtil.getBean("advertisementService");
List<Advertisement> advList = advertisementService.getAdvertisements();
%>
<!DOCTYPE html>
<html ng-app="demoApp">
  <head>
    <title>Home</title>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no,width=device-width,height=device-height">
    <link href="<c:url value="/resources/frameworks/ionic/css/ionic.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/test/app/ionic/css/home.css"/>" rel="stylesheet" />
	<script src="<c:url value="/resources/frameworks/ionic/js/ionic.bundle.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/test/app/ionic/js/common.js"/>"></script>
	<style type="text/css">
	  .slider {
	    height: 190px;
      }
      
      .slider-slide {
	    color: #000;
	    background-color: #fff;
	    height: 100%;
      }
	</style>
  </head>
  <body>
    <ion-header-bar class="bar-positive-demo" align-title="center">
      <h1 class="title">{{barTitle}}</h1>
      <button menu-toggle="right" class="button button-icon icon ion-more more-btn" ng-if="false" ng-controller="moreCtl" on-tap="onTap()"></button>
    </ion-header-bar>
    <ion-tabs class="tabs-default tabs-icon-top" ng-controller="tabCtl">
      <%-- HOME TAB --%>
      <ion-tab title="{{tabName1}}" icon-on="tab-info-ico" icon-off="tab-info-ico-outline" ng-click="selectTabWithIndex(0)">
        <ion-view>
          <ion-content>
		    <%-- ADVERTISEMENT --%>
			<ion-slide-box does-continue="true" auto-play="true" slide-interval="3000">
			  <%
			    for ( Advertisement adv : advList ) {
			    	%>
			    	<ion-slide>
                      <div class="box">
				        <img src="${pageContext.request.contextPath}/test/app/ionic/imageViewer.jsp?path=<%=adv.getPath() %>" style="width: 100%;" height="190"/>
			 	      </div>
                    </ion-slide>
			    	<%
			    }
			  %>
            </ion-slide-box>
			<%-- SUDOKU --%>
			<div class="sudoku">
			  <div class="row">
                <div class="col">
                  <div ng-controller="actionsheetCtl1">
                    <div><img class="fun-btn" src="${pageContext.request.contextPath}/test/app/ionic/images/icon_01.png" on-tap="onTap()"/></div>
                    <div><span>{{columnName}}</span></div>
	              </div>
                </div>
                <div class="col">
                  <div ng-controller="actionsheetCtl2">
				    <div><img class="fun-btn" src="${pageContext.request.contextPath}/test/app/ionic/images/icon_02.png" on-tap="onTap()"/></div>
				    <div><span>{{columnName}}</span></div>
	              </div>
                </div>
                <div class="col">
                  <div ng-controller="actionsheetCtl3">
				    <div><img class="fun-btn" src="${pageContext.request.contextPath}/test/app/ionic/images/icon_03.png" on-tap="onTap()"/></div>
				    <div><span>{{columnName}}</span></div>
	              </div>
                </div>
              </div>
			  <div class="row">
                <div class="col">
                  <div ng-controller="actionsheetCtl4">
			        <div><img class="fun-btn" src="${pageContext.request.contextPath}/test/app/ionic/images/icon_04.png" on-tap="onTap()"/></div>
			        <div><span>{{columnName}}</span></div>
	              </div>
                </div>
                <div class="col">
                  <div ng-controller="actionsheetCtl5">
				    <div><img class="fun-btn" src="${pageContext.request.contextPath}/test/app/ionic/images/icon_05.png" on-tap="onTap()"/></div>
			        <div><span>{{columnName}}</span></div>
	              </div>
                </div>
                <div class="col">
                  <div ng-controller="actionsheetCtl6" ng-if="displayActivities">
				    <div><img class="fun-btn" src="${pageContext.request.contextPath}/test/app/ionic/images/icon_06.png" on-tap="onTap()"/></div>
			        <div><span>{{columnName}}</span></div>
	              </div>
                </div>
              </div>
			</div>
          </ion-content>
        </ion-view>
      </ion-tab>
      <%-- FILE LIST TAB --%>
      <ion-tab title="{{tabName2}}" icon-on="tab-newspaper-ico" icon-off="tab-newspaper-ico-outline" ng-click="selectTabWithIndex(1)">
        <ion-view>
          <%--
          <ion-content scroll="true" overflow-scroll="true">
            <iframe src="${pageContext.request.contextPath}/test/app/ionic/previewPDF.jsp?id=<%=docId%>" style="width: 100%; height: 100%; border: 0px;"></iframe>
          </ion-content>
           --%>
          <ion-content has-header="true" ng-controller="listCtrl">
            <ion-refresher pulling-text="Loading" on-refresh="doRefresh()"></ion-refresher>
            <ion-list>
              <ion-item ng-repeat="info in infoList" href="${pageContext.request.contextPath}/test/app/ionic/fileViewer.jsp?id={{info.id}}">{{info.name}}</ion-item>
            </ion-list>
            <ion-infinite-scroll ng-if="loadmore" on-infinite="loadMoreData()"></ion-infinite-scroll>
          </ion-content>
        </ion-view>
      </ion-tab>
      <%-- QUESTIONNAIRE SURVEY TAB --%>
      <ion-tab title="{{tabName3}}" icon-on="tab-survey-ico" icon-off="tab-survey-ico-outline" ng-click="selectTabWithIndex(2)">
        <ion-view>
          <ion-content padding="true">
            <div style="text-align: center; width: 100%;">
              <img src="${pageContext.request.contextPath}/test/app/ionic/images/warning.png" style="width: 100px; height: 88px; margin-top: 50px;"/><br>
              <span>功能未開放</span>
            </div>
          </ion-content>
        </ion-view>
      </ion-tab>
      <%-- USER PROFILE TAB --%>
	  <ion-tab title="{{tabName4}}" icon-on="tab-profile-ico" icon-off="tab-profile-ico-outline" ng-click="selectTabWithIndex(3)">
        <ion-view>
          <ion-content padding="true">
            <div class="list">
              <a class="item item-icon-left" href="#">
                <i class="icon ion-ios-person"></i>${sessionScope.loginUser.userAlias}
              </a>
              
              <a class="item item-icon-left" href="#">
                <c:if test="${sessionScope.loginUser.userSex eq 0}">
                  <i class="icon ion-man"></i>男
                </c:if>
                <c:if test="${sessionScope.loginUser.userSex eq 1}">
                  <i class="icon ion-woman"></i>女
                </c:if>
              </a>
              
              <a class="item item-icon-left" href="#">
                <i class="icon ion-ios-location"></i>${sessionScope.loginUser.orgName}
              </a>

             <a class="item item-icon-left item-icon-right" href="#" ng-controller="cellphoneCtl" on-tap="onTap()" ng-if="false">
               <i class="icon ion-ios-telephone"></i>${sessionScope.loginUser.userCellphone}
               <i class="icon ion-ios-arrow-right"></i>
             </a>
             
             <a class="item item-icon-left" href="#">
                <i class="icon ion-ios-email"></i>${sessionScope.loginUser.userEmail}
              </a>

             <a class="item item-icon-left item-icon-right" href="#" ng-controller="pwdCtl" on-tap="onTap()">
               <i class="icon ion-ios-locked"></i>用戶密碼
               <i class="icon ion-ios-arrow-right"></i>
             </a>
           </div>
           <div class="padding" ng-controller="logoutCtl" on-tap="onTap()">
             <button class="button button-block button-positive logout-btn">系統登出</button>
           </div>
          </ion-content>
        </ion-view>
      </ion-tab>
    </ion-tabs>
    <script>
	  var app = angular.module('demoApp',['ionic']).run(function($rootScope, $timeout, $ionicLoading) {
		    $rootScope.barTitle = '主頁';
		    $rootScope.displayMore = false;
		    <%
		    if ( session.getAttribute("loginUser") != null ) {
		    	CurrentUser currentUser = (CurrentUser)session.getAttribute("loginUser");
		    	if ( currentUser.getUserType().intValue() == 0 ) {
		    		%>$rootScope.displayActivities = false;<%
		    	} else {
		    		%>$rootScope.displayActivities = true;<%
		    	}
		    }
		    %>
		    
		    $ionicLoading.show({
			    content: '數據加載中',
			    animation: 'fade-in',
			    showBackdrop: true,
			    maxWidth: 200,
			    showDelay: 0
			});
		    
		    $timeout(function () {
			    $ionicLoading.hide();
			}, 2000);
	  });
	  
	  ionicAppConfig(app);
	  
	  app.controller('tabCtl',function($scope, $rootScope, $ionicTabsDelegate) {
		  $scope.tabName1 = "主頁";
		  $scope.tabName2 = "勞聯報";
		  $scope.tabName3 = "調查問卷";
		  $scope.tabName4 = "個人中心";
		  
		  $scope.selectTabWithIndex = function(index) {
			  if ( index == 0 ) {
				  $rootScope.barTitle = '主頁';
				  $rootScope.displayMore = false;
			  }
			  if ( index == 1 ) {
				  $rootScope.barTitle = '勞聯報';
				  $rootScope.displayMore = true;
			  }
			  if ( index == 2 ) {
				  $rootScope.barTitle = '調查問卷';
				  $rootScope.displayMore = false;
			  }
			  if ( index == 3 ) {
				  $rootScope.barTitle = '個人中心';
				  $rootScope.displayMore = false;
			  }
			  $ionicTabsDelegate.select(index);
		  }
      });
	  
	  app.controller('moreCtl',function($scope) {
		  $scope.onTap = function() {
			  window.location.href = "fileList.jsp";
          };
      });
	  
	  app.controller('actionsheetCtl1',function($scope, $rootScope) {
		  $scope.columnName = "最新資訊";
		  $scope.onTap = function() {
			  window.location.href = "infoList.jsp?label=TYPE1";
          };
      });
	  
	  app.controller('actionsheetCtl2',function($scope, $rootScope) {
		  $scope.columnName = "權益資訊";
		  $scope.onTap = function() {
			  window.location.href = "infoList.jsp?label=TYPE2";
          };
      });
	  
	  app.controller('actionsheetCtl3',function($scope, $rootScope) {
		  $scope.columnName = "進修課程";
		  $scope.onTap = function() {
			  window.location.href = "infoList.jsp?label=TYPE3";
          };
      });
	  
	  app.controller('actionsheetCtl4',function($scope, $rootScope) {
		  $scope.columnName = "福利項目";
		  $scope.onTap = function() {
			  window.location.href = "infoList.jsp?label=TYPE4";
          };
      });
	  
	  app.controller('actionsheetCtl5',function($scope, $rootScope) {
		  $scope.columnName = "文康活動";
		  $scope.onTap = function() {
			  window.location.href = "infoList.jsp?label=TYPE5";
          };
      });
	  
	  app.controller('actionsheetCtl6',function($scope, $rootScope) {
		  $scope.columnName = "活動通知";
		  $scope.onTap = function() {
			  window.location.href = "infoList.jsp?label=TYPE6";
          };
      });
	  
	  app.controller('cellphoneCtl',function($scope, $ionicPopup, $timeout, $rootScope) {
		  $scope.onTap = function() {
			  /*$ionicPopup.show({
				  template: '<input id="cellphone" name="cellphone" type="text"/>',
		          title: 'System Notice',
		          subTitle: 'Enter your new cellphone number',
		             scope: $scope,
		             buttons: [{ 
		            	 text: 'Cancel',
		            	 type: 'button-light'
		             }, { 
		            	 text: '<b>Save</b>',
		            	 type: 'button-calm',
		                 onTap: function(e) {
		                	 alert("save!");
		                 }
		             }]
		      });*/
          };
      });
	  
	  app.controller('pwdCtl',function($scope) {
		  $scope.onTap = function() {
			  window.location.href = "resetPwd.jsp";
          };
      });
	  
	  app.controller('logoutCtl',function($scope, $ionicPopup, $timeout) {
		  $scope.onTap = function() {
			  $ionicPopup.show({
		          title: '系統提示',
		          subTitle: '確認是否登出系統 ?',
		             scope: $scope,
		             buttons: [{ 
		            	 text: '取消',
		            	 type: 'button-light'
		             }, { 
		            	 text: '<b>登出</b>',
		            	 type: 'button-assertive',
		                 onTap: function(e) {
		                	 window.location.href = "${pageContext.request.contextPath}/signout.action";
		                 }
		             }]
		      });
          };
      });
	  
	  //--------------------
	  app.controller('listCtrl', function($scope, $timeout, $ionicLoading, $http, $rootScope) {
		  $scope.loadmore = true;
		  $scope.infoList = [];
		  
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
			  $http.get("${pageContext.request.contextPath}/system/assessibility/document/documentGridCacheData.do").success(function(data) {
        		  girdData = data.documentList;
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
        	  $http.get("${pageContext.request.contextPath}/system/assessibility/document/documentGridCacheData.do").success(function(data) {
        		  girdData = data.documentList;
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