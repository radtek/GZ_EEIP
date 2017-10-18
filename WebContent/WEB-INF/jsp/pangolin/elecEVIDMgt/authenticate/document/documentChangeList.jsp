<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>鉴定文书列表</title>
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
			<table class="table table-bordered">
	            <thead>
	                <tr>		                 
	                    <th>文件名</th>
	                    <th>生成时间</th>
	                    <th>操作人</th>                     	                         
	                </tr>
	            </thead>
	            <tbody class="enter-td1">
	                <tr>	                	
	                    <td>物证鉴定档案</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	            	<tr>	                	
	                    <td>鉴定文书档案目录</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	                <tr>	                	
	                    <td>鉴定文书副本</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	                <tr>	                	
	                    <td>鉴定文书审批表</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	                <tr>	                	
	                    <td>鉴定文书副本</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	                <tr>	                	
	                    <td>鉴定委托书</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	                <tr>	                	
	                    <td>鉴定事项确认书</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	                <tr>	                	
	                    <td>电子物证检验原始记录</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	                <tr>	                	
	                    <td>数据光盘</td>
	                    <td>2016年12月19日10:00</td>
	               	    <td>王五</td>             	                    	                   	                    
	                </tr>
	            </tbody>		            		           
	        </table>
			<div class="form-group">
				<div class="center">				
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
	</script>
</body>
</html>