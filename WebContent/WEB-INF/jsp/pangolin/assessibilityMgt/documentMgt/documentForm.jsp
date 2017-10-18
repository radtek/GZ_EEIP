<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Document Form</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/chosen.jquery.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/icheck/icheck.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/switcher/bootstrap-switch.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.download.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/Isempty.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/chosen.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/icheck/skins/all.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/js/switcher/bootstrap-switch.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/frameworks/pangolin/css/formStyle.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet">
  </head>
  <style>
  	#file { display: none; }
  	.filepath { cursor: pointer; }
  	.lh { margin-left: 5px; opacity: 0.5; float: left; }
  	.form_button { width: 78px; height: 40px; }
  	#successIcon, #failureIcon { font-size: 20px; color: #7C8592; display: none; }
  	#reviewDocIcon { font-size: 20px; color: #7C8592; cursor: pointer; display: none; }
  	.uploadStatus { line-height: 42px; }
  </style>
  <body>
    <div class="panel panel-default">
	  <div class="panel-heading">
	    <p class="headPosition">
		  ${ LANG[sessionScope.loginUser.lang]['CURRENT_LOCATION'] }：<a href="${pageContext.request.contextPath}/homepage.do">${ LANG[sessionScope.loginUser.lang]['MODULE_PLATFORM_MGT'] }</a>
		  <i>/</i><a href="${pageContext.request.contextPath}/system/assessibility/document/documentInfoList.do">${ LANG[sessionScope.loginUser.lang]['MODULE_FUNC_DOCS_MGT'] }</a>
		  <i>/</i>${ LANG[sessionScope.loginUser.lang]['ADD_DOC_DATA'] }
		</p>
	  </div>
	  <div class="panel-body panel-body-nopadding">
	    <form class="form-horizontal form-bordered">
	      <div class="form-group">
	        <label for="fileName" class="col-sm-2 control-label"><span class="errors">*</span>${ LANG[sessionScope.loginUser.lang]['COL_DOC_NAME'] }</label>
		    <div class="col-sm-8">
		      <input type="type" 
		             data-bind="value: name" 
		             name="fileName" 
		             class="form-control illegalCharacter" 
		             placeholder="${ LANG[sessionScope.loginUser.lang]['COL_DOC_NAME'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" required></input>
		    </div>
		  </div>
				
		  <div class="form-group">
		    <label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_DOC_UPLOAD'] }</label>
			<div class="col-sm-7">
			  <input type="type" class="form-control filepath" placeholder="${ LANG[sessionScope.loginUser.lang]['COL_DOC_PATH'] }">
			  <input type="file" id="file" name="file" size="10" />
			</div>
			<div class="col-sm-1">
	          <button class="btn btn-primary form_button upload" type="button">
	            <span class="fa  fa-upload"></span>&nbsp;&nbsp;${ LANG[sessionScope.loginUser.lang]['BTN_UPLOAD_DATA'] }
	          </button>
		    </div>
			<div class="col-sm-1">
			  <div class="uploadStatus">
			    <span id="successIcon" class="fa fa-check-circle"></span>
				<span id="failureIcon" class="fa fa-times-circle"></span>
			    <span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span id="reviewDocIcon" class="fa fa-file-text-o"></span>
			  </div>
			</div>
	      </div>

		  <div class="form-group">
		    <label for="fileDesc" class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_DOC_DESC'] }</label>
		    <div class="col-sm-8">
			  <textarea class="form-control illegalCharacter" 
			            data-bind="value: description" 
			            name="fileDesc" 
			            placeholder="${ LANG[sessionScope.loginUser.lang]['COL_DOC_DESC'] }" rows="3"></textarea>
			</div>
			<div class="clear"></div>
		  </div>

		  <div class="form-group">
		    <div class="col-sm-2 col-sm-offset-3 btnCenter">
		      <button class="btn btn-primary btnWidth" data-bind="click: saveData" type="button">${ LANG[sessionScope.loginUser.lang]['BTN_SAVE_DATA'] }</button>
		    </div>
		    <div class="col-sm-2 btnCenter">
		      <button class="btn btn-default btnWidth" data-bind="click: resetData" type="button">${ LANG[sessionScope.loginUser.lang]['BTN_RESET_DATA'] }</button>
		    </div>
			<div class="col-sm-2 btnCenter">
			  <button class="btn btn-default btnWidth" data-bind="click: backToList" type="button">${ LANG[sessionScope.loginUser.lang]['BTN_BACK'] }</button>
			</div>
		  </div>
		</form>
      </div>
	</div>
	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>

    <input type="hidden" name="fileId" data-bind="value: id" />
    <input type="hidden" name="uploadFileName" id="uploadFileName"/>
    
  </form>
  <script type="text/javascript">
    $("#reviewDocIcon").click(function() {
    	download("${pageContext.request.contextPath}/system/assessibility/document/documentDataViewer.do", { "fileName" : $("#uploadFileName").val() });
    });
  
    $("#file").change(function() {
    	$("#successIcon,#failureIcon").hide();
    	if ( $("#file").val() !="" ) $(".filepath").val($("#file").val());
		else $(".filepath").val("");
    	$("#reviewDocIcon").hide();
    });
    
    $(".filepath").click(function() {
    	$("#file").click();
     });
    
    $(".upload").click(function() {
    	$("#successIcon,#failureIcon").hide();
    	if ( $("#file").val() != "" ) {
    		$.ajaxFileUpload({
        		url : "${pageContext.request.contextPath}/system/assessibility/document/uploadDocumentData.do",
    			secureuri : false,
    			fileElementId : "file",
    			dataType : "json",
    			success : function (data, status) {
    				$("#file,#uploadFileName,.filepath").val("");
    				if ( data != undefined && data != null ) {
    					if ( data.status ) {
    						$("#uploadFileName").val(data.tmpFileName);
    						$("#successIcon").show();
    						$("#reviewDocIcon").show();
    					} else {
    						$("#failureIcon").show();
    					}
    				}
    				
    				$("#file").change(function() {
    					$("#successIcon,#failureIcon").hide();
    			    	if ( $("#file").val() !="" ) $(".filepath").val($("#file").val());
    					else $(".filepath").val("");
    			    	$("#reviewDocIcon").hide();
    			    });
    			},
    			error: function (data, status, e) {
    				console.log(e);
    				$("#failureIcon").show();
    			}
    		});
    	}
    });
  
    $(function() {
    	function loadUploadFileData(data) {
    		if ( data != undefined && data.uploadFileName != undefined ) {
    			$("#uploadFileName").val(data.uploadFileName);
    			$("#reviewDocIcon").show();
    		}
    	}
    	
    	var data = loadData("${pageContext.request.contextPath}/system/assessibility/document/loadDocumentInfoData.do", { "id" : "${param.id}" });
		var vm = ko.mapping.fromJS(data);
		
		loadUploadFileData(data);

		vm.saveData = function() {
			$("button").attr("disabled", true);
			if ( validateSubmittedData() ) {
				bindDataToDocVM();
				if (saveData("${pageContext.request.contextPath}/system/assessibility/document/saveDocumentInfoData.do", vm)) {
					saveSuccess("${pageContext.request.contextPath}/system/assessibility/document/documentInfoList.do");
				} else {
					saveFailure();
				}
			} else {
				saveFailure();
			}
		}

		vm.resetData = function() {
			$("form")[0].reset();
		}

		vm.backToList = function() {
			$(".iframes", window.parent.document).attr("src", "${pageContext.request.contextPath}/system/assessibility/document/documentInfoList.do");
		}
		
		function bindDataToDocVM() {
			vm.tempUploadFileName($("#uploadFileName").val());
		}
		
		ko.applyBindings(vm);
	});
  </script>	
</body>
</html>