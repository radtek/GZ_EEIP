<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Advertisement Form</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
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
	<script src="<c:url value="/resources/frameworks/pangolin/js/alertMessages.js" />"></script>
    <%@ include file = "/common/scripts.jsp"%>
    <link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/Isempty.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/chosen.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/icheck/skins/all.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/js/switcher/bootstrap-switch.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/formStyle.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  </head>
  <style>
  	#file ,.comfile { display: none; }
  	.filepath { cursor: pointer; }
  	.lh { margin-left: 5px; opacity: 0.5; float: left; }
  	.ccflie span { float: left; }
  	.form_button { width: 78px; height: 40px; }
  	#successIcon, #failureIcon { font-size: 20px; color: #7C8592; display: none; }
  	#reviewPicIcon { font-size: 20px; color: #7C8592; cursor: pointer; display: none; }
  	.uploadStatus { line-height: 42px; }
  	.photoViewer { z-index: 1000; display: none; width: 500px; height: 281px; position: fixed; }
  </style>
  <body>
    <img class="photoViewer" src="" />
	<div class="panel panel-default">
	  <div class="panel-heading">
	    <p class="headPosition">
	      ${ LANG[sessionScope.loginUser.lang]['CURRENT_LOCATION'] }：<a href="${pageContext.request.contextPath}/homepage.do">${ LANG[sessionScope.loginUser.lang]['MODULE_PLATFORM_MGT'] }</a>
		  <i>/</i><a href="${pageContext.request.contextPath}/system/assessibility/advertisement/advertisementList.do">${ LANG[sessionScope.loginUser.lang]['MODULE_FUNC_AD_MGT'] }</a>
		  <i>/</i>${ LANG[sessionScope.loginUser.lang]['ADD_AD_DATA'] }
		</p>
      </div>
	  
	  <div class="panel-body panel-body-nopadding">
	    <form class="form-horizontal form-bordered">
	      <div class="form-group">
	        <label class="col-sm-2 control-label"><span class="errors">*</span>${ LANG[sessionScope.loginUser.lang]['COL_AD_TITLE'] }</label>
			<div class="col-sm-8" data-bind="with: adVM">
			  <input type="type" 
			         data-bind="value: title" 
			         name="adTitle" 
			         class="form-control illegalCharacter" 
			         placeholder="${ LANG[sessionScope.loginUser.lang]['COL_AD_TITLE'] }${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }" required></input>
			</div>
		  </div>

		  <div class="form-group">
		    <label class="col-sm-2 control-label">URL</label>
		    <div class="col-sm-8" data-bind="with: adVM">
			  <input type="type" 
			         data-bind="value: url" 
			         name="adUrl" 
			         class="form-control" 
			         placeholder="URL${ LANG[sessionScope.loginUser.lang]['TEXTFIELD_REQUIRED'] }"></input>
			</div>
		  </div>
		  
		  <div class="form-group">
		    <label for="adStatus" class="col-sm-2 control-label"><span class="errors">*</span>${ LANG[sessionScope.loginUser.lang]['COL_AD_STATUS'] }</label>
			<div class="col-sm-8" data-bind="with: adStatusVM">
			  <select name="adStatus" 
					  class="form-control"
					  data-bind="options: adStatusList,
                                 optionsValue: 'value',
                  		         optionsText: 'name',
                  		         value: adStatus" required></select>
		    </div>
		  </div>
		  
				
		  <div class="form-group">
		    <label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_AD_PIC_UPLOAD'] }</label> 
		    <div class="col-sm-7">
			  <input type="type" class="form-control filepath" placeholder="${ LANG[sessionScope.loginUser.lang]['COL_AD_PIC_PATH'] }">
			  <input type="file" id="file" name="file" size="10" />
			</div>
			  
			<div class="col-sm-1">
			  <button class="btn btn-primary form_button upload" type="button">
			    <span class="fa fa-upload"></span>&nbsp;&nbsp;${ LANG[sessionScope.loginUser.lang]['BTN_UPLOAD_DATA'] }
			  </button>
			</div>
					
			<div class="col-sm-1">
			  <div class="uploadStatus">
			    <span id="successIcon" class="fa fa-check-circle"></span>
				<span id="failureIcon" class="fa fa-times-circle"></span>
				<span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span id="reviewPicIcon" class="fa fa-picture-o"></span>
			  </div>
			</div>
		  </div>

		  <div class="form-group">
		    <label class="col-sm-2 control-label">${ LANG[sessionScope.loginUser.lang]['COL_AD_DESC'] }</label>
		    <div class="col-sm-8" data-bind="with: adVM">
		      <textarea class="form-control illegalCharacter" 
		                data-bind="value: description" 
		                name="adDesc" 
		                placeholder="${ LANG[sessionScope.loginUser.lang]['COL_AD_DESC'] }" rows="3"></textarea>
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

    <div data-bind="with: adVM">
      <input type="hidden" name="adId" data-bind="value: id"/>
    </div>
    
    <input type="hidden" name="adPhotoName" id="adPhotoName"/>
    
  </form>
  
  <script type="text/javascript">
    $("#reviewPicIcon").mouseover(function(e) {
    	$(".photoViewer").attr("src", "${pageContext.request.contextPath}/system/assessibility/advertisement/imageDataViewer.do?adPhotoName=" + $("#adPhotoName").val());
    	$(".photoViewer").css({"left": e.clientX - 500 , "top": e.clientY - 200}).show();
	});
    
    $("#reviewPicIcon").mouseout(function() {
    	$(".photoViewer").hide();
	});
  
    $("#file").change(function() {
    	$("#successIcon,#failureIcon").hide();
    	if ( $("#file").val() !="" ) $(".filepath").val($("#file").val());
		else $(".filepath").val("");
    	$("#reviewPicIcon").hide();
    });
    
    $(".filepath").click(function() {
    	$("#file").click();
    });
    
    $(".upload").click(function() {
    	$("#successIcon,#failureIcon").hide();
    	if ( $("#file").val() != "" ) {
    		$.ajaxFileUpload({
        		url : "${pageContext.request.contextPath}/system/assessibility/advertisement/uploadADPhotoData.do",
    			secureuri : false,
    			fileElementId : "file",
    			dataType : "json",
    			success : function (data, status) {
    				$("#file,#adPhotoName,.filepath").val("");
    				if ( data != undefined && data != null ) {
    					if ( data.status ) {
    						$("#adPhotoName").val(data.tmpPicName);
    						$("#successIcon").show();
    						$("#reviewPicIcon").show();
    					} else {
    						$("#failureIcon").show();
    					}
    				}
    				
    				$("#file").change(function() {
    					$("#successIcon,#failureIcon").hide();
    			    	if ( $("#file").val() !="" ) $(".filepath").val($("#file").val());
    					else $(".filepath").val("");
    			    	$("#reviewPicIcon").hide();
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
    	function loadImageData(data) {
    		if ( data != undefined && data.uploadFileName != undefined ) {
    			$("#adPhotoName").val(data.uploadFileName);
    			$("#reviewPicIcon").show();
    		}
    	}
    	
		//ADVERTISEMENT VM
    	var adData = loadData("${pageContext.request.contextPath}/system/assessibility/advertisement/loadAdvertisementData.do", { "id" : "${param.id}" });
		var adDataVM = ko.mapping.fromJS(adData);
		
		//ADVERTISEMENT STATUS VM
    	var ADStatus = function(name, val) {
			  this.name = name;
			  this.value = val;
		};
		  
		var adStatusDataVM = {
				adStatusList : ko.observableArray([ new ADStatus("${ LANG[sessionScope.loginUser.lang]['OPTION_AD_STATUS01'] }", 0), new ADStatus("${ LANG[sessionScope.loginUser.lang]['OPTION_AD_STATUS02'] }", 1) ]),
				adStatus : ko.observable(adData.status)
		};
		
		//IMAGE DATA
		loadImageData(adData);
		
		//GENERAL VM
		var vm = {
				adStatusVM : adStatusDataVM,
				adVM : adDataVM
		}

		vm.saveData = function() {
			$("button").attr("disabled", true);
			if ( validateSubmittedData() ) {
				bindDataToADVM();
				if (saveData("${pageContext.request.contextPath}/system/assessibility/advertisement/saveAdvertisementData.do", adDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/system/assessibility/advertisement/advertisementList.do");
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
			$(".iframes", window.parent.document).attr("src", "${pageContext.request.contextPath}/system/assessibility/advertisement/advertisementList.do");
		}
		
		function bindDataToADVM() {
			adDataVM.status = adStatusDataVM.adStatus;
			adDataVM.tempUploadFileName($("#adPhotoName").val());
		}
		
		ko.applyBindings(vm);
	});
  </script>	
</body>
</html>