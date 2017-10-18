<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Document List</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.download.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/modal-common.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/listStyle.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/modal-common.css" />" rel="stylesheet">
  </head>
  <body>
    <div class="panel panel-default">
      <div class="panel-heading">
        <button type="button" class="btn btn-info select_add">${ LANG[sessionScope.loginUser.lang]['ADD_DOC_DATA'] }</button>
      </div>
      
      <div class="panel-body">
        <table class="table" id="table2">
          <thead>
            <tr>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_ID'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_DOC_NAME'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_CREATED_DATE'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_MODIFIED_DATE'] }</th>
              <th>${ LANG[sessionScope.loginUser.lang]['COL_OPERATION'] }</th>
            </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
      </div>
    </div>
    
    <%-- System Notice Modal --%>
    <jsp:include page="/common/commonModal.jsp"></jsp:include>
  
    <input type="hidden" id="rmDocId" />
    <input type="hidden" id="rmDocName" />
    
    <script type="text/javascript">
      $(function() {
    	  $(".select_add").click(function() {
    		  $(".iframes", window.parent.document).attr("src", "${pageContext.request.contextPath}/system/assessibility/document/documentInfoForm.do");
	      });
    	
          loadGridData();
        
          //数据表操作列
    	  function getOperationCol(data, type, row) {
        	  var html = "";
    		  html += "<div class=\"sansan\" onclick=\"download('${pageContext.request.contextPath}/system/assessibility/document/documentDataDownload.do', { 'id' : '" + row.id + "' });\"><span class='shoushi jurisdictionBtn'>${ LANG[sessionScope.loginUser.lang]['BTN_DOWNLOAD_DATA'] }</span></div>";
    		  html += "<div class=\"sansan\" onclick=\"dataTable.editData({ 'id' : '" + row.id + "' });\"><span class='shoushi modifyBtn'>${ LANG[sessionScope.loginUser.lang]['BTN_EDIT_DATA'] }</span></div>";
              //html += "<div class=\"sansan\" onclick=\"dataTable.rmData({ 'id' : '" + row.id + "' }, function() { dataTable.reloadData(); }, function() { dataTable.reloadData(); });\"><span class='shoushi deleteBtn'>${ LANG[sessionScope.loginUser.lang]['BTN_RM_DATA'] }</span></div>";
              html += "<div class=\"sansan\" data-toggle=\"modal\" data-target=\"#sysNoticePopup\" onclick=\"setRemovedDocParam('" + row.id + "', '" + row.name + "');\"><span class='shoushi deleteBtn'>${ LANG[sessionScope.loginUser.lang]['BTN_RM_DATA'] }</span></div>";
              return html;
          }
        
          //加载列表数据
          function loadGridData() {
        	  //数据列绑定
    	      var columns = [
    	          { "mData" : "id", "bSortable" : false, "bVisible" : false },
                  { "mData" : "name", "bSortable" : true },
                  { "mData" : "createdDate", "bSortable" : true, "mRender": getFormattedDate },
                  { "mData" : "modifiedDate", "bSortable" : true,  "mRender": getFormattedDate },
                  { "mData" : null , "bSortable" : false,  "mRender": getOperationCol ,"sWidth": "150px"}
              ];
        	
    	      //排序规则
              var sorting = [ [ 2, 'desc' ] ];
    	  
    	      //扩展参数
              var extraParams = [];
          
              //初始化数据表
              dataTable = new BSDataTable();
              dataTable.initialize({
                  "tableId" : "table2",
                  "columns" : columns,
                  "sorting" : sorting,
                  "pageSize" : DEFAULT_PAGE_SIZE,
                  "dataSource" : "${pageContext.request.contextPath}/system/assessibility/document/documentInfoGridData.do",
                  "extraParams" : extraParams,
                  "style" : DT_FULL_NUMBERS,
                  "bProcessing" : true,
                  "url" : {
            	      "addDataUrl" : "${pageContext.request.contextPath}/system/assessibility/document/documentInfoForm.do",
        		      "editDataUrl" : "${pageContext.request.contextPath}/system/assessibility/document/documentInfoForm.do",
        		      "rmDataUrl" : "${pageContext.request.contextPath}/system/assessibility/document/removeDocumentInfoData.do"
    	          }
    	      });
            
              //隐藏列表组件显示条数
              $('#table2_length').hide();
          }
      });
      
      function setRemovedDocParam(docId, docName) {
    	  $("#rmDocId").val(docId);
	      $("#rmDocName").val(docName);
	      setSystemNoticeContent("${ LANG[sessionScope.loginUser.lang]['RM_DOC_NOTICE'] }&nbsp;"+$("#rmDocName").val()+"&nbsp;?");
      }
      
      initSystemNoticePopup(function() {
    	  dataTable.rmData({ 'id' : $("#rmDocId").val() }, function() { dataTable.reloadData(); }, function() { dataTable.reloadData(); });
      });
    </script>
  </body>
</html>