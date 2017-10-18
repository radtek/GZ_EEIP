<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>个人不符合项报告列表</title>
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
</head>
<body>
	<div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>会议管理</a><span>></span><a>会议申请</a><span>></span><a>内部审核会议</a><span>></span><a>查看</a><span>></span><a>不符合项报告</a>
        </p>
   	</div>
	<div class="file-upload">												
		<table class="table table-bordered">
            <thead>
                <tr>		                 
                    <th>姓名</th>
                    <th>岗位</th>
                    <th>严重性评价</th>
                    <th>操作</th>   	                         
                </tr>
            </thead>
            <tbody class="enter-td1">
                      
            </tbody>		            		           
        </table>
	</div>	
	<div class="btn-content">
       	<button class="btn btn-color2 back-btn"><i class="fa fa-chevron-left"></i>返回</button>
       	<%-- <a href="${pageContext.request.contextPath}/meetingMgt/internalAudit/inconformityReportForm.do">录入</a>
       	<a href="${pageContext.request.contextPath}/meetingMgt/internalAudit/inconformityReportView.do">查看</a> --%>
    </div>
	<script>
		$(function(){
			
			var data = [];
			if( 1==1 ){
				data = loadData("${pageContext.request.contextPath}/meeting/meetingIi/report/getReportsByAppIdData.do",{ "id" : "${param.id}" });
			}else{
				data = loadData("${pageContext.request.contextPath}/meeting/meetingIi/report/getReportsByAppIdAndParticipantIdData.do?id=${param.id}&participantId=${sessionScope.loginUser.userId}",{ });
			}
		    var html = '';
		    
		    for(var i=0;i<data.length;i++){
		    	html += '<tr><td>'+data[i]['principalAlias']+'</td>'+
		    	                   '<td>'+getFormatAuditPost(data[i]['auditedPost'])+'</td>'+
		    	                   '<td>'+getFormatEvaluation(data[i]['evaluation'])+'</td>';
		        if("${param.status}" == 0 ){
		        	html += '<td><a class="approval-btn modify" title="录入" data-id="'+data[i]['id']+'"><i class="fa fa-edit"></i></a></td></tr>';
		        }else {
		        	html +='<td><a class="approval-btn view" title="查看" data-id="'+data[i]['id']+'"><i class="fa fa-search"></i></a></td></tr>';
		        }  
		    }
		    
	        $(".enter-td1").html(html);
	 	    
	 	    $(".enter-td1").on('click','.modify',function(){
	 	    	var id = $(this).attr('data-id');
	 	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/inconformityReportForm.do?id='+id+"&appId=${param.id}");
	 	    })
		 	
		 	 $(".enter-td1").on('click','.view',function(){
		 	    	var id = $(this).attr('data-id');
		 	    	$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/inconformityReportView.do?id='+id+"&appId=${param.id}&status=${param.status}");
		 	 })
		  
		 	function getFormatAuditPost(data){
	 	    	if( data == null ) return "";
	 	    	return data;
	 	    }
		 	 
		    
		    function getFormatEvaluation(data){
		    	if(data == 0) return "严重不符合";
		    	if(data == 1) return "一般不符合";
		    	if(data == 2) return "轻微不符合";
		    	return "无";
		    }
			
			$(".back-btn").click(function(){//返回
				if("${param.status}" == 0){
					$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalFileUpload.do?id=${param.id}');
				}else if("${param.status}" == 1){
					$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalFileAudit.do?id=${param.id}');
				}else if("${param.status}" == 2){
					$('.index-iframe' , window.parent.document ).attr('src','${pageContext.request.contextPath}/meetingMgt/internalAudit/meetInternalAuditView.do?id=${param.id}');
				}
		    	
			});
			
			
		});
	</script>
</body>
</html>