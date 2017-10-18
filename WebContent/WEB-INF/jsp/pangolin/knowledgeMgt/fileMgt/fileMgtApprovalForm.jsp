<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>知识管理-审批表单</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/knowledgeMgt/fileMgt-form.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>知识管理</a><span>></span><a>知识文件管理</a><span>></span><a>审批</a>
        </p>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>文件编号：</label>
                <div class="col-sm-4" data-bind="with:docVM">
                    <input type="text" placeholder="" class="form-control" data-bind="value:sn" readonly required/>
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>文件名称：</label>
                <div class="col-sm-4" data-bind="with:docVM">
                    <input type="text" placeholder="" class="form-control" data-bind="value:name" readonly required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>文件类型：</label>
                <div class="col-sm-4" data-bind="with:docVM">
                    <select class="form-control" data-bind="value:dirId" id="dirSelect" disabled required>
                       
                    </select>
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>年份：</label>
                <div class="col-sm-4" data-bind="with:docVM">
                    <input type="text" placeholder="" class="form-control " data-bind="value:year" readonly required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">关联文件：</label>
                <div class="col-sm-10" data-bind="with:docVM">
                	<textarea class="form-control" id="relations" readonly></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">原文件：</label>
                <div class="col-sm-10">
					<div class="upload-file" id="oldFile">
						<!-- <div class="item"><p><a href="###" id="originalName"></a><button type="button" class="btn btn-color1" id="original"><i class="fa fa-download"></i>下载</button></p></div> -->
						<!-- <div class="list-content">
							<div class="list-img">	
								<img src="" class="originalImg" />
							</div>
							<div class="list-name">
								<p><a href=""></a></p>
							</div>
						</div> -->
					</div>
				</div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">新文件：</label>
                <div class="col-sm-10">
                    <div class="upload-file" data-bind="with:docVM" id="newFile">
						<!-- <div class="item"><p><a href="###" data-bind="text:name"></a><button type="button" class="btn btn-color1" id="download"><i class="fa fa-download"></i>下载</button></p></div> -->
						<div class="list-content">
							<div class="list-img">	
								<img src="" />
							</div>
							<div class="list-name">
								<p><a href="#" id="download" data-bind="text:name" ></a></p>
							</div>
						</div>
					</div>
                </div>
            </div>
            <div class="form-group  display">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>修改原因：</label>
                <div class="col-sm-10" data-bind="with:docVM">
                    <textarea class="form-control" data-bind="value:reason" readonly ></textarea>
                </div>
            </div>
            <div class="form-group  display">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>修改内容：</label>
                <div class="col-sm-10" data-bind="with:docVM">
                    <textarea class="form-control" data-bind="value:content" readonly ></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>审核意见：</label>
                <div class="col-sm-10" data-bind="with:docVM">
                    <textarea class="form-control" data-bind="value:opinion" required></textarea>
                </div>
            </div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn" data-bind="click :backToListData"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1" data-bind="click :saveData"><i class="fa fa-check"></i>同意</button>
        <button class="btn btn-color1" data-bind="click :refuseData"><i class="fa fa-times"></i>不同意</button>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    	/* $('.datetimepicker').datetimepicker({
	       format: 'YYYY',
	    });	 */
    
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/knowledgeMgt/fileMgt/fileMgtList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
        
        var docData = loadData("${pageContext.request.contextPath}/tmpDocOperationLog/loadTmpDocOperationLogData.do", { "id" : "${param.id}"});
        console.log(docData);
        var docDataVM = ko.mapping.fromJS(docData);
       
        if( docData.docId != null && docData.docId != ""){
        	var documentData = loadData("${pageContext.request.contextPath}/system/assessibility/document/loadDocumentInfoData.do", { "id" : docData.docId });
        	var href = "${pageContext.request.contextPath}/tmpDocOperationLog/downloadData.do?id="+documentData.id;
        	console.log(documentData);
        	var dataName = documentData.name;
        	var fileTypeNames = documentData.extensions;
        	var fileTypeName = fileTypeNames.replace(".","");
        	//console.log(fileTypeName);
			//var fileNameLength = dataName.length-fileTypeName.length-1;
			//var dataName = dataName.substring(0,fileNameLength);
			//var dataId = data.id;
			var uoloadFfileType = fileTypeName.toLowerCase();
			var imgArr = ["jpg", "jpeg", "png", "bmp"];
			var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
			var videoArr = ["mov", "avi", "mp4", "wmv"];
        	var html = '';
        	html += '<div class="list-content">';
        	html += '	<div class="list-img">';
        	if($.inArray(uoloadFfileType,imgArr)!= -1){
				html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png">';
			} else if($.inArray(uoloadFfileType,videoArr)!= -1){
				html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png">';
			} else {
				html += '<img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/'+uoloadFfileType+'.png">';
			}
        	html += '	</div>';
        	html += '	<div class="list-name">';
        	html += '		<p><a href="'+href+'">'+dataName+'</a></p>';
        	html += '	</div>';
        	html += '</div>';
            $("#oldFile").html(html);
            //$("#oldFile .list-name a").text(documentData.name).attr("href",href);
        	
        	//$("#originalName").text(documentData.name);
            /* $("#original").click(function(){
            	window.location.href = "${pageContext.request.contextPath}/tmpDocOperationLog/downloadData.do?id="+documentData.id;
            }) */
        }else{
        	$(".display").hide();
        }
        
        var dirData = loadData("${pageContext.request.contextPath}/directory/directoryGridData.do", {});
        /*  var newHref = "${pageContext.request.contextPath}/tmpDocOperationLog/downloadData.do?id="+docData.id;
        $("#newFile .list-name a").attr("href",href); */
        $("#download").click(function(){
        	window.location.href = "${pageContext.request.contextPath}/tmpDocOperationLog/downloadData.do?id="+docData.id;
        });
        
        var dirHtml = '';
        for(var i=0;i<dirData.length;i++){
        	dirHtml += '<option value="'+dirData[i]['id']+'">'+dirData[i]['name']+'</option>';
        }
        $("#dirSelect").html(dirHtml);
        
        
        
        var relations = '';
        var documents = docData.documents;
        for(var i=0;i<documents.length;i++){
        	relations += documents[i]['name']+',';
        }
        $("#relations").val(relations.substring(0,relations.length-1));
        
        var vm = {
        	docVM : docDataVM
        }
        
        vm.saveData = function(){
      	  $("button").attr("disabled", true);
    	        if ( validateSubmittedData() ) {
    	            bindDataToVM();
    	        	if (saveData("${pageContext.request.contextPath}/tmpDocOperationLog/saveDocumentAndHistoryData.do", docDataVM)) {
    					saveSuccess("${pageContext.request.contextPath}/knowledgeMgt/fileMgt/tempFileMgtList.do");
    				} else {
    					saveFailure();
    				}
    	        } else {
    	        	saveFailure();
    	        } 
        }
        
        vm.refuseData = function(){
        	  $("button").attr("disabled", true);
      	        if ( validateSubmittedData() ) {
      	        	//bindDataToVM();
      	        	docDataVM.status = 3;
      	        	if (saveData("${pageContext.request.contextPath}/tmpDocOperationLog/saveTmpDocOperationLogData.do", docDataVM)) {
      					saveSuccess("${pageContext.request.contextPath}/knowledgeMgt/fileMgt/tempFileMgtList.do");
      				} else {
      					saveFailure();
      				}
      	        } else {
      	        	saveFailure();
      	        } 
          }
        
        vm.backToListData = function(){
      	  $('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/knowledgeMgt/fileMgt/tempFileMgtList.do');
        }
        
        function bindDataToVM(){
        	docDataVM.approverName = "${sessionScope.loginUser.userName}";
        	docDataVM.approverId = "${sessionScope.loginUser.userId}";
        	docDataVM.approverAlias = "${sessionScope.loginUser.userAlias}";
        	docDataVM.approvedDate = new Date();
        }

        ko.applyBindings(vm); 
        
        $(function(){
        	var fileTypeNames = docData.extensions;
        	var fileTypeName = fileTypeNames.replace(".","");
        	console.log(fileTypeName);
			var uoloadFfileType = fileTypeName.toLowerCase();
			var imgArr = ["jpg", "jpeg", "png", "bmp"];
			var fileArr = ["doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt"];
			var videoArr = ["mov", "avi", "mp4", "wmv"];
        	if($.inArray(uoloadFfileType,imgArr)!= -1){
        		var src = "${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/img.png";
        		$("#newFile .list-img img").attr("src",src);
        	} else if($.inArray(uoloadFfileType,videoArr)!= -1){
				var src = "${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/video.png";
        		$("#newFile .list-img img").attr("src",src);
			} else {
				var src = "${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/uploadImg/"+uoloadFfileType+".png";
        		$("#newFile .list-img img").attr("src",src);
			}
        });
    </script>
</body>
</html>