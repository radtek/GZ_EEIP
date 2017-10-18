<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8"/>
    <title>Home Page</title>
  </head>
  <body>
    <c:forEach items="${sessionScope.loginUser.roles}" var="item">
      <c:if test="${item.key eq 'ROLE_ADMIN'}">
        <c:redirect url="/system/org/orgList.do"></c:redirect>
      </c:if>
      
      <c:if test="${item.key eq 'ROLE_SC_ADMIN'}">
        <c:redirect url="/operation/console/serviceCounterConsole.do"></c:redirect>
      </c:if>
      
      <c:if test="${item.key eq 'ROLE_ENGINEER'}">
        <c:redirect url="/operation/console/engineerConsole.do"></c:redirect>
      </c:if>
      
      <c:if test="${item.key eq 'ROLE_EVENT_ADMIN'}">
        <c:redirect url="/operation/event/eventList.do"></c:redirect>
      </c:if>
      
      <c:if test="${item.key eq 'ROLE_MISSION_ADMIN'}">
        <c:redirect url="/operation/mission/missionList.do"></c:redirect>
      </c:if>
      
      <c:if test="${item.key eq 'ROLE_KB_ADMIN'}">
        <c:redirect url="/operation/knowledge/knowledgeList.do"></c:redirect>
      </c:if>
      
      <c:if test="${item.key eq 'ROLE_ASSET_ADMIN'}">
        <c:redirect url="asset/assetInfo/hardwareList.do"></c:redirect>
      </c:if>
      
      <c:if test="${item.key eq 'ROLE_ASSET_REGISTRAR'}">
        <c:redirect url="asset/assetInfo/hardwareList.do"></c:redirect>
      </c:if>
    </c:forEach>
  </body>
</html>