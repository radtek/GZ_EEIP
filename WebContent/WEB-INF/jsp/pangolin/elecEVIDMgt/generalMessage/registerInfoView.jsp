<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>电子物证管理-综合鉴定信息-登记信息</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
    <script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script> 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>	 
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/zyupload.basic-1.0.0.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/base.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>综合鉴定信息</a><span>></span><a>查看</a>
        </p>
    </div>
    <jsp:include page="/common/tabsContent.jsp"></jsp:include>
  	<div class="tabs-list" id="register">
  		<iframe class="iframe-page iframe-register" src=""></iframe>
    	<%-- <jsp:include page="/common/registerInfoView.jsp"></jsp:include> --%>
    </div>
    <div class="tabs-list" id="accepted">
    	<iframe class="iframe-page iframe-accepted" src=""></iframe>
    	<%-- <jsp:include page="/common/physicalEvidenceAcceptView.jsp"></jsp:include> --%>
    </div>
    <div class="tabs-list" id="check">
    	<iframe class="iframe-page iframe-check" src=""></iframe>
    	<%-- <jsp:include page="/common/checkInfoView.jsp"></jsp:include> --%>
    </div>
    <div class="tabs-list" id="warehousing">
    	<iframe class="iframe-page iframe-warehousing" src=""></iframe>
    	<%-- <jsp:include page="/common/physicalEvidenceStorageView.jsp"></jsp:include> --%>
    </div>
    <div class="tabs-list" id="process">
    	<iframe class="iframe-page iframe-process" src=""></iframe>
    	<%-- <jsp:include page="/common/authenticateProcessView.jsp"></jsp:include> --%>
    </div>
    <div class="tabs-list" id="leave">
    	<iframe class="iframe-page iframe-leave" src=""></iframe>
    	<%-- <jsp:include page="/common/physicalEvidenceOutView.jsp"></jsp:include> --%>
    </div>
    <script> 
		$(function(){
			$(".tabs-nav li").click(function(){
				var aClass = $(this).find("a").attr("class");
				if( aClass == "register" ){
					if( $(".iframe-"+aClass).attr("src") == "" ){
						var src = "${pageContext.request.contextPath}/elecEVIDMgt/registerInfoView.do?commonPreappraisalId="+"${param.commonPreappraisalId}";
						iframeHeight(aClass, src);
					}
				}else if( aClass == "accepted" ){
					if( $(".iframe-"+aClass).attr("src") == "" ){
						var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceAcceptView.do?commonAppraisalId="+"${param.commonAppraisalId}";
						iframeHeight(aClass, src);
					}
				}else if( aClass == "check" ){
					if( $(".iframe-"+aClass).attr("src") == "" ){
						var src = "${pageContext.request.contextPath}/elecEVIDMgt/checkInfoView.do?commonAppraisalId="+"${param.commonAppraisalId}";
						iframeHeight(aClass, src);
					}
				}else if( aClass == "warehousing" ){
					if( $(".iframe-"+aClass).attr("src") == "" ){
						var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceStorageView.do?commonAppraisalId="+"${param.commonAppraisalId}";
						iframeHeight(aClass, src);
					}
				}else if( aClass == "process" ){
					if( $(".iframe-"+aClass).attr("src") == "" ){
						var src ='';
						if("${param.userrole}" != ''){
							 src = "${pageContext.request.contextPath}/elecEVIDMgt/authenticateProcessView.do?commonAppraisalId="+"${param.commonAppraisalId}&userrole=1";
						}else{
						 src = "${pageContext.request.contextPath}/elecEVIDMgt/authenticateProcessView.do?commonAppraisalId="+"${param.commonAppraisalId}";
						}
						iframeHeight(aClass, src);
					}
				}else if( aClass == "leave" ){
					if( $(".iframe-"+aClass).attr("src") == "" ){
						var src = "${pageContext.request.contextPath}/elecEVIDMgt/physicalEvidenceOutView.do?commonAppraisalId="+"${param.commonAppraisalId}";
						iframeHeight(aClass, src);
					}
				}
			});
			/* var status ;
			appraisalData = loadData("${pageContext.request.contextPath}/elecEVIDMgt/appraisal/loadDataById.do",{ "id" : "${param.id}" });
			if(appraisalData.status > 4){
				status = 5;
			}else {
				status = appraisalData.status;
			} */
			/* 标签页事件和样式-开始 */
 			var clickStatus = "${param.num}";	//点击状态0
			var dataStatus = 5;		//数据状态
			tabsContent(clickStatus,dataStatus);
			$(".tabs-nav li").eq(clickStatus).click();
			/* 标签页事件和样式-结束  */
		});
		
		function iframeHeight(aClass, src){
			$(".iframe-"+aClass).attr("src", src);
			$(".iframe-"+aClass).load(function(){
	            var mainheight = $(".iframe-"+aClass).contents().find("body").height()+100;
	            $(".iframe-"+aClass).height(mainheight);
	        });
		}
	</script>
</body>
</html> 