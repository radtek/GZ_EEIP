<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>固定资产报废申请</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
</head>
<body style="width:100%;">
     <div class="main-content">       
    
         <div class="form-content">
             <form class="form-horizontal">
                <div class="form-group">
                	<label class="col-sm-2 control-label">文件编号：</label>
	                <div class="col-sm-4" >
	                    <input type="text" placeholder="" class="form-control" data-bind="value:sn" readonly/>
	                </div>
                	<label class="col-sm-2 control-label">文件名称：</label>
	                <div class="col-sm-4" >
	                    <input type="text" placeholder="" class="form-control" data-bind="value:name"  readonly/>
	                </div>
            	</div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">文件类型：</label>
	                <div class="col-sm-4" >
	                    <select class="form-control dirSelect" data-bind="value:dirId"  disabled>
	                        
	                    </select>
	                </div>
	                <label class="col-sm-2 control-label">年份：</label>
	                <div class="col-sm-4" >
	                    <input type="text" placeholder="" class="form-control" data-bind="value:year" readonly/>
	                </div>
	            </div>
	            <div class="form-group relationship">
	                <label class="col-sm-2 control-label">关联文件：</label>
	                <div class="col-sm-10">
	                	 <div class="associated-file-area">
	                    	<!-- <li><p>去为请问请去为请问请驱蚊器委屈翁去为请问请翁请问请问请问而且委屈翁而且委屈翁群无额</p></li>
	                    	<li><p>去为请问请去为请问请驱蚊器</p></li>
	                    	<li><p>去为请问请去为请问请驱蚊器委屈翁去为请问请翁请问请问请问而且委屈翁而且委屈翁群无额</p></li>
	                    	<li><p>去为请问请去为请问请驱蚊器委屈翁去为请问请翁请问请问请问而且委屈翁而且委屈翁群无额</p></li> -->
	                    </div>
	                </div>
	            </div>
          </form>
       </div>
                
       <div class="btn-content">
       	  <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
          <button class="btn btn-color1 download"><i class="fa fa-download"></i>下载</button>               
       </div>
    </div>
   
    <script>
  
    var docData = loadData("${pageContext.request.contextPath}/system/assessibility/document/loadDocumentInfoData.do", { "id" : "${param.id}" });
    if ( "${param.status}" == 1 ) {
    	docData = loadData("${pageContext.request.contextPath}/docHistory/loadDocHistoryData.do", { "id" : "${param.id}" });
    	$(".relationship").hide();
    }
    var vm = ko.mapping.fromJS(docData);
    var documents = docData.documents;
    
    var dirData = loadData("${pageContext.request.contextPath}/directory/directoryGridData.do", {});
    
    var dirHtml = '';
    for ( var i = 0; i < dirData.length; i++ ) {
    	dirHtml += '<option value="'+dirData[i]['id']+'">'+dirData[i]['name']+'</option>';
    }
    
    $(".dirSelect").html(dirHtml);
    
    ko.applyBindings(vm); 
    
    //复写
	if ( documents.length > 0 ) {
		for ( var i=0; i < documents.length; i++) {
			$(".associated-file-area").prepend("<li><p id='"+ documents[i]['id'] +"'>"+ documents[i]['name'] +"</p></li>");
		}
	}
        
    $(".download").click(function() {
    	if ( "${param.status}" == 1 ) {
    		window.location.href = "${pageContext.request.contextPath}/docHistory/downloadDocHistoryData.do?id=${param.id}";
    	} else {
    		window.location.href = "${pageContext.request.contextPath}/tmpDocOperationLog/downloadData.do?id=${param.id}";
    	}
    	
    })
    $(".back-btn").click(function(){
    	$('.file-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/knowledgeMgt/knowledgeBase/fileList.do');
    })
    </script>
</body>
</html>