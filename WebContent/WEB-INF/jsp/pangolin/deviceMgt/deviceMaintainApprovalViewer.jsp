<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>设备维护申请审批-查看</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.datatables.min.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/jquery.datatables.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>设备与环境管理</a><span>></span><a>设备维护申请审批</a><span>></span><a>查看</a>
        </p>
    </div>
    <div class="form-title">仪器设备核查/校准/维修申请单</div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备名称：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>设备识别号：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>制造厂商：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" required />
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>规格/型号：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" required />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">申请项目：</label>
                <div class="col-sm-1">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radio1">
                        <label for="radio1">检定</label>
                    </div>
                </div>
                <div class="col-sm-1">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radio2">
                        <label for="radio2">校准</label>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radio1" value="" id="radio3">
                        <label for="radio3">维修</label>
                    </div>
                </div>
                <label class="col-sm-2 control-label">申请时间：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">经费预算(元)：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">详细说明：</label>
                <div class="col-sm-10">
                	<textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">申请人：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">申请时间：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">审核人意见：</label>
                <div class="col-sm-10">
                	<textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">审核人：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">审核时间：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实验室主任意见：</label>
                <div class="col-sm-10">
                	<textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实验室主任：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">审批时间：</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" />
                </div>
            </div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <!-- <button class="btn btn-color1"><i class="fa fa-check"></i>同意</button>
        <button class="btn btn-color1"><i class="fa fa-times"></i>不同意</button> -->
    </div>
    <script type="text/javascript">
	    $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/deviceMgt/deviceMaintainApprovalList.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
    </script>
</body>
</html>