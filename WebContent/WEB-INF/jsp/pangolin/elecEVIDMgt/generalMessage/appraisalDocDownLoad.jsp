<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>物证文书报告列表</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bracket-common.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/toggles.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
  	<script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/jquery-barcode.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	 
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>综合鉴定信息</a><span>></span><a>下载文书</a>
        </p>
    </div>
    <div class="form-module">
	    <div class="form-module-title">
	        <p>物证文书列表</p>
	    </div>
	    <div class="form-content">
	        <form class="form-horizontal">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">文书列表：</label>
	                <div class="col-sm-10">
	                    <div class="document-content">
	                        <div class="document-style document0" style="display:none"><span><a class="downFile" id="0">鉴定委托书</a></span></div>
	                        <div class="document-style document1" style="display:none"><span><a class="downFile" id="1">鉴定事项确认书</a></span></div>
	                        <div class="document-style document2" style="display:none"><span><a class="downFile" id="2">物证鉴定档案封面</a></span></div>
	                        <div class="document-style document3" style="display:none"><span><a class="downFile" id="3">鉴定文书档案目录</a></span></div>
	                        <div class="document-style document4" style="display:none"><span><a class="downFile" id="4">电子物证检验原始记录</a></span></div>
	                        <div class="document-style document5" style="display:none"><span><a class="downFile" id="5">鉴定文书</a></span></div>
	                        <div class="document-style document6" style="display:none"><span><a class="downFile" id="6">检验鉴定照片记录表</a></span></div>
	                        <div class="document-style document7" style="display:none"><span><a class="downFile" id="7">提取电子证据清单</a></span></div>
	                        <div class="document-style document8" style="display:none"><span><a class="downFile" id="8">鉴定文书审批表</a></span></div>
	                        <div class="document-style document9" style="display:none"><span><a class="downFile" id="9">不受理鉴定委托告知书</a></span></div>
	                        <div class="document-style document10" style="display:none"><span><a class="downFile" id="10">中止鉴定告知书</a></span></div>
	                        <div class="document-style document11" style="display:none"><span><a class="downFile" id="11">鉴定文书修改审批表</a></span></div>
	                        <div class="document-style document12" style="display:none"><span><a class="downFile" id="12">检材流转记录表</a></span></div>
	                    </div>
	                </div>
	            </div>
	        </form>
	    </div>
	</div>
	<!-- <div class="btn-content">
	    <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
	</div> -->
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
			var docData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/AppraisalDoc/getListData.do",{ "appraisalId" : "${param.id}" });
			if(docData.length > 0){
				for(var i = 0 ; i < docData.length ; i++){
					$('.document'+docData[i].type+'').show();
				}
			}
			
			$(".downFile").click(function(){
				var type = $(this).attr("id");
				window.location.href = "${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type="+type+"&appraisalId=${param.id}";
			})
			
		});
	</script>
</body>
</html>