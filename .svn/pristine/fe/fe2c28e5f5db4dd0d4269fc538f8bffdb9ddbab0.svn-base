<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定文书修改审批</title>
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
</head>
<body>
	<div class="content">
		<div class="location">
			<span>当前位置：电子物证管理 > 鉴定人员操作台  </span>			
		</div>
		
		<form class="form-horizontal myform">															
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>委托单位：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" required/>
				</div>				
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定文书名称：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" required/>
				</div>								
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span class="required-fields">*</span>鉴定文书编号：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" required/>
				</div>														
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">委托人：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>		
				<label class="col-sm-2 control-label">申请日期：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>				
										
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">修改人：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>	
				<label class="col-sm-2 control-label">申请日期：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>									
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">修改内容：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>														
			</div>
		    <div class="form-group">
				<label class="col-sm-2 control-label">修改方式：</label>
				<div class="col-sm-10" >
					<input type="text" class="form-control" />
				</div>														
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">授权签字人意见：</label>
				<div class="col-sm-10" >
					<p class="mag-bottom-span">
						<input type="checkbox"/> <span class="mag-right-span"> 同意</span>
						<input type="checkbox"/> <span> 不同意</span>
					</p>
					<p>
						<input type="text" class="form-control" />
					</p>		
				</div>														
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">技术负责人意见：</label>
				<div class="col-sm-10" >
					<p class="mag-bottom-span">
						<input type="checkbox"/> <span class="mag-right-span"> 同意</span> 
						<input type="checkbox"/> <span> 不同意</span>
					</p>
					<p>
						<input type="text" class="form-control" />
					</p>		
				</div>														
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">鉴定机构负责人意见：</label>
				<div class="col-sm-10" >
					<p class="mag-bottom-span">
						<input type="checkbox"/> <span class="mag-right-span">同意</span>   
						<input type="checkbox"/> <span>不同意</span>
					</p>
					<p>
						<input type="text" class="form-control" />
					</p>		
				</div>														
			</div>
			<div class="form-group">
				<div class="center">
					<button type="submit" data-bind="click: saveData" class="submit-btn">√ 提交</button>
					<button type="button" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div>
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
		$(".back-btn").click(function(){
	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/elecEVIDMgt/authenticate/document/documentList.do');
	    })		
	    $(".submit-btn").click(function(){
			if(validateSubmittedData()){
				
			}else{
				saveFailure();
			}
		})
	</script>
</body>
</html>