<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>工作经历详情页</title>
    <meta charset="utf-8" />
    <meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>   
    <script	src="<c:url value="/resources/frameworks/pangolin/js/moment-with-locales.min.js" />"></script>	 
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script	src="<c:url value="/resources/frameworks/pangolin/js/bootstrap-datetimepicker.min.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
 	<script src="<c:url value="/resources/frameworks/pangolin/js/eeip/expert.js" />"></script>
  	<script src="<c:url value="/resources/frameworks/pangolin/js/data-formatter.js" />"></script>
 	
 	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/expert/expert.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" /> 
	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" /> 
</head>
<body>
	<div class="content">		
		<div class="crumbs-nav">
	        <p class="crumbs-text">
	           	当前位置：<a>人员信息管理</a><span>></span><a>专家库</a><span>></span><a>查看</a><span>></span><a>工作经历</a>
	        </p>
    	</div>
		<jsp:include page="/common/personNav.jsp"></jsp:include>
		<div class="file-upload">														
			<table class="table table-bordered">
				<thead class="col-head">
					<tr>
						<th>工作时间</th>
						<th>单位名称</th>
						<th>从事何种工作</th>
						<th>任何职务</th>
					</tr>
				</thead>
				<tbody class="handleData">
					
				</tbody>
			</table>
		</div>
	</div>	
	<div class="btn-content">
        <button type="button" class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
    </div>
	<script>
		$(function(){ 
					
			var data = loadData("${pageContext.request.contextPath}/psnlInfo/userWorkExp/getUserWorkExpByUserIdListData.do",{ "userBasicInfoId" : "${param.userBasicInfoId}" });
			 
			 if(data.length>0){ 
				 var resultHtml='';
		    	for(var i=0;i<data.length;i++){
		    		  resultHtml+='<tr class="col-read">'
		    			+'<td><input type="text"  class="datetimepicker11" value="'+new Date(data[i].startDate).Format("yyyy-MM-hh")+'" readonly="readonly" style="width:100px;" required/>至<input type="text"  class="datetimepicker11" value="'+new Date(data[i].startDate).Format("yyyy-MM-hh")+'" readonly="readonly" style="width:100px;" required/></td>'												
		    			+'<td><input type="text" readonly="readonly" value="'+data[i].org+'" required/></td>'
		    			+'<td><input type="text" readonly="readonly" value="'+data[i].job+'" required/></td>'
		    			+'<td><input type="text" readonly="readonly" value="'+data[i].position+'" required/></td>'
		    			+'</tr>';		    			
		    	}
		    	$(".datetimepicker11").datetimepicker({viewMode: 'years',format: 'YYYY-MM-DD'});
		    	$(".handleData").append(resultHtml);
		    	
		    }
		   
			
		});
		
		$(".back-btn").click(function(){//返回
			$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/psnlInfo/expert/personnelInfoList.do');
		});
		 
	</script>
</body>
</html>