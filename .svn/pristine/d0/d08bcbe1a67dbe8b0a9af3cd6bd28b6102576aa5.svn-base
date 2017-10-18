<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>质量体系文件修改意见表单查看</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
	
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />	
	<style>
		table td {vertical-align: middle !important;text-align:center;}
	</style>
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>管理评审会议</a><span>></span><a>查看</a><span>></span><a>质量体系文件修改意见表</a>
        </p>
   	</div>
	<div class="form-module">
        <div class="form-module-title">
            <p>质量手册</p>
        </div>
        <div class="file-upload">
        	<table class="table table-bordered" data-bind="with:qualityVM">
	            <thead>
	                <tr>		                 	                    
	                    <th>修改处（章、节、条款）</th>
	                    <th>原内容</th>
	                    <th>修改意见</th>
	                    <th>修改理由</th>     
	                </tr>
	            </thead>
	            <tbody class="enter-td1" data-bind="foreach:qualitys">
	                <tr>	                   
	                    <td><output type="text" data-bind="value:modif"/></td>
	                    <td><output type="text" data-bind="value:original"/></td>
	                    <td><output type="text" data-bind="value:opinion"/></td>
	                    <td><output type="text" data-bind="value:reason"/></td>	                    
	                </tr>              
	            </tbody>	   
	        </table>
        </div>
    </div>
    <div class="form-module">
        <div class="form-module-title">
            <p>程序文件</p>
        </div>
        <div class="file-upload">
        	<table class="table table-bordered" data-bind="with:programVM">
	            <thead>
	                <tr>		                 	                    
	                    <th>修改处（章、节、条款）</th>
	                    <th>原内容</th>
	                    <th>修改意见</th>
	                    <th>修改理由</th>     
	                </tr>
	            </thead>
	            <tbody class="enter-td1" data-bind="foreach:programs">
	                <tr>	                   
	                    <td><output type="text" data-bind="value:modif"/></td>
	                    <td><output type="text" data-bind="value:original"/></td>
	                    <td><output type="text" data-bind="value:opinion"/></td>
	                    <td><output type="text" data-bind="value:reason"/></td>                 
	                </tr>
	                                   
	            </tbody>	           	            
	        </table>
        </div>
    </div>
    <div class="form-module">
        <div class="form-module-title">
            <p>作业指导书、表格类</p>
        </div>
        <div class="file-upload">
        	<table class="table table-bordered" data-bind="with:formVM">
	            <thead>
	                <tr>		                 	                    
	                    <th>修改处（章、节、条款）</th>
	                    <th>原内容</th>
	                    <th>修改意见</th>
	                    <th>修改理由</th>      
	                </tr>
	            </thead>
	            <tbody class="enter-td1" data-bind="foreach:forms">
	               <tr>	                   
	                    <td><output type="text" data-bind="value:modif"/></td>
	                    <td><output type="text" data-bind="value:original"/></td>
	                    <td><output type="text" data-bind="value:opinion"/></td>
	                    <td><output type="text" data-bind="value:reason"/></td>                   
	                </tr>
	               	                   
	            </tbody>	           	            
	        </table>
        </div>
    </div>	
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn" data-bind="click: backToList"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
	
	$(function(){
	 	var cmtData = loadData("${pageContext.request.contextPath}/meetingQs/docCmt/loadDocCmtByAppIdData.do",{ "id" : "${param.id}" });
	    var cmtDataVM = ko.mapping.fromJS(cmtData);
	    
	    if ( cmtData.itemsQuality.length == 1 && !cmtData.itemsQuality[0].meetingAppId  ) {
	    	cmtData.itemsQuality = [];
	    }
	    
	    if ( cmtData.itemsProgram.length == 1 && !cmtData.itemsProgram[0].meetingAppId  ) {
	    	cmtData.itemsProgram = [];
	    }
	    
	    if ( cmtData.itemsForm.length == 1 && !cmtData.itemsForm[0].meetingAppId  ) {
	    	cmtData.itemsForm = [];
	    }
	    	
	    
	    // 质量手册
	    var qualityDataVM = {
	    		qualitys : ko.observableArray(cmtData.itemsQuality)
	    }
	    
	    //程序文件
	    var programDataVM = {
	    		programs : ko.observableArray(cmtData.itemsProgram)
	    }
	    
	    //作业指导书、表格类
	    var formDataVM = {
	    		forms : ko.observableArray(cmtData.itemsForm)
	    }
	    
	    var vm = {
	    		cmtVM : cmtDataVM,
	    		qualityVM : qualityDataVM,
	    		programVM : programDataVM,
	    		formVM : formDataVM
	    }
	    
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/review/meetReviewView.do?id=${param.id}');
		}
		
		ko.applyBindings(vm);
		
	});
	</script>
</body>
</html>