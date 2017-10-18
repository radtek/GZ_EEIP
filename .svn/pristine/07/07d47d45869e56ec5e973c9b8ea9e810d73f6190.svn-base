<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>物证受理</title>
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
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
    
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="form-module">
	    <div class="form-module-title">
	        <p>检材受理</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">受理人：</label>
	                <div class="col-sm-2" data-bind="with:appraisalVm">
	                    <input type="text" class="form-control" data-bind="value:acceptorAlias"/>
	                </div>
	                <div class="col-sm-2">
	                   
	                </div>
	                <label class="col-sm-2 control-label">受理时间：</label>
	                <div class="col-sm-4" data-bind="with:appraisalVm">
	                    <input type="text"  class="form-control" data-bind="value:acceptedDate" />
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">受理意见：</label>
	                <div class="col-sm-10">
	                    <div class="matter-content">
	                        <div class="matter-module">
	                            <div class="matter-module-title">外观是否完整：</div>
	                            <div class="matter-module-option">
	                                <div class="col-sm-4">
	                                    <div class="rdio rdio-primary">
	                            <input type="radio" name="appearanceSitn" value="1" id="radioYes">
	                            <label for="radioYes">是</label>
	                        </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="rdio rdio-primary">
	                            <input type="radio" name="appearanceSitn" value="0" id="radioNo">
	                            <label for="radioNo">否</label>
	                        </div>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="matter-module">
	                            <div class="matter-module-title">拟同意接收：</div>
	                            <div class="matter-module-option">
	                                <div class="col-sm-4">
	                                    <div class="rdio rdio-primary">
	                            <input type="radio" name="receptionSitn" value="1" id="radioYes2">
	                            <label for="radioYes2">是</label>
	                        </div>
	                                </div>
	                                <div class="col-sm-4">
	                                    <div class="rdio rdio-primary">
	                            <input type="radio" name="receptionSitn" value="0" id="radioNo2">
	                            <label for="radioNo2">否</label>
	                        </div>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="matter-module">
	                        <div class="matter-module-title">其他：</div>
	                            <div class="matter-module-option">
	                                <div class="col-sm-12" data-bind="with:appraisalVm">
	                                    <input type="text"  class="other-inputs"  data-bind="value:other"/>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>					
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">受理拍照：</label>
	                <div class="col-sm-10">
	                    <div class="img-upload">
	                        <%-- <div class="big-img">
	                            <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
	                        </div> --%>
	                        <ul class="img-list">
	                           <%--  <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
	                            <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li>
	                         --%></ul>
	                    </div>
	                </div>
	            </div>
	             <div class="form-group">
	                <label class="col-sm-2 control-label">受理视频文件：</label>
	                <div class="col-sm-10">
	                    <div class="document-content video-list">
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
			var commonAppraisalId = "${param.commonAppraisalId}";
			var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : commonAppraisalId });
			appraisalData.acceptedDate=  new Date(appraisalData.acceptedDate).Format("yyyy-MM-dd hh:mm")
			var appraisalDataVm = ko.mapping.fromJS(appraisalData);
			$('input[name="appearanceSitn"][value='+appraisalData.appearanceSitn+']').attr("checked",true); 
			$('input[name="receptionSitn"][value='+appraisalData.receptionSitn+']').attr("checked",true); 
			var vm={
					appraisalVm:appraisalDataVm 
			};
			loadAccrptImage(commonAppraisalId);
			ko.applyBindings(vm); 
			
			/*查看图片--开始*/
			$(".img-list").on("click", "img", function(){
		        var src = $(this).attr("src");
		        $(".modal-bigImg .bigImg").attr("src",src);
		        //$(".big-img").html("<img src='"+ src +"' />");
		        var bodyHeight = $("body").height()+50;
		        console.log(bodyHeight);
		        $(".iframe-accepted", window.parent.document).height(bodyHeight);
		    });
			/*查看图片--结束*/
		});
		function loadAccrptImage(commonAppraisalId){
			var appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisalAcptAtt/loadDataByAppraisalId.do",{ "appraisalId" : commonAppraisalId });
			var imageExt = ["jpg", "jpeg", "png", "bmp"];
			var videoExt = ["mov", "avi", "mp4", "wmv"];
			var imageNum = null;
			if( appraisalData.length > 0){
				var imageHtml = '';
				var videoHtml = '';
				for( var i=0 ; i < appraisalData.length ; i++){
					var ext = appraisalData[i].ext;
					console.log(ext);
					var dataExt = ext.toLowerCase();
					console.log(dataExt);
					if($.inArray(dataExt,videoExt) != -1){
						// 视频
 						videoHtml += '<div class="document-style"><span><a href="${pageContext.request.contextPath}/elecMgt/appraisalAcptAtt/downLoadAttById.do?id='+appraisalData[i].id+'">'+appraisalData[i].name+'</a></span></div>';
					} else if($.inArray(dataExt,imageExt) != -1){
						if(imageNum == null){
							imageNum = i;
						}
						// 图片
						imageHtml += '<li><span><img data-toggle="modal" data-target=".modal-bigImg" src="${pageContext.request.contextPath}/elecMgt/AppraisalAcptAtt/getImageById.do?id='+appraisalData[i].id+'" /></span></li>';
					}
				}
				$(".img-list").append(imageHtml);
				$(".video-list").append(videoHtml);
			} 
		} 
	</script>
</body>
</html>