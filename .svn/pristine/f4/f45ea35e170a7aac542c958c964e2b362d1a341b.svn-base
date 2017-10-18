<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>电子物证管理-综合鉴定信息-物证受理</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body data-num="1">
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>综合鉴定信息</a><span>></span><a>查看</a>
        </p>
    </div>
    <jsp:include page="/common/tabsContent.jsp"></jsp:include>
    <div class="form-module">
        <div class="form-module-title">
            <p>检材受理</p>
        </div>
        <div class="form-content">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">受理人：</label>
                    <div class="col-sm-2">
                        <select name="" id="" class="form-control">
                            <option value="">111</option>
                            <option value="">222</option>
                            <option value="">333</option>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <select name="" id="" class="form-control">
                            <option value="">111</option>
                            <option value="">222</option>
                            <option value="">333</option>
                        </select>
                    </div>
                    <label class="col-sm-2 control-label">受理时间：</label>
                    <div class="col-sm-4">
                        <input type="text" placeholder="" class="form-control" />
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
				                            <input type="radio" name="radio1" value="" id="radioYes">
				                            <label for="radioYes">是</label>
				                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
				                            <input type="radio" name="radio1" value="" id="radioNo">
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
				                            <input type="radio" name="radio2" value="" id="radioYes2">
				                            <label for="radioYes2">是</label>
				                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="rdio rdio-primary">
				                            <input type="radio" name="radio2" value="" id="radioNo2">
				                            <label for="radioNo2">否</label>
				                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="matter-module">
                            <div class="matter-module-title">其他：</div>
                                <div class="matter-module-option">
                                    <div class="col-sm-12">
                                        <input type="text" value="" class="other-inputs" />
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
                            <div class="big-img">
                                <img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" />
                            </div>
                            <ul class="img-list">
                                <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/111.png" /></span></li>
                                <li><span><img src="${pageContext.request.contextPath}/resources/frameworks/pangolin/images/eeip/deviceMgt/222.png" /></span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="btn-content">
      <!--   <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button> -->
        <!-- <button type="button" class="btn btn-color1"><i class="fa fa-check"></i>通过</button>
        <button type="button" class="btn btn-color1"><i class="fa fa-times"></i>拒绝</button> -->
    </div>
    <script>
    	var num = $("body").data("num");
    	$(".tabs-nav li").eq(num).addClass("action");
    	$(".tabs-nav li").eq(num+1).addClass("action-next");
    
    	$(".tabs-nav li").hover(
            function(){
                $(this).next().addClass("action-next");
            },
            function(){
                if( !$(this).hasClass("action") ){
                    $(this).next().removeClass("action-next");
                }
            }
        );
    	
    	$(".register").attr("data-url","${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/registerInfoView.do");
    	$(".accepted").attr("data-url","${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/physicalEvidenceAcceptView.do");
    	$(".check").attr("data-url","${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/checkInfoView.do");
    	$(".warehousing").attr("data-url","${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/physicalEvidenceStorageView.do");
    	$(".process").attr("data-url","${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/authenticateProcessView.do");
    	$(".leave").attr("data-url","${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/physicalEvidenceOutView.do");
    	
    	$(".tabs-nav li a").click(function(){
    		var url = $(this).data("url");
			$(".index-iframe", window.parent.document).attr("src",url);
    	});
    	
    	$(".img-list img").click(function(){
            var src = $(this).attr("src");
            $(".big-img img").attr("src",src);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/generalMessage/timelineViewer.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
    </script>
</body>
</html>