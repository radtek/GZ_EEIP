<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>电子物证管理-管理人员操作台-修改文书审批-修改审批</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script> 
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/deviceMgt/deviceMgt-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>电子物证管理</a><span>></span><a>管理人员操作台</a><span>></span><a>修改文书审批</a><span>></span><a>审批</a>
        </p>
    </div>
    <div class="form-title">鉴定文书修改申请表</div>
    <div class="file-upload">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>文书名称</th>
                    <th>原文件</th>
                    <th>新文件</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="docType" data-type="2">物证鉴定档案封面</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">不可修改</td>
                </tr>
                
                <tr>
                    <td class="docType" data-type="3">物证鉴定档案目录</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">第二版</td>
                </tr>
                
                <tr>
                    <td class="docType" data-type="5">鉴定文书副本</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">第二版</td>
                </tr> 
                
                 <tr>
                    <td class="docType" data-type="8">鉴定文书审批表</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">不可修改</td>
                </tr> 
                <tr>
                    <td class="docType" data-type="0">鉴定委托书</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">不可修改</td>
                </tr> 
                <tr>
                    <td class="docType" data-type="1">鉴定事项确认书</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">不可修改</td>
                </tr> 
                <tr>
                    <td class="docType" data-type="4">电子物证检验原始记录</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">不可修改</td>
                </tr> 
                 <tr>
                    <td class="docType" data-type="6">检验鉴定照片记录表</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">不可修改</td>
                </tr> 
                 <tr>
                    <td class="docType" data-type="7">提取电子证据清单</td>
                    <td class="vision" data-type="1">第一版</td>
                    <td class="vision" data-type="2">不可修改</td>
                </tr> 
            </tbody>
        </table>
    </div>
    <div class="form-content">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label"><span class="required-fields">*</span>审批意见：</label>
                <div class="col-sm-10" data-bind="with:appraisalReviseVm">
                    <textarea class="form-control" data-bind="value: resultOpinion" required></textarea>
                </div>
            </div>
        </form>
    </div>
    <div class="btn-content">
        <button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
        <button class="btn btn-color1" data-bind ="click : passData"><i class="fa fa-check"></i>通过</button>
        <button class="btn btn-color1" data-bind ="click : refuseData"><i class="fa fa-check"></i>拒绝</button>
    </div>
    <jsp:include page="/common/alertMessages.jsp"></jsp:include>
    <script>
    $(function(){
 
    	var appraisalReviseData = loadData("${ pageContext.request.contextPath }/elecEVIDMgt/AppraisalRevise/loadAppraisalReviseData.do",{ "id" : "${param.id}" });
    	var appraisalReviseDataVm = ko.mapping.fromJS(appraisalReviseData);
    
    	var vm = {
    			appraisalReviseVm : appraisalReviseDataVm
    	         }
        vm.passData = function(){  	
    		appraisalReviseDataVm.status = 7;
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
 	        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/AppraisalRevise/saveAppraisalReviseData.do", appraisalReviseDataVm)) {
 	        		//更正文书版本
 	        		/* if(appraisalReviseData.method== 0){ */
 	        			if(saveData("${pageContext.request.contextPath}/elecEVIDMgt/AppraisalRevise/updateVersion.do", appraisalReviseDataVm)){
							saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do");
						}else{
							saveFailure("数据保存失败！");
						}
 	        		/* } */
				}
	        } else {
	        	saveFailure();
	        } 
	    } 
        
        vm.refuseData = function(){ 
        	appraisalReviseDataVm.status = 8;
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
 	        	if (saveData("${pageContext.request.contextPath}/elecEVIDMgt/AppraisalRevise/saveAppraisalReviseData.do", appraisalReviseDataVm)) {
					saveSuccess("${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do");
				}
	        } else {
	        	saveFailure();
	        } 
	    } 
        
        ko.applyBindings(vm);
        
        $(".table tbody").on("click",".vision",function(){
        	var type = $(this).attr("data-type");//心就数据
        	var value = $(this).siblings(".docType").attr("data-type");//数据类型
        	if(type==1){
        		//加载第第一版
        		window.location.href="${pageContext.request.contextPath}/elecEVIDMgt/AppraisalDoc/downAppraisalDocData.do?type="+value+"&appraisalId="+appraisalReviseData.appraisalId;
        	}else if(type==2){
        		if(value == 3 ||value == 5){
        		//加载第第二版
        		window.location.href="${pageContext.request.contextPath}/elecEVIDMgt/AppraisalDoc/downByReviseIdData.do?type="+value+"&appraisalReviseId="+"${param.id}";
        		}
            };
        });
       
        $(".back-btn").click(function(){
        	var url = "${pageContext.request.contextPath}/elecEVIDMgt/managersOperatorStation/modifyClericalApprovalList.do";
        	$(".index-iframe", window.parent.document).attr("src",url);
        });
    });
 </script>
</body>
</html>