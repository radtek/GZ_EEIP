<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>知识管理-知识库</title>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  	<meta name="renderer" content="webkit" />
  	<script src="<c:url value="/resources/frameworks/pangolin/js/jq.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-3.3.0.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout.mapping.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/knockout/knockout-ext.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/jquery.required.validate.js" />"></script>
	<script src="<c:url value="/resources/frameworks/pangolin/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/ajaxfileupload.js" />"></script>
    <script src="<c:url value="/resources/frameworks/pangolin/js/eeip/jquery.treemenu.js" />"></script>
  	
  	<link href="<c:url value="/resources/frameworks/pangolin/css/style.default.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/jquery.treemenu.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/base.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/knowledgeMgt/knowledgeMgt-form.css" />" rel="stylesheet" />
  	<link href="<c:url value="/resources/frameworks/pangolin/css/eeip/style-form.css" />" rel="stylesheet" />
</head>
<body>
    <div class="crumbs-nav">
        <p class="crumbs-text">
           	当前位置：<a>知识管理</a><span>></span><a>知识库</a>
        </p>
    </div>
    <div class="main-content" >
        <div class="left-content">
        	<div class="title-name">
        		<p>知识库文件</p>
        	</div>
           
        	<ul class="tree treemenu">			  
			   
			</ul>
        </div>
        
        <div class="right-form">   
        	<div class="enter-search">
        		<input type="text" placeholder="搜索"/>
        		<button type="button" class="btn btn-color2 search"><i class="fa fa-search"></i>查询</button>
        	</div>          		
      		<iframe class="file-iframe" src="" ></iframe>
        </div>
    </div>
   
    <script> 
    	$(".btn-color2").click(function(){
    		$(".enter-search").hide();
    		$('.file-iframe').attr('data-search',$(".enter-search input").val());
    		$('.file-iframe').attr('src','${pageContext.request.contextPath}/knowledgeMgt/knowledgeBase/fileList.do');
    		$(".file-iframe").show();
    		
    	})
		// 文件夹
		var dirData = loadData("${pageContext.request.contextPath}/directory/directoryGridData.do",{});
        var html = '';
        for(var i=0;i<dirData.length;i++){        	
        	if( dirData[i]['isLeaf'] ){
        		html += '<li class="directory tree-closed1" data-id="'+dirData[i]['id']+'"><span class="toggler1">'+dirData[i]['name']+'</span></li>';
        	}else{
        		html += '<li class="directory tree-empty1" data-id="'+dirData[i]['id']+'"><span class="toggler1">'+dirData[i]['name']+'</span></li>';
        	}       	
        }
        $(".tree").html(html);
        
        // 正式文件
        $(".tree").on('click','.directory',function(){
        	if(!$(this).hasClass("already-open")){
        		$(this).addClass("already-open");
        		var id = $(this).attr('data-id');
            	var documentData = loadData("${pageContext.request.contextPath}/document/getDocumentByDirId.do",{ 'dirId': id });
            	var documentHtml = '<ul class="treemenu">';
            	for(var i=0;i<documentData.length;i++){
            		if( documentData[i]['histDoc'] ){
            			documentHtml += '<li class="view tree-closed2" data-id="'+documentData[i]['id']+'"><span class="toggler2">'+documentData[i]['name']+'</span></li>';
            		}else{
            			documentHtml += '<li class="view tree-empty2" data-id="'+documentData[i]['id']+'"><span class="toggler2">'+documentData[i]['name']+'</a></span>';
            		}
            	}
            	documentHtml += '</ul>'
            	$(this).append(documentHtml);
        	}
        	
        });
        
        // 文件历史记录
        $(".tree").on('click','.view',function() {
        	if(!$(this).hasClass("already-open")){
        		$(this).addClass("already-open");
	        	var id = $(this).attr('data-id');	        	
	        	var histDocData = loadData("${pageContext.request.contextPath}/docHistory/getDocHistoryByDocId.do",{ 'docId': id });	        	
	        	var histHtml = '<ul class="treemenu">';
	        	for(var i=0;i<histDocData.length;i++){
	        		histHtml += '<li class="viewHist" data-id="'+histDocData[i]['id']+'"><span class="toggler3">'+histDocData[i]['name']+'</span></li>'
	        	}
	        	histHtml += '</ul>'
	        	$(this).append(histHtml);
        	}
        })
        
        $(".tree").on('click','.view',function() {      	
        	var id = $(this).attr('data-id');
        	$('.file-iframe').attr('src','${pageContext.request.contextPath}/knowledgeMgt/knowledgeBase/fileViewer.do?id='+id);
        	$(".enter-search").hide();
        	$('.file-iframe').show();
        })
        
         $(".tree").on('click','.viewHist',function() {
        	var id = $(this).attr('data-id');
        	$('.file-iframe').attr('src','${pageContext.request.contextPath}/knowledgeMgt/knowledgeBase/fileViewer.do?status=1&id='+id);
        	$(".enter-search").hide();
        	$('.file-iframe').show();
        	return false;
        })
        
    </script>
</body>
</html>