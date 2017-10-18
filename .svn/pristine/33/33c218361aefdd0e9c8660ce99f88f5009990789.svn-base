<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>电子物证管理-综合鉴定信息-检材审核</title>
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
<body data-num="2">
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>综合鉴定信息</a><span>></span><a>查看</a>
        </p>
    </div>
    <jsp:include page="/common/tabsContent.jsp"></jsp:include>
    <div class="form-module">
        <div class="form-module-title">
            <p>检材审核</p>
        </div>
        <div class="form-content">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">鉴定事项：</label>
                    <div class="col-sm-10">
                        <div class="matter-content">
                            <div class="matter-module">
                                <div class="matter-module-title">1.委托项目选择：</div>
                                <div class="matter-module-option">
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox1" />
                                            <label for="checkbox1">提取固定电子数据</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox2" />
                                            <label for="checkbox2">恢复电子数据</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox3" />
                                            <label for="checkbox3">检验程序功能</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox4" />
                                            <label for="checkbox4">破解电子数据密码</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox5" />
                                            <label for="checkbox5">分析电子数据</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox6" />
                                            <label for="checkbox6">销毁电子数据</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="matter-module">
                                <div class="matter-module-title">2.方法选择选择：</div>
                                <div class="matter-module-option">
                                    <div class="col-sm-12">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox7" />
                                            <label for="checkbox7">《数字化设备证据数据发现提取固定方法》GA/T756-2008</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox8" />
                                            <label for="checkbox8">《电子物证搜索检验技术规范》GB/T29362-2012</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox9" />
                                            <label for="checkbox9">《电子物证恢复检验技术规范》GB/T29360-2012</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 other-position">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox10" />
                                            <label for="checkbox10">其他</label>
                                        </div>
                                        <input type="text" value="" class="other-input" />
                                    </div>
                                </div>
                            </div>
                            <div class="matter-module">
                                <div class="matter-module-title">3.结果要求：</div>
                                <div class="matter-module-option">
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox11" />
                                            <label for="checkbox11">出具检验报告</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox12" />
                                            <label for="checkbox12">出具鉴定意见书</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox13" />
                                            <label for="checkbox13">只提取电子数据</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 other-position">
                                        <div class="ckbox ckbox-primary">
                                            <input type="checkbox" value="" id="checkbox14" />
                                            <label for="checkbox14">其他</label>
                                        </div>
                                        <input type="text" value="" class="other-input" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">审核人：</label>
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
                    <label class="col-sm-2 control-label">审核时间：</label>
                    <div class="col-sm-4">
                        <input type="text" placeholder="" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">审核意见：</label>
                    <div class="col-sm-10">
                        <textarea rows="8" cols="" class="form-control"></textarea>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="btn-content">
     <!--    <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button> -->
        <!-- <button class="btn btn-color1"><i class="fa fa-check"></i>通过</button>
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