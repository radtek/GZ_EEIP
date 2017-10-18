<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-受理人员操作台-检材入库-查看</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body data-num="3">
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>受理人员操作台</a><span>></span><a>检材入库</a><span>></span><a>查看</a>
        </p>
    </div>
    <jsp:include page="/common/tabsContent.jsp"></jsp:include>
    <div class="form-module">
        <div class="form-module-title">
            <p>检材入库</p>
        </div>
        <div class="form-content">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">条形码：</label>
                    <div class="col-sm-4">
                        <textarea rows="4" cols="" class="form-control"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">登记人：</label>
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
                    <label class="col-sm-2 control-label">入库时间：</label>
                    <div class="col-sm-4">
                        <input type="text" placeholder="" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">存放位置：</label>
                    <div class="col-sm-10">
                        <input type="text" placeholder="" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">入库拍照：</label>
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
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <!-- <button class="btn btn-color1"><i class="fa fa-check"></i>提交</button>
        <button class="btn btn-color1"><i class="fa fa-times"></i>拒绝</button> -->
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
    	
    	$(".img-list img").click(function(){
            var src = $(this).attr("src");
            $(".big-img img").attr("src",src);
        });
        
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/acceptanceOperatorStation/warehousingList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
    </script>
</body>
</html>