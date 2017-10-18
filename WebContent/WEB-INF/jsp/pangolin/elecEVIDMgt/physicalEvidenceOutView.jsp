<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>检材出库</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
    
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="form-module">
	    <div class="form-module-title">
	        <p>检材出库</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	        		<div class="form-group">
						<label class="col-sm-2 control-label">检材编号：</label>
						<div class="col-sm-4" data-bind="with:evidenceVm">
							<input type="text" data-bind="value:sn" class="form-control" readonly />
						</div>
						<label class="col-sm-2 control-label">检材名称：</label>
						<div class="col-sm-4" data-bind="with:evidenceVm">
							<input type="text" data-bind="value:name" class="form-control" readonly />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">存放位置：</label>
						<div class="col-sm-10" data-bind="with:evidenceVm">
							<input type="text" data-bind="value:location" class="form-control" readonly />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">文书存放位置：</label>
						<div class="col-sm-10" data-bind="with:evidenceVm">
							<input type="text" class="form-control " data-bind="value:docLocation" readonly />
						</div>
					</div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">登记人：</label>
	                <div class="col-sm-4" data-bind="with:evidenceLogVm">
	                    <input type="text" class="form-control" data-bind="value:creatorAlias" />
	                </div>
	                <label class="col-sm-2 control-label">出库时间：</label>
	                <div class="col-sm-4"  data-bind="with:evidenceLogVm">
	                   <input type="text" class="form-control" data-bind="value:createdDate" />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">出库拍照：</label>
	                <div class="col-sm-10">
	                    <div class="img-upload">
	                        <%-- <div class="big-img">
	                            <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
	                        </div> --%>
	                        <ul class="img-list">
	                           <%--  <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
	                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li> --%>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	        </form>
	    </div>
	</div>
	<!-- <div class="btn-content">
	    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	</div> -->
	
	<!-- <button data-toggle="modal" data-target=".modal-bigImg"></button> -->
	<div class="modal fade modal-bigImg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  	<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      	<div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">查看大图</h4>
		      	</div>
		      	<div class="modal-body">
		       	 	<img src="" class="bigImg" />
		      	</div>
		    </div>
	  	</div>
	</div>
	
	<script>
		$("input, textarea, select").attr("disabled",true);
		if(window.navigator.userAgent.indexOf('AppleWebKit') != -1) {
			$(".rdio-primary").addClass("rdio");
			$(".ckbox-primary").addClass("ckbox"); 
		}else{
			$(".rdio-primary").removeClass("rdio");
			$(".ckbox-primary").removeClass("ckbox");
		}
		
		$(function(){
			var id = "${param.commonAppraisalId}";
			var	appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : id });
			var evidenceData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidence/getDataByAppraisalId.do",{ "appraisalId" : appraisalData.id });
			var evidenceLog = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLog/getDataByEvidIdAndSpLabel.do",{ "evidId" : evidenceData.id , "spLabel" : 1 });
			evidenceLog.createdDate=  new Date(evidenceLog.createdDate).Format("yyyy-MM-dd hh:mm")
			var evidenceLogDataVm = ko.mapping.fromJS(evidenceLog);
			var evidenceLogAttData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadDataByEvidOpLogId.do",{ "evidOpLogId" : evidenceLog.id  });
			
			evidenceData.createdDate=  new Date(evidenceData.createdDate).Format("yyyy-MM-dd hh:mm")
			var evidenceDataVm = ko.mapping.fromJS(evidenceData);
			var vm = {
					evidenceVm : evidenceDataVm,
					evidenceLogVm  : evidenceLogDataVm
			}
		 	ko.applyBindings(vm);  
			if(evidenceLogAttData.length>0){
				var html ='';
				for(var i =0 ; i < evidenceLogAttData.length ; i++){
					html += '<li><span><img data-toggle="modal" data-target=".modal-bigImg" src="${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadImageData.do?id='+evidenceLogAttData[i].id+'" /></span></li>';
				}
				//var bigHtml =  '<img src="${pageContext.request.contextPath}/elecEVIDMgt/evidOpLogAtt/loadImageData.do?id='+evidenceLogAttData[0].id+'" />';
				$(".img-list").append(html);
				//$(".big-img").append(bigHtml);
			}
			
			/*查看图片--开始*/
			$(".img-list").on("click", "img", function(){
		        var src = $(this).attr("src");
		        $(".modal-bigImg .bigImg").attr("src",src);
		        //$(".big-img").html("<img src='"+ src +"' />");
		        var bodyHeight = $("body").height()+30;
		        console.log(bodyHeight);
		        $(".iframe-leave", window.parent.document).height(bodyHeight);
		    });
			/*查看图片--结束*/
		});
	</script>
</body>
</html>