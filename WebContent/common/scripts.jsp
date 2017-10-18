<%-- <script src="<c:url value="/resources/javascript/chinese.js" />"></script> --%>
<c:forEach items="${sessionScope.loginUser.roles}" var="item">
  <c:set var="currentRoleName" value="${item.key}" scope="page" />
    <script type="text/javascript">
      CURRENT_ROLE_ID = "${item.value}";
      CURRENT_ROLE_NAME = "${ROLE_NAME[currentRoleName]}";
      CURRENT_ROLE_LABEL = "${currentRoleName}";
    </script>
</c:forEach>
<script type="text/javascript">
  CURRENT_ORG_ID = "${sessionScope.loginUser.orgId}";
  CURRENT_ORG_NAME = "${sessionScope.loginUser.orgName}";
</script>