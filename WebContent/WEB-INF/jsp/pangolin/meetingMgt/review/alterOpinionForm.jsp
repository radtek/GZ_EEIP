<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>质量体系文件修改意见表单</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/meet/meet.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/alertMessages.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<style>
		table td {vertical-align: middle !important;text-align:center;}
	</style>
</head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>管理评审会议</a>
	        </p>
    	</div>
		<form class="form-horizontal myform">			
			<div class="mid-title"><span>丨</span> 质量手册</div>													
			<table class="table table-bordered" data-bind="with:qualityVM">
	            <thead>
	                <tr>		                 	                    
	                    <th>修改处（章、节、条款）</th>
	                    <th>原内容</th>
	                    <th>修改意见</th>
	                    <th>修改理由</th>   
	                    <th>操作</th>          
	                </tr>
	            </thead>
	            <tbody class="enter-td1" data-bind="foreach:qualitys">
	                <tr>	                   
	                    <td><input type="text" data-bind="value:modif"/></td>
	                    <td><input type="text" data-bind="value:original"/></td>
	                    <td><input type="text" data-bind="value:opinion"/></td>
	                    <td><input type="text" data-bind="value:reason"/></td>
	                    <td><button type="submit" class="btn btn-default" data-bind="click: $parent.qualityRemove">删除</button></td>	                   	                    
	                </tr>
	                
	                	                   
	            </tbody>	   
	        </table>
	        <button type="submit" class="btn btn-default" data-bind="click: qualityAdd">增加</button>
	        <div class="mid-title"><span>丨</span> 程序文件</div>													
			<table class="table table-bordered" data-bind="with:programVM">
	            <thead>
	                <tr>		                 	                    
	                    <th>修改处（章、节、条款）</th>
	                    <th>原内容</th>
	                    <th>修改意见</th>
	                    <th>修改理由</th>   
	                    <th>操作</th>          
	                </tr>
	            </thead>
	            <tbody class="enter-td1" data-bind="foreach:programs">
	                <tr>	                   
	                    <td><input type="text" data-bind="value:modif"/></td>
	                    <td><input type="text" data-bind="value:original"/></td>
	                    <td><input type="text" data-bind="value:opinion"/></td>
	                    <td><input type="text" data-bind="value:reason"/></td>
	                    <td><button type="submit" class="btn btn-default" data-bind="click: $parent.programRemove">删除</button></td>                  	                    
	                </tr>
	                <!-- <tr>
	                	<td colspan="5"><button class="btn btn-default">增加</button></td>
	                </tr>	 -->	                   
	            </tbody>	           	            
	        </table>
	        <button type="submit" class="btn btn-default" data-bind="click: programAdd">增加</button>
	        <div class="mid-title"><span>丨</span> 作业指导书、表格类</div>													
			<table class="table table-bordered" data-bind="with:formVM">
	            <thead>
	                <tr>		                 	                    
	                    <th>修改处（章、节、条款）</th>
	                    <th>原内容</th>
	                    <th>修改意见</th>
	                    <th>修改理由</th>   
	                    <th>操作</th>       
	                </tr>
	            </thead>
	            <tbody class="enter-td1" data-bind="foreach:forms">
	               <tr>	                   
	                    <td><input type="text" data-bind="value:modif"/></td>
	                    <td><input type="text" data-bind="value:original"/></td>
	                    <td><input type="text" data-bind="value:opinion"/></td>
	                    <td><input type="text" data-bind="value:reason"/></td>
	                    <td><button type="submit" class="btn btn-default" data-bind="click: $parent.formRemove">删除</button></td>	                   	                    
	                </tr>
	                <!-- <tr>
	                	<td colspan="5"><button class="btn btn-default">增加</button></td>
	                </tr> -->		                   
	            </tbody>	           	            
	        </table>
	        <button type="submit" class="btn btn-default" data-bind="click: formAdd">增加</button>
			<div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: saveData" class="submit-btn">√ 提交</button>
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div>
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
	
	$(function(){
	 	var cmtData = loadData("${pageContext.request.contextPath}/meetingQs/docCmt/loadDocCmtByAppIdData.do",{ "id" : "${param.id}" });
	    var cmtDataVM = ko.mapping.fromJS(cmtData);
	    
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
	    
	    vm.qualityAdd = function(){
	    	qualityDataVM.qualitys.push({'modif':'','original':'','opinion':'','reason':''})
	    }
	    
	    qualityDataVM.qualityRemove = function(){
	    	 if(this.id != null){
	    		 $.ajax({
		    		 url:'${pageContext.request.contextPath}/meeting/meetingQs/docCmt/item/removeItemData.do',
		    		 type:'post',
		    		 datatype:'json',
		    		 data:{'id':this.id},
		    		 success:function(){
		    			 //qualityDataVM.qualitys.remove(this);
		    		 }
		    	 }) 
	    	 }
	    	 qualityDataVM.qualitys.remove(this);
	    }
	    
	    vm.programAdd = function(){
	    	programDataVM.programs.push({'modif':'','original':'','opinion':'','reason':''})
	    }
	    
	    programDataVM.programRemove = function(){
	    	 if(this.id != null){
	    		 $.ajax({
		    		 url:'${pageContext.request.contextPath}/meeting/meetingQs/docCmt/item/removeItemData.do',
		    		 type:'post',
		    		 datatype:'json',
		    		 data:{'id':this.id},
		    		 success:function(){
		    			// programDataVM.programs.remove(this);
		    		 }
		    	 }) 
	    	 }
	    	 programDataVM.programs.remove(this);
	    }
	    
	    vm.formAdd = function(){
	    	formDataVM.forms.push({'modif':'','original':'','opinion':'','reason':''})
	    }
	    
	    formDataVM.formRemove = function(){
	    	 if(this.id != null){
	    		 $.ajax({
		    		 url:'${pageContext.request.contextPath}/meeting/meetingQs/docCmt/item/removeItemData.do',
		    		 type:'post',
		    		 datatype:'json',
		    		 data:{'id':this.id},
		    		 success:function(){
		    			// formDataVM.forms.remove(this);
		    		 }
		    	 }) 
	    	 }
	    	 formDataVM.forms.remove(this);
	    }
	    
	    vm.saveData = function(){
	    	$("button").attr("disabled", true);
	        if ( validateSubmittedData() ) {
	        	bindDataVM();
	        	if (saveData("${pageContext.request.contextPath}/meetingQs/docCmt/saveDocCmtData.do", cmtDataVM)) {
					saveSuccess("${pageContext.request.contextPath}/meetingMgt/review/meetReviewFileView.do?id=${param.id}");
				} else {
					saveFailure();
				}
	        } else {
	        	saveFailure();
	        }
		} 

		
		vm.backToList = function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/review/meetReviewFileView.do?id=${param.id}');
		}
		
		ko.applyBindings(vm);
		//数据绑定
		function bindDataVM(){
			cmtDataVM.itemsQuality = qualityDataVM.qualitys;
			cmtDataVM.itemsProgram = programDataVM.programs;
			cmtDataVM.itemsForm = formDataVM.forms;
			cmtDataVM.status = 1;
			cmtDataVM.meetingAppId = "${param.id}";
			cmtDataVM.creatorName = "${sessionScope.loginUser.userName}";
			cmtDataVM.creatorId = "${sessionScope.loginUser.userId}";
			cmtDataVM.creatorAlias = "${sessionScope.loginUser.userAlias}";
		}
	});
	</script>
</body>
</html>