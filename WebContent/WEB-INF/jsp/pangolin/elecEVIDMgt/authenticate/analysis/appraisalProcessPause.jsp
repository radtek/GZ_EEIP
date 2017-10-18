<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定已暂停</title>
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
			<div class="mid-title">
				<span>丨</span> 鉴定分配 
				<span style="float:right;"> 					
					<button type="button" class="btn btn-warning">重新分配</button>
				</span>
				<div style="clear:both;"></div>	
			</div>															
			<div class="form-group">
				<label class="col-sm-2 control-label">分配人：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>
				<label class="col-sm-2 control-label">分配时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>								
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">鉴定师：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>											
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">预计开始时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>
				<label class="col-sm-2 control-label">截止时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>								
			</div>	
		    <div class="mid-title"><span>丨</span> 检材领用</div>
		   	<div class="form-group">
				<label class="col-sm-2 control-label">领用人：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>													
			</div>
			<div class="form-group">			
				<label class="col-sm-2 control-label">领用时间：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">领用拍照：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>						
			</div>
		    <div class="mid-title"><span>丨</span> 设备使用情况</div>
		    <div class="form-group">
				<label class="col-sm-2 control-label">检材编号：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>
				<label class="col-sm-2 control-label">设备识别号：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">设备名称：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>			
				<label class="col-sm-2 control-label">设备状况：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>									
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">开始时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>
				<label class="col-sm-2 control-label">结束时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>								
			</div>
		    <div class="mid-title"><span>丨</span> 鉴定原始记录</div>	
		    <div class="form-group">
				<label class="col-sm-2 control-label">鉴定视频录制：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>						
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">案件编号：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>
				<label class="col-sm-2 control-label">检材编号：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>							
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">鉴定方法：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>
				<label class="col-sm-2 control-label">检验地点：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>							
			</div>		
			<div class="form-group">
				<label class="col-sm-2 control-label">开始时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>
				<label class="col-sm-2 control-label">结束时间：</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control" />
				</div>							
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">检验过程：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>								
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">杀毒结果：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>								
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">检验结果：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>								
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>								
			</div>	
			<div class="form-group">
				<label class="col-sm-2 control-label">附件：</label>
				<div class="col-sm-10" >
					<p>
						<a href="###">《检验鉴定照片记录表》</a>
					</p>	
					<p>
						<a href="###">《提取电子证据清单》</a>
					</p>	
				</div>												
			</div>
			<div class="mid-title"><span>丨</span> 检材归还</div>	
				<div class="form-group">
				<label class="col-sm-2 control-label">归还人：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>													
			</div>
			<div class="form-group">			
				<label class="col-sm-2 control-label">归还时间：</label>
				<div class="col-sm-4" >
					<select class="form-control" /></select>
				</div>							
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">归还拍照：</label>
				<div class="col-sm-10" >
					<textarea type="text" class="form-control"></textarea>
				</div>						
			</div>			
			<div class="form-group">
				<div class="center">					
					<button type="submit" data-bind="click: backToList" class="back-btn">< 返回</button>
				</div>
			</div>
		</form>
	</div>	
	<jsp:include page="/common/alertMessages.jsp"></jsp:include>
	
	<script>
	
	</script>
</body>
</html>