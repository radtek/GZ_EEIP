<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-管理人员操作台-文书审批-审批-填表</title>
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
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>管理人员操作台</a><span>></span><a>文书审批</a><span>></span><a>审批</a><span>></span><a>填表</a>
        </p>
    </div>
    <div class="form-title">鉴定文书审批表</div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>委托单位：</label>
                <div class="col-sm-10">
                    <input type="text" placeholder="" class="form-control" required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定文书编号：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" required/>
                </div>
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>主办人：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">复核人：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">复核时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">发文形式：</label>
                <div class="col-sm-3">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radioProfession" value="" id="profession1">
                        <label for="profession1">数据恢复</label>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radioProfession" value="" id="profession2">
                        <label for="profession2">数据分析</label>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="rdio rdio-primary">
                        <input type="radio" name="radioProfession" value="" id="profession3">
                        <label for="profession3">系统分析</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
            	<label class="col-sm-2 control-label">数量(份)：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">附件：</label>
                <div class="col-sm-10">
                    <div class="matter-content">
                        <div class="matter-module">
                            <div class="matter-module-option">
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="" id="checkbox11" />
                                        <label for="checkbox11">鉴定委托书</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="" id="checkbox12" />
                                        <label for="checkbox12">鉴定事项确认书</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="" id="checkbox13" />
                                        <label for="checkbox13">检验记录</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="" id="checkbox14" />
                                        <label for="checkbox14">检材照片</label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="" id="checkbox15" />
                                        <label for="checkbox15">提取数据</label>
                                    </div>
                                </div>
                                <div class="col-sm-12 other-position">
                                    <div class="ckbox ckbox-primary">
                                        <input type="checkbox" value="" id="checkbox16" />
                                        <label for="checkbox16">其他</label>
                                    </div>
                                    <input type="text" value="" class="other-input" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">授权签字人意见：</label>
                <div class="col-sm-3">
	                <div class="rdio rdio-primary">
	                    <input type="radio" name="radioProfession2" value="" id="profession4">
	                    <label for="profession4">认可项目</label>
	                </div>
	            </div>
	            <div class="col-sm-3">
	                <div class="rdio rdio-primary">
	                    <input type="radio" name="radioProfession2" value="" id="profession5">
	                    <label for="profession5">非认可项目</label>
	                </div>
	            </div>
	            <div class="col-sm-3">
	                <div class="rdio rdio-primary">
	                    <input type="radio" name="radioProfession2" value="" id="profession6">
	                    <label for="profession6">符合委托方要求</label>
	                </div>
	            </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">授权签字人：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">签字时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实验室负责人意见：</label>
                <div class="col-sm-10">
                    <textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">实验室负责人：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
                <label class="col-sm-2 control-label">审批时间：</label>
                <div class="col-sm-4">
                    <input type="text" placeholder="" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">备注：</label>
                <div class="col-sm-10">
                    <textarea rows="8" cols="" class="form-control"></textarea>
                </div>
            </div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1"><i class="fa fa-check"></i>提交</button>
        <!-- <button class="btn btn-color1"><i class="fa fa-times"></i>拒绝</button> -->
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
        $(".back-btn").click(function(){
	    	var url = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/clericalApprovalForm.do";
	    	$(".index-iframe", window.parent.document).attr("src",url);
	    });
        $(".btn-color1").click(function(){
			if(validateSubmittedData()){
				
			}else{
				saveFailure();
			}
		})
    </script>
</body>
</html>